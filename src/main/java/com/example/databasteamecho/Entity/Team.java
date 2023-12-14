package com.example.databasteamecho.Entity;

import javax.persistence.*;

//Abenezer
@Entity

@Table (name="teams")
public class Team {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name =  "player_id")
    private int id;


    @Column (name= "team_name", length = 30)
    private  String teamName;


    @Column (name = "game_id")
    private int gameId ;




  public Team() {
      
  }

  public Team(int id, String teamName, int gameId) {

    this.id = id;
    this.teamName = teamName;
    this.gameId = gameId;

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

    public int getGameId() {

    return gameId;

    }

    public void setGameId(int gameId) {

    this.gameId = gameId;

    }

    











}
