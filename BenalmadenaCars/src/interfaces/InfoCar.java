package interfaces;

import java.awt.Color;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InfoCar extends JPanel{
	private Ventana ventana;
	private JTextField campoMatricula;
	
	public InfoCar(Ventana v) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(113, 11, 225, 48);
		add(label);
		
		JLabel lblEliminarUsuario = new JLabel("Eliminar Coche");
		lblEliminarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarUsuario.setBounds(143, 70, 158, 14);
		add(lblEliminarUsuario);
		
		JLabel textMatricula = new JLabel("Matrícula");
		textMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		textMatricula.setBounds(76, 149, 75, 14);
		add(textMatricula);
		
		campoMatricula = new JTextField();
		campoMatricula.setBounds(227, 147, 158, 20);
		add(campoMatricula);
		campoMatricula.setColumns(10);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.conectarBd();
				String matricula=campoMatricula.getText();
				Statement deleteStatement = null;
				try {
					deleteStatement = ventana.getConnection().createStatement();	  
		                deleteStatement.executeUpdate(
		                        "delete from coches where matricula=('" + matricula +"');");
		                deleteStatement.close();
		                JOptionPane.showMessageDialog(ventana, "¡El coche con matrícula: "+matricula+" ha sido eliminado con éxito!","Coche eliminado",JOptionPane.INFORMATION_MESSAGE);
		                ventana.cargaCoches();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 campoMatricula.setText("");
		          
			}
		});
		btnEliminar.setBounds(234, 219, 109, 23);
		add(btnEliminar);
		
		JButton bttCancelar = new JButton("CANCELAR");
		bttCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaCoches();
			}
		});
		bttCancelar.setBounds(113, 219, 111, 23);
		add(bttCancelar);
		
	}
}
