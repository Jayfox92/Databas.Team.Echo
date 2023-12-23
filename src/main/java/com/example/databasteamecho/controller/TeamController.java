package com.example.databasteamecho.controller;

import com.example.databasteamecho.model.Player;
import com.example.databasteamecho.model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static com.example.databasteamecho.controller.PlayerController.ENTITY_MANAGER_FACTORY;

public class TeamController {
    public List<Team> getAll() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Team> playerListToReturn = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Team> resultList = entityManager.createQuery("FROM Team", Team.class);
            playerListToReturn.addAll(resultList.getResultList());
            transaction.commit();

            return playerListToReturn;
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
}
