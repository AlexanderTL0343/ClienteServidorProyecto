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
    
    private static final String Archivo ="ProyectoFideMotorApp.txt";

    public boolean Validar(String UserName, String Clave) {
        
        boolean aux = false;
        
        try (DataInputStream archivoLectura = new DataInputStream(new FileInputStream(Archivo))) {
            while (true) {
                String Identificación = archivoLectura.readUTF();
                String NombreDelUsuario = archivoLectura.readUTF();
                String ApellidosDelUsuario = archivoLectura.readUTF();
                String NúmeroTelefónico = archivoLectura.readUTF();
                String Dirección = archivoLectura.readUTF();
                String CorreoElectronico = archivoLectura.readUTF();
                String Sexo = archivoLectura.readUTF();
                String FechaDeNacimiento = archivoLectura.readUTF();
                String Nacionalidad = archivoLectura.readUTF();
                String Contraseña = archivoLectura.readUTF();

                if (NombreDelUsuario.equals(UserName) && Contraseña.equals(Clave)) {
                    aux = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al validar contraseña: " + e.getMessage());
        }

        return aux;
    }


    public void mostrarMenu() {
        while (opcion != 5) {
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
