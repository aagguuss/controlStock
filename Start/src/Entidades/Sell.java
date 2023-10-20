/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
/**
 *
 * @author agust
 * esta clase se va encargar de darnos la informacion de las estadistica de venta ademas, 
 * howManyP = howManyProducts
 * 
 */
@Entity
@Table(name="sell")
public class Sell implements  Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date sellingDate; 
    // evaluando si al comprar tiene sentido la ista con a cantidad y en cambio desde interfaz de usario utilizar el espaci de memoria stock
    //y cuando se factura la venta que ese numero se le reste al stock en base de datos;
    @ManyToMany
    @JoinTable(name = "sell_product",
               joinColumns = @JoinColumn(name = "sell_id"),
               inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;
    @Column(name="total_amount")
    double totalAmount;
    @Column(name="Winning")
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
