/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.util.Date;
import java.util.logging.Logger;


/**
 *
 * @author Juan Diego Sánchez Rentería 
 * ID: 00000233013
 */
public class Cliente 
{
    
    private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String calle;
    private String colonia;
    private String numCasa;
    private String fecha;

    /**
     * Método constructor de la clase con todos los elementos del objeto
     * @param idCliente id del cliente
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido Paterno del cliente
     * @param apellidoMaterno Apellido Materno del cliente
     * @param calle Calle del cliente
     * @param colonia Colonia del cliente
     * @param numCasa Número de casa del cliente
     * @param fecha Fecha de nacimiento del cliente
     */
    public Cliente(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String calle, String colonia, String numCasa, String fecha) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.calle = calle;
        this.colonia = colonia;
        this.numCasa = numCasa;
        this.fecha = fecha;
    }
    
    /**
     * Método constructor de la clase con todos los elementos del objeto, exceptuando el ID
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido Paterno del cliente
     * @param apellidoMaterno Apellido Materno del cliente
     * @param calle Calle del cliente
     * @param colonia Colonia del cliente
     * @param numCasa Número de casa del cliente
     * @param fecha Fecha de nacimiento del cliente
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String calle, String colonia, String numCasa, String fecha) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.calle = calle;
        this.colonia = colonia;
        this.numCasa = numCasa;
        this.fecha = fecha;
    }
       
    

    
    
    /**
     * Método para conseguir el ID del cliente 
     * @return id del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

 /**
  * Método para poner el id del cliente
  * @param idCliente ID del cliente
  */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    /**
     * Método para conseguir el nombre  del cliente 
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
    
/**
 * Método para poner el nombre del cliente
 * @param nombre Nombre del cliente
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método para conseguir el apellido paterno del cliente 
     * @return Apellid paterno del cliente
     */    
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    
/**
 * Método para poner el apellido paterno del cliente
 * @param apellidoPaterno Apellido Paterno del cliente
 */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    /**
     * Método para conseguir el apellido materno del cliente 
     * @return Apellid materno del cliente
     */ 
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

/**
 * Método para poner el apellido materno del cliente
 * @param apellidoMaterno Apellido materno del cliente
 */    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    /**
     * Método para conseguir la calle del cliente 
     * @return Calle del cliente
     */ 
    public String getCalle() {
        return calle;
    }
/**
 * Método para poner la calle del cliente
 * @param calle Calle del cliente
 */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    /**
     * Método para conseguir la colonia del cliente 
     * @return Colonia del cliente
     */ 
    public String getColonia() {
        return colonia;
    }
/**
 * Método para poner la colonia del cliente
 * @param colonia Colonia del cliente
 */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    /**
     * Método para conseguir el número de casa del cliente 
     * @return Número de casa del cliente
     */ 
    public String getNumCasa() {
        return numCasa;
    }
/**
 * Método para poner el número de casa del cliente
 * @param numCasa Calle del cliente
 */
    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }
    /**
     * Método para conseguir la fecha de nacimiento del cliente 
     * @return Fecha de nacimiento del cliente
     */ 
    public String getFecha() {
        return fecha;
    }
    
/**
 * Método para poner la fecha de nacimiento del cliente
 * @param fecha Fecha de nacimiento del cliente
 */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
}
