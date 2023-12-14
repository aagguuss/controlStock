/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author agust
 */
@Table(name = "rol")
@Entity
public class Rol implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    @Column(name ="nombre") 
    String nombre;   
    @OneToMany(mappedBy ="rol")
    public ArrayList<Usuario>listaUsuarios;
    
    public Rol() {
       this.listaUsuarios= new ArrayList();
     
    }


    public int getID() {
        return Id;
    }

    public void setID(int ID) {
        this.Id = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }



    @Override
    public String toString() {
        return "Rol{" + "ID=" + Id + ", nombre=" + nombre + '}';
    }
    
    
}
