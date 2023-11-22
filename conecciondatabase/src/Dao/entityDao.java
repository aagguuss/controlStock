/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entidades.Product;
import conecciondatabase.Conexion;
import javax.persistence.EntityManager;

/**
 *
 * @author agust
 */
public class entityDao {
    public void insertProduct(Product product){
        EntityManager em = null ;
        try {
            em= Conexion.createEntityManager();
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error al guardar "+ e.getMessage());
        }finally {
            if (em != null) {
                em.close();
            }
        }
                
    }
}
