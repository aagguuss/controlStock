/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmanejofoco;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

/**
 *
 * @author agust
 */
public class FocoVentana extends JFrame implements WindowFocusListener {

    /**
     * @param args the command line arguments
     */
   // public static void main(String[] args) {
   //     FocoVentana miv = new FocoVentana();
    //    miv.iniciar();
   // }

    public void iniciar() {
        Marco1 = new FocoVentana();
        Marco2 = new FocoVentana();

        Marco1.setVisible(true);
        Marco2.setVisible(true);

        Marco1.setBounds(300, 100, 600, 350);
        Marco2.setBounds(1200, 100, 600, 350);

        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Marco1.addWindowFocusListener(this);
        Marco2.addWindowFocusListener(this);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

        boolean resultado = (e.getSource() == Marco1);
        if (resultado) {
            Marco1.setTitle("Verdadero");
            Marco2.setTitle("Falso");
        } else {
            Marco1.setTitle("Falso");
            Marco2.setTitle("Verdadero");
        }
    }

    @Override
    public void windowLostFocus(WindowEvent e) {

        if (e.getSource().toString().equals(Marco1)) {

        }
        if (e.getSource().toString().equals(Marco2)) {

        }
    }
    FocoVentana Marco1;
    FocoVentana Marco2;
}
