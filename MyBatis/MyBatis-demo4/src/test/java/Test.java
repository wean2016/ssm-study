import cn.wean2016.bean.Classes;
import cn.wean2016.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by hasee on 2017/7/12.
 */
public class Test {

    @org.junit.Test
    public void testSelect(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        String statement = "ClassMapper.getClass";
        Classes classes = session.selectOne(statement, 2);
        System.out.println(classes);

        session.close();
    }

    @org.junit.Test
    public void testSelect2(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        String statement = "ClassMapper.getClass2";
        Classes classes = session.selectOne(statement, 1);
        System.out.println(classes);

        session.close();
    }
}
