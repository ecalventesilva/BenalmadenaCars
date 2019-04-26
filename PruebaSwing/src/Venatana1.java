import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class Venatana1 extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	
	public Venatana1() {
		setSize(new Dimension(300, 300));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JButton Login = new JButton("Login");
		Login.setForeground(Color.BLACK);
		Login.setBounds(49, 200, 89, 23);
		getContentPane().add(Login);
		
		JButton newUser = new JButton("New User");
		newUser.setBounds(148, 200, 89, 23);
		getContentPane().add(newUser);
		
		textField = new JTextField();
		textField.setBounds(98, 134, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 103, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 106, 46, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 137, 78, 14);
		getContentPane().add(lblContrasea);
		
		JLabel lblBenalmadenaCarsSl = new JLabel("BENALMADENA CARS SL");
		lblBenalmadenaCarsSl.setBounds(88, 37, 149, 23);
		getContentPane().add(lblBenalmadenaCarsSl);
	}
}
