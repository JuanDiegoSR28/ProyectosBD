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

    /**
     * Constructor de la clase para la conexión a la base de datos
     * @param cadenaConexion String con el conector para entrar a la BD
     * @param usuario Usuario con el que se ingresará
     * @param password Contraseña del usuario
     */
    public ConexionBD(String cadenaConexion, String usuario, String password) 
    {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.password = password;
    }
    
    
    /**
     * Método para crear la conexión directa con los datos recopilados
     * @return El conector
     * @throws SQLException De haber una falla con los datos
     */
    public Connection crearConexion() throws SQLException
    {
        Connection conexion = 
                DriverManager.getConnection(cadenaConexion, usuario, password);
        return conexion;
    }
    
}
