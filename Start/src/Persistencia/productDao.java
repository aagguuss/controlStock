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

    public void eliminar(Product product) {
        conectar();
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        desconectar();
    }

    public void editar(Product product) {
        System.out.println(product.toString());
        conectar();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        desconectar();
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
    public void Update(Product product){
    
        
    }
    
}
