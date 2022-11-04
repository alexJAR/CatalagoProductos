
package com.softtek.example.tienda;

import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    
    
    private static Connection conexion;
    
    private static Conexion instancia;
    
    private static final String url = "jdbc:mysql://localhost/catalogo";
    private static final String username = "root";
    private static final String password = "root";
    
    private Conexion(){
        
    }
    
    
    public Connection conectar(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, username, password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
            return conexion;
            
        } catch (Exception e) {
            System.out.println("Error al conectar: "+e);
        }
        return conexion;
    }
    
    public void cerrarConexion() throws SQLException{
        try {
            
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se desconecto correctamente");
        } catch (Exception e) {
            System.out.println("Error: "+e);
            conexion.close();
        }finally{
            conexion.close();
        }
    }
    
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}
