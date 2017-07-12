import cn.wean2016.Mapper.UserMapper;
import cn.wean2016.domain.User;
import cn.wean2016.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by hasee on 2017/7/12.
 */
public class Test {

    @org.junit.Test
    public  void testAdd(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        UserMapper mapper = session.getMapper(UserMapper.class);

        System.out.println(mapper.add(new User(-1, "hei", 128)));

        session.close();
    }

    @org.junit.Test
    public  void testDelete(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        UserMapper mapper = session.getMapper(UserMapper.class);

        System.out.println(mapper.deleteById(8));

        session.close();
    }

    @org.junit.Test
    public  void testUpdate(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        UserMapper mapper = session.getMapper(UserMapper.class);

        System.out.println(mapper.update(new User(1, "Jerry", 1)));

        session.close();
    }

    @org.junit.Test
    public  void testSelect(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        UserMapper mapper = session.getMapper(UserMapper.class);

        System.out.println(mapper.getById(1));

        session.close();
    }

    @org.junit.Test
    public  void testSelectAll(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        UserMapper mapper = session.getMapper(UserMapper.class);

        System.out.println(mapper.getAll());

        session.close();
    }
}
