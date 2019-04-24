
package clases;

/**
 *
 * @author EDUARDO
 */
public class Usuario extends Persona{
     private String password;

    public Usuario(String nombre, String apellidos, String dni, int licencia) {
        super(nombre, apellidos, dni, licencia);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    
}
