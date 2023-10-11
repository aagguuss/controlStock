/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Sell;
import Entidades.sellingCalendar;
import java.util.List;

/**
 * 
 * @author agust
 */
public class sellingCalendarService {

    public sellingCalendarService() {
    }
    
    public sellingCalendar createSellingCalendar(List<Sell>Sells){
        sellingCalendar calendar = new sellingCalendar();{
          calendar.setCalendar(Sells);
        }
        
    return calendar;
    }
}
