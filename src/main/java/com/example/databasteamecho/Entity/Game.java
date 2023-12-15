package com.example.databasteamecho.Entity;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int id;

    @Column(name = "players_per_team")
    private int playersPerTeam;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "match")
    private HashSet<Match> listOfMatches = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "team")
    private List<Team> listOfTeams = new ArrayList<>();
}
