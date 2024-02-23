/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicioIU;

import Entidades.Product;
import Entidades.Sell;
import Entidades.SellProduct;
import Servicios.ProductService;
import Servicios.SellProductService;
import Servicios.sellService;
import Servicios.usuarioService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agust
 */
public class InterfaceService {
    usuarioService us;
    SellProductService sps;
    sellService ss;
    ProductService ps;
    DefaultTableModel internModel;

    public InterfaceService() {
        this.sps = new SellProductService();
        this.ps = new ProductService();
        this.ss = new sellService();
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

    public DefaultTableModel DisplayVentaCarrito(DefaultTableModel model, List<Product> products2) {
        model.setRowCount(0); // Eliminar contenido existente
        for (Product product : products2) {
            Object[] row = {
                product.getId(),
                product.getProductName(),
                product.getProductBlend(),
                product.getCategory(),
                product.getSellingPRice(),
                product.getStock(),};
            model.addRow(row);
        }
        return model;
    }

    public DefaultTableModel DisplayVentaCarritoSell(DefaultTableModel model, List<SellProduct> products2) {
        model.setRowCount(0); // Eliminar contenido existente
        for (SellProduct product : products2) {
            Object[] row = {
                product.getReferenceActualProduct(),
                product.getProductName(),
                product.getProductBlend(),
                product.getCategory(),
                product.getSellingPRice(),
                product.getCuantity(),
                 new JCheckBox() ,
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
        printmodelContents(model);
        return model;
    }

    public DefaultTableModel comprobarRepetidos(DefaultTableModel model) throws Exception {
        List<Product> productList = ps.Dao.listarTodos();

        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
            String productName = (String) model.getValueAt(rowIndex, 1);
            String productBlend = (String) model.getValueAt(rowIndex, 2);
            String category = (String) model.getValueAt(rowIndex, 3);

            for (Product product : productList) {
                if (productName.equalsIgnoreCase(product.getProductName())
                        && productBlend.equalsIgnoreCase(product.getProductBlend())
                        && category.equalsIgnoreCase(product.getCategory())) {

                    // Actualizar valores en la base de datos
                    int stock = (Integer) model.getValueAt(rowIndex, 6);
                    product.setStock(stock + product.getStock());
                    product.setBuyingPrice((Double) model.getValueAt(rowIndex, 4));
                    product.setSellingPRice((Double) model.getValueAt(rowIndex, 5));
                    product.setInterest((Double) model.getValueAt(rowIndex, 8));
                    ps.Dao.editar(product);

                    // Actualizar valores en el modelo
                    model.setValueAt(product.getStock(), rowIndex, 6);
                    model.setValueAt(product.getBuyingPrice(), rowIndex, 4);
                    model.setValueAt(product.getSellingPRice(), rowIndex, 5);
                    model.setValueAt(product.getInterest(), rowIndex, 8);

                    // Eliminar la fila del modelo
                    model.removeRow(rowIndex);

                    // Decrementar el índice para compensar la eliminación
                    rowIndex--;
                    break;  // No es necesario seguir buscando productos repetidos
                }
            }
        }

        System.out.println("Model antes de salir de comprobar repetidos:");
        printModelContents(model);

        return model;
    }

// Método auxiliar para imprimir el contenido del modelo
    private void printModelContents(DefaultTableModel model) {
        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
            for (int colIndex = 0; colIndex < model.getColumnCount(); colIndex++) {
                System.out.print(model.getValueAt(rowIndex, colIndex) + "\t");
            }
            System.out.println();
        }
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
    // editar no esta funcionando
    public List<Product> EditaleData(DefaultTableModel model) {
        // Lista para almacenar los productos
        List<Product> ProductPersist = new ArrayList<>();

        System.out.println("model dentro de StockService");

        try {
            // Iterar a través de las filas del modelo
            for (int i = 0; i < model.getRowCount(); i++) {
                // Crear una nueva instancia de Product para cada fila del modelo
                Product product = new Product();

                // Iterar a través de las columnas del modelo
                for (int j = 0; j < model.getColumnCount(); j++) {
                    // Establecer atributos del producto basado en los valores en el modelo

                    // Si la columna es la primera (índice 0), establecer el ID del producto
                    if (j == 0) {
                        product.setId((Integer) model.getValueAt(i, j));
                        System.out.println("ID: " + model.getValueAt(i, j));
                    }

                    // Si la columna es la segunda (índice 1), establecer el nombre del producto
                    if (j == 1) {
                        product.setProductName((String) model.getValueAt(i, j));
                    }
                    if (j == 2) {
                        product.setProductBlend((String) model.getValueAt(i, j));
                    }
                    if (j == 3) {
                        product.setCategory((String) model.getValueAt(i, j));
                    }
                    if (j == 4) {
                        product.setBuyingPrice((Double) model.getValueAt(i, j));
                    }
                    if (j == 5) {
                        product.setSellingPRice((Double) model.getValueAt(i, j));
                    }
                    if (j == 6) {
                        product.setStock((Integer) model.getValueAt(i, j));
                    }
                    if (j == 7) {
                        product.setStockWarning((Integer) model.getValueAt(i, j));
                    }
                    if (j == 8) {
                        product.setInterest((Double) model.getValueAt(i, j));
                    }
                    // Puedes agregar más condiciones similares para establecer otros atributos del producto
                }

                // Agregar el producto a la lista
                ProductPersist.add(product);
            }
        } catch (Exception e) {
            System.out.println("error en cargar product para editar datos de la table model: " + e.getMessage());
        }

        // Devolver la lista de productos creados a partir del modelo
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

    public List<String> ConsultasProductos(List<Boolean> isnull, List<String> categoria) {
        List<String> categoriaPivote = new ArrayList<>();
        try {
            Iterator<String> iterCategoria = categoria.iterator();
            Iterator<Boolean> iterIsnull = isnull.iterator();
            while (iterCategoria.hasNext() && iterIsnull.hasNext()) {
                String currentCategoria = iterCategoria.next();
                boolean currentIsnull = iterIsnull.next();
                if (currentIsnull) {
                    categoriaPivote.add(currentCategoria);
                } else {
                }
            }

        } catch (Exception e) {
        }
        return categoriaPivote;
    }

    public Boolean BooleanFilter(String text) {
        return text != null && !" ".equals(text) && !"".equals(text) && !"[]".equals(text);
    }

    public DefaultTableModel AddCarrito(Product product, DefaultTableModel defaultTableModel) {

        if (repeatControl(product, defaultTableModel)) {
            Object[] p = {product.getId(),
                product.getProductName(),
                product.getProductBlend(),
                product.getCategory(),
                product.getSellingPRice(), 1};

            defaultTableModel.addRow(p);
        }

        return defaultTableModel;
    }

    public DefaultTableModel removeOneFromCarrito(Product buscarPorId, DefaultTableModel defaultTableModel) {

        for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
            for (int j = 0; j < defaultTableModel.getColumnCount(); j++) {
                if (j == defaultTableModel.findColumn("Id")) {
                    if (buscarPorId.getId() == (int) defaultTableModel.getValueAt(i, j)) {
                        defaultTableModel.removeRow(i);
                    }
                }
            }
        }

        return defaultTableModel;
    }

    public DefaultTableModel DeleteallFromCarrito(DefaultTableModel defaultTableModel) {

        for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
            defaultTableModel.removeRow(i);
        }
        defaultTableModel.removeRow(0);
        return defaultTableModel;
    }

    private boolean repeatControl(Product product, DefaultTableModel defaultTableModel) {
        boolean ok = true;
        //evaluar que no funcione al estar la tabla vacia 
        if (defaultTableModel.getRowCount() >= 1) {
            for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
                for (int j = 0; j < defaultTableModel.getColumnCount(); j++) {
                    if (j == defaultTableModel.findColumn("Id")) {
                        if (product.getId() == (int) defaultTableModel.getValueAt(i, j)) {
                            ok = false;
                        }
                    }
                }
            }
        } else {
        }
        return ok;
    }

    public double calculatePriceFromVenta(DefaultTableModel model1) {
        double Total = 0;
        List<Double> price = new ArrayList<>();
        List<Integer> amount = new ArrayList<>();
        for (int i = 0; i < model1.getRowCount(); i++) {
            price.add((double) model1.getValueAt(i, 4));
            amount.add((Integer) model1.getValueAt(i, 5));
        }
       
        for (int j = 0; j < model1.getRowCount(); j++) {
            Total = Total + price.get(j) * amount.get(j);
        }
        return Total;
    }

    public List<SellProduct> procesarTablaEnProductForSell(DefaultTableModel modelCarrito) throws Exception {
        List<SellProduct> productSell = new ArrayList<>();
        for (int i = 0; i < modelCarrito.getRowCount(); i++) {
            productSell.add(sps.createProduct((Integer) modelCarrito.getValueAt(i, 0), (String) modelCarrito.getValueAt(i, 1), (String) modelCarrito.getValueAt(i, 2), (String) modelCarrito.getValueAt(i, 3), ps.Dao.GetPrecioDeCopmra((Integer) modelCarrito.getValueAt(i, 0)), (Double) modelCarrito.getValueAt(i, 4), (Integer) modelCarrito.getValueAt(i, 5)));
            ss.StockAdjust(ps.Dao.buscarPorId((Integer) modelCarrito.getValueAt(i, 0)), (Integer) modelCarrito.getValueAt(i, 5));
        }
        return productSell;
    }

    public void GestionarVenta(List<SellProduct> productoSell) throws Exception {
        ss.createSell(productoSell);
    }

   

    public DefaultTableModel DisplaySell(DefaultTableModel defaultTableModel, Sell sell) {
        defaultTableModel.setRowCount(0);
        Object[] row = {
            sell.getId(),
            sell.getDate(),
            sell.getTotalAmount(),
            procesarProductsofSell(sell.getProducts()),
            sell.getUsuario().getName(),};

        defaultTableModel.addRow(row);
        return defaultTableModel;

    }

    @SuppressWarnings("empty-statement")
    public DefaultTableModel DisplaySells(DefaultTableModel model, List<Sell> sell) {

        try {
            model.setRowCount(0); // Eliminar contenido existente
            for (Sell sellf : sell) {
                Object[] row = {
                    sellf.getId(),
                    sellf.getDate().toString(),
                    sellf.getTotalAmount(),
                    procesarProductsofSell(sellf.getProducts()),
                    sellf.getUsuario().getName(),};
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return model;
    }

    private String procesarProductsofSell(List<SellProduct> products) {
        String response = "";
        for (SellProduct product : products) {
            response = response + "/" + product.getProductName() + "/cantidad:" + product.getCuantity();
        }
        return response;
    }
// ubicar producto devuelto sumarlo al stock 
    public double calcularValor(List<SellProduct> products, DefaultTableModel modelDevolucion) {
        double valorInicial = 0;
        for (SellProduct product : products) {
           valorInicial=valorInicial + product.getCuantity()*product.getSellingPRice();
        }
        double Total = 0;
        List<Double> price = new ArrayList<>();
        List<Integer> amount = new ArrayList<>();
        for (int i = 0; i < modelDevolucion.getRowCount(); i++) {
            price.add((double) modelDevolucion.getValueAt(i, 4));
            amount.add((Integer) modelDevolucion.getValueAt(i, 5));
        }
        for (int j = 0; j < modelDevolucion.getRowCount(); j++) {
            Total = Total + price.get(j) * amount.get(j);
        }
        Total =  Total - valorInicial;
       return Total;
    }

    public void GestionarDevolucion(List<SellProduct> producto, Sell s) {
        s.setProducts(producto);
        s.setTotalAmount(ss.totalAmount(producto));
        s.setProfit(ss.totalWining(producto));
        s.setUsuario(us.buscarUsuarioActivo());
        ss.dao.editar(s);
    }
    
}