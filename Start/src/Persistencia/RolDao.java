/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import entidades.Rol;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class RolDao {

    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("StartPU");
    private EntityManager em = EMF.createEntityManager();

    public RolDao() {
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

    public void guardar(Rol rol) {
        conectar();
        em.getTransaction().begin();
        try {
            em.persist(rol);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Rol guardado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar :" + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public void eliminar(Rol rol) {
        conectar();
        try {
            Rol r = em.find(Rol.class, rol.getId());
            em.getTransaction().begin();
            if (em.contains(r)) {
                em.remove(r);
                em.getTransaction().commit();
                 JOptionPane.showMessageDialog(null, "El Rol a sido elimindo");
            }else{
                JOptionPane.showMessageDialog(null, "El Rol no ha sido encontrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " + e.getMessage());
        } finally {
            desconectar();
        }    
    }

    public void editar(Rol rol) {
        conectar();
        try {
            Rol r = em.find(Rol.class, rol.getId());
            em.getTransaction().begin();
            if (em.contains(r)) {
                em.merge(rol);
                em.getTransaction().commit();
                 JOptionPane.showMessageDialog(null, "El Rol a sido editado");
            }else{
                JOptionPane.showMessageDialog(null, "El Rol no ha sido encontrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar " + e.getMessage());
        } finally {
            desconectar();
        }
        }
        

    public Rol buscarPorId(int id) throws Exception {
        conectar();
        Rol rol = em.find(Rol.class, id);
        desconectar();
        return rol;
    }

    public List<Rol> listarTodos() throws Exception {
        conectar();
        List<Rol> usuario = em.createQuery("SELECT l FROM Rol l")
                .getResultList();
        desconectar();
        return usuario;
    }

    public List<Rol> UsuarioConsulta(String nombre) {
        conectar();
        List<Rol> Roles = em.createQuery("select a from Rol a WHERE a.nombre = '" + nombre + "'").getResultList();// chequar query
        desconectar();
        return Roles;
    }
}
