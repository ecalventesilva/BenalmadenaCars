package interfaces;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Cliente;
import clases.Coche;

public class ClienteListado extends JPanel{
	private Cliente cliente;
	private Connection conec;
	private Ventana ventana;
	
	public ClienteListado(Cliente cl,Ventana v) {
		super();
		ventana=v;
		try {
			conec=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/benalmadenacars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch(SQLNonTransientConnectionException ex) {
			//this.dialogoError("Demasiadas conexiones sin cerrar","Hay demasiados usuarios conectados en este momento, por favor, inténtalo de nuevo más tarde");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, "La conexion a bd ha fallado","",JOptionPane.ERROR_MESSAGE);        
		            ex.printStackTrace();
		}
		cliente=cl;
		setLayout(new BorderLayout(0, 0));
		this.setSize(290,50);
		JButton botonCliente = new JButton(cl.getNombre()+" "+cl.getApellidos());
		add(botonCliente);
		
		botonCliente.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(cliente.getNombre());
				//ventana.cargaInfoCliente();
				
			}
		});

		JButton botonEliminar = new JButton("X");
		add(botonEliminar, BorderLayout.EAST);
		
		botonEliminar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int reply = JOptionPane.showConfirmDialog(ventana, "¿Está seguro que desea eliminar el cliente "+cl.getNombre()+" "+cl.getApellidos()+" con dni: "
						+cl.getDni()+ "?", "Mensaje", JOptionPane.YES_NO_OPTION);
		       
				if (reply == JOptionPane.YES_OPTION) {
		        	
		        	Statement deleteStatement = null;
					try {
						deleteStatement = conec.createStatement();	  
			                deleteStatement.executeUpdate(
			                        "delete from clientes where nombre=('" + cl.getNombre() +"');");
			                deleteStatement.close();
			                JOptionPane.showMessageDialog(ventana, "El cliente "+cl.getNombre()+" "+cl.getApellidos()+" con dni "+cl.getDni()+" ha sido eliminado con éxito");  
			                
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
		          
		        }
		        else {
		           JOptionPane.showMessageDialog(ventana, "El cliente "+cl.getNombre()+" "+cl.getApellidos()+" con dni "+ cl.getDni()+" no ha sido eliminado");
		           
		        }
				ventana.cargaPrincipal();
			}
			
		});
	
	
}}
