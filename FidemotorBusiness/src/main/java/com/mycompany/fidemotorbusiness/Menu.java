/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fidemotorbusiness;

import java.util.LinkedList;
import Cliente.ServicioCliente;

/**
 *
 * @author Venta PC
 */
public class Menu {

    private LinkedList<Vehiculo> inventario = new LinkedList<>();
    private Vehiculo current = null;
    private int currentID = 0;
    private int maxInv;
    
    private LinkedList<Compra> compras = new LinkedList<>();
    private Compra currentC = null;
    private int currentComID;
    private int maxC;
    
    private LinkedList<Usuario> usuarios = new LinkedList<>();

    
    public void actualizarUsers(){
        usuarios.clear();
        ServicioCliente c = new ServicioCliente("6");
        String s = c.getRespuesta();
        String[] x = s.split("##");
        for (int i = 0; i < x.length; i++) {
            String[] y = x[i].split("#");
            
            Usuario u = new Usuario(y[0], y[1], y[2], y[3]);
            usuarios.add(u);
        }
    }
    
    
    public void actualizarCompras(){
        compras.clear();
        ServicioCliente c = new ServicioCliente("2");
        String s = c.getRespuesta();
        String[] x = s.split("##");
        
        for (int i = 0; i < x.length; i++) {
            String[] y = x[i].split("#");
            
            Compra com = new Compra(y[0], y[1], y[2], y[3]);
            compras.add(com);
        }
        
        currentC = compras.getFirst();
        maxC = compras.size()-1;
        currentComID = 0;
        
    }
    
    public boolean editarCompra(String mensaje){
        ServicioCliente c = new ServicioCliente("1##"+currentC.getID()+"#"+mensaje);
        if(c.getRespuesta().equals("false")){
            return false;
        }else{
            return true;
        }
    }
    
    public void cambiarCurrentCom(Boolean b){
        if(b&&currentComID!=0){
            currentComID--;
            currentC=compras.get(currentComID);
        }else if(b==false&&currentComID!=maxInv){
            currentComID++;
            currentC=compras.get(currentComID);
        }
    }
    
    public void actualizarInventario(){
        inventario.clear();
        ServicioCliente c = new ServicioCliente("D");
        String s = c.getRespuesta();
        String[] x = s.split("##");
        
        for (int i = 0; i < x.length; i++) {
            String[] y = x[i].split("#");
            
            Vehiculo v = new Vehiculo(Integer.parseInt(y[0]), y[1], y[2], y[3], y[4], y[5]);
            inventario.add(v);
        }
        
        current = inventario.getFirst();
        maxInv = inventario.size()-1;
        currentID = 0;
    }
    
    public void cambiarCurrentInv(Boolean b){
        if(b&&currentID!=0){
            currentID--;
            current=inventario.get(currentID);
        }else if(b==false&&currentID!=maxInv){
            currentID++;
            current=inventario.get(currentID);
        }
    }
    
    public boolean anadirVehiculo(String mensaje){
        ServicioCliente c = new ServicioCliente("3##"+mensaje);
        if(c.getRespuesta().equals("false")){
            return false;
        }else{
            return true;
        }
    }

    public boolean editarVehiculo(String mensaje) {
        ServicioCliente c = new ServicioCliente("5##"+current.getId()+"#"+mensaje);
        if(c.getRespuesta().equals("false")){
            return false;
        }else{
            return true;
        }

    }
    
    public boolean eliminarVehiculo(){
        ServicioCliente c = new ServicioCliente("4##"+current.getId());
        if(c.getRespuesta().equals("false")){
            return false;
        }else{
            return true;
        }
    }
    

    public String getUserInfoC(){
        String r = "No hay usuario";
        for (Usuario user : usuarios) {
            if(user.getID().equals(currentC.getUser())){
                r = user.getInfo();
            }
        }
        return r;
    }
    
    public String getVehicleInfoC(){
        String r="Vehiculo eliminado";
        for (Vehiculo vehiculo : inventario) {
            String vid = ""+vehiculo.getId();
            if(vid.equals(currentC.getVe())){
                r=vehiculo.getInfo();
            }
        }
        return r;
    }
    
    public String getEstado(){
        return currentC.getEstado();
    }
    
    public Vehiculo getCurrent(){
        return current;
    }

}
