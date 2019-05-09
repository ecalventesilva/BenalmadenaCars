package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteUser extends JPanel{
	private Ventana ventana;
	private JTextField textUsuario;
	private JPasswordField textPassword;
	private JPasswordField textPassword2;

	
	public DeleteUser(Ventana v) {
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
		
		JLabel lblEliminarUsuario = new JLabel("Eliminar Usuario");
		lblEliminarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarUsuario.setBounds(143, 70, 158, 14);
		add(lblEliminarUsuario);
		
		JLabel campoUsuario = new JLabel("Usuario");
		campoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoUsuario.setBounds(64, 129, 75, 14);
		add(campoUsuario);
		
		JLabel campoPassword = new JLabel("Contrase\u00F1a");
		campoPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoPassword.setBounds(64, 154, 75, 14);
		add(campoPassword);
		
		JLabel campoPassword2 = new JLabel("Confirma Contrase\u00F1a");
		campoPassword2.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoPassword2.setBounds(64, 179, 144, 14);
		add(campoPassword2);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(215, 127, 158, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(215, 152, 158, 20);
		add(textPassword);
		
		textPassword2 = new JPasswordField();
		textPassword2.setBounds(215, 177, 158, 20);
		add(textPassword2);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(ventana, "¡Usuario eliminado con éxito!","",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBorder(new LineBorder(new Color(255, 0, 0)));
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(284, 238, 104, 23);
		add(btnEliminar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaInicio();
			}
		});
		btnCancelar.setBounds(143, 238, 114, 23);
		add(btnCancelar);

		
}
	

}
