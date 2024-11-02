package com.kuang.dao;

import com.kuang.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SupplierMapper {

    Supplier getSuppliersAll(Map<String,String> map);

    Supplier getSuppliersAll01(Map<String,String> map);

    Supplier getSuppliersAll02(Map<String,String> map);

    /**
     * 批量新增
     */

    int insertManySupplier(@Param("Supplier") List<Supplier> Supplier);

    /**
     * 批量删除
     */
    int deleteManySupplier(@Param("ids") int [] ids);

    /**
     * 动态修改
     */
    int UpdateManySupplier(Supplier Supplier);

    int UpdateManySupplier01(Supplier Supplier);

    List<Supplier> getSuppliersAll03(
            @Param("supCode") String supCode,
            @Param("supName") String supName,
            @Param("supPhone") String supPhone,
            @Param("index") int index,
            @Param("pageSize") int pageSize
    );

}
