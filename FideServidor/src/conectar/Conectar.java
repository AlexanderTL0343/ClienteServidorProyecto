
package conectar;

import java.sql.*;

public class Conectar {
    protected String nombreBase = "fideservidordb";
    protected String url = "jdbc:mysql://localhost:3306/"+nombreBase;
    protected String user ="root";
    protected String pass = "root";
    protected String driver = "com.mysql.jdbc.Driver";
            
    protected Connection enlace = null;
    
    public Connection Conectar(){
        try {
            Class.forName(driver);
            enlace = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado correctamente");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de coneccion");
        }
        
        
        return enlace;
    }
    
    public void CerrarConeccion(){
        try {
            enlace.close();
            System.out.println("Enlace cerrado");
        } catch (SQLException e) {
            System.out.println("error "+e.getMessage());
        }
    }
}
