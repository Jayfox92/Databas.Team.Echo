package com.example.databasteamecho.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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


    @ManyToOne  // Changed from ManyToMany since  a team is always tied to a specific game //Abenezer
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "team")
    private Set<Player> players;  // New field for associating players


    @ManyToMany(mappedBy = "matches_ListOfTeams")
    private Set<Matches> team_ListOfMatches = new HashSet<>();

    @OneToMany(mappedBy = "winnerTeam")  // New field for matches won by the team //Abenezer
    private Set<Matches> wonMatches = new HashSet<>();


  public Team() {}

    public Team(int id, String teamName, Game game, Set<Player> players, Set<Matches> team_ListOfMatches, Set<Matches> wonMatches) {
        this.id = id;
        this.teamName = teamName;
        this.game = game;
        this.players = players;
        this.team_ListOfMatches = team_ListOfMatches;
        this.wonMatches = wonMatches;
    }

    public Team(String teamName, Game game, Set<Player> players, Set<Matches> team_ListOfMatches, Set<Matches> wonMatches) {
        this.teamName = teamName;
        this.game = game;
        this.players = players;
        this.team_ListOfMatches = team_ListOfMatches;
        this.wonMatches = wonMatches;
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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }


    public Set<Matches> getTeam_ListOfMatches() {
        return team_ListOfMatches;
    }

    public void setTeam_ListOfMatches(Set<Matches> team_ListOfMatches) {
        this.team_ListOfMatches = team_ListOfMatches;
    }

    public Set<Matches> getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(Set<Matches> wonMatches) {
        this.wonMatches = wonMatches;
    }
}
