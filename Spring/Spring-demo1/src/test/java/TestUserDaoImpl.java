import cn.wean2016.bean.User;
import cn.wean2016.dao.daoImpl.UserDaoImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hasee on 2017/7/14.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class TestUserDaoImpl {

    @org.junit.Test
    public void testGetUser(){
        User user = new UserDaoImpl().getUser(1);
        System.out.println(user);
    }

}
