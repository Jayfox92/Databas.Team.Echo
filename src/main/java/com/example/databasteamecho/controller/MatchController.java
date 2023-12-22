package com.example.databasteamecho.controller;

import com.example.databasteamecho.model.Matches;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class MatchController {
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    //CREATE
    public static void addMatch(Matches match) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(match); //Lägger till match i databasen
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

    //---------------------------

    //READ
    public static List<Matches> getAll(boolean printOut) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Matches> matchListToReturn = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Matches> resultList = entityManager.createQuery("FROM Matches ", Matches.class);
            matchListToReturn.addAll(resultList.getResultList());
            transaction.commit();
            if (printOut) {
                for (Matches matches : matchListToReturn) {
                    System.out.println("MatchID: " + matches.getId() + "Game: " + matches.getGame() + "Result: " + matches.getResult() + "Date: " + matches.getMatchDate());
                }
            }

            return matchListToReturn;
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
    //----------------------------

    //UPDATE
    public boolean updateMatch(Matches matches){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(matches);
            transaction.commit();
            return true;
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }
    //----------------------------

    //DELETE
    public static boolean deleteMatch(Matches matches){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.remove(entityManager.contains(matches) ? matches:entityManager.merge(matches));
            transaction.commit();
            return true;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }
}
