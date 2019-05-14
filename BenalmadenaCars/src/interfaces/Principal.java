package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Principal extends JPanel{
	private Ventana ventana;
	
	public Principal(Ventana v) {
		super();
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.ventana=v;
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		setBackground(new Color(245, 245, 220));
		label.setBounds(105, 11, 225, 48);
		add(label);
		
		JButton btnCoches = new JButton("COCHES");
		btnCoches.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCoches.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaCoches();
			}
		});
		btnCoches.setBorder(new LineBorder(Color.RED));
		btnCoches.setBounds(92, 99, 95, 48);
		add(btnCoches);
		
		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setBorder(new LineBorder(Color.ORANGE));
		btnClientes.setBounds(252, 99, 95, 48);
		add(btnClientes);
		
		JButton btnParking = new JButton("PARKING");
		btnParking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnParking.setBorder(new LineBorder(new Color(139, 0, 0)));
		btnParking.setBounds(92, 184, 95, 48);
		add(btnParking);
		
		JButton btnAlquiler = new JButton("ALQUILER");
		btnAlquiler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlquiler.setBorder(new LineBorder(Color.BLUE));
		btnAlquiler.setBounds(252, 184, 95, 48);
		add(btnAlquiler);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaInicio();
			}
		});
		btnVolver.setBounds(351, 246, 89, 23);
		add(btnVolver);

}	
}
