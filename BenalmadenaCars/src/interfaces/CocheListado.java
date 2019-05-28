package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextPane;

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
	private Connection conec;
	private Ventana ventana;
	
	public CocheListado(Coche c,Ventana v) {
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
		coche=c;
		setLayout(new BorderLayout(0, 0));
		this.setSize(290,50);
		JButton botonCoche = new JButton(c.getMarca());
		add(botonCoche);
		
		botonCoche.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(coche.getMarca());
				ventana.cargaInfoCar();
				
			}
		});
		

		JButton botonEliminar = new JButton("X");
		add(botonEliminar, BorderLayout.EAST);
		
		botonEliminar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int reply = JOptionPane.showConfirmDialog(ventana, "¿Está seguro que desea eliminar el coche "+c.getMarca()+" con matricula: "
						+c.getMatricula()+ "?", "Mensaje", JOptionPane.YES_NO_OPTION);
		       
				if (reply == JOptionPane.YES_OPTION) {
		        	
		        	Statement deleteStatement = null;
					try {
						deleteStatement = conec.createStatement();	  
			                deleteStatement.executeUpdate(
			                        "delete from coches where marca=('" + c.getMarca() +"');");
			                deleteStatement.close();
			                JOptionPane.showMessageDialog(ventana, "El coche "+c.getMarca()+" con matricula"+c.getMatricula()+" ha sido eliminado con éxito");  
			                
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
		          
		        }
		        else {
		           JOptionPane.showMessageDialog(ventana, "El coche "+c.getMarca()+" con matricula "+ c.getMatricula()+" no ha sido eliminado");
		           
		        }
				
			}
			
		});
	}
	
}
