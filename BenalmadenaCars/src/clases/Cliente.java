/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

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

    public Cliente(String nombre, String apellidos, int licencia, String dni) {
        super(nombre, apellidos, licencia, dni);
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
    
}
