/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


/**
 *
 * @author Venta PC
 */
public class ServicioCliente {
    String mensaje;

    public ServicioCliente(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getRespuesta(){
        String r = "0";
        Socket cSock = null;
        
        try{
            //creates socket
            cSock = new Socket("127.0.0.1" , 3030);
            
            //sends message
            DataOutputStream dos = new DataOutputStream(cSock.getOutputStream());
            dos.writeUTF(mensaje);
            
            //receives message
            DataInputStream dis = new DataInputStream(cSock.getInputStream());
            r = dis.readUTF();
            //closes everyting
            dos.close();
            dis.close();   
        } catch (IOException ex) {
            
        }
        
        if(cSock != null){
            try{
                cSock.close();
            }catch(IOException e){
                
            }
        }

        return r;
    }
}
