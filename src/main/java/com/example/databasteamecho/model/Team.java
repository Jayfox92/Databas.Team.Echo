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


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
    name = "manytomany_team_game",
    joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> team_ListOfGames = new HashSet<>();

    @ManyToMany(mappedBy = "matches_ListOfTeams")
    private Set<Matches> team_ListOfMatches = new HashSet<>();
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Player player;


  public Team() {}
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

    public Set<Game> getTeam_ListOfGames() {
        return team_ListOfGames;
    }

    public void setTeam_ListOfGames(Set<Game> team_ListOfGames) {
        this.team_ListOfGames = team_ListOfGames;
    }

    public Set<Matches> getTeam_ListOfMatches() {
        return team_ListOfMatches;
    }

    public void setTeam_ListOfMatches(Set<Matches> team_ListOfMatches) {
        this.team_ListOfMatches = team_ListOfMatches;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
