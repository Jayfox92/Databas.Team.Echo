package com.example.databasteamecho.controller;

import com.example.databasteamecho.model.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
                    System.out.println(player.getId()+", "+player.getFirstName() + ", "+player.getAlias());
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




}
