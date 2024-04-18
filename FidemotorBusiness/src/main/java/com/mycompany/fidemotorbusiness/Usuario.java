/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fidemotorbusiness;

/**
 *
 * @author Venta PC
 */
public class Usuario {
    String Id;
    String Nombre;
    String Apellidos;
    String Cedula;

    public Usuario(String Id, String Nombre, String Apellidos, String Cedula) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Cedula = Cedula;
    }
    
    public String getInfo(){
        return "Cliente: "+Nombre+" "+Apellidos+ " Cédula: "+Cedula;
    }
    
    public String getID(){
        return Id;
    }
}
