/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Servicios.rolServicio;
import Servicios.usuarioService;
import entidades.Rol;
import entidades.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class MenuIngreso extends javax.swing.JFrame {

    usuarioService us = new usuarioService();
    rolServicio rs = new rolServicio();

    /**
     * Creates new form menu_F
     * @throws java.lang.Exception
     */
    public MenuIngreso() throws Exception {
        boolean existeAdmin = us.existeUsuarioAdmin();
        try {
            Usuario u = us.buscarUsuarioActivo();
            if (u!=null) {
            us.desactivarUsuario(u);
            }
            
        } catch (Exception e) {
            e.getMessage();
        }
        if (existeAdmin == false) {
            JOptionPane.showMessageDialog(rootPane, "Creando Usuario Administrador Inicial ");
            // Crear nuevo usuario administrador
            Usuario admin = new Usuario();
            admin.setName("admin");
            admin.setPassword("admin");
            admin.setAlta(true);
            Rol rolAdmin = new Rol();
            rolAdmin.setNombre("Administrador");
            rs.crearRol(rolAdmin);
            admin.setRol(rs.BuscarAdminRol());
            us.crearUsuario(admin);
            admin = us.BuscarUsuarioInicial();
            rs.AgregarUsuarioAdministradorList(admin);
            JOptionPane.showMessageDialog(null, "El usuario : admin, fue creado exitosamente, su contraseña es : admin");
        }
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        LblBienvenido = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder("")));
        jPanel1.setPreferredSize(new java.awt.Dimension(425, 334));
        jPanel1.setLayout(null);

        LblBienvenido.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        LblBienvenido.setForeground(new java.awt.Color(102, 255, 51));
        LblBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblBienvenido.setText("Ingreso al sistema");
        LblBienvenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        LblBienvenido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(LblBienvenido);
        LblBienvenido.setBounds(20, 10, 440, 65);

        lblUser.setBackground(new java.awt.Color(153, 153, 153));
        lblUser.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(102, 255, 51));
        lblUser.setText("Usuario :");
        jPanel1.add(lblUser);
        lblUser.setBounds(20, 100, 90, 40);

        lblPassword.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(102, 255, 51));
        lblPassword.setText("Constraseña:");
        jPanel1.add(lblPassword);
        lblPassword.setBounds(10, 180, 130, 25);

        btnAceptar.setBackground(new java.awt.Color(51, 255, 51));
        btnAceptar.setText("Entrar");
        btnAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(110, 270, 90, 30);

        btnSalir.setBackground(new java.awt.Color(0, 102, 0));
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(280, 270, 100, 30);

        txtUsuario.setBackground(new java.awt.Color(204, 204, 204));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(160, 120, 210, 30);

        txtPassword.setBackground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("\n");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword);
        txtPassword.setBounds(160, 180, 211, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿estas seguro que deseas salir de la aplicacion ?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
      
        String nombre = txtUsuario.getText();
        char[] password = txtPassword.getPassword();
        String concatpas= "";
        txtPassword.setText("");
        txtUsuario.setText("");
        String mensaje;
        for (char c : password) {
            concatpas += c;
        }
        try {
            mensaje = us.ValidarUsuario(nombre, concatpas);
            try {
                if (mensaje.equalsIgnoreCase("Entrando 4l $istema")){
                us.activarUsuario(nombre, concatpas);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (mensaje.equalsIgnoreCase("Entrando 4l $istema")) {
                try {
                    JOptionPane.showMessageDialog(null, "Entrando al Programa");
                    mensaje = us.validarRol(nombre, concatpas);
                   
                    if (mensaje.equalsIgnoreCase("Permisos4dministrador")) {
                        //llamar interfaz administrador
                        MenuInicio adminMenu = new MenuInicio();
                        // Cierra el menú de inicio de sesión actual
                        adminMenu.setVisible(true);
                        
                        // cerrar panel ;de log in 
                    }
                    if (mensaje.equalsIgnoreCase("Permisos5imples")) {
                        //llamar interfaz vendedor 
                        // cerrar panel de log in 
                    }
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null , "Error en la line 198 : "+e.getMessage());
                }
            }
        } catch (Exception ex) {
            /*Logger.getLogger(MenuIngreso.class.getName()).log(Level.SEVERE, null, ex);*/
            JOptionPane.showMessageDialog(null , "Error en la line 206 : "+ex.getMessage());
            ex.printStackTrace();
        }

            
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void verificarUsuarioAdmin() throws Exception {
        boolean existeAdmin = us.existeUsuarioAdmin();

        if (existeAdmin = false) {
            // Crear nuevo usuario administrador
            Usuario admin = new Usuario();
            admin.setName("admin");
            admin.setPassword("Administrador");
            admin.setAlta(true);

            Rol rolAdmin = new Rol();
            rolAdmin.setNombre("Administrador");

            admin.setRol(rolAdmin);

            // revisar servicios  hacer test
            rs.crearRol(rolAdmin);
            rolAdmin = rs.BuscarAdminRol();
            us.crearUsuario(admin);

            admin = us.BuscarUsuarioInicial();

            rolAdmin = rs.BuscarAdminRol();
            rolAdmin.listaUsuarios.add(admin);
            admin.setRol(rolAdmin);
            admin.setRol(rolAdmin);

            rs.editarRol(rolAdmin);

            us.editarUsuario(admin);

        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblBienvenido;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
