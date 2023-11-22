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

    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("StartPU");
    private EntityManager em = EMF.createEntityManager();

    private final String sql;

    public productDao() {
        this.sql = "UPDATE nombre_tabla SET columna1 = valor1, columna2 = valor2 WHERE ID=";

    }

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

    public void guardar(Product product) {
        conectar();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        desconectar();
    }
// el elemento que debe ser ingresado a elimnar debe ser un dato obtendio de la persistencia a travez de entity manager para que lo reconozca https://www.youtube.com/watch?v=jPnYs3QiILI 26:13

    public void eliminar(Product product) {
        conectar();
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        desconectar();
    }
// el dato que de ingresa en el merge debe ser un objeto obetnido de la persistencia https://www.youtube.com/watch?v=jPnYs3QiILI  13:33

    public void editar(Product product) {
        conectar();
        try {
            Product p = em.find(Product.class, product.getId());
             em.getTransaction().begin();
            if (em.contains(p)) {        
                em.merge(product);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Modificacion producida con exito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar correctamente ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar " + e.getMessage());
        } finally {
            if(em != null ){
            desconectar();
            }    
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
