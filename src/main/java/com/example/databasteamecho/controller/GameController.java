package com.example.databasteamecho.controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class GameController {



    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    // create/save new game
    public boolean newGame(Object game) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(game);
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

    // read/get all games
    public List<Game> getAll(boolean printOut) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Game> gamesToReturn = new ArrayList<>();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> resultList = entityManager.createQuery("FROM game", game.game_name);
            gamesToReturn.addAll(resultList.getResultList());
            transaction.commit();
            if (printOut) {
                for (Game game :
                        gamesToReturn) {
            //        System.out.println(customer.getId() + ". " + customer.getName()); //  kopia
            //        for (Car car :
            //                customer.getOwnedCars()) {
            //            System.out.println("\t - " + car.getPlateNumber());
                    }
                }
            }
        //    return customerListToReturn;
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

    // update game
    public boolean updateGame(Game game){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(game);
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

    // delete game
    public boolean deleteGame(Game game){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            // If the entity is attached then remove customer, else merge(attach/update) entity and then remove
            entityManager.remove(entityManager.contains(game) ? customer:entityManager.merge(game)); //kan vara fel objekt-typ
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

}
