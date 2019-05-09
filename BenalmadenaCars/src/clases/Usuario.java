
package clases;

import exceptions.DniInvalidoException;

/**
 *
 * @author EDUARDO
 */
public class Usuario extends Persona{
     private String password;

    public Usuario(String nombre, String password, String dni, int licencia) throws DniInvalidoException {
        super(nombre, password, dni, licencia);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    
}
