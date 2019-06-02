
package exceptions;

/**
 *
 * @author EDUARDO
 */
/**
 * EXCEPCION DNI INVALIDO: EL DNI TIENE QUE TENER 9 CARACTERES
 * @author Eduardo
 *
 */
public class DniInvalidoException extends Exception {
    public DniInvalidoException(String msg){
    super(msg);
    
    }
    
}
