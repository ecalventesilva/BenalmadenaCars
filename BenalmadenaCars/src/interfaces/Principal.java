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

public class Principal extends JPanel{
	private Ventana ventana;
	
	public Principal(Ventana v) {
		super();
		this.ventana=v;
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		setBackground(new Color(245, 245, 220));
		label.setBounds(105, 11, 225, 48);
		add(label);
		
		JButton btnCoches = new JButton("COCHES");
		btnCoches.setBorder(new LineBorder(Color.RED));
		btnCoches.setBounds(92, 99, 95, 48);
		add(btnCoches);
		
		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.setBorder(new LineBorder(Color.ORANGE));
		btnClientes.setBounds(252, 99, 95, 48);
		add(btnClientes);
		
		JButton btnParking = new JButton("PARKING");
		btnParking.setBorder(new LineBorder(new Color(139, 0, 0)));
		btnParking.setBounds(92, 184, 95, 48);
		add(btnParking);
		
		JButton btnAlquiler = new JButton("ALQUILER");
		btnAlquiler.setBorder(new LineBorder(Color.BLUE));
		btnAlquiler.setBounds(252, 184, 95, 48);
		add(btnAlquiler);
		
		Button button = new Button("SALIR");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaPantallaInicio();
			}
		});
		button.setBounds(370, 248, 70, 22);
		add(button);

}	
}
