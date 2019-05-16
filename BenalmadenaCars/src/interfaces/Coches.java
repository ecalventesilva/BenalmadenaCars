package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import clases.Coche;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class Coches extends JPanel{
	private Ventana ventana;
	ArrayList<Coche> coches;
	
	public Coches(Ventana v) {
	super();
	coches=new ArrayList<Coche>();
	//crear statement 
	//executeQuery(Select * from coches
	//while(resultset.next){
		//coches.add(new Coche(los datos que vienen de base de datos)
	//}
	this.ventana=v;
	setBackground(new Color(245, 245, 220));
	setLayout(null);
	
	JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
	label.setBounds(164, 11, 225, 48);
	add(label);
	
	JButton btnAtrs = new JButton("ATR\u00C1S");
	btnAtrs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAtrs.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			ventana.cargaPrincipal();
		}
	});
	btnAtrs.setBounds(404, 519, 92, 23);
	add(btnAtrs);
	
	JPanel panel = new JPanel();
	panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	panel.setBounds(39, 100, 290, 442);
	add(panel);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
	/*for(int i=0;i<coches.size();i++) {
		new JButton a=
				panel.add(a);
		//Evento al boton a para que al pulsarlo te cargue el panel de descripción de un solo coche (Pasarle un objeto coche por constructor)
	}*/
	
	JButton btnNewButton_1 = new JButton("New button");
	btnNewButton_1.setMaximumSize(new Dimension(panel.getWidth(),40));
	panel.add(btnNewButton_1);
	
	JButton btnNewButton = new JButton("New button");
	btnNewButton.setSize(panel.getWidth(),40);
	panel.add(btnNewButton);
	
	JLabel lblListaDeCoches = new JLabel("LISTA DE COCHES");
	lblListaDeCoches.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	lblListaDeCoches.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaDeCoches.setBounds(39, 81, 290, 23);
	add(lblListaDeCoches);
	
	JButton btnRegisterNewCar = new JButton("REGISTER NEW CAR");
	btnRegisterNewCar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnRegisterNewCar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ventana.cargaRegistroCoche();
		}
	});
	btnRegisterNewCar.setBounds(367, 450, 161, 23);
	add(btnRegisterNewCar);
	
	JButton btnEliminarCoche = new JButton("ELIMINAR COCHE");
	btnEliminarCoche.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ventana.cargaDeleteCar();
		}
	});
	btnEliminarCoche.setBounds(367, 484, 161, 23);
	add(btnEliminarCoche);

}	
}
