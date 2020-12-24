/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Sockets.Servidor;

import java.awt.Color;
import static java.awt.Color.*;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Jhonny Picado
 */
public class Pantalla extends JFrame implements Observer{
    public static JLabel Casillas[][]=new JLabel[50][50];
    private static Servidor server;
    
    //Constructor de la clase pantalla
    public Pantalla(){
        //server= new Servidor(5005);
        this.setSize(720, 680);
        JPanel b= new JPanel();
        b.setBackground(Color.BLACK);
        generarMatriz(b);
        this.add(b);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  
       server = new Servidor(5005);
        server.addObserver(this);
    }
    
    
    //Metodo que genera la matriz del programa
    public void generarMatriz(JPanel interfaz) {
        
        for(int i=0; i < Casillas.length; i++) {
            
            for(int j=0; j < Casillas[i].length; j++) {
                JLabel btnNuevo = new JLabel();
                btnNuevo.setOpaque(true);
                btnNuevo.setBackground(Color.BLACK);
                Casillas[i][j]=btnNuevo;
                interfaz.add(Casillas[i][j]);
            }
        }
        interfaz.setLayout(new GridLayout(50, 50));
    }
       
    
    public void ModificarPixeles(String mensaje){
        
        Color Colores[]={red,blue,gray,white,cyan,orange};
        Casillas[1][1].setBackground(Colores[(int)(Math.random()*5)]);
        System.out.println("SI LLEGO : "+ mensaje);
        
    }

    @Override
    public void update(Observable o, Object o1) {
        this.ModificarPixeles(o1.toString());
    }
}

