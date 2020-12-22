/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 * Clase main que invoca la aplicacion
 * @author Jhonny Picado
 */
public class Main {
     
    /**
     * @param args
     */
   public static void main(String[] args) {
        // TODO code application logic here
        Pantalla screen= new Pantalla();
        Consola con= new Consola();
        Controlador c= new Controlador(screen);
    }
}
