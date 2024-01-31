/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;


import entidades.Usuario;
import Persistencia.UsuarioDao;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class usuarioService {

    public UsuarioDao dao;

    public usuarioService() {
        this.dao = new UsuarioDao();

    }

    public Usuario crearUsuario(Usuario nombre) {
        Usuario usuario = new Usuario();
        usuario.setPassword(nombre.getPassword());
        usuario.setName(nombre.getName());
        usuario.setAlta(false);
        usuario.setRol(nombre.getRol());
        dao.guardar(usuario);
        return usuario;
    }

    public String ValidarUsuario(String nombre, String passwordI) throws Exception {
        String mensaje = "";
        Usuario var = null ;
        // tremos el usuario indicado 
        try {
            var = dao.buscarPorNombreContraseña(nombre, passwordI);
            System.out.println(var.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar UsuarioConsulta : " + e.getMessage());
        }
        // comprobamos que no sea null
        if (var == null) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario proporcionado no se encuentra en la memoria");
        }
        // comprobamos que el usuario este correcto 
        if (var.getName().equals(nombre) && passwordI.equals(var.getPassword())) {
            mensaje = "Entrando 4l $istema";
            //persistimos que el usuario comprobado se encuentra en el sistema de alta

        }
        if (var.getName().equals(nombre) && !passwordI.equals(var.getPassword())) {
            mensaje = "contraseña incorrecta";
        }

        return mensaje;
    }

    public String validarRol(String nombre, String passwordI) {
        String mensaje = "";
        Usuario var1 = new Usuario();
        try {
            var1 = dao.UsuarioConsulta(nombre, passwordI);
            System.out.println("var1 : "+var1.getRol().getID());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar rol : " + e.getMessage());
        }

        if (var1.getRol().getID()==1) {
            mensaje = "Permisos4dministrador";
        }
        if (var1.getRol().getID()==2) {
            mensaje = "Permisos5imples";
        }

        return mensaje;
    }

    public Usuario BuscarUsuarioInicial() throws Exception {
        return dao.buscarPorId(1);

    }
    public Usuario BuscarUsuarioPorNombreContraseña(String nombre, String contraseña) throws Exception {
        return dao.buscarPorNombreContraseña(nombre, contraseña);

    }

    public boolean existeUsuarioAdmin() throws Exception {
        return dao.existeUsuarioAdmin();
    }

    public void editarUsuario(Usuario admin) {
        dao.editar(admin);
    }

    public Usuario buscarUsuarioActivo() {
        return dao.buscarUsuarioActivo();
    }

    public void activarUsuario(String nombre, String password) {
        
        try {
             Usuario var = dao.buscarPorNombreContraseña(nombre, password);
             dao.activarUsuario(var);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
        
    }
    
    public void desactivarUsuario(Usuario u ){
    dao.desactivarUsuario(u);
    }
    
}
