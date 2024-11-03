package com.kuang.dao;

import com.kuang.cache_pojo.Student;

public interface CStudentMapper01 {
     //通过id查询学生,传递单个参数
     Student queryStudentById(Integer id);
     //删除一条信息,通过id
     Integer delete(Integer id);
}
