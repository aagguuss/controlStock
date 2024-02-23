/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author agust
 */
@Entity
@Table(name = "sell_product")
public class SellProduct implements Serializable {

    /**
     *
     * @author agust
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="sell_product_id")
    int Id;
    @Column(name = "product_name")
    String ProductName;
    @Column(name = "product_blend")
    String ProductBlend;
    @Column(name = "category")
    String category;
    @Column(name = "buying_price")
    double buyingPrice;
    @Column(name = "selling_price")
    double sellingPRice;
    @Column(name = "cuantity")
    int Cuantity;
    @Column(name = "interest")
    double interest;
    @ManyToMany(mappedBy = "products")
    List<Sell> sells;
    @Column(name = "reference_Actual_Product")
    int referenceActualProduct;
    public SellProduct() {
        this.sells= new ArrayList<>();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductBlend() {
        return ProductBlend;
    }

    public void setProductBlend(String ProductBlend) {
        this.ProductBlend = ProductBlend;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPRice() {
        return sellingPRice;
    }

    public void setSellingPRice(double sellingPRice) {
        this.sellingPRice = sellingPRice;
    }

    public int getCuantity() {
        return Cuantity;
    }

    public void setCuantity(int Cuantity) {
        this.Cuantity = Cuantity;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public List<Sell> getSells() {
        return sells;
    }

    public void setSells(Sell sells) {
        this.sells.add( sells) ;
    }

    public int getReferenceActualProduct() {
        return referenceActualProduct;
    }

    public void setReferenceActualProduct(int referenceActualProduct) {
        this.referenceActualProduct = referenceActualProduct;
    }
    
}
