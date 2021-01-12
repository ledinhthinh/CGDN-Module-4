package vn.codegym.blog.model;

import javax.persistence.*;

@Entity
//@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String content;

    public Blog() {
    }
    public Blog(String summary,String content){
        this.content = content;
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
