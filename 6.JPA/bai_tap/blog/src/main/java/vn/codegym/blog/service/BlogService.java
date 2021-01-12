package vn.codegym.blog.service;

import org.springframework.stereotype.Service;
import vn.codegym.blog.model.Blog;

import java.util.List;
@Service
public interface BlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
