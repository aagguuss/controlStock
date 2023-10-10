/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


import java.util.Date;
import java.util.List;
/**
 *
 * @author agust
 * esta clase se va encargar de darnos la informacion de las estadistica de venta ademas, 
 * howManyP = howManyProducts
 * 
 */
public final class Sell {
    Date sellingDate; 
    // evaluando si al comprar tiene sentido la ista con a cantidad y en cambio desde interfaz de usario utilizar el espaci de memoria stock
    //y cuando se factura la venta que ese numero se le reste al stock en base de datos;
    List<Product> products;
    double totalAmount;
    double Winning;

    public Sell() {
        
    }


    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getWinning() {
        return Winning;
    }

    public void setWinning(double Winning) {
        this.Winning = Winning;
    }
   
}
