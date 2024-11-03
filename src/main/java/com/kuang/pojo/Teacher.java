package com.kuang.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L; // 可选，建议设置版本号

    private int id;
    private String name;


}
