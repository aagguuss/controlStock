/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conecciondatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author agust
 */
public class Conexion {
     private static EntityManagerFactory emf = null ;
      public static EntityManager createEntityManager(){
          try{
            if (emf != null){
                emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            }}catch(Exception e){
                    System.out.println(e);
                    }
           return emf.createEntityManager();
            }
           
      }

