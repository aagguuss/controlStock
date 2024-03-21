/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;
import Entidades.Sell;
import Entidades.SellProduct;
import ServicioIU.InterfaceService;
import Servicios.ProductService;
import Servicios.sellService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author agust
 */
public class DevolucionesVendedores extends javax.swing.JFrame {
Sell s;
    sellService ss = new sellService();
    InterfaceService is = new InterfaceService();
    DefaultTableModel modelDevolucion;
    DefaultTableModel modelproducto;
    DefaultTableModel modelventas;
    ProductService Ps;
    ArrayList<Boolean> isnull;
    List<String> categoria;
    List<String> products;
   
    public DevolucionesVendedores() throws Exception {
        this.Ps = new ProductService();
        initComponents();
        isnull= new ArrayList<>();
        categoria= new ArrayList<>();
        products= new ArrayList<>();
        modelproducto = is.Display((DefaultTableModel) TableStockDevolucion.getModel(), Ps.Dao.listarTodos());
        modelventas = is.DisplaySells((DefaultTableModel) TableVenta.getModel(), ss.dao.listarTodos());
        modelDevolucion = (DefaultTableModel)TableCarritoDevolucion.getModel();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableStockVenta1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableStockDevolucion = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        BtnBuscar2 = new javax.swing.JButton();
        TxtFieldsegundo = new javax.swing.JTextField();
        Lblcategoria2 = new javax.swing.JLabel();
        LblDescripcion2 = new javax.swing.JLabel();
        LblMarca2 = new javax.swing.JLabel();
        TxtFieldPrimero = new javax.swing.JTextField();
        TxtFieldtercero = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BtnBuscar = new javax.swing.JButton();
        TxtFieldFecha = new javax.swing.JTextField();
        Lblcategoria = new javax.swing.JLabel();
        LblDescripcion = new javax.swing.JLabel();
        LblMarca = new javax.swing.JLabel();
        TxtFieldID = new javax.swing.JTextField();
        TxtFieldProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        LblId = new javax.swing.JLabel();
        TxtFieldIdVenta = new javax.swing.JTextField();
        LblValor = new javax.swing.JLabel();
        BtnCalcular = new javax.swing.JButton();
        BtnDevolucion = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        LbLIdProduct = new javax.swing.JLabel();
        jTextproductosAgregar = new javax.swing.JTextField();
        btnSeleccionarVenta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCarritoDevolucion = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuPrincipalVendedor = new javax.swing.JMenu();
        MitmVenta = new javax.swing.JMenuItem();
        MitmAgregarStock = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        MitmDevolucion = new javax.swing.JMenuItem();
        MitmCesion = new javax.swing.JMenuItem();
        MitmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(33, 33, 33));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1800, 1200));

        jPanel5.setBackground(new java.awt.Color(33, 33, 33));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane4.setBackground(new java.awt.Color(33, 33, 33));
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        TableStockVenta1.setBackground(new java.awt.Color(51, 51, 51));
        TableStockVenta1.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        TableStockVenta1.setForeground(new java.awt.Color(255, 255, 255));
        TableStockVenta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Marca", "Categoria", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableStockVenta1.setCellSelectionEnabled(true);
        TableStockVenta1.setFillsViewportHeight(true);
        TableStockVenta1.setGridColor(new java.awt.Color(153, 255, 153));
        TableStockVenta1.setInheritsPopupMenu(true);
        TableStockVenta1.setMinimumSize(new java.awt.Dimension(800, 600));
        TableStockVenta1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TableStockVenta1);

        jPanel6.setBackground(new java.awt.Color(33, 33, 33));

        TableStockDevolucion.setBackground(new java.awt.Color(51, 51, 51));
        TableStockDevolucion.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        TableStockDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        TableStockDevolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Marca", "Categoria", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableStockDevolucion.setCellSelectionEnabled(true);
        TableStockDevolucion.setFillsViewportHeight(true);
        TableStockDevolucion.setGridColor(new java.awt.Color(153, 255, 153));
        TableStockDevolucion.setInheritsPopupMenu(true);
        TableStockDevolucion.setMinimumSize(new java.awt.Dimension(800, 600));
        TableStockDevolucion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableStockDevolucion);

        jPanel9.setBackground(new java.awt.Color(33, 33, 33));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        BtnBuscar2.setBackground(new java.awt.Color(51, 51, 51));
        BtnBuscar2.setForeground(new java.awt.Color(255, 255, 255));
        BtnBuscar2.setText("Buscar");
        BtnBuscar2.setBorder(null);
        BtnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar2ActionPerformed(evt);
            }
        });

        TxtFieldsegundo.setBackground(new java.awt.Color(51, 51, 51));
        TxtFieldsegundo.setForeground(new java.awt.Color(255, 255, 255));
        TxtFieldsegundo.setBorder(null);
        TxtFieldsegundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldsegundoActionPerformed(evt);
            }
        });

        Lblcategoria2.setForeground(new java.awt.Color(255, 255, 255));
        Lblcategoria2.setText("Categoria :");

        LblDescripcion2.setForeground(new java.awt.Color(255, 255, 255));
        LblDescripcion2.setText("Nombre :");

        LblMarca2.setForeground(new java.awt.Color(255, 255, 255));
        LblMarca2.setText("Marca :");

        TxtFieldPrimero.setBackground(new java.awt.Color(51, 51, 51));
        TxtFieldPrimero.setForeground(new java.awt.Color(255, 255, 255));
        TxtFieldPrimero.setBorder(null);
        TxtFieldPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldPrimeroActionPerformed(evt);
            }
        });

        TxtFieldtercero.setBackground(new java.awt.Color(51, 51, 51));
        TxtFieldtercero.setForeground(new java.awt.Color(255, 255, 255));
        TxtFieldtercero.setBorder(null);
        TxtFieldtercero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldterceroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblDescripcion2)
                    .addComponent(Lblcategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFieldsegundo, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(TxtFieldPrimero))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFieldtercero)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Lblcategoria2))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(TxtFieldPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblDescripcion2)
                    .addComponent(TxtFieldsegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldtercero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(33, 33, 33));

        jPanel2.setBackground(new java.awt.Color(33, 33, 33));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        BtnBuscar.setBackground(new java.awt.Color(51, 51, 51));
        BtnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        BtnBuscar.setText("Buscar");
        BtnBuscar.setBorder(null);
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        TxtFieldFecha.setBackground(new java.awt.Color(51, 51, 51));
        TxtFieldFecha.setForeground(new java.awt.Color(255, 255, 255));
        TxtFieldFecha.setToolTipText("dia/mes/año en numeros");
        TxtFieldFecha.setBorder(null);
        TxtFieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldFechaActionPerformed(evt);
            }
        });

        Lblcategoria.setForeground(new java.awt.Color(255, 255, 255));
        Lblcategoria.setText("ID :");

        LblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        LblDescripcion.setText("Fecha :");

        LblMarca.setForeground(new java.awt.Color(255, 255, 255));
        LblMarca.setText("Producto:");

        TxtFieldID.setBackground(new java.awt.Color(51, 51, 51));
        TxtFieldID.setForeground(new java.awt.Color(255, 255, 255));
        TxtFieldID.setBorder(null);
        TxtFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldIDActionPerformed(evt);
            }
        });

        TxtFieldProducto.setBackground(new java.awt.Color(51, 51, 51));
        TxtFieldProducto.setForeground(new java.awt.Color(255, 255, 255));
        TxtFieldProducto.setBorder(null);
        TxtFieldProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldProductoActionPerformed(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(33, 33, 33));
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        TableVenta.setBackground(new java.awt.Color(51, 51, 51));
        TableVenta.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        TableVenta.setForeground(new java.awt.Color(255, 255, 255));
        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Valor Total", "Productos ", "Vendedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableVenta.setCellSelectionEnabled(true);
        TableVenta.setFillsViewportHeight(true);
        TableVenta.setGridColor(new java.awt.Color(153, 255, 153));
        TableVenta.setInheritsPopupMenu(true);
        TableVenta.setMinimumSize(new java.awt.Dimension(800, 600));
        TableVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TableVenta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblDescripcion)
                    .addComponent(Lblcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtFieldProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(TxtFieldID)
                    .addComponent(TxtFieldFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lblcategoria))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblDescripcion))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtFieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1008, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(33, 33, 33));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1646, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(555, 555, 555)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(33, 33, 33));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        LblId.setBackground(new java.awt.Color(33, 33, 33));
        LblId.setForeground(new java.awt.Color(255, 255, 255));
        LblId.setText("ID venta :");

        TxtFieldIdVenta.setBackground(new java.awt.Color(51, 51, 51));
        TxtFieldIdVenta.setForeground(new java.awt.Color(255, 255, 255));
        TxtFieldIdVenta.setToolTipText("escriba el numero de la venta en la que se gestiona la devolucion");
        TxtFieldIdVenta.setBorder(null);
        TxtFieldIdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldIdVentaActionPerformed(evt);
            }
        });

        LblValor.setBackground(new java.awt.Color(33, 33, 33));
        LblValor.setForeground(new java.awt.Color(255, 255, 255));
        LblValor.setText("Valor Total :");

        BtnCalcular.setBackground(new java.awt.Color(51, 51, 51));
        BtnCalcular.setForeground(new java.awt.Color(255, 255, 255));
        BtnCalcular.setText("Calcular ");
        BtnCalcular.setBorder(null);
        BtnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalcularActionPerformed(evt);
            }
        });

        BtnDevolucion.setBackground(new java.awt.Color(51, 51, 51));
        BtnDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        BtnDevolucion.setText("Devolucion");
        BtnDevolucion.setBorder(null);
        BtnDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDevolucionActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(51, 51, 51));
        BtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setBorder(null);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnAgregar.setBackground(new java.awt.Color(51, 51, 51));
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setText("Agregar");
        BtnAgregar.setToolTipText("Agrega un producto a la lista de productos a comprar");
        BtnAgregar.setBorder(null);
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        LbLIdProduct.setForeground(new java.awt.Color(255, 255, 255));
        LbLIdProduct.setText("ID producto:");

        jTextproductosAgregar.setBackground(new java.awt.Color(55, 55, 55));
        jTextproductosAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jTextproductosAgregar.setToolTipText("Para agregar productos a la tabla");
        jTextproductosAgregar.setBorder(null);
        jTextproductosAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextproductosAgregarActionPerformed(evt);
            }
        });

        btnSeleccionarVenta.setBackground(new java.awt.Color(60, 60, 60));
        btnSeleccionarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarVenta.setText("seleccionar venta");
        btnSeleccionarVenta.setBorder(null);
        btnSeleccionarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LbLIdProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextproductosAgregar)
                            .addComponent(TxtFieldIdVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                    .addComponent(LblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSeleccionarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addComponent(BtnDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TxtFieldIdVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(LblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeleccionarVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextproductosAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbLIdProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jScrollPane2.setBackground(new java.awt.Color(33, 33, 33));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        TableCarritoDevolucion.setBackground(new java.awt.Color(51, 51, 51));
        TableCarritoDevolucion.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        TableCarritoDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        TableCarritoDevolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Marca", "Categoria", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableCarritoDevolucion.setCellSelectionEnabled(true);
        TableCarritoDevolucion.setFillsViewportHeight(true);
        TableCarritoDevolucion.setGridColor(new java.awt.Color(153, 255, 153));
        TableCarritoDevolucion.setInheritsPopupMenu(true);
        TableCarritoDevolucion.setMinimumSize(new java.awt.Dimension(800, 600));
        TableCarritoDevolucion.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TableCarritoDevolucion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 517, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(114, 23));

        JMenuPrincipalVendedor.setText("Panel de Opciones");
        JMenuPrincipalVendedor.setMinimumSize(new java.awt.Dimension(120, 22));
        JMenuPrincipalVendedor.setPreferredSize(new java.awt.Dimension(114, 30));
        JMenuPrincipalVendedor.setRolloverEnabled(false);

        MitmVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmVenta.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmVenta.setText("Venta");
        MitmVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        MitmVenta.setDoubleBuffered(true);
        MitmVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitmVentaActionPerformed(evt);
            }
        });
        JMenuPrincipalVendedor.add(MitmVenta);

        MitmAgregarStock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmAgregarStock.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmAgregarStock.setText("Agregar Stock");
        MitmAgregarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitmAgregarStockActionPerformed(evt);
            }
        });
        JMenuPrincipalVendedor.add(MitmAgregarStock);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jMenuItem1.setText("Editar Stock");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMenuPrincipalVendedor.add(jMenuItem1);

        MitmDevolucion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmDevolucion.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmDevolucion.setText("Devolucion");
        MitmDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitmDevolucionActionPerformed(evt);
            }
        });
        JMenuPrincipalVendedor.add(MitmDevolucion);

        MitmCesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmCesion.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmCesion.setText("Sesion");
        MitmCesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitmCesionActionPerformed(evt);
            }
        });
        JMenuPrincipalVendedor.add(MitmCesion);

        MitmSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        MitmSalir.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmSalir.setText("Salir");
        MitmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitmSalirActionPerformed(evt);
            }
        });
        JMenuPrincipalVendedor.add(MitmSalir);

        jMenuBar1.add(JMenuPrincipalVendedor);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscar2ActionPerformed

        getDatabis();
        try {
            categoria = is.ConsultasProductos(isnull, categoria);
            products = is.ConsultasProductos(isnull, products);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en btnBuscatAction:" + e.getMessage());
        }
        try {
            modelproducto = is.DisplayVentaCarrito(modelproducto, Ps.Dao.listarEspecificados(categoria, products));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la interface venta : " + e.getMessage());
        }

    }//GEN-LAST:event_BtnBuscar2ActionPerformed

    private void TxtFieldsegundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldsegundoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldsegundoActionPerformed

    private void TxtFieldPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldPrimeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldPrimeroActionPerformed

    private void TxtFieldterceroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldterceroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldterceroActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed

        getData();
        if (isnull.get(0) ) {
            try {
                modelventas = is.DisplaySell((DefaultTableModel) TableVenta.getModel(), ss.dao.buscarPorId(Integer.parseInt(TxtFieldID.getText())));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en btnBuscatAction:" + ex.getMessage());
                System.out.println(ex.getMessage());
            }
        } else {
            try {
                categoria = is.ConsultasProductos(isnull, categoria);
                products = is.ConsultasProductos(isnull, products);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en btnBuscatAction:" + e.getMessage());
            }
            try {
                modelventas = is.DisplaySells((DefaultTableModel) TableVenta.getModel(), ss.dao.listarEspecificados(categoria, products));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la interface venta : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void TxtFieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldFechaActionPerformed

    private void TxtFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldIDActionPerformed

    private void TxtFieldProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldProductoActionPerformed

    private void TxtFieldIdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldIdVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldIdVentaActionPerformed

    private void BtnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalcularActionPerformed
        LblValor.setText("Valor Total :" + is.calcularValor(s.getProducts(),modelDevolucion));
    }//GEN-LAST:event_BtnCalcularActionPerformed

    private void BtnDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDevolucionActionPerformed
        List<SellProduct> producto = new ArrayList<>();
        try {
            modelDevolucion = (DefaultTableModel) TableCarritoDevolucion.getModel();
            producto = is.procesarTablaEnProductForSell(modelDevolucion);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            is.GestionarDevolucion(producto,s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en boton vender :" + e.getMessage());
        }
        modelDevolucion = is.DeleteallFromCarrito(modelDevolucion);
        TableCarritoDevolucion.setModel(modelDevolucion);
    }//GEN-LAST:event_BtnDevolucionActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

        try {
            String intString = TxtFieldIdVenta.getText();
            modelDevolucion = is.removeOneFromCarrito(Ps.Dao.buscarPorId(Integer.parseInt(intString)), ((DefaultTableModel) TableCarritoDevolucion.getModel()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en el boton eliminar al carrito :" + ex.getMessage());
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        // TODO add your handling code here:
        try {
            String intString = TxtFieldIdVenta.getText();
            modelDevolucion = is.AddCarrito(Ps.Dao.buscarPorId(Integer.parseInt(intString)), ((DefaultTableModel) TableCarritoDevolucion.getModel()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el boton agregar al carrito :" + e.getMessage() + "    " + e.toString());
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void jTextproductosAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextproductosAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextproductosAgregarActionPerformed

    private void btnSeleccionarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarVentaActionPerformed
        try {
            s= ss.dao.buscarPorId(Integer.parseInt(TxtFieldIdVenta.getText()));
            modelDevolucion= is.DisplayVentaCarritoSell(modelDevolucion, s.getProducts());
            // iterar por todas las columnas y renderizar
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSeleccionarVentaActionPerformed

    private void MitmVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmVentaActionPerformed
        ventasVendedor V;
        try {
            V = new ventasVendedor();
            V.setVisible(true);
            V.setLocationRelativeTo(null);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir ventas" + e.getMessage());
        }
    }//GEN-LAST:event_MitmVentaActionPerformed

    private void MitmAgregarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmAgregarStockActionPerformed
        stockAgregarVendedor s1;
        try {
            s1 = new stockAgregarVendedor();
            s1.setVisible(true);
            s1.setLocationRelativeTo(null);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir menu de AgregarStock : " + e.getMessage());
        }
    }//GEN-LAST:event_MitmAgregarStockActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        stockEditarVendedor S1;
        try {
            S1 = new stockEditarVendedor();
            S1.setVisible(true);
            S1.setLocationRelativeTo(null);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir Stock Editar : " + ex.getMessage());

            ex.getStackTrace();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MitmDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmDevolucionActionPerformed
        DevolucionesVendedores dv;
        try {
            dv = new DevolucionesVendedores();
            dv.setVisible(true);
            dv.setLocationRelativeTo(null);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir Devoluciones : " + ex.getMessage());
        }

    }//GEN-LAST:event_MitmDevolucionActionPerformed

    private void MitmCesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmCesionActionPerformed
        MenuIngreso mi;
        try {
            mi = new MenuIngreso();
            mi.setVisible(true);
            mi.setLocationRelativeTo(null);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir menu de cesion " + e.getMessage());
        }
    }//GEN-LAST:event_MitmCesionActionPerformed

    private void MitmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_MitmSalirActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnBuscar2;
    private javax.swing.JButton BtnCalcular;
    private javax.swing.JButton BtnDevolucion;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JMenu JMenuPrincipalVendedor;
    private javax.swing.JLabel LbLIdProduct;
    private javax.swing.JLabel LblDescripcion;
    private javax.swing.JLabel LblDescripcion2;
    private javax.swing.JLabel LblId;
    private javax.swing.JLabel LblMarca;
    private javax.swing.JLabel LblMarca2;
    private javax.swing.JLabel LblValor;
    private javax.swing.JLabel Lblcategoria;
    private javax.swing.JLabel Lblcategoria2;
    private javax.swing.JMenuItem MitmAgregarStock;
    private javax.swing.JMenuItem MitmCesion;
    private javax.swing.JMenuItem MitmDevolucion;
    private javax.swing.JMenuItem MitmSalir;
    private javax.swing.JMenuItem MitmVenta;
    private javax.swing.JTable TableCarritoDevolucion;
    private javax.swing.JTable TableStockDevolucion;
    private javax.swing.JTable TableStockVenta1;
    private javax.swing.JTable TableVenta;
    private javax.swing.JTextField TxtFieldFecha;
    private javax.swing.JTextField TxtFieldID;
    private javax.swing.JTextField TxtFieldIdVenta;
    private javax.swing.JTextField TxtFieldPrimero;
    private javax.swing.JTextField TxtFieldProducto;
    private javax.swing.JTextField TxtFieldsegundo;
    private javax.swing.JTextField TxtFieldtercero;
    private javax.swing.JButton btnSeleccionarVenta;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextproductosAgregar;
    // End of variables declaration//GEN-END:variables

    private void getData() {
        try {
            categoria.clear();
            categoria.add("id");
            categoria.add("Date");
            categoria.add("products.ProductName");//ver como se hace la consulta para poder hacer la consulta en jpa de la lista de productos
            products.clear();
            products.add(TxtFieldID.getText());
            products.add(TxtFieldFecha.getText());
            products.add(TxtFieldProducto.getText());
            isnull.clear();
            isnull.add(is.BooleanFilter(TxtFieldID.getText()));
            isnull.add(is.BooleanFilter(TxtFieldFecha.getText()));
            isnull.add(is.BooleanFilter(TxtFieldProducto.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en getData() :" + e.getMessage());
        }

    }

    private void getDatabis() {
          try {
            categoria.clear();
            categoria.add("category");
            categoria.add("ProductName");
            categoria.add(" ProductBlend");
            products.clear();
            products.add(TxtFieldPrimero.getText());
            products.add(TxtFieldsegundo.getText());
            products.add(TxtFieldtercero.getText());
            isnull.clear();
            isnull.add(is.BooleanFilter(TxtFieldPrimero.getText()));
            isnull.add(is.BooleanFilter(TxtFieldsegundo.getText()));
            isnull.add(is.BooleanFilter(TxtFieldtercero.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en getData() :" + e.getMessage());
        }

    }
}
