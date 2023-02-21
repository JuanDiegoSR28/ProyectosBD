/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.util.Date;


/**
 *
 * @author Juan Diego Sánchez Rentería 
 * ID: 00000233013
 */
public class Cuenta 
{
    private Integer id;
    private String fechaApertura; 
    private float saldo;
    private Integer idCliente;
    private String pin;
    
    /**
     * Método constructor de la clase con todos los elementos
     * @param id ID de la clase
     * @param fechaApertura Fecha en la que se creó la cuenta
     * @param saldo Saldo que tiene la cuenta
     * @param idCliente ID del cliente perteneciente a la cuenta
     * @param pin Clave con la que el cliente ingresará a su cuenta
     */    
    public Cuenta(Integer id, String fechaApertura, float saldo, Integer idCliente, String pin) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
        this.pin=pin;
    }
    
    /**
     * Método constructor de la clase sin el ID
     * @param fechaApertura Fecha en la que se creó la cuenta
     * @param saldo Saldo que tiene la cuenta
     * @param idCliente ID del cliente perteneciente a la cuenta
     * @param pin Clave con la que el cliente ingresará a su cuenta
     */
    public Cuenta(String fechaApertura, float saldo, Integer idCliente,String pin) {
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
        this.pin = pin;
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
    public Integer getId() {
        return id;
    }
/**
 * Método para poner el id de la cuenta
 * @param id ID de la cuenta a cambiar
 */
    public void setId(Integer id) {
        this.id = id;
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
     * Método para conseguir el ID del cliente 
     * @return ID del cliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Método para poner el id del cliente
     * @param idCliente ID a poner
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
