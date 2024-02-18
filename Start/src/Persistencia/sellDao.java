/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Sell;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class sellDao {
    dao DAO ;
    private EntityManager em ;

    public sellDao() {
         this.DAO = new dao();
        this.em = dao.EMF.createEntityManager();
    }
    
     public void conectar() {
        if (!em.isOpen()) {
            em = dao.EMF.createEntityManager();
        }
    }

    public void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void guardar(Sell sell) {
        conectar();
        try {
            em.getTransaction().begin();
            em.persist(sell);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Venta cargada exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al cargar la venta:" + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public void eliminar(Sell sell) {
        conectar();
        try {
            Sell s = em.find(Sell.class, sell.getId());
            em.getTransaction().begin();
            if (em.contains(s)) {
                em.remove(s);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "El usuario a sido elimindo");
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no ha sido encontrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public void editar(Sell sell) {
        conectar();
        try {
            Sell s = em.find(Sell.class, sell.getId());
            em.getTransaction().begin();
            if (em.contains(s)) {
                em.merge(sell);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Modificacion producida con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la venta");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar " + e.getMessage());
        } finally {
            desconectar();
        }
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

    public List<Sell> listarEspecificados(List<String> column, List<String> products) throws Exception {
      
        conectar();
        List<Sell> buscados = null;
        try {
            StringBuilder queryString = new StringBuilder("SELECT p FROM Product p WHERE");
            for (int i = 0; i < column.size(); i++) {
                if (i > 0) {
                    queryString.append(" AND");
                }
                queryString.append(" p.").append(column.get(i)).append(" LIKE :param").append(i);
            }
            Query query = em.createQuery(queryString.toString());
            for (int i = 0; i < column.size(); i++) {
                query.setParameter("param" + i, "%" + products.get(i) + "%");
            }
            System.out.println(queryString.toString());
            System.out.println(query.toString());
            buscados = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en listar especificados: " + e.getMessage());
            return listarTodos();
        }
        desconectar();
        return buscados;
    }
    }

