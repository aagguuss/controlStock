/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicioIU;

import Entidades.Product;
import Servicios.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agust
 */
public class StockService {

    ProductService ps;
    DefaultTableModel internModel;

    public StockService() {
        this.ps = new ProductService();
        this.internModel = new DefaultTableModel();
    }

    public void Add(DefaultTableModel table) {
        System.out.println("estamos agregando a la base de datos ");
        Product Productpersist = new Product();
        // Realizar acciones específicas para la opción "Agregar"     
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                switch (j) {
                    case 1 ->
                        Productpersist.setProductName((String) table.getValueAt(i, j));
                    case 2 ->
                        Productpersist.setProductBlend((String) table.getValueAt(i, j));
                    case 3 ->
                        Productpersist.setCategory((String) table.getValueAt(i, j));
                    case 4 ->
                        Productpersist.setBuyingPrice((Double) table.getValueAt(i, j));
                    case 5 ->
                        Productpersist.setSellingPRice((Double) table.getValueAt(i, j));
                    case 6 ->
                        Productpersist.setStock((Integer) table.getValueAt(i, j));
                    case 7 ->
                        Productpersist.setStockWarning((Integer) table.getValueAt(i, j));
                    case 8 ->
                        Productpersist.setInterest((Double) table.getValueAt(i, j));
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

    public DefaultTableModel Display(DefaultTableModel model, List<Product> products2) {
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

    public DefaultTableModel AddSelected(DefaultTableModel model, int rows) {
        System.out.println("estamos el servicio add select ");
        model.setRowCount(0); // Eliminar contenido existente
        model.setRowCount(rows); // Establecer 100 filas vacía

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
        return !Objects.isNull(product.getProductName())
                && !Objects.isNull(product.getProductBlend())
                && !Objects.isNull(product.getCategory())
                && !Objects.isNull(product.getBuyingPrice())
                && !Objects.isNull(product.getSellingPRice())
                && !Objects.isNull(product.getStock())
                && !Objects.isNull(product.getStockWarning())
                && !Objects.isNull(product.getInterest());
    }

    public DefaultTableModel comprobarPrecios(DefaultTableModel model) {
        Double precioCompra = 0.0;
        Double interes = 0.0;
        Double precio = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                precioCompra = (Double) model.getValueAt(i, 4);
                interes = (Double) model.getValueAt(i, 8);

                precio = (Double) model.getValueAt(i, 5);

                if (precio != precioCompra * (interes + 1)) {
                    Object[] opciones = {"Precio final", "Interes"};
                    int seleccion = JOptionPane.showOptionDialog(null, "El precio final no coincide con el interes. ¿Cual es el correcto?", "Selecciona una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                    if (seleccion == 0) {
                        interes = (precio / precioCompra) - 1;
                        // Acciones para elegir el precio final
                        model.setValueAt(interes, i, 8);
                    } else if (seleccion == 1) {
                        // Acciones para elegir el cálculo
                        precio = precioCompra * (interes + 1);
                        model.setValueAt(precio, i, 5);
                    }
                }
            }

        }
        System.out.println("Model en comprobar precio :");
        printmodelContents(model);
        return model;
    }

    public DefaultTableModel comprobarRepetidos(DefaultTableModel model) throws Exception {
        List<Product> modelP = ps.Dao.listarTodos();// convendria traer solo nombre marca  y categoria 
        String nombre = "";
        String marca = "";
        String categoria = "";
        int Stock = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                nombre = (String) model.getValueAt(i, 1);
                marca = (String) model.getValueAt(i, 2);
                categoria = (String) model.getValueAt(i, 3);
                for (Product product : modelP) {
                    if (nombre.equalsIgnoreCase(product.getProductName()) && marca.equalsIgnoreCase(product.getProductBlend()) && categoria.equalsIgnoreCase(product.getCategory())) {
                        // cambian los precios a o se suma stock
                        Stock = (Integer) model.getValueAt(i, 6);
                        product.setStock(Stock + product.getStock());
                        product.setBuyingPrice((Double) model.getValueAt(i, 4));
                        product.setSellingPRice((Double) model.getValueAt(i, 5));
                        product.setInterest((Double) model.getValueAt(i, 8));
                        ps.Dao.editar(product);
                        model.removeRow(product.getId());
                    }
                }
            }
        }
        System.out.println("model antes de partir de comprobar repetidos");
        printmodelContents(model);
        return model;
    }

    public DefaultTableModel SaveNewData(List<Product> listarTodos) {
        internModel.setRowCount(0);
        // esto deberia refactorizarce en un clase DefautTableMOdel 
        internModel.addColumn("Id");
        internModel.addColumn("Nombre");
        internModel.addColumn("Marca");
        internModel.addColumn("Categoria");
        internModel.addColumn("Precio de compra");
        internModel.addColumn("Precio");
        internModel.addColumn("Stock");
        internModel.addColumn("Alerta Stock");
        internModel.addColumn("Interes");
        internModel.addColumn("Indice");
        internModel.setRowCount(listarTodos.size());

        int rowcount = 0;
        for (Product listarTodo : listarTodos) {

            internModel.setValueAt(listarTodo.getId(), rowcount, 0);
            internModel.setValueAt(listarTodo.getProductName(), rowcount, 1);
            internModel.setValueAt(listarTodo.getProductBlend(), rowcount, 2);
            internModel.setValueAt(listarTodo.getBuyingPrice(), rowcount, 3);
            internModel.setValueAt(listarTodo.getBuyingPrice(), rowcount, 4);
            internModel.setValueAt(listarTodo.getSellingPRice(), rowcount, 5);
            internModel.setValueAt(listarTodo.getStock(), rowcount, 6);
            internModel.setValueAt(listarTodo.getStockWarning(), rowcount, 7);
            internModel.setValueAt(rowcount + 1, rowcount, 8);
            rowcount = rowcount + 1;
        }
        return internModel;
    }
    // ver si los datos de la tabla se estan tomando 

    public List<Product> EditaleData(DefaultTableModel model) {
        List<Product> ProductPersist = new ArrayList<>();
        System.out.println("model dentro de StockService");
       // printmodelContents(model);
        Product Product = null;
        // carga el o los productos en la variable product como variable auxiliar  
        try {
            for (int i = 0; i < model.getRowCount()-1; i++) {
            Product = new Product();
            for (int j = 0; j < model.getColumnCount(); j++) {
                
                if (j == 0) {
                    Product.setId((Integer) model.getValueAt(i, j));
                    System.out.println("ID: "+model.getValueAt(i, j));
                }
                if (j == 1) {
                    Product.setProductName((String) model.getValueAt(i, j));
                }

                if (j == 2) {
                    Product.setProductBlend((String) model.getValueAt(i, j));
                }

                if (j == 3) {
                    Product.setCategory((String) model.getValueAt(i, j));
                }
                if (j == 4) {
                    Product.setBuyingPrice((Double) model.getValueAt(i, j));
                }
                if (j == 5) {
                    Product.setSellingPRice((Double) model.getValueAt(i, j));
                }
                if (j == 6) {
                    Product.setStock((Integer) model.getValueAt(i, j));
                }
                if (j == 7) {
                    Product.setStockWarning((Integer) model.getValueAt(i, j));
                }
                if (j == 8) {
                    Product.setInterest((Double) model.getValueAt(i, j));
                }
                

                /*
                 Product = new Product();
                switch (j) {
                case 0 ->
                Product.setId((Integer) model.getValueAt(i, j));
                case 1 ->
                Product.setProductName((String) model.getValueAt(i, j));
                case 2 ->
                Product.setProductBlend((String) model.getValueAt(i, j));
                case 3 ->
                Product.setCategory((String) model.getValueAt(i, j));
                case 4 ->
                Product.setBuyingPrice((Double) model.getValueAt(i, j));
                case 5 ->
                Product.setSellingPRice((Double) model.getValueAt(i, j));
                case 6 ->
                Product.setStock((Integer) model.getValueAt(i, j));
                case 7 ->
                Product.setStockWarning((Integer) model.getValueAt(i, j));
                case 8 ->
                Product.setInterest((Double) model.getValueAt(i, j));
                default -> {
                }
                
                }*/
                System.out.println(Product.toString());
                System.out.println("product antes de cargar al dao");
                ps.Dao.editar(Product);
                ProductPersist.add(Product);
            }
        }
        // Acción para la combinación "Editar"
        System.out.println("Opción Editar seleccionada");
        // Realizar acciones específicas para la opción "Editar"
        // ...
        } catch (Exception e) {
                System.out.println("error en cargar product para editar datos de la table model : "+e.getMessage());
        }
        PrintProducts(ProductPersist);
        return ProductPersist;
    }

    public void PrintProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void printmodelContents(DefaultTableModel model) {
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                Object value = model.getValueAt(row, col);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public void printTableContents(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                Object value = model.getValueAt(row, col);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

}
