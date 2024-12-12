/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author agust
 */
@Table(name = "rol")
@Entity
public class Rol implements Serializable {
    @OneToMany(mappedBy = "rol")
    public List<Usuario> listaUsuarios;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    @Column(name = "nombre")
    String nombre;

    public Rol() {
        this.listaUsuarios = new ArrayList<>();

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

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    @Override
    public String toString() {
        return "Rol{" + "ID=" + Id + ", nombre=" + nombre + '}';
    }


}
