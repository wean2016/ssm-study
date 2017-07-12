import cn.wean2016.bean.ConditionUser;
import cn.wean2016.bean.User;
import cn.wean2016.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by hasee on 2017/7/12.
 */
public class Test {

    @org.junit.Test
    public void testCondition(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        String starement = "UserMapper.getUser";
        List<User> users = session.selectList(starement, new ConditionUser("%o%", 12, 18));
        System.out.println(users);

        session.close();
    }

    @org.junit.Test
    public void testDynamic(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        String starement = "UserMapper.getUser2";
        List<User> users = session.selectList(starement, new ConditionUser("%null%", 12, 13));
        System.out.println(users);

        session.close();
    }
}
