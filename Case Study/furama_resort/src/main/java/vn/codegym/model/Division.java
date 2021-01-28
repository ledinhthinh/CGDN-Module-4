package vn.codegym.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "division")
public class Division {
    @Id
    @Column(name = "division_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer divisionId;
    @Column(name = "division_name")
    private String divisionName;
    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    private List<Employee> employees;
    public Division() {
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
