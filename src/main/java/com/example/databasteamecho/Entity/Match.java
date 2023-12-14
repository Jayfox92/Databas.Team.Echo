package com.example.databasteamecho.Entity;

//FAHRI
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MatchID")
    private int iD;


    @Column(name = "GamesID")
    private int gamesID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerID")
    private int playerID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TeamNameID")
    private int teamNameID;

    @Column(name = "Result")
    private int result;

    @Column(name = "MatchDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date matchDate;

    @OneToOne
    @JoinColumn(name = "games_id")
    private Game game;

    public Match(){

    }
    public Match(int result, Date matchDate){
        this.result = result;
        this.matchDate = matchDate;
    }

    public Match(int iD, int gamesID, int playerID, int teamNameID, int result, Date matchDate){
        this.iD = iD;
        this.gamesID = gamesID;
        this.playerID = playerID;
        this.teamNameID = teamNameID;
        this.result = result;
        this.matchDate = matchDate;

    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getGamesID() {
        return gamesID;
    }

    public void setGamesID(int gamesID) {
        this.gamesID = gamesID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getTeamNameID() {
        return teamNameID;
    }

    public void setTeamNameID(int teamNameID) {
        this.teamNameID = teamNameID;
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
}
