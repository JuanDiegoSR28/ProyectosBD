/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencias;

/**
 *
 * @author Juan Diego Sánchez Rentería 
 * ID: 00000233013
 */
public class PersistenciaException extends Exception {

    /**
     * Método constructor
     */
    public PersistenciaException() {
    }

    /**
     * Método constructor con mensaje
     * @param message mensaje a enviar
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Método constructor con mensaje y causa
     * @param message mensaje a enviar
     * @param cause Causa del error
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Método constructor con causa
     * @param cause Causa del error
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Método constructor con todas las especificaciones
     * @param message Mensaje de salida
     * @param cause Causa del error
     * @param enableSuppression Habilirat supresión
     * @param writableStackTrace Seguir la escritura
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
