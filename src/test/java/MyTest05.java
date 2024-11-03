import com.kuang.dao.CStudentMapper;
import com.kuang.cache_pojo.Student;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyTest05 {

    @Test
    public void test1() throws Exception{
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        //只执行了一条sql语句
        CStudentMapper mapper1 = sqlSession1.getMapper(CStudentMapper.class);
        Student student1 = mapper1.queryStudentById(2);
        System.out.println(student1);

        Student student2 = mapper1.queryStudentById(2);
        System.out.println(student2);

        sqlSession1.close();
    }


    @Test
    public void test2() throws Exception{
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        //只执行了一条sql语句
        //同一个sqlSession就会走一级缓存，跟mapper没有关系
        CStudentMapper mapper1 = sqlSession1.getMapper(CStudentMapper.class);
        Student student1 = mapper1.queryStudentById(2);
        System.out.println(student1);

        CStudentMapper mapper2 = sqlSession1.getMapper(CStudentMapper.class);
        Student student2 = mapper2.queryStudentById(2);
        System.out.println(student2);

        sqlSession1.close();
    }


    @Test
    public void test3() throws Exception{
        //一级缓存就是在一个sqlSession，这里获取了两个sqlSession不是同一个sqlSession，所以不会走缓存会在去查找一遍
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        CStudentMapper mapper1 = sqlSession1.getMapper(CStudentMapper.class);
        Student student1 = mapper1.queryStudentById(2);
        System.out.println(student1);

        CStudentMapper mapper2 = sqlSession2.getMapper(CStudentMapper.class);
        Student student2 = mapper2.queryStudentById(2);
        System.out.println(student2);

        sqlSession1.close();
        sqlSession2.close();

    }


    @Test
    public void test4() throws Exception{
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        CStudentMapper mapper1 = sqlSession1.getMapper(CStudentMapper.class);
        Student student1 = mapper1.queryStudentById(2);
        System.out.println(student1);

        //手动清空一级缓存  会执行两次查询，不会从一级缓存去取
        sqlSession1.clearCache();

        Student student2 = mapper1.queryStudentById(2);
        System.out.println(student2);

        sqlSession1.close();
    }


    @Test
    public void test5() throws Exception{
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        CStudentMapper mapper1 = sqlSession1.getMapper(CStudentMapper.class);
        Student student1 = mapper1.queryStudentById(2);
        System.out.println(student1);

        //会使得下面查询时候不会去一级缓存里面去找
        Integer delete = mapper1.delete(3);

        Student student2 = mapper1.queryStudentById(2);
        System.out.println(student2);

        sqlSession1.close();

    }




}
