package com.example.databasteamecho.controller;

import com.example.databasteamecho.model.Game;
import com.example.databasteamecho.model.Matches;
import com.example.databasteamecho.model.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static com.example.databasteamecho.controller.PlayerController.ENTITY_MANAGER_FACTORY;

public class GameController {

    public List<Game> getAll(boolean printOut) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Game> gameListToReturn = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> resultList = entityManager.createQuery("FROM Game ", Game.class);
            gameListToReturn.addAll(resultList.getResultList());
            transaction.commit();

            return gameListToReturn;
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

    public List<Game> getGamesByIds(List<Integer> gameIds){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Game> gameListToReturn = new ArrayList<>();
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<Game> query = entityManager.createQuery("FROM Game g WHERE g.id IN :gameIds", Game.class);
            query.setParameter("gameIds", gameIds);
            gameListToReturn = query.getResultList();

            transaction.commit();
        }catch (Exception e){
            if (transaction!= null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
        return gameListToReturn;
    }
}
