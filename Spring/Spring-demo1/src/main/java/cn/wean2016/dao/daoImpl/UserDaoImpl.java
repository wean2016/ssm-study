package cn.wean2016.dao.daoImpl;

import cn.wean2016.bean.User;
import cn.wean2016.dao.UserDao;
import cn.wean2016.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by hasee on 2017/7/13.
 */

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    public MyBatisUtils myBatisUtils;

    public void init(){
        System.out.println("UserDaoImpl 被加载了--------------");
    }

    public void save(User user) {
        SqlSession sqlSession = myBatisUtils.getSqlSession();

        String statement = "mapping/UserMapper.updateUser";
        int result = sqlSession.selectOne(statement, new User(1,"wean",11));

        sqlSession.commit();
        sqlSession.close();
    }

    public User getUser(int id) {
        SqlSession sqlSession = myBatisUtils.getSqlSession();

        String statement = "mapping/UserMapper.getUser";

        Object result = sqlSession.selectOne(statement, id);
        User user = null;

        if (result instanceof User){
            user = (User) result;
        }else {
            System.out.println("查询失败");
        }

        return user;
    }


}
