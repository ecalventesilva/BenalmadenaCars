import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{
	private JTextField textField_1;
	private JPasswordField passwordField;
	
	public VentanaPrincipal() {
		setSize(new Dimension(300, 350));
		getContentPane().setForeground(Color.BLACK);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JButton Login = new JButton("Login");
		Login.setForeground(Color.BLACK);
		Login.setBounds(49, 200, 97, 23);
		getContentPane().add(Login);
		
		JButton newUser = new JButton("New User");
		newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana2 registerUser=new Ventana2();
				registerUser.setVisible(true);
				registerUser.setTitle("Benalmadena Cars");
				try {
					registerUser.setIconImage(ImageIO.read(new File("./rent.png")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		newUser.setBounds(159, 200, 89, 23);
		getContentPane().add(newUser);
		
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
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteUser deleteUser=new DeleteUser();
				deleteUser.setVisible(true);
				deleteUser.setTitle("Benalmadena Cars");
				try {
					deleteUser.setIconImage(ImageIO.read(new File("./rent.png")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnDeleteUser.setBounds(49, 238, 97, 23);
		getContentPane().add(btnDeleteUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 134, 86, 20);
		getContentPane().add(passwordField);
	}
}