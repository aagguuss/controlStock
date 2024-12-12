/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Product;
import Persistencia.ProductDao;

import java.util.List;

/**
 * @author agust
 */
public class ProductService {
    public ProductDao Dao;

    public ProductService() {
        this.Dao = new ProductDao();
    }

    public Product createProduct(String productName, String productBlend, String category, double buyingPrice, int stock, int stockWarning, double gain) {
        try {
            Product product = new Product();
            product.setProductName(productName);
            product.setProductBlend(productBlend);
            product.setCategory(category);
            product.setBuyingPrice(buyingPrice);
            product.setStock(stock);
            product.setSellingPRice(getsellingPrice(buyingPrice, gain));
            product.setStockWarning(stockWarning);
            Dao.guardar(product);
            return product;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Product ProductForSell(int Id, String ProductName, String ProductBlend, String Category, double buyingPrice, double sellingPrice, int howManyProducts) {
        Product product = new Product();
        product.setId(Id);
        product.setProductName(ProductName);
        product.setProductBlend(ProductBlend);
        product.setCategory(Category);
        product.setBuyingPrice(buyingPrice);
        product.setSellingPRice(sellingPrice);
        product.setStock(howManyProducts);
        return product;
    }

    public double getsellingPrice(double buyingPrice, double gain) {
        return buyingPrice + (buyingPrice * gain);
    }

    public int addingStock(int num, int stock) {
        return stock + num;
    }

    public int loosingStock(int num, int stock, int stockWarring) {
        return stock - num;
    }

    public String stockWarring(String productName, String productBlend) {
        return "El Stock de " + productName + " marca " + productBlend;
    }

    public void ProductEdit(List<Product> products2) {
        for (int i = 0; i < products2.size(); i++) {
            Dao.editar(products2.get(i));
        }

    }

}
