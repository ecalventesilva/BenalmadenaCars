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

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				ventana.conectarBd();
				try {
					String username=campoUsuario.getText();
		            String password=String.copyValueOf(campoPassword.getPassword());
		            String password2=String.copyValueOf(campoPassword2.getPassword());
		     
		            if (password.equals(password2)) {
		            	if(!password.equals("")&&!password2.equals("")&&!username.equals("")) {
		                Statement deleteStatement = ventana.getConnection().createStatement();
		                deleteStatement.executeUpdate(
		                        "delete from usuario where nombre=('" + username + "');");
		                deleteStatement.close();
		                JOptionPane.showMessageDialog(ventana, "¡Usuario eliminado con éxito!","User Delete",JOptionPane.INFORMATION_MESSAGE);
		                
		                ventana.cargaPantallaInicio();
		                
		            	}else {
		            		JOptionPane.showMessageDialog(ventana, "Por favor, rellene todos los campos para eliminar usuario","",JOptionPane.ERROR_MESSAGE);
		            	}
		            	
		            	}else{
		            	JOptionPane.showMessageDialog(ventana, "Error: las contraseñas introducidas no coinciden","ERROR",JOptionPane.ERROR_MESSAGE);
		            }
		            campoUsuario.setText("");
		            campoPassword.setText("");
		            campoPassword2.setText("");
		            
				 }catch (SQLException ex) {
			            ex.printStackTrace();
				
				 }
				 
				}
		});
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBorder(new LineBorder(new Color(255, 0, 0)));
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(284, 238, 104, 23);
		add(btnEliminar);
		
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
