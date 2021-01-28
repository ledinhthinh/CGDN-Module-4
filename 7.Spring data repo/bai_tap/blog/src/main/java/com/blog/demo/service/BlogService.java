package com.blog.demo.service;

import com.blog.demo.entity.BlogEntity;
//import com.blog.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<BlogEntity> findAll();

    Page<BlogEntity> findAll(Pageable pageable);

    void save(BlogEntity blogEntity);


    BlogEntity findById(int id);

    void update(int id, BlogEntity blogEntity);

    void remove(int id);

    //    List<BlogEntity>findByName(String name);
    Page<BlogEntity> searchBlogtByName(String keyword, Pageable pageable);

    Page<BlogEntity> findAllByOrderByDateOfManufacture(Pageable pageable);

}
