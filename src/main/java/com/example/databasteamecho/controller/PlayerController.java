package com.example.databasteamecho.controller;

import com.example.databasteamecho.model.Game;
import com.example.databasteamecho.model.Player;
import com.example.databasteamecho.model.Team;

import javax.persistence.*;
import java.util.*;

public class PlayerController {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public List<Player> getAll(boolean printOut){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Player> playerListToReturn = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Player> resultList = entityManager.createQuery("FROM Player", Player.class);
            playerListToReturn.addAll(resultList.getResultList());
            transaction.commit();
            if(printOut){
                for (Player player:playerListToReturn){
                    System.out.println("ID:"+player.getId()+", First name:"+player.getFirstName() + ", Nickname:"+player.getNickname());
                }
            }
            return playerListToReturn;
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }


    return null;
    }

    public Set<Player> getPlayersByGame(List<Game> listOfGames){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Set<Player> playerListToReturn = new HashSet<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            for (Game game:listOfGames){
                int gameId = game.getId();
                TypedQuery<Player> query = entityManager.createQuery(
                        "SELECT p FROM Player p JOIN p.player_gameList g WHERE g.id = :gameId", Player.class);
                query.setParameter("gameId", gameId);
                playerListToReturn.addAll(query.getResultList());
            }
            for (Game game:listOfGames){
                int gameId = game.getId();
                TypedQuery<Team> teamQuery = entityManager.createQuery(
                        "SELECT t FROM Team t JOIN t.team_ListOfGames g WHERE g.id = :gameId", Team.class);
                teamQuery.setParameter("gameId", gameId);
                List<Team> listOfTeams = teamQuery.getResultList();
                for (Team team:listOfTeams){

                    playerListToReturn.addAll(team.getTeam_ListOfPlayers());
                }
            }
            transaction.commit();
            return playerListToReturn;
        } catch (Exception e){
            if(transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    public Player getPlayerById(int id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Player> playerResult = entityManager.createQuery("FROM Player WHERE id = :id", Player.class);
            playerResult.setParameter("id",id);
            Player player = playerResult.getSingleResult();
            transaction.commit();
            return player;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }





    public boolean addPlayer(Object player) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(player);
            transaction.commit();
            return true;
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

    public boolean deletePlayer(int id){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Player playerToDelete = entityManager.find(Player.class, id);
            entityManager.remove(entityManager.contains(playerToDelete) ? playerToDelete : entityManager.merge(playerToDelete));
            transaction.commit();
            return true;
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

    public void updatePlayer(Player player){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(player);
            transaction.commit();
        } catch (Exception e){
            if(transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void assignGamesToPlayersAndTeams() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();


            Team team1 = entityManager.find(Team.class, 1);
            Game game1 = entityManager.find(Game.class, 1);
            team1.getTeam_ListOfGames().add(game1);
            entityManager.persist(team1);

            Team team2 = entityManager.find(Team.class, 2);
            Game game3 = entityManager.find(Game.class, 3);
            team2.getTeam_ListOfGames().add(game3);
            entityManager.persist(team2);


            Player player4 = entityManager.find(Player.class, 4);
            Game game2ForPlayer4 = entityManager.find(Game.class, 2);
            player4.getPlayer_gameList().add(game2ForPlayer4);
            entityManager.persist(player4);

            Player player8 = entityManager.find(Player.class, 8);
            Game game2ForPlayer8 = entityManager.find(Game.class, 2);
            player8.getPlayer_gameList().add(game2ForPlayer8);
            entityManager.persist(player8);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


}
