import com.kuang.cache_pojo.Student;
import com.kuang.dao.CStudentMapper02;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyTest07 {

    @Test
    public void test7() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CStudentMapper02 mapper1 = sqlSession1.getMapper(CStudentMapper02.class);
        CStudentMapper02 mapper2 = sqlSession2.getMapper(CStudentMapper02.class);
        Student student1 = mapper1.queryStudentById(2);
        System.out.println(student1);
        sqlSession1.close();
        Student student2 = mapper2.queryStudentById(2);
        System.out.println(student2);
        sqlSession2.close();

    }


}
