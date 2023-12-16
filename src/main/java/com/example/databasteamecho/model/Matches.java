package com.example.databasteamecho.model;

//FAHRI


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "matches")
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int id;

    @Column(name = "result")
    private int result;

    @Column(name = "match_date", length = 30)
    private String matchDate;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "matches_player_id_table",
            joinColumns = {@JoinColumn(name = "player_id")}
    )
    private Set<Player> matches_ListOfPlayers = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "matches_team_id",
            joinColumns = {@JoinColumn(name = "team_id")})
    private Set<Team> matches_ListOfTeams = new HashSet<>();



    public Matches(){}
    public Matches(int result, String matchDate){
        this.result = result;
        this.matchDate = matchDate;
    }

    public Matches(int id, int result, String matchDate){
        this.id = id;
        this.result = result;
        this.matchDate = matchDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }
    public Game getGame(){return game;}
    public void setGame(Game game){this.game = game;}

    public Set<Player> getMatches_ListOfPlayers() {
        return matches_ListOfPlayers;
    }

    public void setMatches_ListOfPlayers(Set<Player> matches_ListOfPlayers) {
        this.matches_ListOfPlayers = matches_ListOfPlayers;
    }

    public Set<Team> getMatches_ListOfTeams() {
        return matches_ListOfTeams;
    }

    public void setMatches_ListOfTeams(Set<Team> matches_ListOfTeams) {
        this.matches_ListOfTeams = matches_ListOfTeams;
    }
}

