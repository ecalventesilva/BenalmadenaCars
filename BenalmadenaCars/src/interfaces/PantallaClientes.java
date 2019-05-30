package interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Cliente;
import clases.Coche;
import exceptions.DniInvalidoException;
import exceptions.LicenciaInvalidaException;

import javax.swing.BoxLayout;
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

public class PantallaClientes extends JPanel{
	private Ventana ventana;
	private Statement s;
	private Connection c;
	JPanel panel1;
	ArrayList<Cliente> clientes;
	Cliente cl;
	
	public PantallaClientes(Ventana v) {
		super();
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.ventana=v;
		setLayout(null);
		JPanel panel;
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		setBackground(new Color(245, 245, 220));
		label.setBounds(105, 11, 225, 48);
		add(label);
		
		JLabel lblClientes = new JLabel("Lista Clientes");
		lblClientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClientes.setBounds(39, 86, 291, 14);
		add(lblClientes);
		
		JButton btnAtras = new JButton("ATR\u00C1S");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal();
			}
		});
		btnAtras.setBounds(383, 519, 158, 23);
		add(btnAtras);
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel1.setBounds(39, 100, 290, 442);
		add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		JButton btnNuevoCliente = new JButton("NUEVO CLIENTE");
		btnNuevoCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaRegistroClientes();
			}
		});
		btnNuevoCliente.setBounds(383, 485, 158, 23);
		add(btnNuevoCliente);
		
		listaClientes();
		
	}	
	public void listaClientes() {
		panel1.removeAll();
		clientes=new ArrayList<Cliente>();

		try {
			c=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/benalmadenacars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch(SQLNonTransientConnectionException ex) {
			//this.dialogoError("Demasiadas conexiones sin cerrar","Hay demasiados usuarios conectados en este momento, por favor, inténtalo de nuevo más tarde");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, "La conexion a bd ha fallado","",JOptionPane.ERROR_MESSAGE);        
		            ex.printStackTrace();
		}
		
			try {
				s=c.createStatement();
				ResultSet rst= s.executeQuery("select * from clientes");
		
		
			while(rst.next()) {
				Cliente cl;
				try {
					cl = new Cliente(rst.getString("nombre"),rst.getString("apellidos"),rst.getString("dni"),rst.getInt("licencia"),
							rst.getString("nacionalidad"),rst.getDate("fnacimiento").toLocalDate(),rst.getString("direccionspain"),rst.getString("residencia"));
				
					ClienteListado list=new ClienteListado(cl,ventana);
					panel1.add(list);
				} catch (DniInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LicenciaInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		panel1.setVisible(false);
		panel1.setVisible(true);

	}}

