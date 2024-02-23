/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.SellProduct;
import Persistencia.SellProductDao;



/**
 *
 * @author agust
 */
public class SellProductService {
    public SellProductDao Dao;

    public SellProductService() {
        this.Dao= new SellProductDao();
    }
    public SellProduct createProduct(int referenceID, String ProductName, String ProductBlend,String Category, double buyingPrice, double sellingPrice ,int howManyProducts) {
        try {
            SellProduct product = new SellProduct();
            product.setProductName(ProductName);
            product.setProductBlend(ProductBlend);
            product.setCategory(Category);
            product.setBuyingPrice(buyingPrice);
            product.setCuantity(howManyProducts);
            product.setSellingPRice(sellingPrice);
            product.setReferenceActualProduct(referenceID);
            
            return product;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public double getsellingPrice(double buyingPrice, double gain){
      return buyingPrice+(buyingPrice * gain);          
    }
}
