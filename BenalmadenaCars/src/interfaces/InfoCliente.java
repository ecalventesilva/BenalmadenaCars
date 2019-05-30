package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import clases.Cliente;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.Cursor;
import javax.swing.JScrollPane;


public class InfoCliente extends JPanel{
	private Ventana ventana;
	private ClienteListado clienteListado;
	private Connection conec;
	private JTextPane infoCliente;
	private Cliente cliente;
	private JScrollPane scrollPane;
	
	public InfoCliente(Ventana v,Cliente cl) {
		super();
		this.ventana=v;
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		ventana.conectarBd();
		
		JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
		label.setBounds(111, 11, 225, 48);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBackground(SystemColor.menu);
		add(label);
		
		JLabel lblInformacinCliente = new JLabel("Informaci\u00F3n Cliente");
		lblInformacinCliente.setBounds(139, 61, 158, 14);
		lblInformacinCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacinCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblInformacinCliente);
		
		cliente=cl;
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		infoCliente = new JTextPane();
		infoCliente.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		infoCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoCliente.setEditable(false);
		infoCliente.setBounds(96, 114, 269, 107);
		infoCliente.setText("Nombre: "+cliente.getNombre()+" "+"\n"+"Apellidos : "+cliente.getApellidos()+"\nDNI: "+cliente.getDni()+"\nNºLicencia: "+
		cliente.getLicencia()+"\nNacionalidad: "+cliente.getNacionalidad()+"\nFecha Nacimiento: "+cliente.getFechaNacimiento()+
		"\nDirección España: "+cliente.getDireccionSpain()+"\nResidencia: "+cliente.getDireccionResidencia());
		
		scrollPane.setBounds(96, 114, 269, 107);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.getViewport().add(infoCliente);
		
		add(scrollPane);
		
		JButton buttonVolver = new JButton("VOLVER");
		buttonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.cargaPantallaClientes();
				infoCliente.setText("");
			}
		});
		buttonVolver.setBounds(311, 266, 111, 23);
		add(buttonVolver);
		
		
		
}
}
