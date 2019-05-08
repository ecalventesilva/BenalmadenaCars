package interfaces;

import javax.swing.JFrame;

import clases.Usuario;

public class Ventana extends JFrame{
	private PantallaInicio pantallaInicio;
	private Login pantallaLogin;
	private Principal principal;
	private Usuario usuario; 
	
	
	
public Ventana() {
		super();
		pantallaInicio=new PantallaInicio(this);
		setSize(350,350);
		setResizable(false);
		setVisible(true);
		this.setContentPane(pantallaInicio);
		this.setTitle("Pantalla Inicio");
		
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
	this.pantallaInicio.setVisible(false);
	this.setContentPane(this.principal);
	this.principal.setVisible(true);
	this.setTitle("Principal");
}
public void cargaPantallaInicio() {

	this.setTitle("Pantalla Inicio");
	if(this.pantallaLogin!=null) {
		this.pantallaLogin.setVisible(false);

	}
	

}}
