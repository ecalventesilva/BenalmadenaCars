package clases;

import exceptions.DniInvalidoException;
import exceptions.LicenciaInvalidaException;

/**
 *
 * @author EDUARDO
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private String dni;
    private int licencia;
    
    
    /**
     * CONSTRUCTOR PERSONA
     * @param nombre STRING NOMBRE DE LA PERSONA
     * @param apellidos STRING APELLIDOS DE LA PERSONA
     * @param dni STRING Nº DNI DE LA PERSONA
     * @param licencia INT Nº DE LICENCIA DE LA PERSONA
     * @throws DniInvalidoException EXCEPCION DNI, EL DNI TIENE QUE TENER 9 CARACTERES
     * @throws LicenciaInvalidaException EXCEPCION LICENCIA, LA LICENCIA TIENE QUE TENER 8 NUMEROS
     */
    public Persona(String nombre, String apellidos, String dni, int licencia) throws DniInvalidoException, LicenciaInvalidaException{
        this.nombre = nombre;
        this.apellidos = apellidos;
        setDni(dni);
        setLicencia(licencia);
        

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getLicencia() {
        return licencia;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setLicencia(int licencia) throws LicenciaInvalidaException{
    	if(String.valueOf(licencia).length()!=8) {
    		
    		throw new LicenciaInvalidaException("Licencia errónea");
    	}
        this.licencia = licencia;
    }

    public void setDni(String dni) throws DniInvalidoException {
        if (dni.length() != 9) {
            throw new DniInvalidoException("El DNI ha fallado!");
        }
        this.dni = dni;
    }

}
