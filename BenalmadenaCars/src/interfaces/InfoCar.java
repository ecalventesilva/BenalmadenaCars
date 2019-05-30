package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public class InfoCar extends JPanel{
	private Ventana ventana;
	private Coche coche;
	private CocheListado cocheListado;
	private Connection conec;
	private JTextPane infoCar;
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
		
		JButton bttCancelar = new JButton("VOLVER");
		bttCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bttCancelar.setBounds(173, 266, 111, 23);
		bttCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ventana.cargaCoches();
				infoCar.removeAll();
			}
		});
		add(bttCancelar);
		
		coche=c;
		infoCar = new JTextPane();
		infoCar.setEditable(false);
		infoCar.setBounds(96, 114, 269, 107);
		infoCar.setText(coche.getMarca()+coche.getMatricula());;
		add(infoCar);
		System.out.println(coche.getMatricula());
		
		
	/*	infoCar.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(coche.getMarca());
				
				
			}
		});*/
	
		
		
                                                      
/*
		JTextPane textPane = new JTextPane(); 
		textPane.setBounds(65, 113, 299, 122);
		textPane.setText(coche.getMarca()+coche.getMatricula());;
		add(textPane);*/
	}	
}
