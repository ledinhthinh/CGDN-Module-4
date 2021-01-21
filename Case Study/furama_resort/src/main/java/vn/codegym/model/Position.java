package vn.codegym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @Column(name = "position_id")
    private Integer positionId;
    @Column(name = "position_name")
    private String positionName;
}
