package interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaClientes extends JPanel{
	private Ventana ventana;
	
	public PantallaClientes(Ventana v) {
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
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClientes.setBounds(135, 63, 158, 14);
		add(lblClientes);
		
		JButton btnAtras = new JButton("ATR\u00C1S");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal();
			}
		});
		btnAtras.setBounds(282, 266, 158, 23);
		add(btnAtras);
		
		JButton btnNewButton = new JButton("NUEVO CLIENTE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaRegistroClientes();
			}
		});
		btnNewButton.setBounds(282, 231, 158, 23);
		add(btnNewButton);
		
		
	}
}
