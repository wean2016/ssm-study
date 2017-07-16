package cn.wean2016.service.serviceImpl;

import cn.wean2016.bean.User;
import cn.wean2016.dao.UserDao;
import cn.wean2016.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by hasee on 2017/7/13.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource(name = "userDaoImpl")
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        this.userDao.save(user);
    }

    public User getUser() {
        return new User(1, "wean", 20);
    }

    public User getUser2(User user){
        System.out.println(user);

        return user;
    }
}
