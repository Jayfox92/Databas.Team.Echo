package com.example.databasteamecho.model;

//FAHRI


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "matches")
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matches_id")
    private int id;

    @Column(name = "result")
    private String result;

    @Column(name = "match_date", length = 30)
    private String matchDate;

    @Column(name = "match_status", length = 30)
    private String matchStatus;

    @Column(name = "winner_player_id")
    private int winnerPlayerId;

    @Column(name = "winner_team_id")
    private int winnerTeamId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "manytomany_matches_player",
            joinColumns = @JoinColumn(name = "matches_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> matches_ListOfPlayers = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "manytomany_matches_team",
            joinColumns = @JoinColumn(name = "matches_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> matches_ListOfTeams = new HashSet<>();



    public Matches(){}
    public Matches(String result, String matchDate, String matchStatus, int winnerPlayerId, int winnerTeamId){
        this.result = result;
        this.matchDate = matchDate;
        this.matchStatus = matchStatus;
        this.winnerPlayerId = winnerPlayerId;
        this.winnerTeamId = winnerTeamId;
    }

    public Matches(int id, String result, String matchDate, String matchStatus, int winnerPlayerId, int winnerTeamId){
        this.id = id;
        this.result = result;
        this.matchDate = matchDate;
        this.matchStatus = matchStatus;
        this.winnerPlayerId = winnerPlayerId;
        this.winnerTeamId = winnerTeamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public int getWinnerPlayerId() {
        return winnerPlayerId;
    }

    public void setWinnerPlayerId(int winnerPlayerId) {
        this.winnerPlayerId = winnerPlayerId;
    }

    public int getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(int winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
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

