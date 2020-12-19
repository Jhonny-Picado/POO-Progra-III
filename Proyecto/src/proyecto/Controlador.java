/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Jhonny Picado
 */
public class Controlador extends JFrame implements KeyListener{
 
    Controlador(){
        addKeyListener(this);
        
    }  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Controlador c= new Controlador();
        c.setSize(500, 150);
        c.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case 37:
                System.out.println("Izquierda");
                break;
            case 38:
                System.out.println("Arriba");
                break;
            case 39:
                System.out.println("Derecha");
                break;
            case 40:
                System.out.println("Abajo");
                break;
            case 32:
                System.out.println("Espacio");
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Aca debe ir un metodo que envie la informacion de la tecla presionada a la consola
}
