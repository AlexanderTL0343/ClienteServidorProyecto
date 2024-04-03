/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fidemotorapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class Usuarios {

    private static String Identificación, NombreDelUsuario, ApellidosDelUsuario, NúmeroTelefónico, Contraseña, Dirección, Sexo, FechaDeNacimiento, CorreoElectronico, Nacionalidad;

    public Usuarios() {
    }

    public static boolean camposRequeridosIncompletos() {
        if ((Identificación.equals(""))
                || (NombreDelUsuario.equals(""))
                || (ApellidosDelUsuario.equals(""))
                || (NúmeroTelefónico.equals(""))
                || (Dirección.equals(""))
                || (Sexo.equals(""))
                || (FechaDeNacimiento.equals(""))
                || (CorreoElectronico.equals(""))
                || (Nacionalidad.equals(""))
                || (Contraseña.equals(""))) {
            return true;
        } else {
            return false;
        }
    }

    public static void agregar() {
        try {
            //Aquí creamos el archivo y la entrada de datos
            DataOutputStream archivo = new DataOutputStream(new FileOutputStream("ProyectoFideMotorApp.txt", true));
            //Aquí solicitamos los datos al usuario
            Identificación = JOptionPane.showInputDialog("Digite su Identificación:");
            NombreDelUsuario = JOptionPane.showInputDialog("Digite su Nombre De Usuario:");
            ApellidosDelUsuario = JOptionPane.showInputDialog("Digite sus Apellidos:");
            NúmeroTelefónico = JOptionPane.showInputDialog("Digite su Número Telefónico:");
            Dirección = JOptionPane.showInputDialog("Digite su Dirección:");
            CorreoElectronico = JOptionPane.showInputDialog("Digite su Correo Electronico:");
            Sexo = JOptionPane.showInputDialog("Digite su Sexo:");
            FechaDeNacimiento = JOptionPane.showInputDialog("Digite su Fecha De Nacimiento:");
            Nacionalidad = JOptionPane.showInputDialog("Digite su Nacionalidad:");
            Contraseña = JOptionPane.showInputDialog("Digite su Contraseña:");
            //Validamos que el usuario digitó toda la información requerida
            if (camposRequeridosIncompletos()) {
                //Si nos faltó escribir algún dato, lanzamos un error, esto cae en el catch
                throw new Exception("Algunos de los campos requeridos no fueron completados");
            } else {
                //Si los datos están correctos escribimos en el archivo
                archivo.writeUTF(Identificación);
                archivo.writeUTF(NombreDelUsuario);
                archivo.writeUTF(ApellidosDelUsuario);
                archivo.writeUTF(NúmeroTelefónico);
                archivo.writeUTF(Dirección);
                archivo.writeUTF(CorreoElectronico);
                archivo.writeUTF(Sexo);
                archivo.writeUTF(FechaDeNacimiento);
                archivo.writeUTF(Nacionalidad);
                archivo.writeUTF(Contraseña);
                //Notificarle al usario que se guardaron los datos
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente!", "Agregar Datos",
                        JOptionPane.INFORMATION_MESSAGE);
                //Debemos cerrar el archivo una vez que dejemos de utilizarlo
                archivo.close();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void modificar() {
        String IdentBusca, Identificación, CorreoElectronico, NúmeroTelefónico, Dirección, Contraseña;
        //boolean proximo = true;
        IdentBusca = JOptionPane.showInputDialog("Digite la cédula de la persona a modificar: ");
        try {
            //Todo lo que debe salir bien, va en este try
            //En este try estamos generando los procesos de lectura y escritura de archivos
            //Definimos el archivo que queremos leer
            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("ProyectoFideMotorApp.txt"));
            //Definimos un archivo temporal, para almacenar los cambios del usuario, que se registrarán en el archivo original
            DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("aux.txt"));

            //Vamos a hacer un try adicional que se va a encargar de buscar, recolectar la nueva información 
            // y modificar el archivo general
            try {
                while (true) {
                    //Descargamos el contenido del archivo
                    Identificación = archivoLectura.readUTF();
                    CorreoElectronico = archivoLectura.readUTF();
                    Dirección = archivoLectura.readUTF();
                    Contraseña = archivoLectura.readUTF();
                    NúmeroTelefónico = archivoLectura.readUTF();
                    //Buscamos la cédula que digitó el usuario
                    if (IdentBusca.equals(Identificación)) {
                        //Si la cédula existe entonces vamos a modificar el dato en el archivo
                        //Solicitamos los nuevos datos al usuario
                        CorreoElectronico = JOptionPane.showInputDialog("Digite el nuevo Correo Electronico:");
                        NúmeroTelefónico = JOptionPane.showInputDialog("Digite el nuevo Número Telefónico:");
                        Dirección = JOptionPane.showInputDialog("Digite la nueva Dirección:");
                        Contraseña = JOptionPane.showInputDialog("Digite la nueva Contraseña:");

                    }
                    archivoEscritura.writeUTF(Identificación);
                    archivoEscritura.writeUTF(CorreoElectronico);
                    archivoEscritura.writeUTF(NúmeroTelefónico);
                    archivoEscritura.writeUTF(Dirección);
                    archivoEscritura.writeUTF(Contraseña);
                }
            } catch (EOFException e) {
                archivoEscritura.close();
                archivoLectura.close();
                //En el momento en que alcancemos el final del archivo, vamos a intercambiar los datos del archivo 
                // temporal al archivo original
                intercambiar();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al localizar el archivo: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            //Todo lo que puede salir mal, va en este catch
            JOptionPane.showMessageDialog(null, "Los archivos tienen errores de lectura/escritura: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void intercambiar() {
        String Identificación, CorreoElectronico, NúmeroTelefónico, Dirección, Contraseña;
        try {
            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("aux.txt"));
            DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("ProyectoFideMotorApp.txt"));

            try {
                while (true) {
                    Identificación = archivoLectura.readUTF();
                    CorreoElectronico = archivoLectura.readUTF();
                    NúmeroTelefónico = archivoLectura.readUTF();
                    Dirección = archivoLectura.readUTF();
                    Contraseña = archivoLectura.readUTF();
                    archivoEscritura.writeUTF(Identificación);
                    archivoEscritura.writeUTF(CorreoElectronico);
                    archivoEscritura.writeUTF(NúmeroTelefónico);
                    archivoEscritura.writeUTF(Dirección);
                    archivoEscritura.writeUTF(Contraseña);
                }
            } catch (EOFException e) {
                archivoEscritura.close();
                archivoLectura.close();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al localizar el archivo: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            //Todo lo que puede salir mal, va en este catch
            JOptionPane.showMessageDialog(null, "Los archivos tienen errores de lectura/escritura: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

}
