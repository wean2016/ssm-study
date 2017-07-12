import cn.wean2016.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import cn.wean2016.util.MyBatisUtils;

import java.util.List;

/**
 * Created by hasee on 2017/7/11.
 */
public class Test {
    @org.junit.Test
    public void testAdd(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        //默认是手动提交的
        SqlSession session = factory.openSession(true);

        String statement = "userMapper.addUser";
        int insert = session.insert(statement, new User(-1, "666", 21));
        System.out.println(insert);

        session.close();
    }

    @org.junit.Test
    public void testUpdate(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        //默认是手动提交的
        SqlSession session = factory.openSession(true);

        String statement = "userMapper.updateUser";
        int update = session.insert(statement, new User(7, "77", 250));
        System.out.println(update);

        session.close();
    }

    @org.junit.Test
    public void testDetele(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        //默认是手动提交的
        SqlSession session = factory.openSession(true);

        String statement = "userMapper.deleteUser";
        int detele = session.insert(statement, 7);
        System.out.println(detele);

        session.close();
    }

    @org.junit.Test
    public void testGetUser(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        String statement = "userMapper.getUser";
        User user = session.selectOne(statement, 1);

        System.out.println(user);

        session.close();
    }

    @org.junit.Test
    public void testGetAllUser(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        String statement = "userMapper.getAllUser";

        List<User> result = session.selectList(statement);

        System.out.println(result);

        session.close();
    }
}
