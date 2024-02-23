/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author agust
 */

public class dao {
 public static EntityManagerFactory EMF ;
    

    public dao() {
    dao.EMF =  Persistence.createEntityManagerFactory("StartPU");
    }
  
 
   
}
