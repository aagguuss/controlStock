/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author agust
 */
@Entity
@Table(name="ToDo")
public class ToDoList implements Serializable  {
    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int ID;
   private String ToDO;

    public ToDoList() {
        
    }
   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getToDO() {
        return ToDO;
    }

    public void setToDO(String ToDO) {
        this.ToDO = ToDO;
    }
   
}
