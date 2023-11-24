/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class UsuarioDao {

    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("StartPU");
    private EntityManager em = EMF.createEntityManager();

    public UsuarioDao() {

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

    public void guardar(Usuario usuario) {
        conectar();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Usuario cargado exitosamente ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al cargar usuario:" + e.getMessage());
        } finally {
            desconectar();
        }

    }

    public void eliminar(Usuario usuario) {
        conectar();
        try {
            Usuario u = em.find(Usuario.class, usuario.getId());
            em.getTransaction().begin();
            if (em.contains(u)) {
                em.remove(u);
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

    public void editar(Usuario usuario) {
        conectar();
        try {
            Usuario u = em.find(Usuario.class, usuario.getId());
            em.getTransaction().begin();
            if (em.contains(u)) {
                em.merge(usuario);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Modificacion producida con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public Usuario buscarPorId(int id) throws Exception {
        conectar();
        Usuario usuario = em.find(Usuario.class, id);
        desconectar();
        return usuario;
    }

    public List<Usuario> listarTodos() throws Exception {
        conectar();
        List<Usuario> usuario = em.createQuery("SELECT l FROM Usuario l")
                .getResultList();
        desconectar();
        return usuario;
    }

    public List<Usuario> UsuarioConsulta(String nombre) {
        conectar();
        List<Usuario> usuario = em.createQuery("select a from Usuario a WHERE a.name = '" + nombre + "'").getResultList();
        desconectar();
        return usuario;
    }
    public boolean existeUsuarioAdmin() throws Exception {
    List<Usuario> usuarios = listarTodos();
    for (Usuario usuario : usuarios) {
        if (usuario.getRol().getNombre().equalsIgnoreCase("administrador")) {
            return true;
        }
    }
    return false;
}
}
