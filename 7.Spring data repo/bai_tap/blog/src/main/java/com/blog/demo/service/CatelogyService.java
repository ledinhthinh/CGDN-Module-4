package com.blog.demo.service;

import com.blog.demo.entity.BlogEntity;
import com.blog.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CatelogyService {
    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    Page<Category> searchCategorytByName(String keyword, Pageable pageable);
    void save(Category category);
    Category findById(int id);
    void update(Category category);
    void remove(int id);

}
