/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class UsuarioDao {

    public dao DAO;
    private EntityManager em;

    public UsuarioDao() {
        this.DAO = new dao();
        this.em = DAO.EMF.createEntityManager();
    }

    public void conectar() {

        if (em == null || !em.isOpen()) {
            em = dao.EMF.createEntityManager();

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
            JOptionPane.showMessageDialog(null, "Usuario dado alta exitosamente ");

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
                u = usuario;
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

    public Usuario UsuarioConsulta(String nombre, String password) {
        conectar();
        Usuario u = new Usuario();
        try {
            u = (Usuario) em.createQuery("select a from Usuario a WHERE a.name = '" + nombre + "' AND a.password = '" + password + "'").getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            desconectar();
        }
        return u;
    }

    public boolean existeUsuarioAdmin() throws Exception {
        List<Usuario> usuarios = listarTodos();

        return !usuarios.isEmpty();
    }

    public Usuario buscarUsuarioActivo() {

        conectar();

        // Corrected query execution
        Object query = em.createQuery("SELECT u FROM Usuario u WHERE u.alta = 'true'").getSingleResult();
        Usuario u = null;

        try {
            u = (Usuario) query;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            desconectar();
        }

        return u;
    }

    public void activarUsuario(Usuario u) {
        conectar();
        try {
            Usuario uPersist = em.find(Usuario.class, u.getId());
            uPersist.setAlta(true);
            em.getTransaction().begin();
            if (em.contains(uPersist)) {
                em.merge(uPersist);
                em.getTransaction().commit();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo activar el ususaio  ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Acitvar Usuario" + u.getName() + "  : " + e.getMessage());
        } finally {
            desconectar();
        }

    }

    public void desactivarUsuario(Usuario u) {
        conectar();
        try {
            Usuario uPersist = em.find(Usuario.class, u.getId());
            uPersist.setAlta(false);
            em.getTransaction().begin();
            if (em.contains(uPersist)) {
                em.merge(uPersist);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Usuario activo");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo activar el ususaio  ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Acitvar Usuario" + u.getName() + "  : " + e.getMessage());
        } finally {
            desconectar();
        }

    }
    
    public List<String> TraerTodosUsuario() {
    try {
        conectar();

        List<String> resultadosBrutos = em.createQuery("SELECT DISTINCT p.name FROM Usuario p", String.class)
                .getResultList();

        return resultadosBrutos;
    } finally {
        desconectar();
    }
}

    public Usuario buscarPorNombreContraseña(String nombre, String contraseña) {
          try {
        conectar();
        Usuario usuarioEspecifico = em.createQuery("SELECT u FROM Usuario u WHERE u.name = :nombre AND u.password = :contrasena", Usuario.class)
                .setParameter("nombre", nombre)
                .setParameter("contrasena", contraseña)
                .getSingleResult();

        return usuarioEspecifico;

    } finally {
        desconectar();
    }
    }
}
