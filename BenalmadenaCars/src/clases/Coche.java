
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
    
/**
 * CONSTRUCTOR DE COCHE
 * @param marca STRING NOMBRE DE LA MARCA DEL COCHE
 * @param modelo STRING NOMBRE DEL MODELO DEL COCHE
 * @param matricula STRING Nº DE LA MATRICULA DEL COCHE
 * @param color STRING COLOR DEL COCHE
 * @param tipo STRING EL TIPO, SE REFIERE A LA CLASIFACIÓN QUE VA DESDE EL GRUPO A, HASTA EL GRUPO H
 * @param motor STRING MOTOR, SI ES GASOLINA O DIESEL
 * @param descripcion STRING PEQUEÑA DESCRIPCION DE LOS DATOS MAS RELEVANTES DEL VEHÍCULO
 * @param precio_dia FLOAT PRECIO ORIENTATIVO DEL COCHE POR DÍA DE ALQUILER
 */
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


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getMotor() {
		return motor;
	}


	public void setMotor(String motor) {
		this.motor = motor;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public float getPrecio_dia() {
		return precio_dia;
	}


	public void setPrecio_dia(float precio_dia) {
		this.precio_dia = precio_dia;
	}
    
}
