/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * @author agust
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int Id;
    @Column(name = "nombre")
    protected String name;
    @Column(name = "password")
    protected String password;
    @Column(name = "alta")
    protected boolean alta;

    @ManyToOne
    @JoinColumn(name = "fk_rol")
    protected Rol rol;


    public Usuario() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Id=" + Id + ", name=" + name + ", password=" + password + ", alta=" + alta + ", rol=" + rol.toString() + '}';
    }
}
