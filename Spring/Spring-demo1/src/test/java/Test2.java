import cn.wean2016.bean.User;
import cn.wean2016.service.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hasee on 2017/7/13.
 */

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Test2 {

    @Autowired
    UserService userService;

    @org.junit.Test
    public void test(){
        userService.save(new User(1, "haowan",234));
    }

    @org.junit.Test
    public void test2(){
        userService.getUser();
    }

    @org.junit.Test
    public void test3(){
        userService.getUser2(new User(2, "mom", 30));
    }
}
