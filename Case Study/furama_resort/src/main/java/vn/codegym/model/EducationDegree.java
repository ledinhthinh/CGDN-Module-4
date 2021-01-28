package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @Column(name = "education_degree_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer educationDegreeId;
    @Column(name = "education_degree_name")
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    private List<Employee> employees;
    public EducationDegree() {
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
