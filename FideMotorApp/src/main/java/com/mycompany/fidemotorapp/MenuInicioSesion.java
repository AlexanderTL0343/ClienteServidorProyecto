/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fidemotorapp;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class MenuInicioSesion {

    private int opcion = 0;

    public MenuInicioSesion() {
    }

    Usuarios sesion = new Usuarios();

    public void mostrarMenu() {
        while (opcion != 6) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Inicio Sesion:\n"
                    + "1 - Visualizar compras realizadas\n"
                    + "2 - Visualizar vehículos\n"
                    + "3 - Editar datos\n"
                    + "4 - Salir de la sesión\n"
                    + "Digite una opción para continuar: "
            ));
            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    sesion.modificar();

                    break;
                case 4:

                    break;

                case 5:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
