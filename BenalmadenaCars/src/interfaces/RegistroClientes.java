package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import benalmadenacars.BenalmadenaCars;
import clases.Cliente;
import clases.Usuario;
import exceptions.DniInvalidoException;
import exceptions.LicenciaInvalidaException;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import java.awt.Cursor;

public class RegistroClientes extends JPanel{
	private Ventana ventana;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDni;
	private JTextField textFieldLicencia;
	private JTextField textFieldNacionalidad;
	private JTextField textFieldNacimiento;
	private JTextField textFieldDireccion;
	private JTextField textFieldResidencia;

	public RegistroClientes(Ventana v) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(112, 11, 225, 48);
		add(label);
		
		JLabel lblRegistroNuevoCliente = new JLabel("Registro Nuevo Cliente");
		lblRegistroNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroNuevoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistroNuevoCliente.setBounds(143, 58, 158, 14);
		add(lblRegistroNuevoCliente);
		
		JButton button = new JButton("ATRÁS");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaClientes();
				ventana.cargaPantallaClientes();
				textFieldNombre.setText("");
				textFieldApellidos.setText("");
				textFieldDni.setText("");
				textFieldLicencia.setText("");
				textFieldNacionalidad.setText("");
				textFieldNacimiento.setText("");
				textFieldDireccion.setText("");
				textFieldResidencia.setText("");
			}
		});
		button.setBounds(98, 415, 124, 23);
		add(button);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.conectarBd();
				try {
		            String nombre=textFieldNombre.getText();
		            String apellidos=textFieldApellidos.getText();
		            String dni =textFieldDni.getText();
		            int licencia =Integer.parseInt(textFieldLicencia.getText());
		            String nacionalidad=textFieldNacionalidad.getText();
		            LocalDate fnacimiento=LocalDate.parse(textFieldNacimiento.getText());
		            String direccionSpain=textFieldDireccion.getText();
		            String residencia=textFieldResidencia.getText();
		            
		            Cliente actual = new Cliente(nombre, apellidos, dni, licencia,nacionalidad,fnacimiento,direccionSpain,residencia);
		            Statement registerStatement = ventana.getConnection().createStatement();
		            registerStatement.executeUpdate(
		                    "insert into clientes (nombre,apellidos,dni,licencia,nacionalidad,fnacimiento,direccionSpain,residencia"
		                    + ") values('" + nombre + "',"
		                    + "'" + apellidos + "','" + dni
		                    + "','" + licencia + "','"+nacionalidad+"','"+fnacimiento+"','"+direccionSpain+"','"+residencia+"');");
		            registerStatement.close();
		            JOptionPane.showMessageDialog(ventana, "El cliente: ''"+nombre+"'',"+" ha sido creado con exito","",JOptionPane.INFORMATION_MESSAGE);
		            ventana.cargaPantallaClientes();
		            
		            return;

				 } catch (SQLException ex) {
			            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
			            
				 } catch (DniInvalidoException ex) {
			            Logger.getLogger(BenalmadenaCars.class.getName()).log(Level.SEVERE, null, ex);
			            JOptionPane.showMessageDialog(ventana, "Has introducido un DNI erróneo","Error",JOptionPane.ERROR_MESSAGE);
			            ex.getMessage();
			           
				 
			        } catch (LicenciaInvalidaException e1) {
			        	JOptionPane.showMessageDialog(ventana, "Has introducido un número de licencia inválido","Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					
				}
				
				ventana.cargaPantallaClientes();
				textFieldNombre.setText("");
				textFieldApellidos.setText("");
				textFieldDni.setText("");
				textFieldLicencia.setText("");
				textFieldNacionalidad.setText("");
				textFieldNacimiento.setText("");
				textFieldDireccion.setText("");
				textFieldResidencia.setText("");
		
			
			}});
		btnGuardar.setBounds(232, 415, 124, 23);
		add(btnGuardar);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(47, 118, 116, 23);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(208, 120, 186, 20);
		add(textFieldNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(47, 149, 116, 23);
		add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(208, 151, 186, 20);
		add(textFieldApellidos);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDni.setBounds(47, 176, 116, 23);
		add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(208, 181, 186, 20);
		add(textFieldDni);
		
		JLabel lblLicencia = new JLabel("LICENCIA");
		lblLicencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLicencia.setBounds(47, 210, 116, 23);
		add(lblLicencia);
		
		textFieldLicencia = new JTextField();
		textFieldLicencia.setColumns(10);
		textFieldLicencia.setBounds(208, 215, 186, 20);
		add(textFieldLicencia);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNacionalidad.setBounds(47, 244, 116, 23);
		add(lblNacionalidad);
		
		textFieldNacionalidad = new JTextField();
		textFieldNacionalidad.setColumns(10);
		textFieldNacionalidad.setBounds(208, 249, 186, 20);
		add(textFieldNacionalidad);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA NACIMIENTO");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaNacimiento.setBounds(47, 278, 147, 23);
		add(lblFechaNacimiento);
		
		textFieldNacimiento = new JTextField();
		textFieldNacimiento.setColumns(10);
		textFieldNacimiento.setBounds(208, 280, 186, 20);
		add(textFieldNacimiento);
		
		JLabel lblDireccionSpain = new JLabel("DIRECCION SPAIN");
		lblDireccionSpain.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccionSpain.setBounds(47, 312, 147, 23);
		add(lblDireccionSpain);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(208, 315, 186, 20);
		add(textFieldDireccion);
		
		JLabel lblDireccionResidencia = new JLabel("DIRECCION RESIDENCIA");
		lblDireccionResidencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccionResidencia.setBounds(47, 345, 147, 23);
		add(lblDireccionResidencia);
		
		textFieldResidencia = new JTextField();
		textFieldResidencia.setColumns(10);
		textFieldResidencia.setBounds(208, 343, 186, 20);
		add(textFieldResidencia);
	}
}
