/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
/**
 *
 * @author Usuario
 */
public class Cliente{

        private final String HOST = "127.0.0.1";
        private int puerto;       
        private DataOutputStream out;
        
        public Cliente(int port){
            this.puerto=port;
        }
        
        public void EnviarMensaje(String mensaje){
            try {
                Socket sc = new Socket(HOST, puerto);
                out = new DataOutputStream (sc.getOutputStream());                
                out.writeUTF(mensaje);
                sc.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
