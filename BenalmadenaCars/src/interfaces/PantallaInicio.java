package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Point;

public class PantallaInicio extends JPanel{

	private Ventana ventana;
	private Login login;
	
	public PantallaInicio(Ventana v) {
		super();
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		JLabel lblBenalmdenaCarsSl = new JLabel("BENALM\u00C1DENA CARS SL");
		lblBenalmdenaCarsSl.setForeground(Color.BLACK);
		lblBenalmdenaCarsSl.setBackground(new Color(240, 240, 240));
		lblBenalmdenaCarsSl.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblBenalmdenaCarsSl.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenalmdenaCarsSl.setBounds(37, 11, 232, 55);
		add(lblBenalmdenaCarsSl);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaPantallaLogin();
				
			}
		});
		btnLogin.setBounds(24, 117, 144, 23);
		add(btnLogin);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaPantallaRegistro();
			}
		});
		btnRegistro.setBounds(24, 162, 144, 23);
		add(btnRegistro);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema");
		lblBienvenidoAlSistema.setForeground(Color.BLACK);
		lblBienvenidoAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoAlSistema.setBounds(24, 66, 144, 28);
		add(lblBienvenidoAlSistema);
		
		JButton btnEliminarUsuario = new JButton("ELIMINAR USUARIO");
		btnEliminarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaDeleteUser();
			}
		});
		btnEliminarUsuario.setBounds(24, 208, 144, 23);
		add(btnEliminarUsuario);
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(136, 25, 314, 251);
		ventana=v;
		imagen.setIcon(new ImageIcon("imagenes/corsa.png"));
		add(imagen);
		
}	
}
