/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloController;

/**
 *
 * @author Venta PC
 */
public class Vehiculo {
    private int id;
    private String marca;
    private String ano;
    private String modelo;
    private String precio;
    private String tipo;


    public Vehiculo(int id, String tipo, String marca, String ano, String modelo, String precio) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.ano = ano;
        this.modelo = modelo;
        this.precio = precio;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipo() {
        if(tipo.equals("1")){
            return "Automovil";
        }else if(tipo.equals("2")){
            return "Motocicleta";
        }else{
            return "Camion";
        }
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getInfo(){
        return marca+" "+modelo+" "+ano+" $"+precio;
    }

    
    
    
    
    
}
