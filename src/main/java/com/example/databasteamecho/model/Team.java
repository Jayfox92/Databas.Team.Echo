package com.example.databasteamecho.model;

import javax.persistence.*;

//Abenezer
@Entity

@Table (name="team")
public class Team {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name =  "team_id")
    private int id;


    @Column (name= "team_name", length = 30)
    private  String teamName;


    @OneToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Match match;






  public Team() {

  }



    public Team(int id, String teamName) {

    this.id = id;
    this.teamName = teamName;

    }

    public Team(String teamName) {
        this.teamName = teamName;
    }



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

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
    











}