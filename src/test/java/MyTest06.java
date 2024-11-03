import com.kuang.cache_pojo.Student;
import com.kuang.dao.CStudentMapper01;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyTest06 {
    @Test
    public void test5() throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CStudentMapper01 mapper1 = sqlSession1.getMapper(CStudentMapper01.class);
        CStudentMapper01 mapper2 = sqlSession2.getMapper(CStudentMapper01.class);


        //这行代码执行结束之后，实际上数据是缓存到一级缓存当中了。(sqlSession1是一级缓存。>
        Student student1 = mapper1.queryStudentById(2);
        System.out.println(student1);

        //如果这里不关闭SqlSession1对象的话，二级缓存中还是没有数据的。

        //这行代码执行结束之后，实际上数据会缓存到一级缓存当中。(sqlSession2是一级缓存。)
        Student student2 = mapper2.queryStudentById(2);
        System.out.println(student2);

        //程序执行到这里的时候，会将sqlSession1这个一级缓存中的数据写入到二级缓存当中。
        sqlSession1.close();
        //程序执行到这里的时候，会将sqlSession2这个一级缓存中的数据写入到二级缓存当中。
        sqlSession2.close();

    }

    @Test
    public void test6() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CStudentMapper01 mapper1 = sqlSession1.getMapper(CStudentMapper01.class);
        CStudentMapper01 mapper2 = sqlSession2.getMapper(CStudentMapper01.class);


        //这行代码执行结束之后，实际上数据是缓存到一级缓存当中了。(sqlSession1是一级缓存。>
        Student student1 = mapper1.queryStudentById(2);
        System.out.println(student1);

        //程序执行到这里的时候，会将sqlSession1这个一级缓存中的数据写入到二级缓存当中。
        sqlSession1.close();

        //如果一级缓存中没有找到对应的缓存结果，MyBatis 会尝试从二级缓存中查找，发现存在就会使用二级缓存
        Student student2 = mapper2.queryStudentById(2);
        System.out.println(student2);


        //程序执行到这里的时候，会将sqlSession2这个一级缓存中的数据写入到二级缓存当中。
        sqlSession2.close();

    }


}
