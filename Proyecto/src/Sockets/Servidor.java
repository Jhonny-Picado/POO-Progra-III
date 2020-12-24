/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Servidor extends Observable implements Runnable{
    
    private int puerto;
   
    public Servidor (int port){
        this.puerto=port;
        Thread hilo= new Thread(this);
        hilo.start();
    }
    
    @Override
    public void run() {
    
        ServerSocket servidor;
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        try {
            servidor = new ServerSocket(puerto);
            while (true) {
                socket = servidor.accept();

                in = new DataInputStream(socket.getInputStream());

                Object mensaje = in.readUTF();                
                
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                socket.close();

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
}
