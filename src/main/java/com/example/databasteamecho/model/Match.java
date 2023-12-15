package com.example.databasteamecho.model;

//FAHRI


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int iD;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    //want one to many but getting relation-error, new table might solve?
    @ManyToMany
    @JoinColumn(name = "player_id")
    private List<Player> listOfPlayers = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Team> listOfTeams = new ArrayList<>();

    @Column(name = "result")
    private int result;

    @Column(name = "match_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date matchDate;



    public Match(){

    }
    public Match(int result, Date matchDate){
        this.result = result;
        this.matchDate = matchDate;
    }

    public Match(int iD, int gamesID, int playerID, int teamNameID, int result, Date matchDate){
        this.iD = iD;
        this.result = result;
        this.matchDate = matchDate;

    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }
    public Game getGame(){return game;}
    public void setGame(Game game){this.game = game;}

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public List<Team> getListOfTeams() {
        return listOfTeams;
    }

    public void setListOfTeams(List<Team> listOfTeams) {
        this.listOfTeams = listOfTeams;
    }
}
