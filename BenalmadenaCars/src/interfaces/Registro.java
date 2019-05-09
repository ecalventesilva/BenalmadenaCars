package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Cursor;

public class Registro extends JPanel{
	private Ventana ventana;
	private JTextField textUsuario;
	private JTextField textDni;
	private JTextField textLicencia;
	private JPasswordField textPassword;
	
	public Registro(Ventana v) {
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
		
		JLabel campoUsuario = new JLabel("Nombre Usuario");
		campoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoUsuario.setBounds(39, 158, 124, 23);
		add(campoUsuario);
		
		JLabel campoPassword = new JLabel("Contrase\u00F1a");
		campoPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoPassword.setBounds(39, 192, 124, 23);
		add(campoPassword);
		
		JLabel campoDni = new JLabel("DNI");
		campoDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoDni.setBounds(39, 231, 124, 23);
		add(campoDni);
		
		JLabel campoLicencia = new JLabel("Licencia");
		campoLicencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoLicencia.setBounds(39, 265, 124, 23);
		add(campoLicencia);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(171, 160, 209, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(171, 233, 209, 20);
		add(textDni);
		
		textLicencia = new JTextField();
		textLicencia.setColumns(10);
		textLicencia.setBounds(171, 267, 209, 20);
		add(textLicencia);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(171, 194, 209, 20);
		add(textPassword);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(256, 353, 124, 23);
		add(btnConfirmar);
		
}	
}
