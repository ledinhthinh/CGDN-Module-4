package vn.codegym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_birthday")
    private String customerBirthday;
    @Column(name = "customer_gender")
    private String customerGender;
    @Column(name = "customer_id_card")
    private String customerIdCard;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "customer_address")
    private String customerAddress;
}
