

package Entidades;
import java.io.Serializable;
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
@Table(name="product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    @Column(name="product_name")
    String ProductName;
    @Column (name="product_blend")
    String  ProductBlend;
    @Column (name="category")
    String category;
    @Column (name="buying_price")
     double buyingPrice;
    @Column (name="selling_price")
     double sellingPRice;
    @Column (name="stock")
     int Stock;
    @Column (name="stock_waring")
     int    stockWarning;
    @Column (name="interest")
    double interest;
    @ManyToMany(mappedBy = "products")
    List<Sell> sells;
    

 
    public Product() {    
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

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public List<Sell> getSells() {
        return sells;
    }

    public void setSells(List<Sell> sells) {
        this.sells = sells;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStockWarning() {
        return stockWarning;
    }

    public void setStockWarning(int stockWarning) {
        this.stockWarning = stockWarning;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
}
