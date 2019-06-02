package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.awt.Cursor;
/**
 * Ventana: pantalla principal, donde se ve el menú principal: COCHES, CLIENTES, PARKING (NO DISPONIBLE POR EL MOMENTO) Y ALQUILER.
 * @author Eduardo
 *
 */
public class Principal extends JPanel{
	private Ventana ventana;
	private PantallaCoches coche;
	private PantallaClientes cliente;
	
	public Principal(Ventana v) {
		super();
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.ventana=v;
		this.coche=new PantallaCoches(v);
		this.cliente=new PantallaClientes(v);
		setLayout(null);
		ventana.conectarBd();
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		setBackground(new Color(245, 245, 220));
		label.setBounds(105, 11, 225, 48);
		add(label);
		
		/**
		 * Boton coches: carga la pantalla coches
		 */
		JButton btnCoches = new JButton("COCHES");
		btnCoches.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCoches.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coche.listaCoches();
				ventana.cargaCoches();
				
			}
		});
		btnCoches.setBorder(new LineBorder(Color.RED));
		btnCoches.setBounds(252, 55, 95, 48);
		add(btnCoches);
		/**
		 * Boton clientes, carga la ventana clientes
		 */
		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cliente.listaClientes();
				ventana.cargaPantallaClientes();
			}
		});
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setBorder(new LineBorder(Color.ORANGE));
		btnClientes.setBounds(252, 125, 95, 48);
		add(btnClientes);
		
		/*
		/**
		 * Boton parking: ACTUALMENTE NO ESTÁ IMPLEMENTADO
		 */
		/*JButton btnParking = new JButton("PARKING");
		btnParking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnParking.setBorder(new LineBorder(new Color(139, 0, 0)));
		btnParking.setBounds(92, 184, 95, 48);
		add(btnParking);*/
		
		
		/**
		 * Boton alquiler: carga la pantalla alquiler
		 */
		JButton btnAlquiler = new JButton("ALQUILER");
		btnAlquiler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaPantallaAlquiler();
			}
		});
		btnAlquiler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlquiler.setBorder(new LineBorder(Color.BLUE));
		btnAlquiler.setBounds(252, 192, 95, 48);
		add(btnAlquiler);
		
		/**
		 * Boton volver, nos devuelve a la ventana anterior: Pantalla Inicio
		 */
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaInicio();
			}
		});
		btnVolver.setBounds(351, 246, 89, 23);
		add(btnVolver);

		/**
		 * Label que contiene una imagen.
		 */
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fiat500.png"));
		lblNewLabel.setBounds(-6, 65, 248, 175);
		add(lblNewLabel);
		
		
		
}	
}
