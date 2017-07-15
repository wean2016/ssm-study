import cn.wean2016.domain.User;
import cn.wean2016.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by hasee on 2017/7/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class SMTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAdd(){

        User user = new User(999,"dad111", new Date(), 12345);
        userMapper.save(user);
    }

    @Test
    public void testDel(){
        userMapper.delete(1);
    }

    @Test
    public void testUpdate(){
        userMapper.update(new User(2, "adfsdfs", new Date(), 32132123));
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        System.out.println(userMapper.findAll());
    }

}
