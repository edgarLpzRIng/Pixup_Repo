package mx.unam.dgscati.pixup.view.desktop;

import javax.swing.JFrame;

public class HomeForm extends JFrame{
	
	public HomeForm (){
		super();
		inicializarVentana();
	}
	
	private void inicializarVentana(){
		this.setTitle("Home Form");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
