
import com.kuang.dao.SupplierMapper;
import com.kuang.pojo.Supplier;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest04 {

    @Test
    public void getSuppliersAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
        HashMap<String,String> map = new HashMap<>();
//        map.put("supName","广州市白云区美星五金制品厂");
        map.put("supCode","GZ_GYS003");
        Supplier sup =  mapper.getSuppliersAll(map);
        System.out.println(sup);
        sqlSession.close();


    }

    @Test
    public void getSuppliersAll01() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
        HashMap<String,String> map = new HashMap<>();
//        map.put("supName","广州市白云区美星五金制品厂");
        map.put("supCode","GZ_GYS003");
        Supplier sup =  mapper.getSuppliersAll01(map);
        System.out.println(sup);
        sqlSession.close();


    }

    @Test
    public void getSuppliersAll02() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
        HashMap<String,String> map = new HashMap<>();
//        map.put("supName","广州市白云区美星五金制品厂");
        map.put("supCode","GZ_GYS003");
        Supplier sup =  mapper.getSuppliersAll02(map);
        System.out.println(sup);
        sqlSession.close();


    }


    @Test
    public void getSuppliersAll03() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);

        List<Supplier> sup =  mapper.getSuppliersAll03("","地球有限公司","",1,5);
        for (Supplier sup1 : sup) {
            System.out.println(sup1);
        }
        sqlSession.close();


    }

    /**
     * 批量新增
     */
    @Test
    public void insertManySupplier() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Supplier> supplierList = new ArrayList<Supplier>();
        Supplier supplier = new Supplier();
        supplier.setSupCode("CD_9969");
        supplier.setSupName("小王");
        Supplier supplier1 = new Supplier();
        supplier1.setSupCode("CD_9970");
        supplier1.setSupName("小红");
        Supplier supplier2 = new Supplier();
        supplier2.setSupCode("CD_9971");
        supplier2.setSupName("小强");
        supplierList.add(supplier);
        supplierList.add(supplier1);
        supplierList.add(supplier2);
        int i = sqlSession.getMapper(SupplierMapper.class).insertManySupplier(supplierList);
        System.out.println("新增了---->"+i);
        sqlSession.commit();
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteManySupplier() throws Exception{
        int ids[]={19,20,21};
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int i = sqlSession.getMapper(SupplierMapper.class).deleteManySupplier(ids);
        System.out.println("删除了---->"+i);
        sqlSession.commit();
    }

    /**
     * 动态修改
     */
    @Test
    public void UpdateManySupplier() throws Exception{
        Supplier supplier = new Supplier();
        supplier.setSupCode("DQ_6989");
        supplier.setSupName("地球有限公司");
        supplier.setId(24);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        int i = sqlSession.getMapper(SupplierMapper.class).UpdateManySupplier(supplier);
        int i = sqlSession.getMapper(SupplierMapper.class).UpdateManySupplier01(supplier);

        System.out.println("修改了---"+i);
        sqlSession.commit();
    }

}
