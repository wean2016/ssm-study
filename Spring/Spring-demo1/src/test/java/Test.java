import cn.wean2016.bean.User;
import cn.wean2016.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hasee on 2017/7/13.
 */
public class Test {

//    @org.junit.Test
//    public void springTest(){
//        // 初始化容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//
//        // 获得 bean
//        UserDao userDao = (UserDao) applicationContext.getBean("UserDao");
//
//        // 输出结果
//        userDao.save();
//
//    }
//
//    @org.junit.Test
//    public void springTest2(){
//        // 初始化容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//
//        // 获得 bean
//        User user = (User) applicationContext.getBean("User");
//        System.out.println("---");
//        applicationContext = null;
//        System.gc();
//        System.out.println("-----");
//
//
//    }
}
