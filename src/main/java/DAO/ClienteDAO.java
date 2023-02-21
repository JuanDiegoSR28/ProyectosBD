/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Cliente;
import Conexion.ConexionBD;
import Conexion.Cuenta;
import Conexion.CuentaCliente;
import Persistencias.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 
import javax.swing.JOptionPane;
/**
 *
 * @author Juan Diego Sánchez Rentería 
 * ID: 00000233013
 */
public class ClienteDAO 
{
        
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    private final ConexionBD generadorConexiones;
    
    /**
     * Constructor de la clase
     * @param generadorConexiones Objeto de ConexionBD que nos permitirá tener interacción con dicha clase
     */
    public ClienteDAO(ConexionBD generadorConexiones)
    {
        this.generadorConexiones=generadorConexiones;
    }
    
    
    /**
     * Método para consultar un cliente en base a su ID
     * @param idCliente ID del cliente a consultar
     * @return Datos del cliente consultado
     */
    public Cliente consultar(Integer idCliente) {
        String codigoSQL = 
                "select *"
                + "from cliente where ID_CLIENTE= ? ";
        
        try(Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando= conexion.prepareStatement(codigoSQL);){
            
            comando.setInt(1, idCliente);
            ResultSet registro=  comando.executeQuery();
            // Se encontró el cliente..
            Cliente cliente = null;
            if(registro.next()){ 
                Integer id = registro.getInt("ID_CLIENTE");
                String nombre=registro.getString("NOMBRE");
                String apellidoP=registro.getString("APELLIDO_PATERNO");
                String apellidoM=registro.getString("APELLIDO_MATERNO");
                String calle=registro.getString("CALLE");
                String colonia=registro.getString("COLONIA");
                String numCasa=registro.getString("NUMERO_CASA");
                String fechaNacimiento=registro.getDate("FECHA_NACIMIENTO").toString();
                cliente=new Cliente(id,nombre,apellidoP,apellidoM,calle,colonia,numCasa,fechaNacimiento);
            }
            
            return cliente;
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }

    }

    /**
     * Método para consultar los datos de una cuenta en base a su ID
     * @param idCuenta ID de la cuenta
     * @param contra Contraseña de la cuenta
     * @return Cuenta con todos los datos
     */
    public Cuenta consultar(Integer idCuenta, int contra) {
        String codigoSQL = 
                "select * ,CONVERT(AES_DECRYPT(PIN,'AES')USING UTF8) AS CONTRA "
                + "from CUENTAS where ID_CUENTA= ? ";
        
        try(Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando= conexion.prepareStatement(codigoSQL);){
            
            comando.setInt(1, idCuenta);
            ResultSet registro=  comando.executeQuery();
            // Se encontró el cliente..
            Cuenta cuenta = null;
            if(registro.next())
            { 
                Integer id = registro.getInt("ID_CUENTA");
                String fechaApertura= registro.getDate("FECHA_APERTURA").toString();
                float saldo = registro.getFloat("SALDO");
                Integer idCliente = registro.getInt("ID_CLIENTES");
                String pin = registro.getString("CONTRA");
                cuenta = new Cuenta(id,fechaApertura,saldo,idCliente,pin);
                JOptionPane.showMessageDialog(null, "Usuario encontrado!");
            }
            
            return cuenta;
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return null;
        }

    }
    /**
     * Método para actualizar datods de un cliente
     * @param cliente Cliente al cual se le actualizarán los datos
     */
    public void actualizar(Cliente cliente) {
        String codigoSQL = 
                "UPDATE cliente SET NOMBRE = ?, "
                + "APELLIDO_PATERNO = ?, APELLIDO_MATERNO = ?, "
                + "CALLE = ?, COLONIA = ?, NUMERO_CASA = ?, FECHA_NACIMIENTO = ? "
                + "WHERE (ID_CLIENTE) = ?";
        
        try(Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando= conexion.prepareStatement(codigoSQL);){
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setString(4, cliente.getCalle());
            comando.setString(5, cliente.getColonia());
            comando.setString(6, cliente.getNumCasa());
            comando.setString(7, cliente.getFecha());
            comando.setInt(8, cliente.getIdCliente());
            comando.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario actualizado");
           
      
           
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
           
        }

    }

    
    /**
     * Método apra consultar por su ID la clase CuentaCliente
     * @param idCuenta ID de la cuenta
     * @return Objeto tipo cuentaCliente que recopila los datos de ambos
     */
    public CuentaCliente consultarPorId (Integer idCuenta) {
        String codigoSQL = 
                "select * ,"
                + "CONVERT(AES_DECRYPT(PIN,'AES')USING UTF8) AS CONTRA "
                + "from CUENTAS "
                + "INNER JOIN CLIENTE ON CUENTAS.ID_CLIENTES = CLIENTE.ID_CLIENTE "
                + "where ID_CUENTA = ? ";
        
        try(Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando= conexion.prepareStatement(codigoSQL);){
            

            comando.setInt(1, idCuenta);
            ResultSet registro =  comando.executeQuery();
            // Se encontró el cliente..
                CuentaCliente cuentaCliente = null;
        if(registro.next())
            { 
                Integer idCliente = registro.getInt("ID_CLIENTES");
                String nombre = registro.getString("NOMBRE");
                String apellidoP = registro.getString("APELLIDO_PATERNO");
                String apellidoM = registro.getString("APELLIDO_MATERNO");
                String calle=registro.getString("CALLE");
                String colonia=registro.getString("COLONIA");
                String numCasa=registro.getString("NUMERO_CASA");
                String fechaNacimiento=registro.getDate("FECHA_NACIMIENTO").toString();
                Integer idCuentaC = registro.getInt("ID_CUENTA");
                String fechaApertura= registro.getDate("FECHA_APERTURA").toString();
                float saldo = registro.getFloat("SALDO");
                String pin = registro.getString("CONTRA");                

                cuentaCliente = new CuentaCliente
                (idCliente,nombre,apellidoP,apellidoM,calle,colonia,numCasa,fechaNacimiento,idCuentaC,fechaApertura,saldo,pin);
 
            }
            
            return cuentaCliente;
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return null;
        }

    }

    /**
     * Método para hacer una transferencia
     * @param cantidad Cantidad que se transferirá 
     * @param idTransferencia ID de la cuenta que transferirá
     * @param idTransferido ID de la cuenta que será transferida
     * @return Un entero que ayudará a confirmar si la operación fue exitosa
     */
    public int transferencia (int cantidad, int idTransferencia, int idTransferido) {
        String codigoSQL = 
  
        
           "CALL TRANSACCION(200,4,5,@RESULTADO);"+" SELECT * FROM CUENTA WHERE ID_CUENTA = "+idTransferencia;
        
        try(Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando= conexion.prepareStatement(codigoSQL);){
            

            ResultSet registro =  comando.executeQuery();
            
            
            int resultado = 0;
            if(registro.next())
            {
                resultado = registro.getInt("RESU");
            }
            
            return resultado;
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return -1;
        }

    }

    /**
     * Método para insertar un cliente en la base de datos
     * @param cliente Cliente del cual se extraerán los datos
     * @throws PersistenciaException Se ejecutará en caso de haber datos erróneos
     */
    public void insertar(Cliente cliente) throws PersistenciaException{
        String codigoSQL = "INSERT INTO CLIENTE "
                    + "(NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, CALLE, COLONIA, NUMERO_CASA, FECHA_NACIMIENTO) "
                    + "values(?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);)
        {
            
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setString(4, cliente.getCalle());
            comando.setString(5, cliente.getColonia());
            comando.setString(6, cliente.getNumCasa());
            comando.setString(7, cliente.getFecha());
            
            comando.executeUpdate();
            
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            Integer llavePrimaria=0;
            if(llavesGeneradas.next())
            {
                int posicionLlavePrimaria = 1;
                llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
            }
            

            
        } catch(SQLException e)
        {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");
            
        }
    }
    
    
//    public Cliente eliminar(Integer id) throws PersistenciaException{
//        String codigoSQL = "delete from clientes where id_cliente = ?";
//        
//        try (Connection conexion = generadorConexiones.crearConexion();
//            PreparedStatement comando = conexion.prepareStatement(codigoSQL);){
//            
////            Cliente clienteBuscado = this.consultar(id);
//            comando.setInt(1, id);
//            int numeroClientesEliminados = comando.executeUpdate();
////            return numeroClientesEliminados > 0 ? clienteBuscado : null;
//            
//        } catch(SQLException e){
//            LOG.log(Level.SEVERE, e.getMessage());
//            return null;
//        }
//    }

    
//    public List<Cliente> consultar(ConfiguracionPaginado paginado) throws PersistenciaException {
//        String codigoSQL = "select id_cliente, nombre, apellido_paterno from clientes ";
//        List listaClientes = new  LinkedList<>();
//        
//        try(Connection conexion = generadorConexiones.crearConexion();
//            PreparedStatement comando= conexion.prepareStatement(codigoSQL);){
//            ResultSet registro=comando.executeQuery();
//            while(registro.next()){ 
//                Integer id = registro.getInt("id_cliente");
//                String nombre=registro.getString("nombre");
//                String apellidoP=registro.getString("apellido_paterno");
//                String apellidoM=registro.getString("apellido_materno");
//                Integer idDireccion=registro.getInt("id_direccion");
//                Cliente cliente=new Cliente(id ,nombre,apellidoP,apellidoM,idDireccion);
//                listaClientes.add(cliente);
//            }
//            return listaClientes;
//        } catch(SQLException e){
//            LOG.log(Level.SEVERE, e.getMessage());
//            throw new PersistenciaException("No fue posible consultar la lista de clientes");
//        }
//    }


      
    
    
    
}
