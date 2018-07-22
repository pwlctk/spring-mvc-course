package pl.pwlctk.kursspringmvc.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstname;
    private String lastname;


    @OneToOne
    private Package apackage;

    public Customer() {
    }

    public Customer(String firstname, String lastname, Package apackage) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.apackage = apackage;
    }

    public Customer(int id, String firstname, String lastname, Package apackage) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.apackage = apackage;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Package getApackage() {
        return apackage;
    }

    public void setApackage(Package apackage) {
        this.apackage = apackage;
    }
}
