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

public class InfoCar extends JPanel{
	private Ventana ventana;
	private Coche coche;
	private CocheListado cocheListado;
	private Connection conec;
	
	public InfoCar(Ventana v) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		try {
			conec=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/benalmadenacars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch(SQLNonTransientConnectionException ex) {
			//this.dialogoError("Demasiadas conexiones sin cerrar","Hay demasiados usuarios conectados en este momento, por favor, inténtalo de nuevo más tarde");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, "La conexion a bd ha fallado","",JOptionPane.ERROR_MESSAGE);        
		            ex.printStackTrace();
		}
		//coche=c;
		
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
		bttCancelar.setBounds(173, 266, 111, 23);
		bttCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaCoches();
			}
		});
		add(bttCancelar);
		
	
		
		/*
                                                      

		JTextPane textPane = new JTextPane(); 
		textPane.setBounds(65, 113, 299, 122);
		textPane.setText(coche.getMarca()+coche.getMatricula());;
		add(textPane);*/
	}	
}
