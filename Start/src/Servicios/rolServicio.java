/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import entidades.Rol;
import java.util.List;
import Persistencia.RolDao;

/**
 *
 * @author agust
 */
public class rolServicio {

    RolDao dao;

    public rolServicio() {
        this.dao = new RolDao();
    }

    public Rol crearRol(String nombre) {
        try {
            Rol rol = new Rol();
            rol.setNombre(nombre);
            dao.guardar(rol);
            return rol;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void mostrarRol() throws Exception {
        List<Rol> listaRoles = dao.listarTodos();
        for (Rol var : listaRoles) {
            System.out.println(var.toString());

        }
    }
}
