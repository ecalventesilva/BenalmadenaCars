package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.border.LineBorder;


import clases.Coche;
import clases.Coche.color;
import clases.Coche.motor;
import clases.Coche.tipo;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class PantallaCoches extends JPanel{
	private Ventana ventana;
	private Statement s;
	public Connection c;
	JPanel panel;
	ArrayList<Coche> coches;
	
	public PantallaCoches(Ventana v) {
	super();
	try {
		c=DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/benalmadenacars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
	} catch(SQLNonTransientConnectionException ex) {
		//this.dialogoError("Demasiadas conexiones sin cerrar","Hay demasiados usuarios conectados en este momento, por favor, inténtalo de nuevo más tarde");
	} catch (SQLException ex) {
		JOptionPane.showMessageDialog(ventana, "La conexion a bd ha fallado","",JOptionPane.ERROR_MESSAGE);        
	            ex.printStackTrace();
	}
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
	
	panel = new JPanel();
	panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	panel.setBounds(39, 100, 290, 442);
	add(panel);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
		//if(Coches.)
	
	/*for(int i=0;i<coches.size();i++) {
		new JButton a=
				panel.add(a);
		//Evento al boton a para que al pulsarlo te cargue el panel de descripción de un solo coche (Pasarle un objeto coche por constructor)
	}*/
	
	
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
	btnEliminarCoche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnEliminarCoche.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setVisible(false);
			ventana.cargaInfoCar();
		}
	});
	btnEliminarCoche.setBounds(367, 484, 161, 23);
	add(btnEliminarCoche);
	
	panel.removeAll();
	coches=new ArrayList<Coche>();
	
		try {
			s=c.createStatement();
			ResultSet rst= s.executeQuery("select * from coches");
	
	
		while(rst.next()) {
			Coche car=new Coche(rst.getString("marca"),rst.getString("modelo"),rst.getString("matricula"),rst.getString("color"),
					rst.getString("tipo"),rst.getString("motor"),rst.getString("descripcion"),rst.getFloat("precio"));
			
			CocheListado cl=new CocheListado(car);
			panel.add(cl);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	panel.setVisible(false);
	panel.setVisible(true);

}	
	public void listaCoches() {
		panel.removeAll();
		coches=new ArrayList<Coche>();
		if(coches!=null) {	
		
			try {
				s=c.createStatement();
				ResultSet rst= s.executeQuery("select * from coches");
		
		
			while(rst.next()) {
				Coche car=new Coche(rst.getString("marca"),rst.getString("modelo"),rst.getString("matricula"),rst.getString("color"),
						rst.getString("tipo"),rst.getString("motor"),rst.getString("descripcion"),rst.getFloat("precio"));
				
				JButton btnNewButton_1 = new JButton(car.getMarca());
				btnNewButton_1.setMaximumSize(new Dimension(panel.getWidth(),40));
				panel.add(btnNewButton_1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		panel.setVisible(false);
		panel.setVisible(true);
	}
	}

