package benalmadenacars;

import clases.Usuario;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author EDUARDO
 */ 
public class BenalmadenaCars {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection connection=null;
        
        String menu="\n\nIntroduce un número para realizar una acción:"
                +"\n\t0 - Salir"
                +"\n\t1 - Registro nuevo usuario"
                +"\n\t2 - Accerder";
        int action=0;
        Usuario user=null;
        do{
            if(user!=null){
                    menu="\n\nHello, "+user.getNombre()+". Choose action by number:"
                +"\n\t0 - Salir";
                    if(user.getPokemon()==null){
                        menu+="\n\t1 - Registro nuevo usuario";
                    }else{
                        
                    }
            }
            System.out.println(menu);
            action=Integer.parseInt(sc.nextLine());
            switch(action){
                case 0:
                    System.out.println("¡Hasta Pronto!");
                    break;
                case 1:
                    //if user is still null, the user hasn't been registered nor logged in
                    if(user==null){
                        user=registarUsuario(sc,connection); //CREAR UNA FUNCIÓN "REGISTRAR USUARIO"
                    }else{
                        System.out.println("Registra el usuario");
                    }
                    break;
                case 2:
                    user=loginUsuario(sc,connection); //CREAR UNA FUNCIÓN "LOGIN USUARIO"
                 break;
                default:
                    System.err.println("Opción inválida");
                    break;
            }
        }while(action!=0);
        
    }
    
    public static Usuario registarUsuario(Scanner sc, Connection conec){
       
        
        return null;
    
    
    }
    
    public static Usuario loginUsuario(Scanner sc, Connection conec){
        
        System.out.println("Introduce tu nombre de usuario");
            String username=sc.nextLine();
            System.out.println("Introduce tu contraseña");
            String password=sc.nextLine();
        
        
        return null;
    
    
    }
    
}
