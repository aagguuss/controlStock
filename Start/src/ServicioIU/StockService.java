/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicioIU;
import Entidades.Product;
import Servicios.ProductService;
import java.util.List;
import java.util.Objects;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author agust
 */
public class StockService {
         ProductService ps;
    public StockService() {
        this.ps = new ProductService();              
    }
    public void Add(DefaultTableModel table){
        System.out.println("estamos agregando a la base de datos ");
    Product Productpersist = new Product();
                // Realizar acciones específicas para la opción "Agregar"     
                for (int i=0;i<table.getRowCount();i++){
                    for(int j=0;j<table.getColumnCount();j++){
                        switch (j) {
                            case 1 -> Productpersist.setProductName((String) table.getValueAt(i, j));
                            case 2 -> Productpersist.setProductBlend((String) table.getValueAt(i, j));
                            case 3 -> Productpersist.setCategory((String) table.getValueAt(i, j));
                            case 4 -> Productpersist.setBuyingPrice((Double) table.getValueAt(i, j));
                            case 5 -> Productpersist.setSellingPRice((Double) table.getValueAt(i, j));
                            case 6 -> Productpersist.setStock((Integer) table.getValueAt(i, j));
                            case 7 -> Productpersist.setStockWarning((Integer) table.getValueAt(i, j));
                            case 8 -> Productpersist.setInterest((Double) table.getValueAt(i, j));
                            default -> {
                            }
                        }
                    }
                    
                   if (todosLosAtributosCompletos(Productpersist)) {
                    ps.Dao.guardar(Productpersist);
                       System.out.println("datos guardados");
                    } else {
                  /*en este espacio deberia hacerse un logica que cree otra tabla donde se pondran los productos que no tengan los datos para ser persistidos
                 para luego devolver la tabla y setearla en la intefaz*/
                     System.out.println("Los atributos de Productpersist no están completos");
                             }
                             }                                   
                
    }
    public void Edit (DefaultTableModel table){
    Product Productpersist = new Product();
                // Realizar acciones específicas para la opción "Agregar"     
                for (int i=0;i<table.getRowCount();i++){
                    for(int j=0;j<table.getColumnCount();j++){
                        switch (j) {
                            case 0 -> Productpersist.setId((Integer)table.getValueAt(j, j));
                            case 1 -> Productpersist.setProductName((String) table.getValueAt(i, j));
                            case 2 -> Productpersist.setProductBlend((String) table.getValueAt(i, j));
                            case 3 -> Productpersist.setCategory((String) table.getValueAt(i, j));
                            case 4 -> Productpersist.setBuyingPrice((Double) table.getValueAt(i, j));
                            case 5 -> Productpersist.setSellingPRice((Double) table.getValueAt(i, j));
                            case 6 -> Productpersist.setStock((Integer) table.getValueAt(i, j));
                            case 7 -> Productpersist.setStockWarning((Integer) table.getValueAt(i, j));
                            case 8 -> Productpersist.setInterest((Double) table.getValueAt(i, j));
                            default -> {
                            }
                        }
                    }
                    
                   if (todosLosAtributosCompletos(Productpersist)) {
                    ps.Dao.editar(Productpersist);
                    
                    } else {
                             }
                             }  
                // Acción para la combinación "Editar"
                System.out.println("Opción Editar seleccionada");
                // Realizar acciones específicas para la opción "Editar"
                // ...
                                                                  
    } 
    public DefaultTableModel Display(DefaultTableModel model, List<Product> products2){
             model.setRowCount(0); // Eliminar contenido existente
               for (Product product : products2) {
                            Object[] row = {
                            product.getId(),
                            product.getProductName(),
                            product.getProductBlend(),
                            product.getCategory(),
                            product.getBuyingPrice(),
                            product.getSellingPRice(),
                            product.getStock(),
                            product.getStockWarning(),
                            product.getInterest()
                                             };
                            model.addRow(row);
                                                        }
        return model;
    }   
    public DefaultTableModel AddSelected(DefaultTableModel model){
             System.out.println("estamos el servicio add select ");
             model.setRowCount(0); // Eliminar contenido existente
             model.setRowCount(100); // Establecer 100 filas vacía

    for (int row = 0; row < model.getRowCount(); row++) {
        for (int column = 0; column < model.getColumnCount(); column++) {
            if (column == 4 || column == 5 || column == 8) {
                model.setValueAt(0.0, row, column);
            }
        }
    }

    return model;
}
   private boolean todosLosAtributosCompletos(Product product) {
    return !Objects.isNull(product.getProductName()) && 
           !Objects.isNull(product.getProductBlend()) &&
           !Objects.isNull(product.getCategory()) && 
           !Objects.isNull(product.getBuyingPrice()) &&
           !Objects.isNull(product.getSellingPRice()) && 
           !Objects.isNull(product.getStock()) &&
           !Objects.isNull(product.getStockWarning()) && 
           !Objects.isNull(product.getInterest());
}

}