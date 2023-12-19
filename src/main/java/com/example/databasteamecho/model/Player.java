package com.example.databasteamecho.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private String nickname;
    @Column(name = "email", length = 40)
    private String email;
    @Column(name = "phonenumber", length = 25)
    private String phonenumber;
    @Column(name = "street_adress", length = 40)
    private String streetAdress;
    @Column(name = "postal_code", length = 15)
    private int postalCode;
    @Column(name = "city", length = 30)
    private String city;
    @Column(name = "country", length = 30)
    private String country;
    @ManyToMany(mappedBy = "matches_ListOfPlayers")
    private Set<Matches> player_ListOfMatches = new HashSet<>();

    @ManyToOne  // Establishes a ManyToOne relationship with Team
    @JoinColumn(name = "team_id")  // Foreign key column in player table
    private Team team;  // New field to link player to a team

    @OneToMany(mappedBy = "winnerPlayer")  // New field for matches won by the player //Abenezer
    private Set<Matches> wonMatches = new HashSet<>();


    public Player (){}

    public Player(int id, String firstName, String lastName, String nickname, String email, String phonenumber, String streetAdress, int postalCode, String city, String country, Set<Matches> player_ListOfMatches, Team team, Set<Matches> wonMatches) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.streetAdress = streetAdress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.player_ListOfMatches = player_ListOfMatches;
        this.team = team;
        this.wonMatches = wonMatches;
    }

    public Player(String firstName, String lastName, String nickname, String email, String phonenumber, String streetAdress, int postalCode, String city, String country, Set<Matches> player_ListOfMatches, Team team, Set<Matches> wonMatches) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.streetAdress = streetAdress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.player_ListOfMatches = player_ListOfMatches;
        this.team = team;
        this.wonMatches = wonMatches;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    } //changed to setNickname //Abenezer

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    } // changed the parameter to long to match the phonenumber field type //Abenezer

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

    public Set<Matches> getListOfMatches() {
        return player_ListOfMatches;
    }

    public void setListOfMatches(Set<Matches> listOfMatches) {
        this.player_ListOfMatches = listOfMatches;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<Matches> getPlayer_ListOfMatches() {
        return player_ListOfMatches;
    }

    public void setPlayer_ListOfMatches(Set<Matches> player_ListOfMatches) {
        this.player_ListOfMatches = player_ListOfMatches;
    }

    public Set<Matches> getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(Set<Matches> wonMatches) {
        this.wonMatches = wonMatches;
    }
}
