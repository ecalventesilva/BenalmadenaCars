package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Principal extends JPanel{
	private Ventana ventana;
	
	public Principal(Ventana v) {
		super();
		this.ventana=v;
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(68, 11, 225, 48);
		add(label);

}}
