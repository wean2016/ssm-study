import cn.wean2016.bean.User;
import cn.wean2016.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by hasee on 2017/7/13.
 */
/*
* 测试缓存
*
*/
public class Test {

    /* 一级缓存：session 级的缓存
       1. 默认开启
       2. 清理缓存
               1. 执行了 session.clearCache();
               2. 执行了 CUD操作*/
    @org.junit.Test
    public void testCacheOne(){

        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        String statement = "UserMapper.getUser";
        // 第一次拿对象
        User user = session.selectOne(statement, 1);
        System.out.println(user);

        // 第二次拿同一个对象
        User user2 = session.selectOne(statement, 1);
        System.out.println(user2);

        session.close();

        /*
            DEBUG 07-13 13:05:13,885 Setting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:05:13,886 ooo Using Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:05:13,886 ==>  Preparing: select * from c_user where id=?   (Log4jImpl.java:46)
            DEBUG 07-13 13:05:13,917 ==> Parameters: 1(Integer)  (Log4jImpl.java:46)
            User{id=1, name='Tom', age=12}
            DEBUG 07-13 13:05:13,942 Cache Hit Ratio [UserMapper]: 0.0  (Log4jImpl.java:46)
            User{id=1, name='Tom', age=12}
            DEBUG 07-13 13:05:13,946 Closing JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:05:13,946 Returned connection 708890004 to pool.  (Log4jImpl.java:46)
        */
        /*
        * 上面是部分测试输出，可以看出，在同一个 session 中查询同一个对象会读取一级缓存中的数据 （只发一条 sql 查询）
        */

    }
    /*
    * 在一级缓存中执行 CUD
    */
    @org.junit.Test
    public void testCacheOne1(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        String getStatement = "UserMapper.getUser";
        String updateStatement = "UserMapper.updateUser";

        User user = session.selectOne(getStatement, 1);
        System.out.println(user);

        // 执行一次 update
        session.update(updateStatement, new User(1, "sbbbbb", 888));

        // 第二次查询同一个对象
        user = session.selectOne(getStatement, 1);
        System.out.println(user);

        session.close();

        /*
            DEBUG 07-13 13:15:23,433 Setting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:15:23,434 ooo Using Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:15:23,435 ==>  Preparing: select * from c_user where id=?   (Log4jImpl.java:46)
            DEBUG 07-13 13:15:23,465 ==> Parameters: 1(Integer)  (Log4jImpl.java:46)
            User{id=1, name='Tom', age=12}
            DEBUG 07-13 13:15:23,505 ooo Using Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:15:23,506 ==>  Preparing: update c_user set name=?, age=? where id=?   (Log4jImpl.java:46)
            DEBUG 07-13 13:15:23,506 ==> Parameters: sbbbbb(String), 888(Integer), 1(Integer)  (Log4jImpl.java:46)
            DEBUG 07-13 13:15:23,512 ooo Using Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:15:23,513 ==>  Preparing: select * from c_user where id=?   (Log4jImpl.java:46)
            DEBUG 07-13 13:15:23,514 ==> Parameters: 1(Integer)  (Log4jImpl.java:46)
            User{id=1, name='sbbbbb', age=888}
            DEBUG 07-13 13:15:23,518 Closing JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
        */
        /*
        * 上面是部分日志输出，可以看到在进行一次 update 操作后，
        * 第二次读取同一个对象时，Mybatis 重新发了一条 sql 语句查询了原来的对象
        */

    }

    /*
    * 二级缓存：映射文件级的缓存 （区别于 hibernate 的二级缓存 是 sessionFactory 级别的缓存）
    * 1. 默认不开启
    * 2. 开启方法： 在 Mapper.xml 文件中添加 <cache /> 标签
    *
    * */
    @org.junit.Test
    public void testCacheTwo(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session1 = factory.openSession(true);
        SqlSession session2 = factory.openSession(true);

        String getStatement = "UserMapper.getUser";

        //使用 session1 查询第一个对象并作输出
        System.out.println(session1.selectOne(getStatement, 1));
        //使用 session1 查询同一个对象并作输出
        System.out.println(session1.selectOne(getStatement, 1));

        session1.close();
        session2.close();

        /*
            DEBUG 07-13 13:22:33,190 Setting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:22:33,192 ooo Using Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
            DEBUG 07-13 13:22:33,192 ==>  Preparing: select * from c_user where id=?   (Log4jImpl.java:46)
            DEBUG 07-13 13:22:33,234 ==> Parameters: 1(Integer)  (Log4jImpl.java:46)
            User{id=1, name='sbbbbb', age=888}
            DEBUG 07-13 13:22:33,273 Cache Hit Ratio [UserMapper]: 0.0  (Log4jImpl.java:46)
            User{id=1, name='sbbbbb', age=888}
            DEBUG 07-13 13:22:33,276 Closing JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@2a40cd94]  (Log4jImpl.java:46)
        */
        /*
        * 可以看出，开启二级缓存后 （在 Mapper 文件中开启）
        * 两个不同的 session 查看同一个对象，当二级缓存没有被清理时，
        * MyBatis 会直接读取缓存中的对象，而不会再发一条 sql
        */
    }

}
