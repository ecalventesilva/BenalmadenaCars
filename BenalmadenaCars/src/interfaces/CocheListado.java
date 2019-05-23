package interfaces;

import javax.swing.JPanel;

import clases.Coche;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;

public class CocheListado extends JPanel {
	private Coche coche;
	private Ventana ventana;
	public Connection conec;
	
	
	public CocheListado(Coche c) {
		super();
		try {
			conec=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/benalmadenacars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch(SQLNonTransientConnectionException ex) {
			//this.dialogoError("Demasiadas conexiones sin cerrar","Hay demasiados usuarios conectados en este momento, por favor, inténtalo de nuevo más tarde");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, "La conexion a bd ha fallado","",JOptionPane.ERROR_MESSAGE);        
		            ex.printStackTrace();
		}
		coche=c;
		setLayout(new BorderLayout(0, 0));
		this.setSize(290,50);
		JButton botonCoche = new JButton(c.getMarca());
		add(botonCoche);
		
		JButton botonEliminar = new JButton("X");
		add(botonEliminar, BorderLayout.EAST);
		botonCoche.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(coche.getMarca());
			}
			
		});
		botonEliminar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Eliminar "+coche.getMarca());
				
				int reply = JOptionPane.showConfirmDialog(ventana, "¿Está seguro que desea eliminar el coche "+c.getMarca()+"?", "Mensaje", JOptionPane.YES_NO_OPTION);
		       
				if (reply == JOptionPane.YES_OPTION) {
		        	
		        	Statement deleteStatement = null;
					try {
						deleteStatement = conec.createStatement();	  
			                deleteStatement.executeUpdate(
			                        "delete from coches where marca=('" + c.getMarca() +"');");
			                deleteStatement.close();
			                JOptionPane.showMessageDialog(ventana, "El coche con matricula "+c.getMatricula()+" ha sido eliminado con éxito");  
			                
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
		          
		        }
		        else {
		           JOptionPane.showMessageDialog(ventana, "El coche con matricula "+ c.getMatricula()+" no ha sido eliminado");
		           
		        }
				
			}
			
		});
	}
	
}
