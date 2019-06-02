package exceptions;

/**
 * EXCEPCION LICENCIA INVÁLIDA: LA LICENCIA TIENE QUE TENER 8 NUMEROS
 * @author Eduardo
 *
 */
public class LicenciaInvalidaException extends Exception{
	public LicenciaInvalidaException(String msg){
	    super(msg);
	    }

}
