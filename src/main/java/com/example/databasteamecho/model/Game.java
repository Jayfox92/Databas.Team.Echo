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

    @Column(name = "players_per_team", length = 40, nullable = false)
    private int playersPerTeam;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<Team> teams;


    public Game() {
    }

    public Game(String gameName) {
        this.gameName = gameName;
        this.playersPerTeam = playersPerTeam;
    }

    public Game(String gameName, int playersPerTeam, Set<Team> teams) {
        this.gameName = gameName;
        this.playersPerTeam = playersPerTeam;
        this.teams = teams;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getPlayersPerTeam() {
        return playersPerTeam;
    }

    public void setPlayersPerTeam(int playersPerTeam) {
        this.playersPerTeam = playersPerTeam;
    }


    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }



}