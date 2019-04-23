
package clases;

/**
 *
 * @author EDUARDO
 */
public class Persona {
    
    private String nombre;
    private String apellidos;
    private String licencia;
    private String dni;

    public Persona(String nombre, String apellidos, String licencia, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.licencia = licencia;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getLicencia() {
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

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
