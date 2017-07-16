package cn.wean2016.dao;

import cn.wean2016.bean.User;

/**
 * Created by hasee on 2017/7/13.
 */
public interface UserDao {
    public void save(User user);

    public User getUser(int id);
}
