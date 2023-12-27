package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.GameController;
import com.example.databasteamecho.controller.PlayerController;
import com.example.databasteamecho.controller.TeamController;
import com.example.databasteamecho.model.Game;
import com.example.databasteamecho.model.Player;
import com.example.databasteamecho.model.Team;

import java.util.ArrayList;
import java.util.List;

public class PlayerDisplayItem {
    private PlayerController playerController = new PlayerController();
    private TeamController teamController = new TeamController();
    private GameController gameController = new GameController();
    private String label;
    private String value;

    private Class<?> type;
    private int id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private String phonenumber;
    private String streetAdress;
    private String postalCode;
    private String city;
    private String country;
    private Team team;
    private String teamName;




public PlayerDisplayItem(){}
    public PlayerDisplayItem(String label, String value, Class<?> type) {
        this.label = label;
        this.value = value;
        this.type = type;
    }

    public PlayerDisplayItem(int id, String firstName, String lastName, String nickname, String email, String phonenumber, String streetAdress, String postalCode, String city, String country) {
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

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return label;
    }

    public List<PlayerDisplayItem> getPlayers(){
        List<Player> listOfPlayers = playerController.getAll(false);
        List<Team> listOfTeams = teamController.getAll();
        List<PlayerDisplayItem> displayItems = new ArrayList<PlayerDisplayItem>();
        for(Player player : listOfPlayers){
            PlayerDisplayItem a = new PlayerDisplayItem(
                    id = player.getId(),
                    firstName = player.getFirstName(),
                    lastName = player.getLastName(),
                    nickname = player.getNickname(),
                    email = player.getEmail(),
                    phonenumber = player.getPhonenumber(),
                    streetAdress = player.getStreetAdress(),
                    postalCode = player.getPostalCode(),
                    city = player.getCity(),
                    country = player.getCountry()
                    );
            if(player.getTeam()!=null){
                try {
                    a.setTeamName(player.getTeam().getTeamName());
                }catch (Exception ignored) {}

            }
            displayItems.add(a);
        }
        return displayItems;
}

    public Player getPlayerById(){
    return playerController.getPlayerById(id);
    }

    public List<Game> getGames(){
    return gameController.getAll(false);
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

