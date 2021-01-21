package vn.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User implements Validator {
    @NotEmpty
    @Size(min = 5,max = 45)
    private String firstName;
    @Size(min = 5,max = 45)
    private String lastName;
    private String phone;
    @Min(18)
    private int age;
    @Email
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phone = user.getPhone();
        ValidationUtils.rejectIfEmpty(errors, "phone", "number.empty");
        if (phone.length()>11 || phone.length()<10){
            errors.rejectValue("phone", "number.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone", "number.startsWith");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "number.matches");
        }

    }
}
