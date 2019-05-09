package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Login extends JPanel{
	private Ventana ventana;
	private PantallaInicio inicio;
	private Login pantallaLogin;
	private Principal principal;
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	
public Login(Ventana v) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(68, 11, 225, 48);
		add(label);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(51, 100, 92, 24);
		add(lblUsuario);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(51, 150, 92, 24);
		add(lblPassword);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(167, 102, 148, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoPassword = new JPasswordField();
		campoPassword.setBounds(167, 152, 148, 20);
		add(campoPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal();	
			}
		});
		btnLogin.setBounds(214, 226, 108, 23);
		add(btnLogin);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaInicio();
				
			}
		});
		btnCancelar.setBounds(100, 226, 104, 23);
		add(btnCancelar);

}	
}
