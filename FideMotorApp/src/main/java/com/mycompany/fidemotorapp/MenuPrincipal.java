/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fidemotorapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class MenuPrincipal {
     private int opcion = 0;
     Usuarios nuevoUser= new Usuarios();  
     MenuInicioSesion MIS = new MenuInicioSesion();

    public MenuPrincipal() {
    }
        
      
    public void mostrarMenuPricipal()
            
    {
        OUTER:
        while (opcion != 3) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "FideMotor APP:\n"
                    + "1 - Registrase\n"
                    + "2 - Iniciar Sesion\n"
                    + "3 - Salir\n"
                    + "Digite una opción para continuar: "
            ));
            switch (opcion) {
                case 1:
                    nuevoUser.agregar();

                    break;
                case 2: 
                    String UserName=JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
                      
                    String Clave = JOptionPane.showInputDialog("Ingrese su contraseña:");
                      
                      if (MIS.Validar(UserName, Clave)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                           
                    MIS.mostrarMenu();
                           
                    } else {
                    JOptionPane.showMessageDialog(null,"Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }

                    break;
                case 3:
                    break OUTER;
                case 4:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
