/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import entidades.Rol;
import entidades.Usuario;
import java.util.List;

import Persistencia.UsuarioDao;

/**
 *
 * @author agust
 */
public class usuarioService {

    UsuarioDao dao;

    public usuarioService() {
        this.dao = new UsuarioDao();

    }

    public Usuario crearUsuario(String nombre, String password, Rol rol) {
        Usuario usuario = new Usuario();
        usuario.setPassword(password);
        usuario.setName(nombre);
        usuario.setRol(rol);
        usuario.setAlta(true);
        dao.guardar(usuario);
        return usuario;
    }

    public String ValidarUsuario(String nombre, char[] passwordI) {
        String mensaje = "";
        String concatPas = "";
        for (char var : passwordI) {
            concatPas += var;
        }
        List<Usuario> usuario = dao.UsuarioConsulta(nombre);
        if (usuario.isEmpty()) {
            mensaje = "no hay ningun usuario registrado con este nombre";
        } else {
            for (Usuario var : usuario) {
                if (var.getName().equals(nombre) && concatPas.equals(var.getPassword()) && var.isAlta() == false) {
                    mensaje = "este usario fue dado de baja";
                    continue;// salta a la proxima iteracion del foreach
                }
                if (var.getName().equals(nombre) && concatPas.equals(var.getPassword())) {
                    mensaje = "Bienvenido al administrados de Biblioteca";
                    break;
                }
                if (var.getName().equals(nombre) && !concatPas.equals(var.getPassword())) {
                    mensaje = "contraseña incorrecta";
                }

            }
        }

        return mensaje;
    }

    public String validarRol(String nombre, char[] passwordI) {
        String mensaje = "";
        String concatPas = "";
        for (char var : passwordI) {
            concatPas += var;
        }
        List<Usuario> usuario = dao.UsuarioConsulta(nombre);
        for (Usuario var1 : usuario) {
            if (var1.getRol().getNombre().equalsIgnoreCase("Adminitrador")){
                mensaje="Permisos4dministrador";
            }
            if(var1.getRol().getNombre().equalsIgnoreCase("Bibliotecario")){
             mensaje="Permisos5imples";
            }
        }
        return mensaje;
    }
}
