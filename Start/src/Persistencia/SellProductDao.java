/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Product;
import Entidades.SellProduct;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class SellProductDao {
    private dao DAO;
    private EntityManager em;

    public SellProductDao() {
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

    public void guardar(SellProduct product) {
        conectar();
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "producto vendido Registrado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar :" + e.getMessage());
        } finally {
            desconectar();
        }
    }
    
    public void eliminar(SellProduct product) {
        conectar();
        try {
            SellProduct p = em.find(SellProduct.class, product.getId());
            em.getTransaction().begin();
            if (em.contains(p)) {
                em.remove(p);
                em.getTransaction().commit();
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el producto");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar :" + e.getMessage());
        } finally {
            desconectar();
        }
    }
    
    public void editar(SellProduct product) {
        conectar();
        try {
            SellProduct p = em.find(SellProduct.class, product.getId());
            em.getTransaction().begin();
            if (em.contains(p)) {
                p = product;
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
    
    public SellProduct buscarPorId(int id) throws Exception {
        conectar();
        SellProduct product = em.find(SellProduct.class, id);
        desconectar();
        return product;
    }
      
       public List<SellProduct> listarTodos() throws Exception {
        conectar();
        // revisar query segun se desarrollen las tablas
        List<SellProduct> products = em.createQuery("SELECT l FROM SellProduct l")
                .getResultList();
        desconectar();
        return products;
    }
//SELECT p FROM Product p WHERE p.name LIKE :param0 AND p.blend LIKE :param1

    public List<SellProduct> listarEspecificados(List<String> column, List<String> produtos) throws Exception {
        conectar();
        List<SellProduct> buscados = null;
        try {
            StringBuilder queryString = new StringBuilder("SELECT p FROM SellProduct p WHERE");
            for (int i = 0; i < column.size(); i++) {
                if (i > 0) {
                    queryString.append(" AND");
                }
                queryString.append(" p.").append(column.get(i)).append(" LIKE :param").append(i);
            }
            Query query = em.createQuery(queryString.toString());
            for (int i = 0; i < column.size(); i++) {
                query.setParameter("param" + i, "%" + produtos.get(i) + "%");
            }
            buscados = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en listar especificados: " + e.getMessage());
            return listarTodos();
        }
        desconectar();
        return buscados;
    }

 
    public List<SellProduct> buscarPorMarca(String marca) throws Exception {
         try {
        conectar();

        // Construir la consulta dinámicamente
        String jpql = "SELECT p FROM SellProduct p WHERE 1=1";

      

        // Verificar si se proporciona la marca como parámetro
        if (marca != null && !marca.isEmpty()) {
            jpql += " AND p.ProductBlend = :marca";
        }

        // Crear la consulta
        TypedQuery<SellProduct> query = em.createQuery(jpql, SellProduct.class);

       
        if (marca != null && !marca.isEmpty()) {
            query.setParameter("marca", marca);
        }

        // Ejecutar la consulta y obtener resultados
        List<SellProduct> products = query.getResultList();

        return products;
    } catch (Exception e) {
        System.out.println("" + e.getMessage());
    } finally {
        desconectar();
    }
    return null;
}

    public List<SellProduct> buscarPorCategoria(String categoria) throws Exception {
    try {
        conectar();

        // Construir la consulta dinámicamente
        String jpql = "SELECT p FROM SellProduct p WHERE 1=1";

        // Verificar si se proporciona la categoría como parámetro
        if (categoria != null && !categoria.isEmpty()) {
            jpql += " AND p.category = :categoria";
        }
        // Crear la consulta
        TypedQuery<SellProduct> query = em.createQuery(jpql, SellProduct.class);

        // Establecer parámetros si es necesario
        if (categoria != null && !categoria.isEmpty()) {
            query.setParameter("categoria", categoria);
        }
      
        // Ejecutar la consulta y obtener resultados
        List<SellProduct> products = query.getResultList();

        return products;
    } catch (Exception e) {
        System.out.println("" + e.getMessage());
    } finally {
        desconectar();
    }
    return null;
}
    
     public List<SellProduct> buscarPorCategoriayMarca(String categoria, String marca) throws Exception {
     try {
        conectar();

        // Construir la consulta dinámicamente
        String jpql = "SELECT p FROM SellProduct p WHERE 1=1";

        // Verificar si se proporciona la categoría como parámetro
        if (categoria != null && !categoria.isEmpty()) {
            jpql += " AND p.category = :categoria";
        }

        // Verificar si se proporciona la marca como parámetro
        if (marca != null && !marca.isEmpty()) {
            jpql += " AND p.ProductBlend = :marca";
        }

        // Crear la consulta
        TypedQuery<SellProduct> query = em.createQuery(jpql, SellProduct.class);

        // Establecer parámetros si es necesario
        if (categoria != null && !categoria.isEmpty()) {
            query.setParameter("categoria", categoria);
        }
        if (marca != null && !marca.isEmpty()) {
            query.setParameter("marca", marca);
        }

        // Ejecutar la consulta y obtener resultados
        List<SellProduct> products = query.getResultList();

        return products;
    } catch (Exception e) {
        System.out.println("" + e.getMessage());
    } finally {
        desconectar();
    }
    return null;
}

   public List<String> TraerTodasMarcas() {
    try {
        conectar();

        List<String> resultadosBrutos = em.createQuery("SELECT DISTINCT p.ProductBlend FROM SellProduct p", String.class)
                .getResultList();

        return resultadosBrutos;
    } finally {
        desconectar();
    }
}

    public List<String> TraerTodasCategorias() {
        try {
        conectar();

        List<String> categorias = em.createQuery("SELECT DISTINCT p.category FROM SellProduct p", String.class)
                .getResultList();

        return categorias;
    } finally {
        desconectar();
    }

    }
}

