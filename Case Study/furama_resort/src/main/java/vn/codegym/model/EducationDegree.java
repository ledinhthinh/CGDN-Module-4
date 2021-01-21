package vn.codegym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @Column(name = "education_degree_id")
    private Integer educationDegreeId;
    @Column("education_degree_name")
    private String educationDegreeName;
}
