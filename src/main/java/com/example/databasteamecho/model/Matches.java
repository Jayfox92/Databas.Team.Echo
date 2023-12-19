package com.example.databasteamecho.model;

//FAHRI


import javax.persistence.*;
import java.util.*;
import java.util.Date;

@Entity
@Table(name = "matches")
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matches_id")
    private int id;


    @Column(name = "match_date", length = 30)
    private Date matchDate;

    @Column(name = "match_status")
    private String matchStatus; // "Upcoming" or "Concluded" //abenezer

    // Winner representation for player vs player matches //Abenezer
    @ManyToOne
    @JoinColumn(name = "winner_player_id")
    private Player winnerPlayer;

    // Winner representation for team vs team matches //Abenezer
    @ManyToOne
    @JoinColumn(name = "winner_team_id")
    private Team winnerTeam;


    /**
     * The game associated with the match.
     * It's a ManyToOne relationship because each match is linked to one specific game.
     * updated by Abenezer
     */
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    /**
     * Set of players participating in the match.
     * It's a ManyToMany relationship because each match involves multiple players,
     * and each player can participate in multiple matches.
     * The 'matches_players' join table manages this relationship.
     * updated by Abenezer
     */
    @ManyToMany
    @JoinTable(
            name = "matches_players",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> matches_ListOfPlayers = new HashSet<>();

    /**
     * Set of teams participating in the match.
     * Similar to players, it's a ManyToMany relationship.
     * The 'matches_teams' join table manages the relationship between matches and teams.
     * updated by Abenezer
     */
    @ManyToMany
    @JoinTable(
            name = "matches_teams",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> matches_ListOfTeams = new HashSet<>();



    public Matches(){}

    public Matches(int id, Date matchDate, String matchStatus, Player winnerPlayer, Team winnerTeam, Game game, Set<Player> matches_ListOfPlayers, Set<Team> matches_ListOfTeams) {
        this.id = id;
        this.matchDate = matchDate;
        this.matchStatus = matchStatus;
        this.winnerPlayer = winnerPlayer;
        this.winnerTeam = winnerTeam;
        this.game = game;
        this.matches_ListOfPlayers = matches_ListOfPlayers;
        this.matches_ListOfTeams = matches_ListOfTeams;
    }

    public Matches(Date matchDate, String matchStatus, Player winnerPlayer, Team winnerTeam, Game game, Set<Player> matches_ListOfPlayers, Set<Team> matches_ListOfTeams) {
        this.matchDate = matchDate;
        this.matchStatus = matchStatus;
        this.winnerPlayer = winnerPlayer;
        this.winnerTeam = winnerTeam;
        this.game = game;
        this.matches_ListOfPlayers = matches_ListOfPlayers;
        this.matches_ListOfTeams = matches_ListOfTeams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public Team getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(Team winnerTeam) {
        this.winnerTeam = winnerTeam;
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

