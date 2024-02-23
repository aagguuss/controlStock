/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Product;
import Entidades.Sell;
import Entidades.SellProduct;
import Persistencia.sellDao;
import entidades.Usuario;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * 
 * @author agust
 * el producto agregado para que createSell funcione correctamente debe ser el 
 * de productForSell donde en la variable stock se pasa la cantidad de productos comprada
 * 
 */
public class sellService {
// declarar daoservice 
    public sellDao dao;
    ProductService ps;
    usuarioService us;
    SellProductService sps;
    public sellService() {
        this.sps = new SellProductService();
        this.ps = new ProductService();
        this.dao= new sellDao();
        this.us = new usuarioService();
        //inicializar daoservice
    }
    public void createSell(List<SellProduct> productsell) throws Exception{
            Sell sell = new Sell();
            sell.setDate(LocalDateTime.MAX);
            sell.setTotalAmount(totalAmount(productsell));
            sell.setProfit(totalWining(productsell));    
            Usuario u = us.buscarUsuarioActivo();
            sell.setUsuario(us.buscarUsuarioActivo());
            dao.guardar(sell); 
            sell = dao.buscarUltimo();
            for (SellProduct object : productsell) {
            object.setSells(sell);
            sps.Dao.guardar(object);
        }
            sell.setProducts(productsell);
            dao.editar(sell); 
            
        // iterar y restar al stock la cantidad de productos.
}
public double totalAmount(List<SellProduct> products) {
    double total = 0;
    for (SellProduct product : products) {
        total = total + product.getSellingPRice()*product.getCuantity();
    }
    return total;
}
public double totalWining(List<SellProduct> products) {
    double total = 0;
    for (SellProduct product : products) {
        total = total + (product.getSellingPRice()-product.getBuyingPrice())*product.getCuantity();
    }
    return total;
}
    public void StockAdjust(Product product , int stockCompra){
        product.setStock(product.getStock()-stockCompra);
        try {
             ps.Dao.editar(product);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}