/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jhonny Picado
 */
public class Pantalla extends JFrame{
    public static JLabel Casillas[][]=new JLabel[50][50];
    
    
    //Constructor de la clase pantalla
    public Pantalla(){
        this.setSize(720, 680);
        JPanel b= new JPanel();
        b.setBackground(Color.BLACK);
        Tablero(b);
        this.add(b);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  
        
    }
    
    //Metodo que genera la matriz del programa
    public void Tablero(JPanel interfaz) {
        
        for(int i=0; i < Casillas.length; i++) {
            
            for(int j=0; j < Casillas[i].length; j++) {
                JLabel btnNuevo = new JLabel();
                btnNuevo.setOpaque(true);
                btnNuevo.setBackground(Color.BLACK);
                Casillas[i][j]=btnNuevo;
                       
                if (i==49 && j ==49){
                    Casillas[i][j].setBackground(Color.yellow);
                }
                interfaz.add(Casillas[i][j]);
            }
        }
        
        interfaz.setLayout(new GridLayout(50, 50));
    }
}
