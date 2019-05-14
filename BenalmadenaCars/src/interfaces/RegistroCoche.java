package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.sun.org.apache.bcel.internal.generic.Select;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import clases.Coche.tipo;
import clases.Coche.color;
import java.awt.Cursor;

public class RegistroCoche extends JPanel{
	
private Ventana ventana;
private JTextField campoMatricula;
private JTextField campoDescripcion;
	
	public RegistroCoche(Ventana v) {
	super();
	this.ventana=v;
	setBackground(new Color(245, 245, 220));
	setLayout(null);
	
	JButton btnAtras = new JButton("ATRAS");
	btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAtras.setOpaque(false);
	btnAtras.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ventana.cargaCoches();
		}
	});
	btnAtras.setBounds(338, 415, 89, 23);
	add(btnAtras);
	
	JLabel label = new JLabel("BENALM\u00C1DENA CARS SL");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
	label.setBounds(119, 11, 225, 48);
	add(label);
	
	JLabel lblMarca = new JLabel("MARCA");
	lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblMarca.setBounds(53, 105, 96, 23);
	add(lblMarca);
	
	JLabel lblModelo = new JLabel("MODELO");
	lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblModelo.setBounds(53, 139, 96, 23);
	add(lblModelo);
	
	JLabel lblMatrcula = new JLabel("MATR\u00CDCULA");
	lblMatrcula.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblMatrcula.setBounds(53, 173, 96, 23);
	add(lblMatrcula);
	
	JLabel lblColor = new JLabel("COLOR");
	lblColor.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblColor.setBounds(53, 207, 96, 23);
	add(lblColor);
	
	JLabel lblTipo = new JLabel("TIPO");
	lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblTipo.setBounds(53, 241, 96, 23);
	add(lblTipo);
	
	JLabel lblDescripcion = new JLabel("DESCRIPCION");
	lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblDescripcion.setBounds(53, 309, 96, 23);
	add(lblDescripcion);
	
	JLabel lblPrecio = new JLabel("PRECIO");
	lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblPrecio.setBounds(53, 343, 96, 23);
	add(lblPrecio);
	
	campoMatricula = new JTextField();
	campoMatricula.setBounds(163, 175, 186, 20);
	add(campoMatricula);
	campoMatricula.setColumns(10);
	
	campoDescripcion = new JTextField();
	campoDescripcion.setColumns(10);
	campoDescripcion.setBounds(163, 311, 186, 20);
	add(campoDescripcion);
	
	JButton btnGuardar = new JButton("GUARDAR");
	btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnGuardar.setBounds(199, 381, 108, 23);
	add(btnGuardar);
	
	JLabel lblMotor = new JLabel("MOTOR");
	lblMotor.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblMotor.setBounds(53, 276, 96, 23);
	add(lblMotor);
	
	JRadioButton rdbtnDiesel = new JRadioButton("Diesel\r\n");
	rdbtnDiesel.setOpaque(false);
	rdbtnDiesel.setBounds(179, 272, 96, 32);
	add(rdbtnDiesel);
	
	
	
	
	JRadioButton rdbtnGasolina = new JRadioButton("Gasolina");
	rdbtnGasolina.setOpaque(false);
	rdbtnGasolina.setBounds(277, 272, 89, 32);
	add(rdbtnGasolina);
	
	ButtonGroup group = new ButtonGroup();
	group.add(rdbtnDiesel);
	group.add(rdbtnGasolina);
	
	JLabel lblRegistroNuevoCoche = new JLabel("Registro nuevo coche");
	lblRegistroNuevoCoche.setHorizontalAlignment(SwingConstants.CENTER);
	lblRegistroNuevoCoche.setBounds(163, 58, 128, 23);
	add(lblRegistroNuevoCoche);
	
	JComboBox comboBoxTipo = new JComboBox();
	comboBoxTipo.setModel(new DefaultComboBoxModel(tipo.values()));
	comboBoxTipo.setBounds(163, 243, 96, 20);
	add(comboBoxTipo);
	
	JComboBox comboBoxColor = new JComboBox();
	comboBoxColor.setModel(new DefaultComboBoxModel(color.values()));
	comboBoxColor.setBounds(163, 209, 96, 20);
	add(comboBoxColor);
	


}	
}
