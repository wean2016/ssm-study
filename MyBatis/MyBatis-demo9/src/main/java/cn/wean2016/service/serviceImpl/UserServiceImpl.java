package cn.wean2016.service.serviceImpl;

import cn.wean2016.mapper.UserMapper;
import cn.wean2016.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hasee on 2017/7/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void printAllStudent() {
        System.out.println(userMapper.findAll());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(int id){
        userMapper.delete(id);
        // 测试回滚
        id = 1/0;
    }
}
