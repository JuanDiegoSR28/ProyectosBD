/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Conexion.ConexionBD;
import DAO.ClienteDAO;
import Interfaz.Inicio;
import Persistencias.PersistenciaException;

/**
 *
 * @author JDSan
 */
public class Main {

    /**
     * Método principal del proyectos
     * @param args Argumentos necesarios para establecer la clase
     * @throws PersistenciaException Error derivado de las clases usadas
     */
    public static void main(String[] args) throws PersistenciaException
    {
        String cadenaConexion = "jdbc:mysql://127.0.0.1/proyecto1_banco";
        //Poner constraseña necesaria
        ConexionBD generadorConexion = new ConexionBD(cadenaConexion,"root","");
        
        Inicio inicio = new Inicio(generadorConexion);
        inicio.setVisible(true);
        
    }
    
}
