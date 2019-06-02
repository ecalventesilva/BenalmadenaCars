package clases;

import java.time.LocalDate;

import exceptions.DniInvalidoException;

public class Alquiler {
	private String dniCliente;
	private String matricula;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	/**
	 * CONSTRUCTOR ALQUILER
	 * @param dniCliente STRING Nº DNI CLIENTE
	 * @param matricula STRING Nº MATRICULA COCHE
	 * @param fechaInicio LOCALDATE FECHA DE INICIO ALQUILER
	 * @param fechaFin LOCALDATE FECHA DE FIN ALQUILER
	 * @throws DniInvalidoException EXCEPCIÓN EL DNI DEBE DE CONTENER 9 CARACTERES
	 */
	public Alquiler(String dniCliente, String matricula, LocalDate fechaInicio, LocalDate fechaFin) throws DniInvalidoException {
		super();
		this.dniCliente = dniCliente;
		this.matricula = matricula;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

}
