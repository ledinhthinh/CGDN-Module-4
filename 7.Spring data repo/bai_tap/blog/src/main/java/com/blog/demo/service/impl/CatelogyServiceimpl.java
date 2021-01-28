package com.blog.demo.service.impl;

import com.blog.demo.entity.BlogEntity;
import com.blog.demo.entity.Category;
import com.blog.demo.repository.CategoryRepository;
import com.blog.demo.service.CatelogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CatelogyServiceimpl implements CatelogyService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public Page<Category> searchCategorytByName(String keyword, Pageable pageable) {
        return this.categoryRepository.findByNameCategoryContaining(keyword,pageable);
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void remove(int id) {
        this.categoryRepository.deleteById(id);
    }


}
