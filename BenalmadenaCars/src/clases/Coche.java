
package clases;

/**
 *
 * @author EDUARDO
 */


public class Coche {
	private String marca;
    private String modelo;
    private String matricula;
    private String color;
    private String tipo;
    private String motor;
    private String descripcion;
    private float precio_dia;
    

    public enum color{
        NEGRO,
        PLATA,
        BLANCO,
        ROJO,
        AZUL,
        MARRON

    }
    public enum motor{
    	GASOLINA,
    	DIESEL
    }
   
   
    public enum tipo{
        GRUPO_A,
        GRUPO_B,
        GRUPO_C,
        GRUPO_D,
        GRUPO_E,
        GRUPO_F,
        GRUPO_G,
        GRUPO_H
    
    }
    
}
