package com.mycompany.fidemotorapp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MenuInicioSesion {

    private int opcion = 0;

    public MenuInicioSesion() {
    }

    Usuarios sesion = new Usuarios();

    private static final String Archivo = "ProyectoFideMotorApp.txt";

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
                    visualizarCompras();
                    break;
                case 2:
                    visualizarVehiculos();
                    break;
                case 3:
                    String campoModificar = JOptionPane.showInputDialog(null,
                            "Qué campo desea modificar?\n"
                            + "1 - Identificación\n"
                            + "2 - Nombre del Usuario\n"
                            + "3 - Apellidos del Usuario\n"
                            + "4 - Número Telefónico\n"
                            + "5 - Dirección\n"
                            + "6 - Correo Electrónico\n"
                            + "7 - Sexo\n"
                            + "8 - Fecha de Nacimiento\n"
                            + "9 - Nacionalidad\n"
                            + "10 - Contraseña\n"
                            + "Ingrese el número de opción:");
                    switch (campoModificar) {
                        case "1":
                            sesion.modificar();
                            break;
                        case "2":
                            sesion.modificar();
                            break;
                        case "3":
                            sesion.modificar();
                            break;
                        case "4":
                            sesion.modificar();
                            break;
                        case "5":
                            sesion.modificar();
                            break;
                        case "6":
                            sesion.modificar();
                            break;
                        case "7":
                            sesion.modificar();
                            break;
                        case "8":
                            sesion.modificar();
                            break;
                        case "9":
                            sesion.modificar();
                            break;
                        case "10":
                            sesion.modificar();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Sesión finalizada");
                    return; // Salir del método y volver al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    // Método para visualizar compras realizadas
    private void visualizarCompras() {

        JOptionPane.showMessageDialog(null, "Visualizando compras realizadas");
    }

    // Método para visualizar vehículos
    private void visualizarVehiculos() {

        JOptionPane.showMessageDialog(null, "Visualizando vehículos");
    }
}
