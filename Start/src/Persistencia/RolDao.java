/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import entidades.Rol;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class RolDao implements AutoCloseable{
    dao DAO = new dao();
  
    private EntityManager em = DAO.EMF.createEntityManager();
    public RolDao() {
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

    public void guardar(Rol rol) {
        conectar();
        em.getTransaction().begin();
        try {
            em.persist(rol);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Rol guardado con exito");
            desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar :" + e.getMessage());
            desconectar();
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
                desconectar();
            } else {
                JOptionPane.showMessageDialog(null, "El Rol no ha sido encontrado");
                desconectar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " + e.getMessage());
            desconectar();
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
                desconectar();
            } else {
                JOptionPane.showMessageDialog(null, "El Rol no ha sido encontrado");
                desconectar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar " + e.getMessage());
            desconectar();
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
    public Rol buscarPorString(String Rol) throws Exception {
        conectar();
        Rol rol = em.find(Rol.class, Rol);
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

    public List<Rol> RolConsulta(String nombre) {
        conectar();
        List<Rol> Roles = em.createQuery("select a from Rol a WHERE a.nombre = '" + nombre + "'").getResultList();// chequar query
        desconectar();
        return Roles;
    }

    public void agregarUsuarioAdministradorList(Usuario u) throws Exception {
        conectar();
        try {
            em.getTransaction().begin();
            Rol r = buscarPorId(1);
            ArrayList<Usuario> listaUsuarios = r.getListaUsuarios();
            listaUsuarios.add(u);
            desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el usuario a la lista del rol : "+e.getMessage());
             desconectar();
        }finally{
        desconectar();
        }
     
    }
    public void agregarUsuarioVendedorList(Usuario u) throws Exception {
        conectar();
        try {
            em.getTransaction().begin();
            Rol r = buscarPorId(2);
            ArrayList<Usuario> listaUsuarios = r.getListaUsuarios();
            listaUsuarios.add(u);
            desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el usuario a la lista del rol : "+e.getMessage());
             desconectar();
        }finally{
        desconectar();
        }
     
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarUsuarioAdministradorList(Usuario usuarioAEditar) {
        conectar();
        try {
            em.getTransaction().begin();
            Rol r = buscarPorId(1);
            ArrayList<Usuario> listaUsuarios = r.getListaUsuarios();
            listaUsuarios.remove(usuarioAEditar);
            desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el usuario a la lista del rol : "+e.getMessage());
             desconectar();
        }finally{
        desconectar();
        }
     
    }

    public void eliminarUsuarioVendorList(Usuario usuarioAEditar) {
       conectar();
        try {
            em.getTransaction().begin();
            Rol r = buscarPorId(2);
            ArrayList<Usuario> listaUsuarios = r.getListaUsuarios();
            listaUsuarios.remove(usuarioAEditar);
            desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el usuario a la lista del rol : "+e.getMessage());
             desconectar();
        }finally{
        desconectar();
        }
    }
}
