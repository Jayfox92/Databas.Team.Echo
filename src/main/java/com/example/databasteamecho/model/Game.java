package com.example.databasteamecho.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Johann, Abenezer & Fahri
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "game")
    private Set<Matches> game_ListOfMatches = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "game")
    private Set<Team> teams; // A game can have multiple teams // Abenezer



    public Game(){}

    public Game(int id, String gameName, int playersPerTeam, Set<Matches> game_ListOfMatches, Set<Team> teams) {
        this.id = id;
        this.gameName = gameName;
        this.playersPerTeam = playersPerTeam;
        this.game_ListOfMatches = game_ListOfMatches;
        this.teams = teams;
    }

    public Game(String gameName, int playersPerTeam, Set<Matches> game_ListOfMatches, Set<Team> teams) {
        this.gameName = gameName;
        this.playersPerTeam = playersPerTeam;
        this.game_ListOfMatches = game_ListOfMatches;
        this.teams = teams;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getGameName(){return gameName;}
    public void setGameName(String gameName){this.gameName = gameName;}
    public int getPlayersPerTeam(){return playersPerTeam;}
    public void setPlayersPerTeam(int playersPerTeam){this.playersPerTeam = playersPerTeam;}

    public Set<Matches> getGame_ListOfMatches() {
        return game_ListOfMatches;
    }

    public void setGame_ListOfMatches(Set<Matches> game_ListOfMatches) {
        this.game_ListOfMatches = game_ListOfMatches;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
