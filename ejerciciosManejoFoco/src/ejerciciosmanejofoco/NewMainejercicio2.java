/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmanejofoco;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author agust
 */
public class NewMainejercicio2 {

    /**
     * @param args the command line arguments
     */
        
        class laminaFoco extends JPanel {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setLayout(null);
                JTextField usuarioMail = new JTextField();
                JTextField password = new JTextField();
                usuarioMail.setBounds(120, 10, 150, 20);
                password.setBounds(120, 50, 150, 20);
                add(usuarioMail);
                add(password);
                class lanzarFocos implements FocusListener {

                    @Override
                    public void focusGained(FocusEvent e) {
                        String text;
                        if (e.getSource().toString().equals("usuarioMail")) {
                            text = usuarioMail.getText();
                            System.out.println("usuario  :" + text);
                        }
                        if (e.getSource().toString().equals("password")) {
                            text = password.getText();
                            System.out.println("password  :" + text);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        String text;
                        if (e.getSource().toString().equals("usuarioMail")) {
                            usuarioMail.setText("Focus Lost");
                        }
                        if (e.getSource().toString().equals("password")) {
                            usuarioMail.setText("Focus Lost");
                        }
                    }
                }
                lanzarFocos elfoco = new lanzarFocos();
                usuarioMail.addFocusListener(elfoco);
                password.addFocusListener(elfoco);
                setVisible(true);
            }

        }
        
        laminaFoco l = new laminaFoco();
        
   

}
