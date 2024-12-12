/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Rol;
import Entidades.Usuario;
import UI.MenuIngreso;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.List;

/**
 * @author agust
 */
public class RolDao implements AutoCloseable {
    dao DAO = new dao();

    private EntityManager em = dao.EMF.createEntityManager();

    public RolDao() {
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

    public void guardar(Rol rol) {
        conectar();
        em.getTransaction().begin();
        try {
            em.persist(rol);
            em.getTransaction().commit();
            MenuIngreso.avisar("Rol guardado con éxito");
        } catch (Exception e) {
            MenuIngreso.avisar("Error al guardar: " + e.getMessage());
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
                MenuIngreso.avisar( "El Rol a sido elimindo");
            } else {
                MenuIngreso.avisar( "El Rol no ha sido encontrado");
            }
        } catch (Exception e) {
            MenuIngreso.avisar( "Error al eliminar " + e.getMessage());
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
                MenuIngreso.avisar( "El Rol ha sido editado");
            } else {
                MenuIngreso.avisar( "El Rol no ha sido encontrado");
            }
        } catch (Exception e) {
            MenuIngreso.avisar( "Error al editar " + e.getMessage());
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
        List<Rol> usuario = em.createQuery("SELECT l FROM Rol l").getResultList();
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
            List<Usuario> listaUsuarios = r.getListaUsuarios();
            listaUsuarios.add(u);
        } catch (Exception e) {
            MenuIngreso.avisar("Error al agregar el usuario a la lista del rol : " + e.getMessage());
        } finally {
            desconectar();
        }

    }

    public void agregarUsuarioVendedorList(Usuario u) throws Exception {
        conectar();
        try {
            em.getTransaction().begin();
            Rol r = buscarPorId(2);
            List<Usuario> listaUsuarios = r.getListaUsuarios();
            listaUsuarios.add(u);
        } catch (Exception e) {
            MenuIngreso.avisar("Error al agregar el usuario a la lista del rol : " + e.getMessage());
        } finally {
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
            List<Usuario> listaUsuarios = r.getListaUsuarios();
            listaUsuarios.remove(usuarioAEditar);
        } catch (Exception e) {
            MenuIngreso.avisar("Error al agregar el usuario a la lista del rol : " + e.getMessage());
        } finally {
            desconectar();
        }

    }

    public void eliminarUsuarioVendorList(Usuario usuarioAEditar) {
        conectar();
        try {
            em.getTransaction().begin();
            Rol r = buscarPorId(2);
            List<Usuario> listaUsuarios = r.getListaUsuarios();
            listaUsuarios.remove(usuarioAEditar);
        } catch (Exception e) {
            MenuIngreso.avisar("Error al agregar el usuario a la lista del rol : " + e.getMessage());
        } finally {
            desconectar();
        }
    }
}
