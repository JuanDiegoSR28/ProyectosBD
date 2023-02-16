/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan Diego Sánchez Rentería
 * ID: 00000233013
 */
public class ConexionBD 
{
    private final String cadenaConexion;
    private final String usuario;
    private final String password;

    public ConexionBD(String cadenaConexion, String usuario, String password) 
    {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.password = password;
    }
    
    
    public Connection crearConexion() throws SQLException
    {
        Connection conexion = 
                DriverManager.getConnection(cadenaConexion, usuario, password);
        return conexion;
    }
    
}
