/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


import entidades.Usuario;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 *
 * @author agust
 * esta clase se va encargar de darnos la informacion de las estadistica de venta ademas, 
 * howManyP = howManyProducts
 * 
 */
@Entity
@Table(name="sell")
public class Sell   implements  Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected Usuario usuario;

     @ManyToMany
    @JoinTable(
        name = "sell_sell_product",
        joinColumns = @JoinColumn(name = "sell_id"),
        inverseJoinColumns = @JoinColumn(name = "sell_product_id")
    )
    protected List<SellProduct> products;

    @Column(name = "total_amount")
    protected double totalAmount;

    @Column(name = "profit")
    protected double profit;

     @Column(name = "date")
    protected LocalDateTime Date;

    @PrePersist
    protected void onCreate() {
        Date = LocalDateTime.now();
    }
    
        public Sell(Usuario u ) {
        this.usuario = u;
    } 
        
    public Sell() {
        this.products=new ArrayList<>();
    }

    public List<SellProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SellProduct> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime Date) {
        this.Date = Date;
    }

   
   
}
