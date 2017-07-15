package cn.wean2016.service.serviceImpl;

import cn.wean2016.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hasee on 2017/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll(){
        userService.printAllStudent();
    }

    @Test
    public void testDelete(){

        userService.deleteUser(3);
    }
}
