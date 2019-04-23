package benalmadenacars;

import clases.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EDUARDO
 */
public class BenalmadenaCars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection connection = null;
      
     
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/benalmadenacars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        } catch (SQLException ex) {
            System.err.println("Imposible conectar");
            ex.printStackTrace();
            System.exit(0);
        }
        
        String menu = "\n\nIntroduce un número para realizar una acción:"
                + "\n\t0 - EXIT"
                + "\n\t1 - NEW USER"
                + "\n\t2 - LOGIN";
        int action = 0;
        Usuario user = null;
        do {

            System.out.println(menu);
            action = Integer.parseInt(sc.nextLine());
            switch (action) {
                case 0:
                    System.out.println("¡Hasta Pronto!");
                    break;
                case 1:                  
                    if (user == null) {
                        user = registarUsuario(sc, connection); //CREAR UNA FUNCIÓN "REGISTRAR USUARIO"
                    } else {
                        System.out.println("Registra el usuario");
                    }
                    break;
                case 2:
                    user = loginUsuario(sc, connection); //CREAR UNA FUNCIÓN "LOGIN USUARIO"
                    break;
                    
                default:
                    System.err.println("Opción inválida");
                    break;
            }
        } while (action != 0);

    }

    public static Usuario registarUsuario(Scanner sc, Connection conec) {
        System.out.println("Introduce un nombre de usuario:");
        String usuario= sc.nextLine();
        System.out.println("Introduce una contraseña:");
        String contraseña= sc.nextLine();
        System.out.println("Introduce tu número de licencia:");
        String licencia= sc.nextLine();
        System.out.println("Introduce tu DNI:");
        String dni= sc.nextLine();
        
        
        
        return null;

    }

    public static Usuario loginUsuario(Scanner sc, Connection conec) {

        try {
            System.out.println("Introduce tu nombre de usuario");
            String username = sc.nextLine();
            System.out.println("Introduce tu contraseña");
            String password = sc.nextLine();
            
            PreparedStatement loginStatement=
                    conec.prepareStatement(
                            "select * from usuario where nombre=? "
                                    + "and =? ");
            loginStatement.setString(1, username);
            loginStatement.setString(2, password);
            ResultSet foundUser=loginStatement.executeQuery();
            
            if(foundUser.next()){ //Usuario encontrado
                 System.out.println("Bienvenido al sistema");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
