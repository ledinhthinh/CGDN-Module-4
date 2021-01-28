package vn.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @Pattern(regexp = "^(NV)-\\d{4}$",message = "Not OK.ID invalid")
    private String employeeId;

    @Column(name = "employee_name")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Not OK.Name invalid")
    private String employeeName;

    @Column(name = "employee_birthday")
    @NotEmpty(message = "Birthday is required!")
    private String employeeBirthday;

    @Column(name = "employee_id_card")
    @Pattern(regexp = "^\\d{9}$",message = "Not OK.Id card invalid")
    private String employeeIdCard;

    @Column(name = "employee_salary")
    @Pattern(regexp = "^[\\d]+$",message = "Not OK.Amount invalid")
    private String employeeSalary;

    @Column(name = "employee_phone")
    @Pattern(regexp = "^0[1-9]{1}[0-9]{8}$",message = "Not OK.Phone invalid")
    private String employeePhone;

    @Column(name = "employee_email" )
    @Pattern(regexp = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$",message = "Not OK.Email invalid")
    private String employeeEmail;

    @Column(name = "employee_address")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id" ,nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id",nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id" ,nullable = false)
    private Division division;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddess) {
        this.employeeAddress = employeeAddess;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

}
