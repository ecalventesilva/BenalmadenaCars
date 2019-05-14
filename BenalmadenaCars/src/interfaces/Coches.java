package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Coches extends JPanel{
	private Ventana ventana;
	
	public Coches(Ventana v) {
	super();
	this.ventana=v;
	setBackground(new Color(245, 245, 220));
	setLayout(null);
	
	JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
	label.setBounds(121, 11, 225, 48);
	add(label);
	
	JButton btnAtrs = new JButton("ATR\u00C1S");
	btnAtrs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAtrs.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			ventana.cargaPrincipal();
		}
	});
	btnAtrs.setBounds(401, 455, 89, 23);
	add(btnAtrs);
	
	JPanel panel = new JPanel();
	panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	panel.setBounds(29, 100, 290, 378);
	add(panel);
	
	JLabel lblListaDeCoches = new JLabel("LISTA DE COCHES");
	lblListaDeCoches.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	lblListaDeCoches.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaDeCoches.setBounds(29, 79, 290, 23);
	add(lblListaDeCoches);
	
	JButton btnRegisterNewCar = new JButton("REGISTER NEW CAR");
	btnRegisterNewCar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnRegisterNewCar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ventana.cargaRegistroCoche();
		}
	});
	btnRegisterNewCar.setBounds(329, 421, 161, 23);
	add(btnRegisterNewCar);

}	
}
