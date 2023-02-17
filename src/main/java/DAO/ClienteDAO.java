/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Cliente;
import Conexion.ConexionBD;
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

/**
 *
 * @author Juan Diego Sánchez Rentería 
 * ID: 00000233013
 */
public class ClienteDAO 
{
        
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    private final ConexionBD generadorConexiones;
    
    public ClienteDAO(ConexionBD generadorConexiones){
        this.generadorConexiones=generadorConexiones;
    }
    
    
    public Cliente consultar(Integer idCliente) {
        String codigoSQL = "select id_cliente, nombre, apellidoPaterno, apellidoMaterno from clientes where id_cliente= ?";
        
        try(Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando= conexion.prepareStatement(codigoSQL);){
            
            comando.setInt(1, idCliente);
            ResultSet registro=  comando.executeQuery();
            // Se encontró el cliente..
            Cliente cliente = null;
            if(registro.next()){ 
                Integer id = registro.getInt("id_cliente");
                String nombre=registro.getString("nombre");
                String apellidoP=registro.getString("apellidoPaterno");
                String apellidoM=registro.getString("apellidoMaterno");
                Integer idDireccion=registro.getInt("id_direccion");
                cliente=new Cliente(nombre,apellidoP,apellidoM,idDireccion);
            }
            
            return cliente;
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }

    }

    
    public Cliente insertar(Cliente cliente) throws PersistenciaException{
        String codigoSQL = "insert into clientes"
                    + "(nombre, apellidoPaterno, apellidoMaterno, direccion) "
                    + "values(?, ?, ?, ?)";
        
        try (Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);){
            
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setInt(4, cliente.getIdDireccion());
            
            comando.executeUpdate();
            
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if(llavesGeneradas.next()){
                int posicionLlavePrimaria = 1;
                Integer llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
                cliente.setId(llavePrimaria);
                return cliente;
            }
            
            throw new PersistenciaException("Cliente registrado, pero id no generado");
            
            
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");
        }
    }
    
    
    public Cliente eliminar(Integer id) throws PersistenciaException{
        String codigoSQL = "delete from clientes where id_cliente = ?";
        
        try (Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);){
            
            Cliente clienteBuscado = this.consultar(id);
            comando.setInt(1, id);
            int numeroClientesEliminados = comando.executeUpdate();
            return numeroClientesEliminados > 0 ? clienteBuscado : null;
            
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    
    public List<Cliente> consultar(ConfiguracionPaginado paginado) throws PersistenciaException {
        String codigoSQL = "select id_cliente, nombre, apellido_paterno from clientes ";
        List listaClientes = new  LinkedList<>();
        
        try(Connection conexion = generadorConexiones.crearConexion();
            PreparedStatement comando= conexion.prepareStatement(codigoSQL);){
            ResultSet registro=comando.executeQuery();
            while(registro.next()){ 
                Integer id = registro.getInt("id_cliente");
                String nombre=registro.getString("nombre");
                String apellidoP=registro.getString("apellido_paterno");
                String apellidoM=registro.getString("apellido_materno");
                Integer idDireccion=registro.getInt("id_direccion");
                Cliente cliente=new Cliente(id ,nombre,apellidoP,apellidoM,idDireccion);
                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch(SQLException e){
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }
    }

}
