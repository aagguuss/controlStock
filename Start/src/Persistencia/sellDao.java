/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Product;
import Entidades.Sell;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author agust
 */
public class sellDao {
    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("StartPU");
    private EntityManager em = EMF.createEntityManager();
    
     public void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    public void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void guardar(Sell Sell) {
        conectar();
        em.getTransaction().begin();
        em.persist(Sell);
        em.getTransaction().commit();
        desconectar();
    }

    public void eliminar(Sell Sell) {
        conectar();
        em.getTransaction().begin();
        em.remove(Sell);
        em.getTransaction().commit();
        desconectar();
    }

    public void editar(Sell Sell) {
        conectar();
        em.getTransaction().begin();
        em.merge(Sell);
        em.getTransaction().commit();
        desconectar();
    }

    public Sell buscarPorId(int id) throws Exception {
        conectar();
       Sell sell = em.find(Sell.class, id);
        desconectar();
        return sell;
    }

    public List<Sell> listarTodos() throws Exception {
        conectar();
        // revisar query segun se desarrollen las tablas
        List<Sell> Sells = em.createQuery("SELECT l FROM sell l")
                .getResultList();
        desconectar();
        return Sells;
    }
}
