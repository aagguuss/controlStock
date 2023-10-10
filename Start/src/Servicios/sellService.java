/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Product;
import Entidades.Sell;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author agust
 * el producto agregado para que createSell funcione correctamente debe ser el 
 * de productForSell donde en la variable stock se pasa la cantidad de productos comprada
 * 
 */
public class sellService {
// declarar daoservice 
    public sellService() {
        //inicializar daoservice
    }
public Sell createSell(List products){
        Sell sell = new Sell();
        sell.setSellingDate(new Date());
        sell.setProducts(products);
        sell.setTotalAmount(totalAmount(products));
        sell.setWinning(totalWining(products));
        return sell;
}
public double totalAmount(List<Product> products) {
    double total = 0;
    for (Product product : products) {
        total = total + product.getSellingPRice()*product.getStock();
    }
    return total;
}
public double totalWining(List<Product> products) {
    double total = 0;
    for (Product product : products) {
        total = total + (product.getSellingPRice()-product.getBuyingPrice())*product.getStock();
    }
    return total;
}
    public void StockAdjust(Product product , int stockCompra){
        
    }
}