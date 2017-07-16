package cn.wean2016.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by hasee on 2017/7/14.
 */
@Component
public class MyBatisUtils {

    @Autowired
    public SqlSessionFactory sqlSessionFactory;

    public SqlSession  getSqlSession(){

        if (sqlSessionFactory == null) {
            System.out.println("获取 SqlSessionFactory 失败");
            System.exit(1);
        }
        return sqlSessionFactory.openSession();
    }
}
