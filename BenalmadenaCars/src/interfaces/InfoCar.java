package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Coche;
import clases.Usuario;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Cursor;
/**
 * Pantalla InfoCar: pantalla que nos carga toda la informacion del coche seleccionado, registrado anteriormente en la base de datos
 * @author Eduardo
 *
 */
public class InfoCar extends JPanel{
	private Ventana ventana;
	private Coche coche;
	private CocheListado cocheListado;
	private Connection conec;
	private JTextPane infoCar;
	private JScrollPane scrollPane;
	
	public InfoCar(Ventana v,Coche c) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		ventana.conectarBd();
		
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setBounds(113, 11, 225, 48);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		add(label);
		
		JLabel lblEliminarUsuario = new JLabel("Informaci\u00F3n coche");
		lblEliminarUsuario.setBounds(143, 70, 158, 14);
		lblEliminarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblEliminarUsuario);
		
		
		coche=c;
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		infoCar = new JTextPane();
		infoCar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		infoCar.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoCar.setEditable(false);
		infoCar.setBounds(96, 114, 269, 107);
		infoCar.setFont(new Font("italic",Font.BOLD,14));
		infoCar.setText("Marca: "+coche.getMarca()+" "+"\n"+"Modelo: "+coche.getModelo()+"\nMatricula: "+coche.getMatricula()+"\nColor: "+coche.getColor()+
				"\nTipo: "+coche.getTipo()+"\nMotor: "+coche.getMotor()+"\nDescripción: "+coche.getDescripcion()+"\nPrecio/día: "+coche.getPrecio_dia()+"€");
		
		scrollPane.setBounds(96, 114, 269, 107);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.getViewport().add(infoCar);
		
		add(scrollPane);
		
		/**
		 * BOTÓN VOLVER: REGRESA A LA VENTANA "COCHES".
		 */
		JButton bttCancelar = new JButton("VOLVER");
		bttCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bttCancelar.setBounds(173, 266, 111, 23);
		bttCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaCoches();
				infoCar.setText("");
			}
		});
		add(bttCancelar);

	}	
}
