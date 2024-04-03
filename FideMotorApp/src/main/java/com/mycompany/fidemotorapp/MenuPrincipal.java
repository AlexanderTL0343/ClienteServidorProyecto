package com.mycompany.fidemotorapp;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    private int opcion = 0;
    Usuarios nuevoUser = new Usuarios();
    MenuInicioSesion MIS = new MenuInicioSesion();

    public MenuPrincipal() {
    }

    public void mostrarMenuPrincipal() {
        OUTER:
        while (opcion != 3) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "FideMotor APP:\n"
                    + "1 - Registrarse\n"
                    + "2 - Iniciar Sesión\n"
                    + "3 - Salir\n"
                    + "Digite una opción para continuar: "
            ));
            switch (opcion) {
                case 1:
                    nuevoUser.agregar();
                    break;
                case 2:
                    String UserName = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
                    String Clave = JOptionPane.showInputDialog("Ingrese su contraseña:");

                    if (MIS.Validar(UserName, Clave)) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                        MIS.mostrarMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error de inicio de sesión", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    break OUTER;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}