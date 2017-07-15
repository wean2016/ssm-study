package cn.wean2016.mapper;

import cn.wean2016.domain.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * Created by hasee on 2017/7/14.
 */
public interface UserMapper {

//    @Insert("INSERT INTO s_user(user_name, user_birthday, user_salary) VALUES(#{name}, #{birthday}, #{salary})")
    void save(User user);
    void update(User user);
    void delete(int id);
    User findById(int id);
    List<User> findAll();
}
