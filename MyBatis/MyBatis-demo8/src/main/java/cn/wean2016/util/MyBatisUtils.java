package cn.wean2016.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by hasee on 2017/7/11.
 */
public class MyBatisUtils {

    public static SqlSessionFactory getFactory(){

        String resource = "conf.xml";
        InputStream is = MyBatisUtils.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);


        return factory;
    }
}
