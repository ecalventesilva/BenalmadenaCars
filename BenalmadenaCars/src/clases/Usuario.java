
package clases;

import exceptions.DniInvalidoException;
import exceptions.LicenciaInvalidaException;

/**
 *
 * @author EDUARDO
 */
public class Usuario extends Persona{
     private String password;
     /**
      * CONSTRUCTOR USUARIO
      * @param nombre STRING NOMBRE DE USUARIO
      * @param password STRING CONSTRASEÑA DEL USUARIO
      * @param dni STRING Nº DNI DEL USUARIO
      * @param licencia STRING Nº LICENCIA DEL USUARIO 
      * @throws DniInvalidoException EXCEPCION DNI, EL DNI TIENE QUE TENER 9 CARACTERES
      * @throws LicenciaInvalidaException EXCEPCION LICENCIA, LA LICENCIA TIENE QUE TENER 8 NUMEROS
      */
    public Usuario(String nombre, String password, String dni, int licencia) throws DniInvalidoException, LicenciaInvalidaException {
        super(nombre, password, dni, licencia);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    
}
