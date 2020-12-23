/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Sockets.Cliente;
import Sockets.Servidor;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Jhonny Picado
 */
public class Pacman implements Observer{
    Servidor server;
    Cliente cliente;
    
    Pacman(){
        server = new Servidor(5000);
        server.addObserver(this);
        cliente= new Cliente (5005);
    }  
    
    
    public void IMPRIMIR(String mensaje){
        //System.out.println(mensaje);
        cliente.EnviarMensaje(mensaje);
    }

    @Override
    public void update(Observable o, Object o1) {
        this.IMPRIMIR(o1.toString());
    }
}
