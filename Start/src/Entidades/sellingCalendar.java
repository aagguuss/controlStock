/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author agust
 */
@Entity
@Table(name="selling_calendar")

public class sellingCalendar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    @ManyToOne
    @JoinColumn(name="fk_sell")
    List<Sell>Calendar;

    public sellingCalendar() {
    }

    public List<Sell> getClaendar() {
        return Calendar;
    }

    public void setCalendar(List<Sell> Calendar) {
        this.Calendar= Calendar;
    }
    
    
}
