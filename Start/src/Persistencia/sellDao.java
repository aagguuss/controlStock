/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Sell;
import Entidades.SellProduct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class sellDao {

    dao DAO;
    private EntityManager em;

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
        List<Sell> Sells = em.createQuery("SELECT s FROM Sell s", Sell.class).getResultList();
        desconectar();
        return Sells;
    }

    public List<Sell> listarEspecificados(List<String> column, List<String> products) throws Exception {
      conectar();
    List<Sell> buscados = null;

    // Verificar si las listas están vacías
    if (column.isEmpty() && products.isEmpty()) {
        return listarTodos(); // Si no se especifican criterios, devolver todos los registros
    }

    // Construir la consulta JPQL base
    StringBuilder queryString = new StringBuilder("SELECT s FROM Sell s");

    // Verificar si se necesita agregar un JOIN basado en los criterios
    boolean needJoin = false;
    for (String col : column) {
        if ("products.ProductName".equals(col)) {
            needJoin = true;
            break;
        }
    }

    // Agregar el JOIN solo si es necesario
    if (needJoin) {
        queryString.append(" JOIN s.products p");
    }

    // Construir las cláusulas WHERE según los criterios proporcionados
    boolean whereAdded = false;
    for (int i = 0; i < column.size(); i++) {
        if (products.get(i) != null && !products.get(i).isEmpty()) { // Verificar si el parámetro no está vacío
            if (!whereAdded) {
                queryString.append(" WHERE ");
                whereAdded = true;
            } else {
                queryString.append(" AND ");
            }
            if ("Date".equals(column.get(i))) {
                queryString.append("s.").append(column.get(i)).append(" BETWEEN :startDate AND :endDate");
            } else if ("products.ProductName".equals(column.get(i))) {
                queryString.append("p.").append(column.get(i).substring(column.get(i).indexOf(".") + 1)).append(" LIKE :param").append(i);
            } else {
                queryString.append("s.").append(column.get(i)).append(" LIKE :param").append(i);
            }
        }
    }

    // Crear la consulta JPQL
    Query query = em.createQuery(queryString.toString());

    // Asignar parámetros
    for (int i = 0; i < column.size(); i++) {
        if (products.get(i) != null && !products.get(i).isEmpty()) { // Verificar si el parámetro no está vacío
            if ("Date".equals(column.get(i))) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate startDate = LocalDate.parse(products.get(i), formatter);
                LocalDateTime startDateTime = startDate.atStartOfDay();
                LocalDateTime endDateTime = startDate.atTime(LocalTime.MAX);
                query.setParameter("startDate", startDateTime);
                query.setParameter("endDate", endDateTime);
            } else {
                query.setParameter("param" + i, "%" + products.get(i) + "%");
            }
        }
    }

    // Ejecutar la consulta
    try {
        buscados = query.getResultList();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error en listar especificados: " + e.getMessage());
        System.out.println(e.getMessage());
        return listarTodos();
    } finally {
        desconectar();
    }

    return buscados;
    }

    public Sell buscarUltimo() {
        conectar();
        Sell sell = null;
        try {
            // Consulta JPQL para obtener el último objeto Sell persistido
            String jpql = "SELECT s FROM Sell s ORDER BY s.id DESC";
            Query query = em.createQuery(jpql);
            query.setMaxResults(1); // Limitar los resultados a 1
            sell = (Sell) query.getSingleResult();
        } catch (NoResultException e) {
            // Manejar la excepción si no se encuentra ningún objeto Sell persistido
            JOptionPane.showMessageDialog(null, "No se encontró ningún objeto Sell persistido");
        } catch (Exception e) {
            // Manejar otras excepciones
            JOptionPane.showMessageDialog(null, "Error al buscar el último objeto Sell: " + e.getMessage());
        } finally {
            desconectar();
        }
        return sell;
    }

  
}
