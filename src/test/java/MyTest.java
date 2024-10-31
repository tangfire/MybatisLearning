import com.kuang.dao.UserDao;
import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void getUserList(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }



        //关闭SqlSession
        sqlSession.close();
    }


    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(4,"tangfire","123456");

        int r = mapper.addUser(user);

//        增删改需要提交事务！
        sqlSession.commit();
        sqlSession.close();

        System.out.println(r);

    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4,"tangfire216","123456");
        int r = mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(r);
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int r = mapper.deleteUser(5);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(r);
    }


//    Map传递参数，直接在sql中取出key即可！ 【parameterType=“map”】
//
//    对象传递参数，直接在sql中取对象的属性即可！【parameterType=“Object”】
//
//    只有一个基本类型参数的情况下，可以直接在sql中取到！
//
//    多个参数用Map，或者注解！
    @Test
    public void addUserMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userid",5);
        map.put("passWord","2222333");

        mapper.addUserMap(map);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void findUsersByName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findUsersByName("李");

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }





}
