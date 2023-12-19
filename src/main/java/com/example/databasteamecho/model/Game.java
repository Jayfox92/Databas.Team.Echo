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

    @OneToMany(mappedBy = "game")
    private Set<Matches> game_ListOfMatches = new HashSet<>();

    @ManyToMany(mappedBy = "team_ListOfGames")
    private Set<Team> game_ListOfTeams = new HashSet<>();
    @ManyToMany(mappedBy = "player_gameList")
    private Set<Player> game_ListOfPlayers = new HashSet<>();


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

    public Set<Matches> getGame_ListOfMatches() {
        return game_ListOfMatches;
    }

    public void setGame_ListOfMatches(Set<Matches> game_ListOfMatches) {
        this.game_ListOfMatches = game_ListOfMatches;
    }

    public Set<Team> getGame_ListOfTeams() {
        return game_ListOfTeams;
    }

    public void setGame_ListOfTeams(Set<Team> game_ListOfTeams) {
        this.game_ListOfTeams = game_ListOfTeams;
    }

    public Set<Player> getGame_ListOfPlayers() {
        return game_ListOfPlayers;
    }

    public void setGame_ListOfPlayers(Set<Player> game_ListOfPlayers) {
        this.game_ListOfPlayers = game_ListOfPlayers;
    }
}
