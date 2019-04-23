
package clases;

/**
 *
 * @author EDUARDO
 */
public class Usuario extends Persona{
     private String password;

    public Usuario(String nombre, String apellidos, String licencia, String dni) {
        super(nombre, apellidos, licencia, dni);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    
}
