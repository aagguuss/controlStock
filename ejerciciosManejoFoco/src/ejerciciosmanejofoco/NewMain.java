/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmanejofoco;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author agust
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public class variosOyentes {

        public static void main(String[] args) {
            // TODO code application logic here
            marcoPrincipal miMarco = new marcoPrincipal();
                    miMarco.setVisible(true);
        }
    }

    static class marcoPrincipal extends JFrame {

        public marcoPrincipal() {
            setTitle("Prueba varios");
            setBounds(100, 100, 300, 200);
            laminaPrincipal lamina = new laminaPrincipal();
            add(lamina);

        }

        class laminaPrincipal extends JPanel {

            public laminaPrincipal() {
                JButton nuevobtn = new JButton();
                nuevobtn.setText("nuevo");
                cerrarbtn.setText("cerrar");
                add(nuevobtn);
                add(cerrarbtn); 
                oyenteNuevo oyente = new oyenteNuevo();
                nuevobtn.addActionListener(oyente);
                cerrarTodos cerrar = new cerrarTodos();
                cerrarbtn.addActionListener(cerrar);
                
            }
           
            
            private class oyenteNuevo implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                  ventanaEmergente ventanNueva = new ventanaEmergente(cerrarbtn);
                  ventanNueva.setVisible(true);
                }
            
            }
            private class cerrarTodos implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                  dispose();
                }
            
            }
            
             JButton cerrarbtn = new JButton();
               class ventanaEmergente extends JFrame {
        
        public ventanaEmergente(JButton oyente){
           
            contador++;
            setTitle("Venta"+contador);
            setBounds(40*contador, 40*contador, 300, 150);
            cerrarTodos cerrar = new cerrarTodos();
            addActionListener(cerrar);
        }
         
        private static int contador=0;
        }
       
    }
    }
    
}
