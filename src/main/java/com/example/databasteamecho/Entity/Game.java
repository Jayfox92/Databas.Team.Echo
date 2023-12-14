package com.example.databasteamecho.Entity;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "matches")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int id;

    @Column(name = "players_per_team")
    private int playersPerTeam;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "Matches")
    private HashSet<Match> listOfMatches = new HashSet<>();
}
