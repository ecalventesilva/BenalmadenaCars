package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
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

public class DeleteCar extends JPanel{
	private Ventana ventana;
	private JTextField campoMatricula;
	
	public DeleteCar(Ventana v) {
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
		textMatricula.setBounds(64, 129, 75, 14);
		add(textMatricula);
		
		campoMatricula = new JTextField();
		campoMatricula.setBounds(215, 127, 158, 20);
		add(campoMatricula);
		campoMatricula.setColumns(10);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.conectarBd();
				String matricula=campoMatricula.getText();
				PreparedStatement loginStatement = null;
				try {
					loginStatement = ventana.getConnection().prepareStatement(
					        "select * from coches where matricula='"+matricula+"' ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		            ResultSet foundCar = null;
					try {
						foundCar = loginStatement.executeQuery();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            try {
						if(foundCar.next()) {
							Coche user=new Coche(foundCar.getString("marca"),foundCar.getString("modelo"),
									foundCar.getString("matricula"),foundCar.getString("color"),foundCar.getString("tipo"),
									foundCar.getString("motor"),foundCar.getString("descripcion"),foundCar.getFloat("precio"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnEliminar.setBounds(178, 266, 89, 23);
		add(btnEliminar);
		
	}

}
