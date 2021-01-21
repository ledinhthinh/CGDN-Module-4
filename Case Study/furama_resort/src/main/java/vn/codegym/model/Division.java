package vn.codegym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "division")
public class Division {
    @Id
    @Column(name = "division_id")
    private Integer divisionId;
    @Column(name = "division_name")
    private String divisionName;

}
