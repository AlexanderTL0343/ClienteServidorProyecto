/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fidemotorbusiness;

/**
 *
 * @author Venta PC
 */
public class Compra {
    String id;
    String usuario;
    String vehiculo;
    String estado;//1 procesado //2 listo para entrega //3 Listo para entrega //4 Enviado

    public Compra(String id,  String estado,String usuario, String vehiculo) {
        this.id = id;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.estado = estado;
    }
    
    
    
    public String getID(){
        return id;
    }   
    public String getUser(){
        return usuario;
    }
    public String getVe(){
        return vehiculo;
    }
    public String getEstado(){
        if(null == estado){
            return "Listo para entrega";
        }else return switch (estado) {
            case "1" -> "Enviado";
            case "2" -> "Aceptado";
            case "3" -> "Procesado";
            default -> "Listo para entrega";
        };
    }
}
    
