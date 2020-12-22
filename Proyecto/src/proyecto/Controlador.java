/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONArray;
/**
 *
 * @author Jhonny Picado
 */
public class Controlador extends JFrame implements KeyListener{
 
    private static Cliente cliente;
    private static JSONArray arregloJson;
    
    Controlador(JFrame input){
        readJson();
        input.addKeyListener(this);
        cliente = new Cliente(5000);
    }  
   
    @Override
    public void keyPressed(KeyEvent ke) {  
        switch (ke.getKeyCode()) {
            case 37:
                //System.out.println("Izquierda");
                cliente.EnviarMensaje((String)arregloJson.get(0));
                break;
            case 38:
               // System.out.println("Arriba");
                cliente.EnviarMensaje((String)arregloJson.get(1));
                break;
            case 39:
                //System.out.println("Derecha");
                cliente.EnviarMensaje((String)arregloJson.get(2));
                break;
            case 40:
               // System.out.println("Abajo");
                cliente.EnviarMensaje((String)arregloJson.get(3));
                break;
            case 32:
                //System.out.println("Espacio");
                cliente.EnviarMensaje((String)arregloJson.get(4));
                break;
            default:
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyReleased(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.  
    }
    
    private JSONObject coversion(String mensaje){
        JSONObject json= new JSONObject();
        
        json.put("direccion", mensaje);
        return json;
    }
    
    
    //Lee el JSON y lo deja en el array a usar más arriba
    public static void readJson(){
      try {

        JSONParser parser = new JSONParser();
        Object object =  parser.parse(new FileReader("C:\\Users\\Usuario\\Documents\\Josué TEC\\Git-hub\\Programación Orientada a Objetos\\POO-Progra-III\\Proyecto\\src\\proyecto\\Controlador.json"));
        
        JSONObject config = new JSONObject (object.toString());

        arregloJson = config.getJSONArray("Direccion");
        

      // String verb = (String) arregloJson.get(0);
       //System.out.println(verb);

    } catch (IOException e) {
        System.out.println("Excepcion leyendo fichero de configuracion " + e);
    }   catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}
