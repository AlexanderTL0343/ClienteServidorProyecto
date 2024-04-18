/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseManager;

import java.sql.*;
import conectar.Conectar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignacio
 */
public class DatabaseManager {

    Conectar con;

    public DatabaseManager() {
        con = new Conectar();

    }

    public String RegisterUser(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {

            try {
                String[] p = prompt.split("#");
                Statement stm = c.createStatement();
                String sql = "Select * from login where cedula_login= " + p[2] + "";
                ResultSet rs = stm.executeQuery(sql);

                if (rs.next()) {
                    System.out.println("existe");
                    con.CerrarConeccion();
                    return "false";
                } else {
                    Statement stm2 = c.createStatement();
                    String sql2 = "insert into usuario(nombre_usuario, apellidos_usuario, cedula_usuario, contrasena_usuario, telefono_usuario, direccion_usuario,sexo_usuario, anio_usuario, nacionalidad_usuario, email_usuario)"
                            + "values ('" + p[0] + "','" + p[1] + "'," + p[2] + ",'" + p[3] + "'," + p[4] + ",'" + p[5] + "'," + p[6] + "," + p[7] + ",'" + p[8] + "','" + p[9] + "')";
                    stm2.execute(sql2);

                    Statement stm3 = c.createStatement();
                    String sql3 = "select * from usuario where cedula_usuario= " + p[2] + "";
                    ResultSet rs3 = stm3.executeQuery(sql3);

                    rs3.next();

                    Statement stm4 = c.createStatement();
                    String sql4 = "insert into login(cedula_login,contrasena_login,id_usuario_login) values(" + p[2] + ",'" + p[3] + "'," + rs3.getInt("id_usuario") + ")";
                    stm4.execute(sql4);
                    con.CerrarConeccion();
                    return "" + rs3.getInt("id_usuario");
                }

            } catch (SQLException e) {
                System.out.println("errorRegistarCatch");
                System.out.println(e.getMessage());
                return "false";
            }

        } else {
            return "false";
        }

    }

    public String LoginUser(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {

            try {
                String[] p = prompt.split("#");
                String r;
                Statement stm = c.createStatement();
                String sql = "Select * from login where cedula_login= " + p[0] + " and contrasena_login= '" + p[1] + "'";
                ResultSet rs = stm.executeQuery(sql);

                if (rs.next()) {
                    Statement stm2 = c.createStatement();
                    String sql2 = "Select * from usuario where id_usuario ='" + rs.getInt("id_usuario_login") + "'";
                    ResultSet rs2 = stm2.executeQuery(sql2);
                    rs2.next();
                    int id = rs2.getInt("id_usuario");
                    String nombre = rs2.getString("nombre_usuario");
                    String apellidos = rs2.getString("apellidos_usuario");
                    int cedula = rs2.getInt("cedula_usuario");
                    int telefono = rs2.getInt("telefono_usuario");
                    String direccion = rs2.getString("direccion_usuario");
                    int sexo = rs2.getInt("sexo_usuario");
                    int anio = rs2.getInt("anio_usuario");
                    String nacionalidad = rs2.getString("nacionalidad_usuario");
                    String email = rs2.getString("email_usuario");

                    r = id + "#" + nombre + "#" + apellidos + "#" + cedula + "#" + telefono + "#" + direccion + "#" + sexo + "#" + anio + "#" + nacionalidad + "#" + email;
                } else {

                    r = "false#credenciales";
                }

                con.CerrarConeccion();
                return r;
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
                return "false#catch";
            }

        } else {
            return "false#coneccionnull";
        }
    }

    public String EditUser(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String[] p = prompt.split("#");
                Statement stm = c.createStatement();
                String sql = "update usuario set nombre_usuario= '" + p[1] + "',apellidos_usuario= '" + p[2] + "', telefono_usuario= " + p[3] + ", direccion_usuario='" + p[4] + "' where id_usuario= " + p[0] + "";
                stm.executeUpdate(sql);
                con.CerrarConeccion();
                return "true";
            } catch (SQLException e) {
                System.out.println(" error catch editar usuario " + e.getMessage());
                con.CerrarConeccion();
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String GetInventory() {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String r = "";
                Statement stm = c.createStatement();
                String sql = "select * from inventario";
                ResultSet rs = stm.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id_vehiculo");
                    int tipo = rs.getInt("tipo_vehiculo");
                    String marca = rs.getString("marca_vehiculo");
                    int anio = rs.getInt("anio_vehiculo");
                    String modelo = rs.getString("modelo_vehiculo");
                    double precio = rs.getDouble("precio_vehiculo");
                    boolean disponible = rs.getBoolean("disponible_vehiculo");

                    if (disponible) {
                        r = r + id + "#" + tipo + "#" + marca + "#" + anio + "#" + modelo + "#" + precio + "##";
                    }

                }

                if (r.equals("")) {
                    r = "false";
                }
                con.CerrarConeccion();
                return r;
            } catch (SQLException e) {
                System.out.println("error catch get inventory");
                con.CerrarConeccion();
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String BuyVehicle(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String[] p = prompt.split("#");
                System.out.println(p.length);
                String sql = "insert into compra(estado_compra,usuario_id_usuario, vehiculo_id_vehiculo) values(1," + p[0] + "," + p[1] + ")";
                Statement stm = c.createStatement();

                stm.execute(sql);

                return "true";
            } catch (SQLException e) {
                System.out.println("error comprar vehiculo catch");
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String GetUserPurchases(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String r = "";
                Statement stm = c.createStatement();
                String sql = "select * from compra";
                ResultSet rs = stm.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id_compra");
                    int estado = rs.getInt("estado_compra");
                    int usuario = rs.getInt("usuario_id_usuario");
                    int vehiculo = rs.getInt("vehiculo_id_vehiculo");

                    if (usuario == Integer.parseInt(prompt)) {
                        r = r + id + "#" + estado + "#" + usuario + "#" + vehiculo + "##";
                    }

                }

                if (r.equals("")) {
                    r = "false";
                }
                con.CerrarConeccion();
                return r;
            } catch (SQLException e) {
                System.out.println("Error catch user purchase get " + e.getMessage());
                con.CerrarConeccion();
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String GetPurchases() {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String r = "";
                Statement stm = c.createStatement();
                String sql = "select * from compra";
                ResultSet rs = stm.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id_compra");
                    int estado = rs.getInt("estado_compra");
                    int usuario = rs.getInt("usuario_id_usuario");
                    int vehiculo = rs.getInt("vehiculo_id_vehiculo");

                    r = r + id + "#" + estado + "#" + usuario + "#" + vehiculo + "##";
                }
                if (r.equals("")) {
                    r = "false";
                }
                con.CerrarConeccion();
                return r;

            } catch (SQLException e) {
                System.out.println("Error catch user purchase get " + e.getMessage());
                con.CerrarConeccion();
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String GetUserInfo() {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String r = "";
                Statement stm = c.createStatement();
                String sql = "select * from usuario";
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id_usuario");
                    String nombre = rs.getString("nombre_usuario");
                    String apellidos = rs.getString("apellidos_usuario");
                    int cedula = rs.getInt("cedula_usuario");
                    int telefono = rs.getInt("telefono_usuario");
                    String direccion = rs.getString("direccion_usuario");
                    int sexo = rs.getInt("sexo_usuario");
                    int anio = rs.getInt("anio_usuario");
                    String nacionalidad = rs.getString("nacionalidad_usuario");
                    String email = rs.getString("email_usuario");

                    r = r + id + "#" + nombre + "#" + apellidos + "#" + cedula + "#" + telefono + "#" + direccion + "#" + sexo + "#" + anio + "#" + nacionalidad + "#" + email + "##";
                }

                if (r.equals("")) {
                    r = "false";
                }
                con.CerrarConeccion();
                return r;
            } catch (SQLException e) {
                System.out.println("Error catch getUserInfo");
                con.CerrarConeccion();
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String EditPurchase(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String[] p = prompt.split("#");
                Statement stm = c.createStatement();
                String sql = "update compra set estado_compra= " + p[1] + " where id_compra= " + p[0] + "";
                stm.executeUpdate(sql);

                con.CerrarConeccion();
                return "true";

            } catch (SQLException e) {
                System.out.println("Error editar compra catch " + e.getMessage());
                con.CerrarConeccion();
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String AddVehicle(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String[] p = prompt.split("#");
                Statement stm = c.createStatement();
                String sql = "insert into inventario(tipo_vehiculo, marca_vehiculo, anio_vehiculo, modelo_vehiculo, precio_vehiculo,disponible_vehiculo) values('" + p[0] + "','" + p[1] + "'," + p[2] + ",'" + p[3] + "'," + p[4] + ",true)";
                stm.execute(sql);
                con.CerrarConeccion();
                return "true";
            } catch (SQLException e) {
                System.out.println("error catch anadir vehiculo " + e.getMessage());
                con.CerrarConeccion();
                return "false";
            }

        } else {
            System.out.println("error no conexion");
            return "False";
        }

    }

    public String DeleteVehicle(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                Statement stm = c.createStatement();
                String sql = "update inventario set disponible_vehiculo=false where id_vehiculo=" + prompt + "";
                stm.executeUpdate(sql);
                con.CerrarConeccion();
                return "true";
            } catch (SQLException e) {
                System.out.println("Editar vehiculo catch " + e.getMessage());
                con.CerrarConeccion();
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String EditVehicle(String prompt) {
        Connection c = con.Conectar();
        if (c != null) {
            try {
                String[] p = prompt.split("#");
                Statement stm = c.createStatement();
                String sql = "update inventario set marca_vehiculo='" + p[1] + "',anio_vehiculo=" + p[2] + ",modelo_vehiculo='" + p[3] + "',precio_vehiculo=" + p[4] + " where id_vehiculo =" + p[0] + "";
                stm.executeUpdate(sql);
                con.CerrarConeccion();
                return "true";
            } catch (SQLException e) {
                System.out.println("error editar vehiculo catch " + e.getMessage());
                con.CerrarConeccion();
                return "false";
            }
        } else {
            return "false";
        }
    }
}
