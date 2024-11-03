package com.kuang.cache_pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student  implements Serializable {
    private Integer stuId;
    private String stuName;
    private Integer stuAge;
    private Double stuSalary;
    private Date stuBirth;
    private Date createTime;
    private Integer courseId;
}
