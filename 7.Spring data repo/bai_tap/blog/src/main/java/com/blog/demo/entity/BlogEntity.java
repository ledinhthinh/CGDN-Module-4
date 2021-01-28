package com.blog.demo.entity;

import javax.persistence.*;

@Entity(name = "blogentity")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBlog;
    private String describe_blog;
    private String img_blog;
    private String use_blog;
    @Column(name = "date_of_manufacture", columnDefinition = "DATE")

    private String dateOfManufacture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "idCategory")
    private Category category;


//    public String getName_blog() {
//        return name_blog;
//    }
//
//    public void setName_blog(String name_blog) {
//        this.name_blog = name_blog;
//    }

    public String getDescribe_blog() {
        return describe_blog;
    }

    public void setDescribe_blog(String describe_blog) {
        this.describe_blog = describe_blog;
    }

    public String getUse_blog() {
        return use_blog;
    }

    public void setUse_blog(String use_blog) {
        this.use_blog = use_blog;
    }

    public String getImg_blog() {
        return img_blog;
    }

    public void setImg_blog(String img_blog) {
        this.img_blog = img_blog;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public BlogEntity() {
    }
}
