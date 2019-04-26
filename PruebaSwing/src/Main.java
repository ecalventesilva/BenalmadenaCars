import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		
		//Primero tengo que crear la ventana que hereda de JFRAME, 
		
		VentanaPrincipal ventana=new VentanaPrincipal();
		
		//System.out.println("Hola, voy a abrir una ventana");
		//para poder ver la ventana tengo que llamar la funcion setVisible
		ventana.setVisible(true);
		
		//para darle tamaño tenemos la funcion setSize
		
		//vamos a experimentar con algunas propiedades mas:
		ventana.setTitle("Benalmadena Cars");
		
		ventana.setBackground(new Color(255,0,0));
		try {
			ventana.setIconImage(ImageIO.read(new File("./rent.png")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		/*VentanaPrincipal vp2=new VentanaPrincipal();
		vp2.setVisible(true);
		Ventana2 v2=new Ventana2();
		v2.setVisible(true);*/
	}

}
