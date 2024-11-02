package com.kuang.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Supplier {
        private int id; // 供应商ID
 
        private String supCode; // 供应商编码
 
        private String supName; // 供应商名称
 
        private String supDesc; // 供应商描述
 
        private String supContact; // 供应商联系人
 
        private String supPhone; // 供应商电话
 
        private String supAddress; // 供应商地址
 
        private String supFax; // 供应商传真
 
        private int createdUserId; // 创建用户ID
 
        private Date createdTime; // 创建时间
 
        private int updatedUserId; // 更新用户ID
 
        private Date updatedTime; // 更新时间
 
        // 省略getter和setter方法
 
}