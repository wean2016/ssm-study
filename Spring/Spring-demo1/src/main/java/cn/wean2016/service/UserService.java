package cn.wean2016.service;

import cn.wean2016.bean.User;

/**
 * Created by hasee on 2017/7/13.
 */

public interface UserService {

    public void save(User user);

    public User getUser();

    public User getUser2(User user);
}
