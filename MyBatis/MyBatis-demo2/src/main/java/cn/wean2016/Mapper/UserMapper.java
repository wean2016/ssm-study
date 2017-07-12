package cn.wean2016.Mapper;

import cn.wean2016.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by hasee on 2017/7/12.
 */
public interface UserMapper {

    @Insert("INSERT INTO users(name, age) values(#{name}, #{age})")
    public int add(User user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    public int deleteById(int id);

    @Update("UPDATE users SET name=#{name}, age=#{age} WHERE id=#{id}")
    public int update(User user);

    @Select("select * from users where id=#{id}")
    public User getById(int id);

    @Select("SELECT * FROM users")
    public List<User> getAll();
}
