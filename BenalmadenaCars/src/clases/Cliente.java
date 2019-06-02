/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import exceptions.DniInvalidoException;
import exceptions.LicenciaInvalidaException;

import java.time.LocalDate;

/**
 *
 * @author 1DAM
 */
public class Cliente extends Persona {
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private String direccionSpain;
    private String direccionResidencia;

    /**
     * CONSTRUCTOR CLIENTE 
     * @param nombre STRING NOMBRE DEL CLIENTE
     * @param apellidos STRING APELLIDOS DEL CLIENTE
     * @param dni STRING Nº DNI DEL CLIENTE
     * @param licencia INT Nº DE LICENCIA DEL CLIENTE
     * @throws DniInvalidoException EXCEPCION DNI, EL DNI TIENE QUE TENER 9 CARACTERES
     * @throws LicenciaInvalidaException EXCEPCION LICENCIA, LA LICENCIA TIENE QUE TENER 8 NUMEROS
     */
    public Cliente(String nombre, String apellidos, String dni, int licencia) throws DniInvalidoException, LicenciaInvalidaException {
        super(nombre, apellidos, dni, licencia);
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccionSpain() {
        return direccionSpain;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccionSpain(String direccionSpain) {
        this.direccionSpain = direccionSpain;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

	public Cliente(String nombre, String apellidos, String dni, int licencia, String nacionalidad,
			LocalDate fechaNacimiento, String direccionSpain, String direccionResidencia)
			throws DniInvalidoException, LicenciaInvalidaException {
		super(nombre, apellidos, dni, licencia);
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionSpain = direccionSpain;
		this.direccionResidencia = direccionResidencia;
	}
    
}
