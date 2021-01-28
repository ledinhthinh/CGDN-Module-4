package com.blog.demo.repository;

import com.blog.demo.entity.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogEntityRepository extends JpaRepository<BlogEntity,Integer> {
Page<BlogEntity> findAllByOrderByDateOfManufacture(Pageable pageable);
Page<BlogEntity> findByNameBlogContaining(String keyword, Pageable pageable);


}
