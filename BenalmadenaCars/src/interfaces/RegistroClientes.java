package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroClientes extends JPanel{
	private Ventana ventana;

	public RegistroClientes(Ventana v) {
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
		
		JLabel lblRegistroNuevoCliente = new JLabel("Registro Nuevo Cliente");
		lblRegistroNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroNuevoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistroNuevoCliente.setBounds(143, 58, 158, 14);
		add(lblRegistroNuevoCliente);
		
		JButton button = new JButton("CANCELAR");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaClientes();
			}
		});
		button.setBounds(117, 266, 124, 23);
		add(button);
		
		JButton button_1 = new JButton("CONFIRMAR");
		button_1.setBounds(261, 266, 124, 23);
		add(button_1);
	}
}
