/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fideservidor;

import DatabaseManager.DatabaseManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Venta PC
 */
public class ServerThread extends Thread{
    private Socket s1;
    private String r = "false";
    private DatabaseManager db;
    

    public ServerThread(Socket s1) {
        this.s1 = s1;
        db= new DatabaseManager();
    }
    //Usuarios
    //"A" registerUser - "B" LoginUser - "C" EditarUsuario
    //"D" VerVehiculos - "E" ComprarVehiculo - "F" verComprasUsuario
    
    //Business
    //"1" GestionarEstadosDeCompras - "2" verTodasLasCompras
    //"3" AgregarVehiculo - "4" EliminarVehiculo - "5" EditarVehiculo - "6" GetUserInfo
    @Override
    public void run(){
        
        DataInputStream dis = null;
        DataOutputStream dos = null;
        
        try{
            //receives message and sends to compare
            dis = new DataInputStream(s1.getInputStream());
            String[] str = dis.readUTF().split("##");
            
            switch (str[0]) {
                case "A" -> //registrar
                    r=db.RegisterUser(str[1]);
                case "B" -> //login
                    r=db.LoginUser(str[1]);
                case "C" -> //editar usuario
                    r=db.EditUser(str[1]);
                case "D" -> //Ver inventario
                    r=db.GetInventory();
                case "E" -> //Comprar vehiculo
                    r=db.BuyVehicle(str[1]);
                case "F" -> //Ver compras usuario
                    r=db.GetUserPurchases(str[1]);
                case "1" -> //EditarEstadoCompra
                    r=db.EditPurchase(str[1]);
                case "2" -> //Ver todas las compras
                    r=db.GetPurchases();
                case "3" -> //Agregar vehiculo
                    r=db.AddVehicle(str[1]);
                case "4" -> //Eliminar vehiculo
                    r=db.DeleteVehicle(str[1]);
                case "5" -> //Editar vehiculo
                    r=db.EditVehicle(str[1]);
                case "6" -> //get user info
                    r=db.GetUserInfo();
                default -> {
                }
            }
            
            
            //gets response var from class Credential and sends it
            dos = new DataOutputStream(s1.getOutputStream());
            dos.writeUTF(r);
            
            
            //closes data streams
            dis.close();
            dos.close();
  
        }catch(IOException e){
        }
        
        if(s1 != null){
            //closing the client
            try{
                s1.close();
            }catch(IOException e){
                
            }
        }
    }
    
    
}
