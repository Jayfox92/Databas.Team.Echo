package com.example.databasteamecho.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Abenezer
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int id;

    @Column(name = "team_name", length = 30)
    private String teamName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private Set<Player> team_id_in_players = new HashSet<>();
    private Set<Player> players;
    // Constructors
    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(int id, String teamName, Game game, Set<Player> players) {
        this.id = id;
        this.teamName = teamName;
        this.game = game;
        this.players = players;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

  /*  public Set<Player> getTeam_id_in_players() {
        return team_id_in_players;
     } */

    /*public void setTeam_id_in_players(Set<Player> team_id_in_players) {
        this.team_id_in_players = team_id_in_players;
    } */

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return this.teamName; // Or any other meaningful representation
    }


}
