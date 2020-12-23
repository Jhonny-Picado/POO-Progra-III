/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import Vista.Pantalla;

/**
 * Clase main que invoca la aplicacion
 * @author Jhonny Picado Vega
 */
public class MainPacman {
     
    /**
     * @param args
     */
   public static void main(String[] args) {
        // TODO code application logic here
        Pantalla screen= new Pantalla();
        Pacman pacman= new Pacman();
        Controlador control= new Controlador(screen);
    }
}
