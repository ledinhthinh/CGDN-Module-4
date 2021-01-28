package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer positionId;
    @Column(name = "position_name")
    private String positionName;
    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    private List<Employee> employees;
    public Position() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
