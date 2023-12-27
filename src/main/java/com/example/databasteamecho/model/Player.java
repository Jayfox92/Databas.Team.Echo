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
    @Column(name = "phonenumber", length = 40)
    private String phonenumber;
    @Column(name = "street_adress", length = 40)
    private String streetAdress;
    @Column(name = "postal_code", length = 25)
    private String postalCode;
    @Column(name = "city", length = 30)
    private String city;
    @Column(name = "country", length = 30)
    private String country;
    @ManyToMany(mappedBy = "matches_ListOfPlayers")
    private Set<Matches> player_ListOfMatches = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "team_id_in_players")
     @JoinColumn(name = "team_id")
    private Team team;
    @ManyToMany
    @JoinTable(
            name = "manytomany_player_game",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> player_gameList = new HashSet<>();
    public Player (){}

    public Player(int id, String firstName, String lastName, String nickname, String email, String phonenumber, String streetAdress, String postalCode, String city, String country) {
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
    }

    public Player(String firstName, String lastName, String nickname, String email, String phonenumber, String streetAdress, String postalCode, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
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

    public Set<Game> getPlayer_gameList() {
        return player_gameList;
    }

    public void setPlayer_gameList(Set<Game> player_gameList) {
        this.player_gameList = player_gameList;
    }



    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + nickname + ")";
    }


}
