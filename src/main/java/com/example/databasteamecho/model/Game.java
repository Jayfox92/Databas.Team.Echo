package com.example.databasteamecho.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int id;

    @Column(name = "game_name", length = 40, nullable = false)
    private String gameName;

    @Column(name = "players_per_team")
    private int playersPerTeam;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "match")
    private List<Match> listOfMatches = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "team")
    private Team team;


    public Game(){}
    public Game(int id, String gameName, int playersPerTeam){
        this.id = id;
        this.gameName = gameName;
        this.playersPerTeam = playersPerTeam;
    }
    public Game(String gameName, int playersPerTeam){
        this.gameName = gameName;
        this.playersPerTeam = playersPerTeam;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getGameName(){return gameName;}
    public void setGameName(String gameName){this.gameName = gameName;}
    public int getPlayersPerTeam(){return playersPerTeam;}
    public void setPlayersPerTeam(int playersPerTeam){this.playersPerTeam = playersPerTeam;}
    public Team getTeam(){return team;}
    public void setTeam(Team team){this.team = team;}

    public List<Match> getListOfMatches() {
        return listOfMatches;
    }

    public void setListOfMatches(List<Match> listOfMatches) {
        this.listOfMatches = listOfMatches;
    }
}
