package benalmadenacars;

import exceptions.DniInvalidoException;
import exceptions.LicenciaInvalidaException;
import interfaces.Ventana;
import clases.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EDUARDO
 */
public class BenalmadenaCars {

    public static void main(String[] args) {
    	Ventana v=new Ventana();
    	v.setVisible(true);
    	Scanner sc = new Scanner(System.in);
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/benalmadenacars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        } catch (SQLException ex) {
            System.err.println("Imposible conectar");
            ex.printStackTrace();
            System.exit(0);
        }
        /**
         * Menu pantalla principal del programa
         */
        String menu = "\n\nIntroduce un numero para realizar una accion:"
                + "\n\t0 - EXIT"
                + "\n\t1 - NEW USER"
                + "\n\t2 - LOGIN"
                + "\n\t3 - ELIMINAR USUARIO";
        int action = 0;
        Usuario user = null;
        do {

            System.out.println(menu);
            action = Integer.parseInt(sc.nextLine());
            switch (action) {
                case 0:
                    System.out.println("�Hasta Pronto!");
                    break;
                case 1:
                    if (user == null) {
                        user = registarUsuario(sc, connection);
                    } else {
                        System.out.println("Registra el usuario");
                    }
                    break;
                case 2:
                    user = loginUsuario(sc, connection);
                    break;
                case 3:
                    user = eliminarUsuario(sc, connection);
                    break;
                default:
                    System.err.println("Opcion invalida!");
                    break;
            }
        } while (action != 0);

    }

    /**
     * Funcion resgistrarUsuario: sirve para registrar un usuario en la bd de
     * datos; el sistema solicita: nombre de usuario, password, dni, y numero
     * de licencia.
     *
     * @param sc
     * @param conec
     * @return
     */
    public static Usuario registarUsuario(Scanner sc, Connection conec) {
        try {
            System.out.println("Introduce un nombre de usuario:");
            String nombre = sc.nextLine();
            System.out.println("Introduce una password:");
            String password = sc.nextLine();
            System.out.println("Introduce tu DNI:");
            String dni = sc.nextLine();
            System.out.println("Introduce tu numero de licencia:");
            int licencia = Integer.parseInt(sc.nextLine());

            Usuario actual = new Usuario(nombre, password, dni, licencia);
            Statement registerStatement = conec.createStatement();
            registerStatement.executeUpdate(
                    "insert into usuario (nombre,password,dni,licencia"
                    + ") values('" + nombre + "',"
                    + "'" + password + "','" + dni
                    + "','" + licencia + "');");
            registerStatement.close();
            System.out.println("\n\tNuevo usuario creado con exito");
            return actual;

        } catch (SQLException ex) {
            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DniInvalidoException ex) {
            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (LicenciaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    /**
     * Función loginUsuario: funciu
     * on que sirve para acceder al sistema,
     * introduciendo correctamente usuario y contraseña.
     *
     * @param sc
     * @param conec
     * @return
     */
    public static Usuario loginUsuario(Scanner sc, Connection conec) {

        try {
            System.out.println("Introduce tu nombre de usuario");
            String nombre = sc.nextLine();
            System.out.println("Introduce tu password");
            String password = sc.nextLine();

            PreparedStatement loginStatement
                    = conec.prepareStatement(
                            "select * from usuario where nombre=? "
                            + "and password =? ");
            loginStatement.setString(1, nombre);
            loginStatement.setString(2, password);
            ResultSet foundUser = loginStatement.executeQuery();

            if (foundUser.next()) { //Usuario encontrado
                System.out.println("\n\t" + nombre + ", has sido conectado con el sistema. ¡Bienvenido!");
            } else {
                System.out.println("\n\tEl usuario '" + nombre + "' no se encuentra registrado en la Base de Datos.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Funcion elminarUsuario: elimina al introducir nombre y contraseña, el
     * usuario en la bd.
     *
     * @param sc
     * @param conec
     * @return
     */
    public static Usuario eliminarUsuario(Scanner sc, Connection conec) {

        try {
            System.out.println("Introduce tu nombre de usuario");
            String nombre = sc.nextLine();
            System.out.println("Introduce tu password");
            String password = sc.nextLine();
            System.out.println("Confirma tu password");
            String password2 = sc.nextLine();

            /**
             * Uso de un 'if' para confirmar que la password introducido es
             * correcto.
             */
            if (password.equals(password2)) {

                Statement registerStatement = conec.createStatement();
                registerStatement.executeUpdate(
                        "delete from usuario where nombre=('" + nombre + "');");
                registerStatement.close();
                System.out.println("\n\tUsuario eliminado con exito");
            }else{
                System.err.println("Error: las contraseñas introducidas no coinciden");
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

}
