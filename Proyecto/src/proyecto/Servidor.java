/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;

/**
 *
 * @author Usuario
 */
public class Servidor implements Runnable{
    
    private int puerto;
    private Consola consola;
    
    public Servidor (int port){
        puerto=port;
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
                // System.out.println("Server iniciado");
                socket = servidor.accept();

                // System.out.println("Cliente conectado");
                in = new DataInputStream(socket.getInputStream());
                //out = new DataOutputStream (socket.getOutputStream());

                String mensaje = in.readUTF();

                System.out.println(mensaje);
                //out.writeUTF("MAYONESA");
                socket.close();
                //System.out.println("Cliente desconectado");   
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
}
