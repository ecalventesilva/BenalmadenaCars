package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import benalmadenacars.BenalmadenaCars;
import clases.Alquiler;
import clases.Cliente;
import exceptions.DniInvalidoException;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class PantallaAlquiler extends JPanel{
	private Ventana ventana;
	private JTextField campoDni;
	private JTextField campoMatricula;
	private JTextField campoFinicio;
	private JTextField campoFfin;
	private String dniCliente;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String matriculaCoche;
	private JTextField campoPrecio;
	private float precio;
	private LocalDateTime fechaActual;
	
	public PantallaAlquiler(Ventana v) {
		
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(147, 11, 245, 48);
		add(label);
		
		JButton btnAtrs = new JButton("ATR\u00C1S");
		btnAtrs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal();
				campoDni.setText("");
				campoMatricula.setText("");
				campoFinicio.setText("");
				campoFfin.setText("");
			}
		});
		btnAtrs.setBounds(383, 515, 135, 23);
		add(btnAtrs);
		
		JLabel lblAlquiler = new JLabel("Alquiler");
		lblAlquiler.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlquiler.setBounds(188, 70, 158, 14);
		add(lblAlquiler);
		
		JLabel lblDniCliente = new JLabel("DNI CLIENTE");
		lblDniCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDniCliente.setBounds(123, 106, 89, 23);
		add(lblDniCliente);
		
		JLabel lblMatrcula = new JLabel("MATR\u00CDCULA");
		lblMatrcula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatrcula.setBounds(123, 140, 89, 23);
		add(lblMatrcula);
		
		JLabel lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaInicio.setBounds(123, 174, 89, 23);
		add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaFin.setBounds(123, 208, 89, 23);
		add(lblFechaFin);
		
		campoDni = new JTextField();
		campoDni.setBounds(241, 107, 181, 20);
		add(campoDni);
		campoDni.setColumns(10);
		
		campoMatricula = new JTextField();
		campoMatricula.setColumns(10);
		campoMatricula.setBounds(241, 141, 181, 20);
		add(campoMatricula);
		
		campoFinicio = new JTextField();
		campoFinicio.setColumns(10);
		campoFinicio.setBounds(241, 175, 181, 20);
		add(campoFinicio);
		
		campoFfin = new JTextField();
		campoFfin.setColumns(10);
		campoFfin.setBounds(241, 209, 181, 20);
		add(campoFfin);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(123, 242, 89, 23);
		add(lblPrecio);
		
		campoPrecio = new JTextField();
		campoPrecio.setColumns(10);
		campoPrecio.setBounds(241, 240, 181, 20);
		add(campoPrecio);
		
		JButton btnGuardar = new JButton("PRINT & SAVE");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.conectarBd();
				
				try {
				dniCliente=campoDni.getText();
				matriculaCoche=campoMatricula.getText();
				fechaInicio=LocalDate.parse(campoFinicio.getText());
				fechaFin=LocalDate.parse(campoFfin.getText());
				precio=Float.parseFloat(campoPrecio.getText());
				Alquiler alq=new Alquiler(dniCliente, matriculaCoche, fechaInicio, fechaFin);
	            Statement registerStatement = ventana.getConnection().createStatement();
	            registerStatement.executeUpdate(
	            		"insert into alquileres (dniCliente,matriculaCoche,fechaInicio,fechaFin"
	            		+")values('"+ dniCliente +"',"
	            		+ "'" + matriculaCoche +"','"+ fechaInicio 
	            		+ "','" + fechaFin + "');");
	            registerStatement.close(); 
	           
	            
				} catch (SQLException ex) {
		            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(ventana, "El DNI o Matricula introducida no se encuentran registradas","Error",JOptionPane.ERROR_MESSAGE);
		            campoDni.setText("");
					
			 } catch (DniInvalidoException ex) {
		            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(ventana, "Has introducido un DNI erróneo","Error",JOptionPane.ERROR_MESSAGE);
		            ex.getMessage();
		            campoDni.setText("");
		          
			 }
				
				campoDni.setText("");
				campoMatricula.setText("");
				campoFinicio.setText("");
				campoFfin.setText("");
				campoPrecio.setText("");
			
				FileWriter fichero= null;
				PrintWriter pw=null;
				
		
				
				try {
					fichero= new FileWriter("./Impreso_Reserva"+matriculaCoche+".txt");
					
					pw= new PrintWriter(fichero);
					
					pw.println("BENALMÁDENA CARS S.L."+"                          "+fechaActual.now());
					pw.println();
					pw.println("CLiente con DNI: "+dniCliente);
					pw.println("Se le ha asignado el coche con matricula: "+matriculaCoche);
					pw.println("Con fecha de inicio: "+fechaInicio+ ",hasta la fecha de fin del alquiler: "+fechaFin);
					pw.println("El número de días totales de la reserva es de: "+(fechaFin.getDayOfYear()-fechaInicio.getDayOfYear()+" días."));
					pw.println("El precio total de la reserva es: "+(fechaFin.getDayOfYear()-fechaInicio.getDayOfYear())*precio+"€");
					
					JOptionPane.showMessageDialog(ventana, "¡IMPRESO DE RESERVA REALIZADO CON ÉXITO!","",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						if(null!=fichero)
							fichero.close();
					}catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
			}
		});
		btnGuardar.setBounds(383, 481, 135, 23);
		add(btnGuardar);
		/**
		 * Label que contiene una imagen.
		 */
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes/alquiler.png"));
		lblNewLabel.setBounds(39, 263, 307, 275);
		add(lblNewLabel);
		

		
		
	}
}
