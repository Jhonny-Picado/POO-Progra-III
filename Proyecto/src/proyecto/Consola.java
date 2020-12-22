/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Jhonny Picado
 */
public class Consola {
    Servidor server;
    Cliente cliente;
    
    Consola(){
       cliente= new Cliente (5005);
       server = new Servidor(5000);
    }  
         
}
