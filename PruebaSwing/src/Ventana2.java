import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Ventana2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Ventana2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("BENALMADENA CARS SL");
		label.setBounds(140, 11, 149, 23);
		contentPane.add(label);
		
		Button button = new Button("Guardar");
		button.setBounds(341, 229, 70, 22);
		contentPane.add(button);
		
		JLabel lblNombre = new JLabel("Nombre Usuario");
		lblNombre.setBounds(96, 94, 135, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setBounds(96, 119, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(96, 144, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblNLicencia = new JLabel("N\u00BA Licencia");
		lblNLicencia.setBounds(96, 169, 73, 14);
		contentPane.add(lblNLicencia);
		
		
		Label label_1 = new Label("Registro nuevo usuario");
		label_1.setBounds(140, 50, 135, 22);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(203, 91, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 119, 174, 20);
		contentPane.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 144, 174, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(203, 166, 174, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
