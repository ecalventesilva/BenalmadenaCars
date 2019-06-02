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

import clases.Cliente;
import clases.Coche;
import clases.Usuario;

public class Ventana extends JFrame{
	private PantallaInicio pantallaInicio;
	private Login pantallaLogin;
	private Principal principal;
	private Usuario usuario; 
	private RegistroUsuario pantallaRegistro;
	private DeleteUser deleteUser;
	private Connection connection;
	private Ventana ventana;
	private PantallaCoches coches;
	private CocheListado cocheListado;
	private RegistroCoche registroCoche;
	private InfoCar infoCar;
	private PantallaClientes pantallaClientes;
	private RegistroClientes registroClientes;
	private Coche coche;
	private PantallaAlquiler alquiler;
	private InfoCliente infoCliente;
/**
 * Función Ventana que carga la ventana principal del programa con la configuracion propia
 */
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
/**
 * Funcion que carga la Pantalla Login, donde el usuario se puede logear para entrar en el sistema
 */
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
/**
 * Funcion que carga la pantalla Principal del programa, donde se ve el menú principal: COCHES, CLIENTES, PARKING (NO DISPONIBLE POR EL MOMENTO) Y ALQUILER.
 */
public void cargaPrincipal() {
	
	if(this.principal==null) {
		this.principal=new Principal(this);
	}
	this.setSize(450,300);
	this.pantallaLogin.setVisible(false);
	this.setContentPane(this.principal);
	this.principal.setVisible(true);
	this.setTitle("Principal");
	
	
}
/**
 * Funcion que carga la pantallaIncio, la primera ventana del programa donde se encuentra el LOGIN, REGISTRAR USUARIO Y ELIMINAR USUARIO
 */
public void cargaPantallaInicio() {
	
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
/**
 *  Funcion que carga la pantallaRegistro, en la cual se puede registrar un nuevo usuario en el sistema
 */
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
/**
 *  Funcion que carga la pantalla eliminar Usuario (deleteUser) en la cual se puede eliminar un usuario de la base de datos
 */
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
/**
 * Funcion que sirve para conectar con la base de datos mysql. 
 * @return
 */
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
/**
 * Funcion que carga la pantalla coches donde se muestra una lista con los coches registrados previamente en la base de datos
 */
public void cargaCoches() {
	this.coches=new PantallaCoches(this);
	this.principal.setVisible(false);
	this.setSize(550,580);
	this.setLocation(450,50);
	this.setContentPane(this.coches);
	this.coches.setVisible(true);
	this.setTitle("Coches");
}
/**
 * Funcion que carga la pantalla Alquiler donde el usuario puede registrar una reserva e imprimirla en un txt.
 */
public void cargaPantallaAlquiler() {
	this.alquiler=new PantallaAlquiler(this);
	this.principal.setVisible(false);
	this.setSize(550,580);
	this.setLocation(450,50);
	this.setContentPane(this.alquiler);
	this.alquiler.setVisible(true);
	this.setTitle("Alquiler");
	
}
/**
 * Funcion que carga la pantalla Registro coche donde el usuario puede registrar un nuevo coche en la base de datos
 */
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

/**
 * Funcion que carga la pantalla InfoCar que nos muestra información sobre el coche seleccionado en la pantalla coches
 * @param c
 */
public void cargaInfoCar(Coche c) {
	this.infoCar=new InfoCar(this,c);

	if(this.coches!=null) {
		this.coches.setVisible(false);
	}
	this.coches.panel.setVisible(false); 
	this.setSize(450,350);
	this.setLocation(450,180);
	this.setContentPane(this.infoCar);
	this.infoCar.setVisible(true);
	this.setTitle("Información Coche");
	
}
/**
 * Funcion que carga la pantalla infoCliente que nos muestra información sobre el cliente seleccionado en la pantalla clientes
 * @param cl
 */
public void cargaInfoCliente(Cliente cl) {
	this.infoCliente=new InfoCliente(this,cl);

	if(this.pantallaClientes!=null) {
		this.pantallaClientes.setVisible(false);
	}
	this.pantallaClientes.panel1.setVisible(false); 
	this.setSize(450,350);
	this.setLocation(450,180);
	this.setContentPane(this.infoCliente);
	this.infoCliente.setVisible(true);
	this.setTitle("Información Cliente");
	
}
/**
 * Funcion que carga la pantalla clientes con la lista de clientes.
 */
public void cargaPantallaClientes() {
	this.pantallaClientes=new PantallaClientes(this);
	this.principal.setVisible(false);
	this.setSize(550,580);
	this.setLocation(450,50);
	this.setContentPane(this.pantallaClientes);
	this.pantallaClientes.setVisible(true);
	this.setTitle("Clientes");
}

/**
 * Funcion que carga la pantalla RegistroClientes donde el usuario puede registrar un nuevo cliente en la base de datos
 */
public void cargaPantallaRegistroClientes() {
	if(this.registroClientes==null) {
		this.registroClientes=new RegistroClientes(this);
	
}
	this.pantallaClientes.setVisible(false);
	this.setSize(450,530);
	this.setContentPane(this.registroClientes);
	this.registroClientes.setVisible(true);
	this.setTitle("Registar Cliente");
}}
