package vn.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer{
    @Id
    @Column(name = "customer_id")
    @Pattern(regexp = "^(KH)-\\d{4}$" ,message="Not OK.ID invalid")
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @Column(name = "customer_name")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Not OK.Name invalid")
    private String customerName;

    @Column(name = "customer_birthday")
    @NotEmpty(message = "Birthday is required!")
    private String customerBirthday;

    @Column(name = "customer_gender")
    private String customerGender;

    @Column(name = "customer_id_card")
    @Pattern(regexp = "^\\d{9}$",message = "Not OK.Id card invalid")
    private String customerIdCard;

    @Column(name = "customer_phone")
    @Pattern(regexp = "^0[1-9]{1}[0-9]{8}$",message = "Not OK.Phone invalid")
    private String customerPhone;

    @Column(name = "customer_email")
    @Pattern(regexp = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$",message = "Not OK.Email invalid")
    private String customerEmail;

    @Column(name = "customer_address")
    private String customerAddress;



    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


}
