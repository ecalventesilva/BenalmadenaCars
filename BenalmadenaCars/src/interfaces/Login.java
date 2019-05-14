package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

import benalmadenacars.BenalmadenaCars;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class Login extends JPanel{
	private Ventana ventana;
	private PantallaInicio inicio;
	private Login pantallaLogin;
	private Principal principal;
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	private Connection conec;
	
public Login(Ventana v) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(52, 11, 245, 48);
		add(label);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(33, 99, 92, 24);
		add(lblUsuario);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(33, 149, 92, 24);
		add(lblPassword);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(149, 101, 148, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoPassword = new JPasswordField();
		campoPassword.setBounds(149, 151, 148, 20);
		add(campoPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				ventana.conectarBd();
				try {
					String username=campoUsuario.getText();
		            String password=String.copyValueOf(campoPassword.getPassword());
		            PreparedStatement loginStatement
		                    = ventana.getConnection().prepareStatement(
		                            "select * from usuario where nombre=? "
		                            + "and password =? ");
		            loginStatement.setString(1, username);
                    loginStatement.setString(2, password);
		            ResultSet foundUser = loginStatement.executeQuery();

		            if (foundUser.next()) { //Usuario encontrado
		            	JOptionPane.showMessageDialog(ventana,""+username +", has sido conectado con el sistema. ¡Bienvenido!","Login Correcto",JOptionPane.INFORMATION_MESSAGE);
		            	ventana.cargaPrincipal();
		            } else {
		            	JOptionPane.showMessageDialog(ventana, "El usuario no se encuentra en la base de datos","",JOptionPane.ERROR_MESSAGE);
		            }
		            campoUsuario.setText("");
	            	campoPassword.setText("");

		        } catch (SQLException ex) {
		            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
		        
		        
		    }}
		});
		btnLogin.setBounds(182, 227, 108, 23);
		add(btnLogin);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaInicio();
				
			}
		});
		btnCancelar.setBounds(68, 227, 104, 23);
		add(btnCancelar);

}	


}
