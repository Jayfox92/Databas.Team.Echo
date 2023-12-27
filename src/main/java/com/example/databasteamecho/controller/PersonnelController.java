package com.example.databasteamecho.controller;

import com.example.databasteamecho.model.Personnel;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//Abenezer
public class PersonnelController {


    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");


    public List<Personnel> getAll(boolean printOut){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Personnel> personnelList= new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Personnel> resultList = entityManager.createQuery("FROM Personnel ", Personnel.class);
            personnelList.addAll(resultList.getResultList());
            transaction.commit();
            if(printOut){
                for (Personnel personnel:personnelList){
                    System.out.println("ID:"+personnel.getId()+", First name:"+personnel.getFirstName() + ", Nickname:"+personnel.getNickname());
                }
            }
            return personnelList;
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
