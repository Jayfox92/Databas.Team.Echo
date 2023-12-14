package com.example.databasteamecho.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Johann
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int id;
    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;
    @Column(name = "nickname", length = 30, nullable = false)
    private String alias;
    @Column(name = "email", length = 40)
    private String email;
    @Column(name = "phonenumber", length = 25)
    private int phonenumber;
    @Column(name = "street_adress", length = 40)
    private String streetAdress;
    @Column(name = "postal_code", length = 15)
    private int postalCode;
    @Column(name = "city", length = 30)
    private String city;
    @Column(name = "country", length = 30)
    private String country;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "match")
    private List<Match> listOfMatches = new ArrayList<>();
    public Player (){}

    public Player(int id, String firstName, String lastName, String alias, String email, int phonenumber, String streetAdress, int postalCode, String city, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
        this.phonenumber = phonenumber;
        this.streetAdress = streetAdress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Player(String firstName, String lastName, String alias, String email, int phonenumber, String streetAdress, int postalCode, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
        this.phonenumber = phonenumber;
        this.streetAdress = streetAdress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
