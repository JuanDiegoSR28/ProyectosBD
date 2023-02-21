/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

/**
 *
 * @author JDSan
 */
public class CuentaCliente 
{
    private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String calle;
    private String colonia;
    private String numCasa;
    private String fecha;
    private Integer idCuenta;
    private String fechaApertura; 
    private float saldo;
    private String pin;

    public CuentaCliente(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String calle, String colonia, String numCasa, String fecha, Integer idCuenta, String fechaApertura, float saldo, String pin) {
        
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.calle = calle;
        this.colonia = colonia;
        this.numCasa = numCasa;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.pin = pin;
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
 * Método para conseguir el pin de la cuenta
 * @return Pin de la cuenta
 */
    public String getPin() {
        return pin;
    }
/**
 * Método para poner el pin de la cuenta
 * @param pin Pin de la cuenta a cambiar
 */
    public void setPin(String pin) {
        this.pin = pin;
    }
    
    
/**
 *  Método para conseguir el ID de la cuenta
 * @return ID de la cuenta
 */
    public Integer getIdCuenta() {
        return idCuenta;
    }
/**
 * Método para poner el id de la cuenta
 * @param id ID de la cuenta a cambiar
 */
    public void setId(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    /**
     * Método para conseguir la fecha de apertura de la cuenta
     * @return Fecha apertura de la cuenta
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Método para poner la fecha de apertura de la cuenta
     * @param fechaApertura Fecha a cambiar
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Método para conseguir el saldo de la cuenta
     * @return Saldo de la cuenta
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Método para poner el saldo de la cuenta
     * @param saldo Saldo a cambiar
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }


    /**
     * Método para poner el id del cliente
     * @param idCliente ID a poner
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    
    
    
    
}
