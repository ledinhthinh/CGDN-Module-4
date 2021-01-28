package com.blog.demo.service.impl;

import com.blog.demo.entity.BlogEntity;
import com.blog.demo.repository.BlogEntityRepository;
import com.blog.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceimpl implements BlogService {
    @Autowired
   private BlogEntityRepository blogEntityRepository;


    @Override
    public List<BlogEntity> findAll() {
        return this.blogEntityRepository.findAll();
    }

    @Override
    public Page<BlogEntity> findAll(Pageable pageable) {
        return this.blogEntityRepository.findAll(pageable);
    }

    @Override
    public void save(BlogEntity blogEntity) {
        this.blogEntityRepository.save(blogEntity);
    }

    @Override
    public BlogEntity findById(int id) {
        return this.blogEntityRepository.findById(id).orElse(null);
    }

    @Override
    public void update(int id, BlogEntity blogEntity) {
        this.blogEntityRepository.save(blogEntity);
    }

    @Override
    public void remove(int id) {
        this.blogEntityRepository.deleteById(id);
    }

    @Override
    public Page<BlogEntity> searchBlogtByName(String keyword, Pageable pageable) {
        return this.blogEntityRepository.findByNameBlogContaining(keyword,pageable);
    }

    @Override
    public Page<BlogEntity> findAllByOrderByDateOfManufacture(Pageable pageable) {
        return this.blogEntityRepository.findAllByOrderByDateOfManufacture(pageable);
    }


}
