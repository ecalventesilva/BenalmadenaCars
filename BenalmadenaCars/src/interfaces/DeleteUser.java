package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import benalmadenacars.BenalmadenaCars;
import clases.Usuario;
import exceptions.DniInvalidoException;
import exceptions.LicenciaInvalidaException;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Ventana DeleteUser: pantalla que nos permite eliminar un usuario que haya sido registrado anteriormente en el sistema y borrarlo de la base de datos
 * @author Eduardo
 *
 */
public class DeleteUser extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	private JPasswordField campoPassword2;
	private Connection conec;
	
	public DeleteUser(Ventana v) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(113, 11, 225, 48);
		add(label);
		
		JLabel lblEliminarUsuario = new JLabel("Eliminar Usuario");
		lblEliminarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarUsuario.setBounds(143, 70, 158, 14);
		add(lblEliminarUsuario);
		
		JLabel textUsuario = new JLabel("Usuario");
		textUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		textUsuario.setBounds(64, 129, 75, 14);
		add(textUsuario);
		
		JLabel textPassword = new JLabel("Contrase\u00F1a");
		textPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		textPassword.setBounds(64, 154, 75, 14);
		add(textPassword);
		
		JLabel textPassword2 = new JLabel("Confirma Contrase\u00F1a");
		textPassword2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textPassword2.setBounds(64, 179, 144, 14);
		add(textPassword2);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(215, 127, 158, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoPassword = new JPasswordField();
		campoPassword.setBounds(215, 152, 158, 20);
		add(campoPassword);
		
		campoPassword2 = new JPasswordField();
		campoPassword2.setBounds(215, 177, 158, 20);
		add(campoPassword2);
		
		/**
		 * Boton eliminar: al rellenar todos los campos correctamente y hacer click, el sistema borra al usuario 
		 */
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.conectarBd();
				try {
					String username=campoUsuario.getText();
		            String password=String.copyValueOf(campoPassword.getPassword());
		            String password2=String.copyValueOf(campoPassword2.getPassword());
		            PreparedStatement loginStatement
                    = ventana.getConnection().prepareStatement(
                            "select * from usuario where nombre='"+username+"' "
                            + "and password ='"+password+"' ");
			            ResultSet foundUser = loginStatement.executeQuery();
			           if(foundUser.next()) {
			        	   try {
			        		   Usuario nombre=new Usuario(foundUser.getString("nombre"),foundUser.getString("password"),foundUser.getString("dni"),foundUser.getInt("licencia"));
			        		   
					            	
					            		if(password.equals(foundUser.getString("password"))) {
				
							                Statement deleteStatement = ventana.getConnection().createStatement();
							                deleteStatement.executeUpdate(
							                        "delete from usuario where nombre=('" + username +"') and password=('" + password + "');");
							                deleteStatement.close();
							                JOptionPane.showMessageDialog(ventana, "�Usuario eliminado con �xito!","User Delete",JOptionPane.INFORMATION_MESSAGE);
							                
							                ventana.cargaPantallaInicio();

					            
							} }catch (DniInvalidoException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (LicenciaInvalidaException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			           } else {
			        	   
			        		/**
			        		 * Comprobacion de la contrase�a con un if, en el cual se ha de introudcir la contrase�a correctamente 2 veces   
			        		 */
			        		   
			        	   if(!password.equals("")&&!password2.equals("")&&!username.equals("")) {
			        		   if (password.equals(password2)) {
			        			   JOptionPane.showMessageDialog(ventana, "Usuario o contrase�a incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
				        	   }else {
				        		   JOptionPane.showMessageDialog(ventana, "Error: las contrase�as introducidas no coinciden","ERROR",JOptionPane.ERROR_MESSAGE);
			        		   
			        		   
			        	   } }else { 
			        		   JOptionPane.showMessageDialog(ventana, "Por favor, rellene todos los campos para eliminar usuario","",JOptionPane.ERROR_MESSAGE);
			        	   
			           }
			        	   }
		           
		            campoUsuario.setText("");
		            campoPassword.setText("");
		            campoPassword2.setText("");
		            
				 } catch (Exception e) {
					 e.getStackTrace();
				 } 
			}
		});
		
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBorder(new LineBorder(new Color(255, 0, 0)));
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(284, 238, 104, 23);
		add(btnEliminar);
		
		/**
		 * Boton cancelar: el sistema nos lleva a la ventana anterior: Pantalla Inicio
		 */
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaInicio();
			}
		});
		btnCancelar.setBounds(143, 238, 114, 23);
		add(btnCancelar);

		
		
	}
}
	


