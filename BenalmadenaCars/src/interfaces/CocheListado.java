package interfaces;

import javax.swing.JPanel;

import clases.Coche;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CocheListado extends JPanel {
	private Coche coche;
	public CocheListado(Coche c) {
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
			}
			
		});
	}
	
}
