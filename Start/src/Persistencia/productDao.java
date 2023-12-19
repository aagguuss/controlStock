/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class productDao {
     private dao DAO ;
    private EntityManager em ;
    
    

    public productDao() {
        this.DAO = new dao();
        this.em = DAO.EMF.createEntityManager();
        
    }

    public void conectar() {
        if (!em.isOpen()) {
            em = DAO.EMF.createEntityManager();
        }
    }

    public void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void guardar(Product product) {
        conectar();
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "producto guardado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar :" + e.getMessage());
        } finally {
            desconectar();
        }
    }
// el elemento que debe ser ingresado a elimnar debe ser un dato obtendio de la persistencia a travez de entity manager para que lo reconozca https://www.youtube.com/watch?v=jPnYs3QiILI 26:13

    public void eliminar(Product product) {
        conectar();
        try {
            Product p = em.find(Product.class, product.getId());
            em.getTransaction().begin();
            if (em.contains(p)) {
                em.remove(p);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "producto eliminado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el producto");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar :" + e.getMessage());
        } finally {
            desconectar();
        }
    }
// el dato que de ingresa en el merge debe ser un objeto obetnido de la persistencia https://www.youtube.com/watch?v=jPnYs3QiILI  13:33

    public void editar(Product product) {
        conectar();
        try {
            Product p = em.find(Product.class, product.getId());
            em.getTransaction().begin();
            if (em.contains(p)) {
                p= product;
                em.merge(product);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Modificacion producida con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar correctamente ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public Product buscarPorId(int id) throws Exception {
        conectar();
        Product product = em.find(Product.class, id);
        desconectar();
        return product;
    }

    public List<Product> listarTodos() throws Exception {
        conectar();
        // revisar query segun se desarrollen las tablas
        List<Product> products = em.createQuery("SELECT l FROM Product l")
                .getResultList();
        desconectar();
        return products;
    }

}
