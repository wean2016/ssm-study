package main.cn.wean2016.crud.entitis;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import java.util.Date;

@Component
public class Employee {
    private Integer id;

    @NotEmpty
    private String lastName;

    @Email
    private String email;
    //1 male, 0 female
    private Integer gender;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @NumberFormat(pattern = "#,###,###.###")
    private float salary;

    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Date birth, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.department = department;
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Date birth, float salary, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public Employee setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public Date getBirth() {
        return birth;
    }

    public Employee setBirth(Date birth) {
        this.birth = birth;
        return this;
    }

    public float getSalary() {
        return salary;
    }

    public Employee setSalary(float salary) {
        this.salary = salary;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }
}
