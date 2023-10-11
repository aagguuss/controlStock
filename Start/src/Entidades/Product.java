

package Entidades;
import Servicios.ProductService;
/**
 *
 * @author agust
 */

public class Product {
    int Id;
    ProductService pS ;
     String ProductName,  ProductBlend;
     double buyingPrice, sellingPRice;
     int Stock,stockWarning;

 
    public Product() {    
    }
    
    public ProductService getpS() {
        return pS;
    }

    public void setpS(ProductService pS) {
        this.pS = pS;
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

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getStockWarning() {
        return stockWarning;
    }

    public void setStockWarning(int stockWarning) {
        this.stockWarning = stockWarning;
    }
    
    
}
