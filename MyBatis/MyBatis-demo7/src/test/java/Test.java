import cn.wean2016.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasee on 2017/7/13.
 */
public class Test {

    @org.junit.Test
    public void testProcedure(){
        SqlSessionFactory factory = MyBatisUtils.getFactory();
        SqlSession session = factory.openSession(true);

        Map<String, Integer> paramMap = new HashMap<String, Integer>();
        paramMap.put("sex_id", new Integer(0));

        String statement = "UserMapper.getCount";
        session.selectOne(statement, paramMap);
        System.out.println(paramMap.get("user_count"));

        session.close();
    }
}
