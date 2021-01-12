package vn.codegym.blog.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.repository.BlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager blo;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = blo.createQuery("select c from Blog c",Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = blo.createQuery("select c from Blog c where c.id=:id",Blog.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if(blog != null){
            blo.remove(blog);
        }

    }

    @Override
    public void save(Blog model) {
        if (model.getId() != null){
            blo.merge(model);
        }else {
            blo.persist(model);
        }
    }
}
