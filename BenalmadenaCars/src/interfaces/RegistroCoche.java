package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.sun.org.apache.bcel.internal.generic.Select;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import clases.Coche.tipo;
import javafx.scene.control.ComboBox;
import clases.Usuario;
import clases.Coche;
import clases.Coche.color;
import java.awt.Cursor;

public class RegistroCoche extends JPanel{
	
private Ventana ventana;
private JTextField campoMatricula;
private JTextField campoDescripcion;
private JTextField campoMarca;
private JTextField campoModelo;
private JTextField campoPrecio;
	
	public RegistroCoche(Ventana v) {
	super();
	this.ventana=v;
	setBackground(new Color(245, 245, 220));
	setLayout(null);
	
	JButton btnAtras = new JButton("ATRAS");
	btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAtras.setOpaque(false);
	btnAtras.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ventana.cargaCoches();
		}
	});
	btnAtras.setBounds(338, 415, 89, 23);
	add(btnAtras);
	
	JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
	label.setBounds(119, 11, 225, 48);
	add(label);
	
	JLabel lblMarca = new JLabel("MARCA");
	lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblMarca.setBounds(53, 105, 96, 23);
	add(lblMarca);
	
	JLabel lblModelo = new JLabel("MODELO");
	lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblModelo.setBounds(53, 139, 96, 23);
	add(lblModelo);
	
	JLabel lblMatricula = new JLabel("MATR\u00CDCULA");
	lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblMatricula.setBounds(53, 173, 96, 23);
	add(lblMatricula);
	
	JLabel lblColor = new JLabel("COLOR");
	lblColor.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblColor.setBounds(53, 207, 96, 23);
	add(lblColor);
	
	JLabel lblTipo = new JLabel("TIPO");
	lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblTipo.setBounds(53, 241, 96, 23);
	add(lblTipo);
	
	JLabel lblDescripcion = new JLabel("DESCRIPCION");
	lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblDescripcion.setBounds(53, 309, 96, 23);
	add(lblDescripcion);
	
	JLabel lblPrecio = new JLabel("PRECIO");
	lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblPrecio.setBounds(53, 343, 96, 23);
	add(lblPrecio);
	
	campoMatricula = new JTextField();
	campoMatricula.setBounds(163, 175, 186, 20);
	add(campoMatricula);
	campoMatricula.setColumns(10);
	
	campoDescripcion = new JTextField();
	campoDescripcion.setColumns(10);
	campoDescripcion.setBounds(163, 311, 186, 20);
	add(campoDescripcion);
	
	JButton btnGuardar = new JButton("GUARDAR");
	btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnGuardar.setBounds(199, 381, 108, 23);
	add(btnGuardar);
	
	JLabel lblMotor = new JLabel("MOTOR");
	lblMotor.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblMotor.setBounds(53, 276, 96, 23);
	add(lblMotor);
	
	JRadioButton rdbtnDiesel = new JRadioButton("Diesel\r\n");
	rdbtnDiesel.setOpaque(false);
	rdbtnDiesel.setBounds(179, 272, 96, 32);
	add(rdbtnDiesel);
	
	
	
	
	JRadioButton rdbtnGasolina = new JRadioButton("Gasolina");
	rdbtnGasolina.setOpaque(false);
	rdbtnGasolina.setBounds(277, 272, 89, 32);
	add(rdbtnGasolina);
	
	ButtonGroup group = new ButtonGroup();
	group.add(rdbtnDiesel);
	group.add(rdbtnGasolina);
	
	JLabel lblRegistroNuevoCoche = new JLabel("Registro nuevo coche");
	lblRegistroNuevoCoche.setHorizontalAlignment(SwingConstants.CENTER);
	lblRegistroNuevoCoche.setBounds(163, 58, 128, 23);
	add(lblRegistroNuevoCoche);
	
	JComboBox comboBoxTipo = new JComboBox();
	comboBoxTipo.setModel(new DefaultComboBoxModel(tipo.values()));
	comboBoxTipo.setBounds(163, 243, 96, 20);
	add(comboBoxTipo);
	
	JComboBox comboBoxColor = new JComboBox();
	comboBoxColor.setModel(new DefaultComboBoxModel(color.values()));
	comboBoxColor.setBounds(163, 209, 96, 20);
	add(comboBoxColor);
	
	campoMarca = new JTextField();
	campoMarca.setColumns(10);
	campoMarca.setBounds(163, 107, 186, 20);
	add(campoMarca);
	
	campoModelo = new JTextField();
	campoModelo.setColumns(10);
	campoModelo.setBounds(163, 141, 186, 20);
	add(campoModelo);
	
	campoPrecio = new JTextField();
	campoPrecio.setColumns(10);
	campoPrecio.setBounds(163, 343, 186, 20);
	add(campoPrecio);
	
	btnGuardar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			//Coger todos los valores de los campos
			 ventana.conectarBd();
	            try {
	            	String marca=campoMarca.getText();
	    			String modelo=campoModelo.getText();
	    			String matricula=campoMatricula.getText();
	    			String color=comboBoxColor.getSelectedItem().toString();
	    			String tipo=comboBoxTipo.getSelectedItem().toString();
	    			String motor="";
	    			
	    			if (rdbtnDiesel.isEnabled()) {
	    				motor="Diesel";
	    			} else if (rdbtnGasolina.isEnabled()) {
	    				motor="Gasolina";
	    			}
	    			
	    			String descripcion=campoDescripcion.getText();
	    			float precio =Float.parseFloat(campoPrecio.getText());
	    			Coche actual = new Coche(marca, modelo, matricula,color,tipo,motor,descripcion,precio);
	    			Statement registerStatement = ventana.getConnection().createStatement();
	    		    registerStatement.executeUpdate(
		                    "insert into coches (marca,modelo,matricula,color,tipo,motor,descripcion,precio"
		                    + ") values('" + marca + "',"
		                    + "'" + modelo + "','" + matricula
		                    + "','" +color+ "','"+tipo+"','"+motor+"','"+descripcion+"','"+precio+"');");
		            registerStatement.close();
		            JOptionPane.showMessageDialog(ventana, "El coche con matricula: ''"+matricula+"'',"+" ha sido registrado con exito","",JOptionPane.INFORMATION_MESSAGE);
	    			ventana.cargaCoches();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//crear statement
			//executeUpdate("insert into coches values(......)
		}
	});
}	
}
