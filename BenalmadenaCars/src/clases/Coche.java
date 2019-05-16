
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
    

    public Coche(String marca, String modelo, String matricula, String color, String tipo, String motor,
			String descripcion, float precio_dia) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.color = color;
		this.tipo = tipo;
		this.motor = motor;
		this.descripcion = descripcion;
		this.precio_dia = precio_dia;
	}


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
