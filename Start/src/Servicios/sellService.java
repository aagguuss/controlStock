/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Product;
import Entidades.Sell;
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
    sellDao dao;
    ProductService ps;
    usuarioService us;
    public sellService() {
        this.ps = new ProductService();
        this.dao= new sellDao();
        this.us = new usuarioService();
        //inicializar daoservice
    }
public void createSell(List products) throws Exception{
        Sell sell = new Sell();
        sell.setDate(LocalDateTime.MAX);
        sell.setProducts(products);
        sell.setTotalAmount(totalAmount(products));
        sell.setProfit(totalWining(products));
        // esto no deberia ser necesesario en producion solo util para poder cargar un usuario desde venta directamente 
        Usuario u = us.BuscarUsuarioInicial();
        u.setAlta(true);
        us.editarUsuario(u);
        sell.setUsuario(us.buscarUsuarioActivo());
        dao.guardar(sell);
        
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
        product.setStock(product.getStock()-stockCompra);
        try {
             ps.Dao.editar(product);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}