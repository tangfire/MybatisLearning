package com.kuang.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L; // 可选，建议设置版本号


    private int id;
    private String name;
    private Teacher teacher;


}

