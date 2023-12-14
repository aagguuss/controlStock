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

    UsuarioDao dao;

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

    public String ValidarUsuario(String nombre, char[] passwordI) throws Exception {
        String mensaje = "";
        String concatPas = "";
        Usuario var = new Usuario();
        for (char varC : passwordI) {
            concatPas += varC;
        }
        // tremos el usuario indicado 
        try {

            var = dao.UsuarioConsulta(nombre, concatPas);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar UsuarioConsulta : " + e.getMessage());
        }
        // comprobamos que no sea null
        if (var == null) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario proporcionado no se encuentra en la memoria");
        }
        // comprobamos que el usuario este correcto 
        if (var.getName().equals(nombre) && concatPas.equals(var.getPassword()) && var.isAlta() == false) {
            mensaje = "Entrando 4l $istema";
            //persistimos que el usuario comprobado se encuentra en el sistema de alta

        }
        if (var.getName().equals(nombre) && !concatPas.equals(var.getPassword())) {
            mensaje = "contraseña incorrecta";
        }

        return mensaje;
    }

    public String validarRol(String nombre, char[] passwordI) {
        String mensaje = "";
        String concatPas = "";
        Usuario var1 = new Usuario();
        for (char var : passwordI) {
            concatPas += concatPas+var;
        }
        try {
            dao.conectar();
            var1 = dao.UsuarioConsulta(nombre, concatPas);
            JOptionPane.showMessageDialog(null,"Consulta en validar rol contactPas :"+concatPas+"");
            dao.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar rol : " + e.getMessage());
        }

        if (var1.getRol().getNombre().equalsIgnoreCase("Adminitrador")) {
            mensaje = "Permisos4dministrador";
        }
        if (var1.getRol().getNombre().equalsIgnoreCase("Vendedor")) {
            mensaje = "Permisos5imples";
        }

        return mensaje;
    }

    public Usuario BuscarUsuarioInicial() throws Exception {
        return dao.buscarPorId(1);

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

    public void activarUsuario(String nombre, char[] password) {
        String concatPas = "";
        for (char c : password) {
            concatPas = concatPas+c;
        }
        try {
             Usuario var = dao.UsuarioConsulta(nombre, concatPas);
             dao.activarUsuario(var);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
        
    }

    
}
