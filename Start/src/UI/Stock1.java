/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;


import Entidades.Product;
import ServicioIU.InterfaceService;
import Servicios.ProductService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author agust
 */
public class Stock1 extends javax.swing.JFrame {
    String selectionMarca;
    String selectionCategoria; 
    DefaultTableModel model;
    ProductService Ps;
    InterfaceService Ss;    
    private List<Product> products2;
    //checkear que hace bottongroup
    ButtonGroup groupButtons;
    
    public Stock1() throws Exception {
        this.Ss = new InterfaceService();
        this.Ps = new ProductService(); 
        this.selectionCategoria="";
        this.selectionMarca="";
        products2 = Ps.Dao.listarTodos();        
        this.groupButtons = new ButtonGroup();
        initComponents();
        ComboCategoria.addItem("");
        ComboMarca.addItem("");
        this.model = Ss.Display((DefaultTableModel) TableVenta.getModel(), products2);
        // Agregar eventos de cambio de valor a las celdas
        model.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                // Verificar si se modificó alguna de las columnas de interés
                if (column == 4 || column == 5 || column == 8) {
                    // agregar que interprete a cualquier valor nulo en la cas illa como = a 0 dentro de calculatePrice
                    calculatePrice(row, model);
                }
            }     
            
        });
           FillComboBox(ComboCategoria,(List<String>) Ps.Dao.TraerTodasCategorias());
            FillComboBox(ComboMarca,(List<String>) Ps.Dao.TraerTodasMarcas());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BtnAceptar = new javax.swing.JButton();
        ComboCategoria = new javax.swing.JComboBox<>();
        LabelCategoria = new javax.swing.JLabel();
        ComboMarca = new javax.swing.JComboBox<>();
        LabelMarca = new javax.swing.JLabel();
        BtnBuscarPructos = new javax.swing.JButton();
        BtnAgregarProuctos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuPrincipal = new javax.swing.JMenu();
        MitmVenta = new javax.swing.JMenuItem();
        MimtStock = new javax.swing.JMenuItem();
        MitmCesion = new javax.swing.JMenuItem();
        MitmDevolucion = new javax.swing.JMenuItem();
        MitmConsultas = new javax.swing.JMenuItem();
        MitmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(33, 33, 33));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(33, 33, 33));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        BtnAceptar.setBackground(new java.awt.Color(51, 51, 51));
        BtnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAceptar.setText("Aceptar");
        BtnAceptar.setBorder(null);
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });

        ComboCategoria.setBackground(new java.awt.Color(51, 51, 51));
        ComboCategoria.setForeground(new java.awt.Color(255, 255, 255));
        ComboCategoria.setToolTipText("");
        ComboCategoria.setBorder(null);
        ComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCategoriaActionPerformed(evt);
            }
        });

        LabelCategoria.setForeground(new java.awt.Color(255, 255, 255));
        LabelCategoria.setText("Seleccione cátegoria buscada: ");

        ComboMarca.setBackground(new java.awt.Color(51, 51, 51));
        ComboMarca.setForeground(new java.awt.Color(255, 255, 255));
        ComboMarca.setBorder(null);
        ComboMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMarcaActionPerformed(evt);
            }
        });

        LabelMarca.setForeground(new java.awt.Color(255, 255, 255));
        LabelMarca.setText("Seleccione marca buscada: ");

        BtnBuscarPructos.setBackground(new java.awt.Color(51, 51, 51));
        BtnBuscarPructos.setForeground(new java.awt.Color(255, 255, 255));
        BtnBuscarPructos.setText("Consultar Productos");
        BtnBuscarPructos.setBorder(null);
        BtnBuscarPructos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarPructosActionPerformed(evt);
            }
        });

        BtnAgregarProuctos.setBackground(new java.awt.Color(51, 51, 51));
        BtnAgregarProuctos.setForeground(new java.awt.Color(204, 204, 204));
        BtnAgregarProuctos.setText("Agregar Productos");
        BtnAgregarProuctos.setBorder(null);
        BtnAgregarProuctos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarProuctosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelCategoria)
                    .addComponent(ComboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelMarca)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnAgregarProuctos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscarPructos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LabelCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(BtnBuscarPructos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(BtnAgregarProuctos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(555555555, 555555555));

        TableVenta.setBackground(new java.awt.Color(51, 51, 51));
        TableVenta.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        TableVenta.setForeground(new java.awt.Color(255, 255, 255));
        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Marca", "Categoria", "Precio de compra", "Precio", "Stock", "Alerta stock", "Interes", "Indice"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableVenta.setAutoscrolls(false);
        TableVenta.setCellSelectionEnabled(true);
        TableVenta.setFillsViewportHeight(true);
        TableVenta.setGridColor(new java.awt.Color(0, 0, 0));
        TableVenta.setInheritsPopupMenu(true);
        TableVenta.setMaximumSize(new java.awt.Dimension(2147483647, 555555555));
        TableVenta.setMinimumSize(new java.awt.Dimension(800, 600));
        TableVenta.setName(""); // NOI18N
        TableVenta.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TableVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableVenta);
        TableVenta.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1062, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        JMenuPrincipal.setText("Panel de Opciones");

        MitmVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmVenta.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmVenta.setText("Venta");
        MitmVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        MitmVenta.setDoubleBuffered(true);
        MitmVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitmVentaActionPerformed(evt);
            }
        });
        JMenuPrincipal.add(MitmVenta);

        MimtStock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MimtStock.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MimtStock.setText("Stock");
        MimtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MimtStockActionPerformed(evt);
            }
        });
        JMenuPrincipal.add(MimtStock);

        MitmCesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmCesion.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmCesion.setText("Sesion");
        MitmCesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitmCesionActionPerformed(evt);
            }
        });
        JMenuPrincipal.add(MitmCesion);

        MitmDevolucion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmDevolucion.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmDevolucion.setText("Devolucion");
        JMenuPrincipal.add(MitmDevolucion);

        MitmConsultas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmConsultas.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmConsultas.setText("Consultas");
        MitmConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitmConsultasActionPerformed(evt);
            }
        });
        JMenuPrincipal.add(MitmConsultas);

        MitmSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        MitmSalir.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmSalir.setText("Salir");
        JMenuPrincipal.add(MitmSalir);

        jMenuBar1.add(JMenuPrincipal);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//TODO
    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed

            // comprobar que no esten repetidos nombre marca y categoria 
            ///TODO checkear comprobar precios    
            //adaptas metodo vijeo si es que editar fincona 
            try {
                Ss.Add(Ss.comprobarPrecios(Ss.comprobarRepetidos(model)));
                products2 = Ps.Dao.listarTodos();
            } catch (Exception ex) {
                Logger.getLogger(Stock1.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al  cargar productos " + ex.getMessage());
            }
        
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void ComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCategoriaActionPerformed
     selectionCategoria = (String) ComboCategoria.getSelectedItem();
        
    }//GEN-LAST:event_ComboCategoriaActionPerformed

    private void ComboMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMarcaActionPerformed
         selectionMarca = (String) ComboMarca.getSelectedItem();
    }//GEN-LAST:event_ComboMarcaActionPerformed

    private void BtnBuscarPructosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarPructosActionPerformed
        
        if (!selectionCategoria.equals("")&& selectionMarca.equals("")) {    
            try {
                System.out.println(" condicion 1 true");
                products2= Ps.Dao.buscarPorCategoria(selectionCategoria);
                Ss.Display(model, products2);
            } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Error :"+ex.getMessage());
            }
        } else{
                System.out.println(" condicion 1 false");
            }
        if (selectionCategoria.equals("")&& !selectionMarca.equals("")) {
            try {
                System.out.println(" condicion 2 true");
                products2= Ps.Dao.buscarPorMarca(selectionMarca);
                Ss.Display(model, products2);
            } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Error :"+ex.getMessage());
            }
            
        }else{
                    System.out.println(" condicion 2 false");
                    }
        if (!selectionCategoria.equals("")&& !selectionMarca.equals("")){
                try {
                     System.out.println(" condicion 3 true");
                    products2= Ps.Dao.buscarPorCategoriayMarca(selectionCategoria, selectionMarca);
                    Ss.Display(model, products2);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, "Error :"+ex.getMessage());
                }
            }else{
                    System.out.println(" condicion 2 false");
                    }
    }//GEN-LAST:event_BtnBuscarPructosActionPerformed

    private void MitmVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmVentaActionPerformed
        Venta V;
        try {
            V = new Venta();
            V.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir ventas" + e.getMessage());
        }
    }//GEN-LAST:event_MitmVentaActionPerformed

    private void MimtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MimtStockActionPerformed
        Stock1 S1;
        try {
            S1 = new Stock1();
            S1.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir Stock" + ex.getMessage());
            ex.getCause();
            ex.getStackTrace();
        }
    }//GEN-LAST:event_MimtStockActionPerformed

    private void MitmCesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmCesionActionPerformed
        MenuIngreso mi;
        try {
            mi = new MenuIngreso();
            mi.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir menu de cesion " + e.getMessage());
        }
    }//GEN-LAST:event_MitmCesionActionPerformed

    private void MitmConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MitmConsultasActionPerformed

    private void BtnAgregarProuctosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarProuctosActionPerformed
      String input = (JOptionPane.showInputDialog("Ingrese la cantidad de filas de productos a agregar, el maximo es 100"));
            if (input != null) {
                int rows = Integer.parseInt(input);
                model = Ss.AddSelected(model, rows);
            }            
    }//GEN-LAST:event_BtnAgregarProuctosActionPerformed

    //esto deberia pasarse a StockService pero hasta no haberlo probado vamos a dejarlo aca
    private void calculatePrice(int row, DefaultTableModel model1) {        
        try {            
            Double precioCompra = (Double) model1.getValueAt(row, 4);
            Double interes = (Double) model1.getValueAt(row, 8);
            Double precio = (Double) model1.getValueAt(row, 5);
            // Verificar si los valores necesarios están presentes y el interés es diferente de cero
            if (precioCompra != 0 && interes != 0 && precio == 0) {
                precio = precioCompra * (interes + 1);
                model.setValueAt(precio, row, 5);                
            }
            if (precioCompra != 0 && precio != 0 && interes == 0) {
                interes = (precio / precioCompra) - 1;
                model.setValueAt(interes, row, 8);                
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getClass());
            System.out.println(e.toString());
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JButton BtnAgregarProuctos;
    private javax.swing.JButton BtnBuscarPructos;
    private javax.swing.JComboBox<String> ComboCategoria;
    private javax.swing.JComboBox<String> ComboMarca;
    private javax.swing.JMenu JMenuPrincipal;
    private javax.swing.JLabel LabelCategoria;
    private javax.swing.JLabel LabelMarca;
    private javax.swing.JMenuItem MimtStock;
    private javax.swing.JMenuItem MitmCesion;
    private javax.swing.JMenuItem MitmConsultas;
    private javax.swing.JMenuItem MitmDevolucion;
    private javax.swing.JMenuItem MitmSalir;
    private javax.swing.JMenuItem MitmVenta;
    private javax.swing.JTable TableVenta;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void FillComboBox(JComboBox<String> Combo,List<String> contenido) {
        
        if (Combo == ComboMarca) {
             
            for (String marca : contenido) {
                Combo.addItem(marca);
            }
        } else {
          
            for (String categoria : contenido) {
                Combo.addItem(categoria);
            }
        }
    }
    
}