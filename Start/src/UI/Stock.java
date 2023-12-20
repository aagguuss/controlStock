/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;
import Entidades.Product;
import ServicioIU.StockService;
import Servicios.ProductService;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 * @author agust
 */
public class Stock extends javax.swing.JFrame {
    DefaultTableModel model;
    ProductService Ps ;
    StockService Ss; 
    private List<Product> products2;
    ButtonGroup groupButtons;

    public Stock() throws Exception {
        this.Ss = new StockService();
        this.Ps= new ProductService(); 
        products2 = Ps.Dao.listarTodos(); 
        this.groupButtons = new ButtonGroup();
        initComponents();
        this.model= Ss.Display((DefaultTableModel) TableVenta.getModel(),products2);
        // Agregar eventos de cambio de valor a las celdas
        model.addTableModelListener((TableModelEvent e) -> {
         if (e.getType() == TableModelEvent.UPDATE) {
             int row = e.getFirstRow();
             int column = e.getColumn();
             // Verificar si se modificó alguna de las columnas de interés
             if (column == 4 || column == 5 || column == 8) {
                 // agregar que interprete a cualquier valor nulo en la casilla como = a 0 dentro de calculatePrice
                 calculatePrice(row,model);
             }
         }  
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        BtnAceptar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JRadioButton();
        BtnAgregar = new javax.swing.JRadioButton();
        BtnMarcar1 = new javax.swing.JRadioButton();
        BtnEliminar = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        JMenuPrincipal = new javax.swing.JMenu();
        MitmVenta = new javax.swing.JMenuItem();
        MimtStock = new javax.swing.JMenuItem();
        MitmCesion = new javax.swing.JMenuItem();
        MitmDevolucion = new javax.swing.JMenuItem();
        MitmConsultas = new javax.swing.JMenuItem();
        MitmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setAutoscrolls(true);

        TableVenta.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
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
        TableVenta.setCellSelectionEnabled(true);
        TableVenta.setFillsViewportHeight(true);
        TableVenta.setGridColor(new java.awt.Color(153, 255, 153));
        TableVenta.setInheritsPopupMenu(true);
        TableVenta.setMinimumSize(new java.awt.Dimension(800, 600));
        TableVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableVenta);
        TableVenta.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        BtnAceptar.setText("Aceptar");
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });

        groupButtons.add(BtnEditar);
        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        groupButtons.add(BtnAgregar);
        BtnAgregar.setText("Agregar Productos");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnMarcar1.setSelected(true);
        BtnMarcar1.setText("Marcar Alertas ");
        BtnMarcar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMarcar1ActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar filas");
        BtnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnMarcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnMarcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );

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
        JMenuPrincipal.add(MimtStock);

        MitmCesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MitmCesion.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmCesion.setText("Cesion");
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

        MitmSalir.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        MitmSalir.setText("Salir");
        JMenuPrincipal.add(MitmSalir);

        jMenuBar2.add(JMenuPrincipal);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MitmVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmVentaActionPerformed
       
    }//GEN-LAST:event_MitmVentaActionPerformed

    private void MitmConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitmConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MitmConsultasActionPerformed
//TODO
    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
     if (BtnEditar.isSelected()){
        
         try {
             //TODO checkear comprobar precios
             TableModel modelbis = this.TableVenta.getModel();
             System.out.println("model al seleccionar aceptar");
             model = (DefaultTableModel) modelbis;
             System.out.println("model despues de la accion  TableVenta.getModel() sea cargada");      
             
            products2=Ss.EditaleData(Ss.comprobarPrecios(model));
            Ps.ProductEdit(products2);
            int a = 0;
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(rootPane, "Errorr en btn aceptar linea 281 Stock : "+ex.getMessage());
         }
     } else if (BtnAgregar.isSelected()){
         // comprobar que no esten repetidos nombre marca y categoria 
         ///TODO checkear comprobar precios    
         //adaptas metodo vijeo si es que editar fincona
         
         try {
             Ss.Add(Ss.comprobarPrecios(Ss.comprobarRepetidos(model)));
             products2=Ps.Dao.listarTodos();
         } catch (Exception ex) {
             Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                     JOptionPane.showMessageDialog(null, "Error al  cargar productos "+ex.getMessage());
         }
     }
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
      if (BtnEditar.isSelected()) {
          try {
              products2=Ps.Dao.listarTodos();
              model = Ss.Display((DefaultTableModel) TableVenta.getModel(),products2);        
          } catch (Exception ex) {
              System.out.println("Error linea 304: " + ex.getMessage());          
          }  
                } else {  
                     model = Ss.Display((DefaultTableModel) TableVenta.getModel(),products2);                 
               }   
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        
        if (BtnAgregar.isSelected()) {
                    String input = (JOptionPane.showInputDialog("Ingrese la cantidad de filas de productos a agregar, el maximo es 100"));
                    if (input != null){
                    int rows = Integer.parseInt(input);
                   model = Ss.AddSelected((DefaultTableModel)TableVenta.getModel(),rows) ;  }    
                } else {
                     model = Ss.Display((DefaultTableModel) TableVenta.getModel(),products2);               
               }   
    }//GEN-LAST:event_BtnAgregarActionPerformed
//esta maaaaaal 
    private void BtnMarcar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMarcar1ActionPerformed
         if (BtnMarcar1.isSelected()) {
                  markRows();
            } else {
                 unmarkRows();
            }
    }//GEN-LAST:event_BtnMarcar1ActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

        String input = (JOptionPane.showInputDialog("Ingrese a partir de que indice desea borrar las filas "));
        if (input != null){
            int rows = Integer.parseInt(input);
        for (int i = rows ; i < model.getRowCount();i++){
        model.removeRow(i);
        }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    //esto deberia pasarse a StockService pero hasta no haberlo probado vamos a dejarlo aca
   private void calculatePrice(int row,DefaultTableModel model1) {        
       try{    
         Double precioCompra = (Double) model1.getValueAt(row, 4);
         Double interes = (Double) model1.getValueAt(row, 8);
         Double precio = (Double) model1.getValueAt(row, 5);
         // Verificar si los valores necesarios están presentes y el interés es diferente de cero
         if (precioCompra!=0 && interes!=0 && precio==0 ) {
                 precio = precioCompra * (interes + 1);
                 model.setValueAt(precio, row, 5);                
            }
         if (precioCompra!=0 && precio!=0 && interes == 0) {
                 interes = (precio/precioCompra)-1;
                 model.setValueAt(interes, row, 8);     
                }
            }catch( Exception e ){
                            System.out.println(e.getCause());
                            System.out.println(e.getClass());
                            System.out.println(e.toString());
                }
       
}
   // esto esta mal marca lo seleccionado o marca todo pero no la fila que quiero 
    private void markRows() {
    for (int row = 0; row < TableVenta.getRowCount(); row++) {
        int stock = (int) TableVenta.getValueAt(row, 6);
        int alertaStock = (int) TableVenta.getValueAt(row, 7);
        if (stock <= alertaStock) {
            TableVenta.setRowSelectionInterval(6, row);
            TableVenta.setSelectionBackground(Color.RED);
        }
    }
}
    // esto tambien esta mal
    private void unmarkRows() {
        TableVenta.setBackground(Color.WHITE);
    
}
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JRadioButton BtnAgregar;
    private javax.swing.JRadioButton BtnEditar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JRadioButton BtnMarcar1;
    private javax.swing.JMenu JMenuPrincipal;
    private javax.swing.JMenuItem MimtStock;
    private javax.swing.JMenuItem MitmCesion;
    private javax.swing.JMenuItem MitmConsultas;
    private javax.swing.JMenuItem MitmDevolucion;
    private javax.swing.JMenuItem MitmSalir;
    private javax.swing.JMenuItem MitmVenta;
    private javax.swing.JTable TableVenta;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
