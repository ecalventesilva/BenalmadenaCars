package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

import benalmadenacars.BenalmadenaCars;
import clases.Usuario;
import exceptions.DniInvalidoException;
import exceptions.LicenciaInvalidaException;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistroUsuario extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	private JTextField campoDni;
	private JTextField campoLicencia;
	private JPasswordField campoPassword;
	private Connection conec;
	
	public RegistroUsuario(Ventana v) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(112, 11, 225, 48);
		add(label);
		
		JButton btnCancelat = new JButton("CANCELAR");
		btnCancelat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaInicio();
			}
		});
		btnCancelat.setBounds(112, 353, 124, 23);
		add(btnCancelat);
		
		JLabel lblNewLabel = new JLabel("Registro Nuevo Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(139, 70, 158, 14);
		add(lblNewLabel);
		
		JLabel textUsuario = new JLabel("Nombre Usuario");
		textUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		textUsuario.setBounds(50, 141, 124, 23);
		add(textUsuario);
		
		JLabel textPassword = new JLabel("Contrase\u00F1a");
		textPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		textPassword.setBounds(50, 175, 124, 23);
		add(textPassword);
		
		JLabel textDni = new JLabel("DNI");
		textDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		textDni.setBounds(50, 209, 124, 23);
		add(textDni);
		
		JLabel textLicencia = new JLabel("Licencia");
		textLicencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		textLicencia.setBounds(50, 243, 124, 23);
		add(textLicencia);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(182, 143, 209, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoDni = new JTextField();
		campoDni.setColumns(10);
		campoDni.setBounds(182, 211, 209, 20);
		add(campoDni);
		
		campoLicencia = new JTextField();
		campoLicencia.setColumns(10);
		campoLicencia.setBounds(182, 245, 209, 20);
		add(campoLicencia);
		
		campoPassword = new JPasswordField();
		campoPassword.setBounds(182, 177, 209, 20);
		add(campoPassword);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.conectarBd();
				try {
		            String usuario=campoUsuario.getText();
		            String password=String.copyValueOf(campoPassword.getPassword());
		            String dni =campoDni.getText();
		            int licencia =Integer.parseInt(campoLicencia.getText());
		      
		            
		            Usuario actual = new Usuario(usuario, password, dni, licencia);
		            Statement registerStatement = ventana.getConnection().createStatement();
		            registerStatement.executeUpdate(
		                    "insert into usuario (nombre,password,dni,licencia"
		                    + ") values('" + usuario + "',"
		                    + "'" + password + "','" + dni
		                    + "','" + licencia + "');");
		            registerStatement.close();
		            JOptionPane.showMessageDialog(ventana, "El usuario: ''"+usuario+"'',"+" ha sido creado con exito","",JOptionPane.INFORMATION_MESSAGE);
		            ventana.cargaPantallaInicio();
		            
		            return;

				 } catch (SQLException ex) {
			            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
			            
				 } catch (DniInvalidoException ex) {
			            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
			            JOptionPane.showMessageDialog(ventana, "Has introducido un DNI erróneo","Error",JOptionPane.ERROR_MESSAGE);
			            ex.getMessage();
				 
			        } catch (LicenciaInvalidaException e) {
			        	JOptionPane.showMessageDialog(ventana, "Has introducido un número de licencia inválido","Error",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				
				ventana.cargaPantallaInicio();
	            campoUsuario.setText("");
	            campoPassword.setText("");
	            campoDni.setText("");
	            campoLicencia.setText("");
				
			    }
		});
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(256, 353, 124, 23);
		add(btnConfirmar);
		
}	
}
