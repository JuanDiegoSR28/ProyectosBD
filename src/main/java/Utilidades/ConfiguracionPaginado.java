
package Utilidades;

/**
 *
 * @author Juan Diego Sánchez Rentería 
 * ID: 00000233013
 */
public class ConfiguracionPaginado 
{
    private int numeroPagina;
    private int elementosPorPagina;

    public ConfiguracionPaginado(int numeroPagina, int elementosPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.elementosPorPagina = 5;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }
    
    public int getElementosASaltar(){
        return this.numeroPagina * this.elementosPorPagina;
    }
    
    public void avanzarPagina(){
        this.numeroPagina++;
    }
    
    public void retrocederPagina(){
        if(this.numeroPagina>0)
            this.numeroPagina--;
    }
}
