package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaInicio extends JPanel{

	private Ventana ventana;
	private Login login;
	
	public PantallaInicio(Ventana v) {
		super();
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		JLabel lblBenalmdenaCarsSl = new JLabel("BENALM\u00C1DENA CARS SL");
		lblBenalmdenaCarsSl.setBackground(new Color(240, 240, 240));
		lblBenalmdenaCarsSl.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblBenalmdenaCarsSl.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenalmdenaCarsSl.setBounds(65, 11, 225, 48);
		add(lblBenalmdenaCarsSl);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaPantallaLogin();
				
			}
		});
		btnLogin.setBounds(125, 147, 112, 23);
		add(btnLogin);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaPantallaRegistro();
			}
		});
		btnRegistro.setBounds(125, 209, 112, 23);
		add(btnRegistro);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema");
		lblBienvenidoAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoAlSistema.setBounds(105, 70, 144, 28);
		add(lblBienvenidoAlSistema);
		ventana=v;
}	
}
