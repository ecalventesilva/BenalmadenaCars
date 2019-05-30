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
import java.awt.Cursor;

public class PantallaAlquiler extends JPanel{
	private Ventana ventana;

	public PantallaAlquiler(Ventana v) {
		
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(147, 11, 245, 48);
		add(label);
		
		JButton btnAtrs = new JButton("ATR\u00C1S");
		btnAtrs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal();
			}
		});
		btnAtrs.setBounds(429, 515, 89, 23);
		add(btnAtrs);
		
		
	}
}
