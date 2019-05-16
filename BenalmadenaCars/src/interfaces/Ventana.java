package interfaces;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clases.Usuario;

public class Ventana extends JFrame{
	private PantallaInicio pantallaInicio;
	private Login pantallaLogin;
	private Principal principal;
	private Usuario usuario; 
	private RegistroUsuario pantallaRegistro;
	private DeleteUser deleteUser;
	public Connection connection;
	private Ventana ventana;
	private Coches coches;
	private RegistroCoche registroCoche;
	private DeleteCar deleteCar;
	
public Ventana() {
		super();
		pantallaInicio=new PantallaInicio(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,300);
		setResizable(false);
		setVisible(true);
		setLocation(450,180);
		this.setContentPane(pantallaInicio);
		this.setTitle("Bienvenido");
		try {
			this.setIconImage(ImageIO.read(new File("imagenes/rent.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

public Connection getConnection() {
	return connection;
}


public void setConnection(Connection connection) {
	this.connection = connection;
}


public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public void cargaPantallaLogin() {
	if(this.pantallaLogin==null) {
		this.pantallaLogin=new Login(this);
	}
	this.setSize(350,350);
	this.pantallaInicio.setVisible(false);
	this.setContentPane(this.pantallaLogin);
	this.pantallaLogin.setVisible(true);
	this.setTitle("Login");
}
public void cargaPrincipal() {
	
	if(this.principal==null) {
		this.principal=new Principal(this);
	}
	this.setSize(450,300);
	this.pantallaLogin.setVisible(false);
	this.setContentPane(this.principal);
	this.principal.setVisible(true);
	this.setTitle("Principal");
	
	//this.principal.setVisible(true);
	
}
public void cargaPantallaInicio() {
	
	//this.setTitle("Pantalla Inicio");
	if(this.pantallaLogin!=null) {
		this.pantallaLogin.setVisible(false);
	}
	if(this.pantallaRegistro!=null) {
		this.pantallaRegistro.setVisible(false);
	}
	this.setSize(450,300);
	this.setContentPane(this.pantallaInicio);
	this.pantallaInicio.setVisible(true);
	this.setTitle("Bienvenido");
}
public void cargaPantallaRegistro() {
	if(this.pantallaRegistro==null) {
		this.pantallaRegistro=new RegistroUsuario(this);
	}
	this.pantallaInicio.setVisible(false);
	this.setSize(450,450);
	this.setContentPane(this.pantallaRegistro);
	this.pantallaRegistro.setVisible(true);
	this.setTitle("Registro");
}
public void cargaDeleteUser() {
	if(this.deleteUser==null) {
		this.deleteUser=new DeleteUser(this);
	}
	this.pantallaInicio.setVisible(false);
	this.setSize(450,300);
	this.setContentPane(this.deleteUser);
	this.deleteUser.setVisible(true);
	this.setTitle("Eliminar Usuario");
}
public Usuario conectarBd() {
	
	try {
		setConnection(DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/benalmadenacars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", ""));
	} catch(SQLNonTransientConnectionException ex) {
		//this.dialogoError("Demasiadas conexiones sin cerrar","Hay demasiados usuarios conectados en este momento, por favor, inténtalo de nuevo más tarde");
	}catch (SQLException ex) {
		JOptionPane.showMessageDialog(ventana, "La conexion a bd ha fallado","",JOptionPane.ERROR_MESSAGE);        
	            ex.printStackTrace();
	}
	
	return usuario;
	
}
public void cargaCoches() {
	if(this.coches==null) {
		this.coches=new Coches(this);
	}
	this.principal.setVisible(false);
	this.setSize(550,580);
	this.setContentPane(this.coches);
	this.coches.setVisible(true);
	this.setTitle("Coches");
}

public void cargaRegistroCoche() {
	if(this.registroCoche==null) {
		this.registroCoche=new RegistroCoche(this);
	}
	this.coches.setVisible(false);
	this.setSize(450,530);
	this.setContentPane(this.registroCoche);
	this.registroCoche.setVisible(true);
	this.setTitle("Registar Coche");
}


public void cargaDeleteCar() {
	if(this.deleteCar==null) {
		this.deleteCar=new DeleteCar(this);
	
}
	this.coches.setVisible(false);
	this.setSize(450,350);
	this.setContentPane(this.deleteCar);
	this.deleteCar.setVisible(true);
	this.setTitle("Eliminar Coche");
	
}
}
