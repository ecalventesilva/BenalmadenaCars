
package clases;

/**
 *
 * @author EDUARDO
 */
public class Persona {
    
    private String nombre;
    private String apellidos;
    private String dni;
    private int licencia;

    public Persona(String nombre, String apellidos, String dni, int licencia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.licencia = licencia;
        
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

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
