/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import entidades.Rol;
import java.util.List;
import Persistencia.RolDao;
import entidades.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class rolServicio {

    RolDao dao;

    public rolServicio() {
        this.dao = new RolDao();
    }

    public Rol crearRol(Rol nombre) {
        try {
            Rol rol = new Rol();
            rol.setNombre(nombre.getNombre());
           rol.setListaUsuarios(nombre.getListaUsuarios());
            dao.guardar(rol);
            JOptionPane.showMessageDialog(null, "El rol  fue designado correctamente");
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
    
    public Rol BuscarAdminRol() throws Exception{

    return dao.buscarPorId(1);
            
    }
    public void AgregarUsuarioAdministradorList(Usuario u ) throws Exception{
        
        dao.agregarUsuarioAdministradorList(u); 

    }

    public void editarRol(Rol rolAdmin) {
      dao.editar(rolAdmin);
    }
}
