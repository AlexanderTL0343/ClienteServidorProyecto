/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloController;

/**
 *
 * @author Venta PC
 */
public class Usuario {
    String Id;
    String Nombre;
    String Apellidos;
    String Cedula;
    String telefono;
    String direccion;
    String sexo;
    String ano;
    String nacionalidad;
    String email;

    public Usuario(String Id, String Nombre, String Apellidos, String Cedula, String telefono, String direccion, String sexo, String ano, String nacionalidad, String email) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Cedula = Cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sexo = sexo;
        this.ano = ano;
        this.nacionalidad = nacionalidad;
        this.email = email;
    }

    
    
    public String getInfo(){
        return "Cliente: "+Nombre+" "+Apellidos+ " Cédula: "+Cedula;
    }
    
    public String getID(){
        return Id;
    }
}
