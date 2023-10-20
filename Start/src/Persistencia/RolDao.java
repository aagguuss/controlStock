/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistendiciaDao;

import entidades.Rol;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        em.persist(rol);
        em.getTransaction().commit();
        desconectar();
    }

    public void eliminar(Rol rol) {
        conectar();
        em.getTransaction().begin();
        em.remove(rol);
        em.getTransaction().commit();
        desconectar();
    }

    public void editar(Rol  rol) {
        conectar();
        em.getTransaction().begin();
        em.merge(rol);
        em.getTransaction().commit();
        desconectar();
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
        List<Rol> Roles = em.createQuery("select a from Rol a WHERE a.nombre = '"+nombre+"'").getResultList();// chequar query
        desconectar();
        return Roles;
    }
}
