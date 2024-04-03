/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fidemotorbusiness;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Venta PC
 */
public class Menu {

    private LinkedList<Vehiculo> inventario = new LinkedList<>();
    private LinkedList<Compra> compras = new LinkedList<>();

    public void anadirVehiculo(String tipo, String marca, String ano, String modelo, String precio) {
        if (tipo.equals("3") || tipo.equals("2") || tipo.equals("1")) {

            try {
                int a = Integer.parseInt(ano);
                double p = Double.parseDouble(precio);

                if (tipo.equals("1")) {
                    Vehiculo v = new Automovil(marca, a, modelo, p);
                    inventario.add(v);
                } else if (tipo.equals("2")) {
                    Vehiculo v = new Motocicleta(marca, a, modelo, p);
                    inventario.add(v);
                } else {
                    Vehiculo v = new Camion(marca, a, modelo, p);
                    inventario.add(v);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Numero no valido ingresado");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un tipo de vehículo válido");
        }

    }

    public void editarVehiculo() {
        String p = "";
        int c = 1;
        for (Vehiculo vehiculo : inventario) {
            p = p + c + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getAno() + " " + vehiculo.getPrecio() + "\n";
            c++;
        }

        if (p == "") {
            System.out.println("Lista Vacia");
        } else {
            System.out.println(p);
            int co = 1;
            int s = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el vehiculo a editar"));
            Vehiculo editar = null;
            for (Vehiculo vehiculo : inventario) {
                if (s == co) {
                    editar = vehiculo;
                }
                co++;

            }
            if (editar!=null) {
                editar.setAno(2003);
                editar.setMarca("Honda");
                editar.setModelo("Honda");
                editar.setPrecio(34.2);
            }

        }

    }

}
