import com.kuang.dao.StudentMapper;
import com.kuang.dao.TeacherMapper;
import com.kuang.dao.UserMapper02;
import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.pojo02.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest02 {
    @Test
    public void getUsers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper02 mapper = sqlSession.getMapper(UserMapper02.class);
        List<User> userList = mapper.getUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }



    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> studentList = mapper.getStudent();
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }



//    测试一级缓存
    @Test
    public void level_1_cache(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> studentList = mapper.getStudent();
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }

        System.out.println("--------------------------------------------------------");

        List<Student> studentList01 = mapper.getStudent2();
        for (Student student : studentList01) {
            System.out.println(student);
        }

        sqlSession.close();
    }

}
