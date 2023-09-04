package org.example;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Students")
public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courses;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "student_id")
    private List <LinkedPurchaseList> purchaseList;







    @Override
    public String toString() {
        return "Hibernate.Student{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", registrationDate=" + registrationDate +
               '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<LinkedPurchaseList> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<LinkedPurchaseList> purchaseList) {
        this.purchaseList = purchaseList;
    }


}


