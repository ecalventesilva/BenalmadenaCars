package interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
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
		JPanel panel;
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		setBackground(new Color(245, 245, 220));
		label.setBounds(105, 11, 225, 48);
		add(label);
		
		JLabel lblClientes = new JLabel("Lista Clientes");
		lblClientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClientes.setBounds(39, 85, 291, 14);
		add(lblClientes);
		
		JButton btnAtras = new JButton("ATR\u00C1S");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal();
			}
		});
		btnAtras.setBounds(282, 401, 158, 23);
		add(btnAtras);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(39, 100, 290, 242);
		add(panel);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton btnNuevoCliente = new JButton("NUEVO CLIENTE");
		btnNuevoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaRegistroClientes();
			}
		});
		btnNuevoCliente.setBounds(282, 367, 158, 23);
		add(btnNuevoCliente);
		
		
	}
}
