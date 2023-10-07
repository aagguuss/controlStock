/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistendiciaDao;


import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author agust
 */
public class UsuarioDao {
      private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("persistencia");
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
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        desconectar();
    }

    public void eliminar(Usuario usuario) {
        conectar();
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
        desconectar();
    }

    public void editar(Usuario usuario) {
        conectar();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        desconectar();
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
        List<Usuario> usuario = em.createQuery("select a from Usuario a WHERE a.name = '"+nombre+"'").getResultList();
        desconectar();
        return usuario;
    }
}
