package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    List<Blog> queryBlogIF(Map<String,String> map);

    List<Blog> queryBlogChoose(Map<String,String> map);


    int updateBlog(Map<String,String> map);

    int addBlog(Blog blog);
}
