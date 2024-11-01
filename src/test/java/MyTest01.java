import com.kuang.dao.UserMapper01;
import com.kuang.pojo01.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class MyTest01 {

    static Logger logger = Logger.getLogger(MyTest01.class);

//    解决属性名和字段名不一致的问题
//    解决方法：起别名
//    select id,name,pwd as password from mybatis.user where id = #{id}

    @Test
    public void getUserByIdAlias(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper01 mapper = sqlSession.getMapper(UserMapper01.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }


    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");

    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper01 mapper = sqlSession.getMapper(UserMapper01.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",1);
        map.put("pageSize",2);

        List<User> userList =  mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);

        //通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.kuang.dao.UserMapper01.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }



}
