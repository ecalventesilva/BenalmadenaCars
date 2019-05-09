package interfaces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import clases.Usuario;

public class Ventana extends JFrame{
	private PantallaInicio pantallaInicio;
	private Login pantallaLogin;
	private Principal principal;
	private Usuario usuario; 
	private Registro pantallaRegistro;
	

public Ventana() {
		super();
		pantallaInicio=new PantallaInicio(this);
		setSize(350,350);
		setResizable(false);
		setVisible(true);
		this.setContentPane(pantallaInicio);
		this.setTitle("Pantalla Inicio");
		try {
			this.setIconImage(ImageIO.read(new File("./rent.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
	this.pantallaInicio.setVisible(false);
	this.setContentPane(this.pantallaLogin);
	this.pantallaLogin.setVisible(true);
	this.setTitle("Login");
}
public void cargaPrincipal() {
	
	if(this.principal==null) {
		this.principal=new Principal(this);
	}
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
	this.setContentPane(this.pantallaInicio);
	this.pantallaInicio.setVisible(true);
	this.setTitle("Pantalla Inicio");
}
public void cargaPantallaRegistro() {
	if(this.pantallaRegistro==null) {
		this.pantallaRegistro=new Registro(this);
	}
	this.pantallaInicio.setVisible(false);
	this.setContentPane(this.pantallaRegistro);
	this.pantallaRegistro.setVisible(true);
	this.setTitle("Registro");
}


}
