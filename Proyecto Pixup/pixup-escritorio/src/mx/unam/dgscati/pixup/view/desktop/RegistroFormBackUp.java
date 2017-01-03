package mx.unam.dgscati.pixup.view.desktop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mx.unam.dgscati.pixup.bo.CatalogoBO;
import mx.unam.dgscati.pixup.bo.impl.CatalogoBOImpl;
import mx.unam.dgscati.pixup.model.Catalogo;
import mx.unam.dgscati.pixup.view.desktop.util.GenericRender;

public class RegistroFormBackUp extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel 			nombreLabel;
	private JTextField 		nombreField;
	private JLabel 			primerApellidoLabel;
	private JTextField 		primerApellidoField;
	private JLabel 			segundoApellidoLabel;
	private JTextField 		segundoApellidoField;
	private JLabel 			loginLabel;
	private JTextField 		loginField;
	private JLabel 			passwordLabel;
	private JPasswordField	passwordField;
	private JLabel 			passwordConfirmacionLabel;
	private JPasswordField	passwordConfirmacionField;
	private JLabel 			emailLabel;
	private JTextField 		emailField;
	private JLabel 			preguntaSecretaLabel;
	private JComboBox		preguntaSecretaComboBox;
	private JLabel 			repuestaSecretalLabel;
	private JTextField 		repuestaSecretaField;
	
	//Datos de domicilio Envio
	private JLabel 			domicilioLabel;
	private JLabel			calleLabel;
	private JTextField		calleField;
	private JLabel			numeroExteriorLabel;
	private JTextField		numeroExteriorField;
	private JLabel			numeroInteriorLabel;
	private JTextField		numeroInteriorField;
	private JLabel			codigoPostalLabel;
	private JTextField		codigoPostalField;
	private JButton			codigoPostalButton;
	private JLabel			municipioLabel;
	private JLabel			municipioValueLabel;
	private JLabel			estadoLabel;
	private JLabel			estadoValueLabel;
	private JCheckBox		facturacionCheckbox;
	
	//Datos de domicilio de Facturación
	private JLabel 			domicilioFacturacionLabel;
	private JLabel			calleFacturacionLabel;
	private JTextField		calleFacturacionField;
	private JLabel			numeroExteriorFacturacionLabel;
	private JTextField		numeroExteriorFacturacionField;
	private JLabel			numeroInteriorFacturacionLabel;
	private JTextField		numeroInteriorFacturacionField;
	private JLabel			codigoPostalFacturacionLabel;
	private JTextField		codigoPostalFacturacionField;
	private JButton			codigoPostalFacturacionButton;
	private JLabel			municipioFacturacionLabel;
	private JLabel			municipioValueFacturacionLabel;
	private JLabel			estadoFacturacionLabel;
	private JLabel			estadoValueFacturacionLabel;
	
	private CatalogoBO		catalogoBO;
	
//	private JButton			registrarButton;
//	private JButton			cancelarButton;
	
	public RegistroFormBackUp (){
		super();
		catalogoBO = new CatalogoBOImpl();
		inicializarVentana();
		inicializarForma();
		agregarComponentesPanel();
		//agregarLookAndFeel();
		//Utils.applyLookAndFeel(obtieneComponentes());
	}
	
	public List<Component> obtieneComponentes(){
		Component[] arrayComponent = this.getComponents();
		
		return Arrays.asList(arrayComponent);
	}
	
	private void inicializarVentana(){
		this.setTitle("Registro de Usuario");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));//////
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void inicializarForma(){
		
		 nombreLabel = new JLabel("Nombre");
		 nombreField = new JTextField();
		 primerApellidoLabel = new JLabel("Primer apellido");
		 primerApellidoField = new JTextField();
		 segundoApellidoLabel = new JLabel("Segundo apellido");
		 segundoApellidoField = new JTextField();;
		 loginLabel = new JLabel("Login");
		 loginField = new JTextField();
		 passwordLabel = new JLabel("Password");
		 passwordField = new JPasswordField();
		 passwordConfirmacionLabel = new JLabel("Confirmación password");
		 passwordConfirmacionField = new JPasswordField();
		 emailLabel = new JLabel("Email");
		 emailField = new JTextField();
		 preguntaSecretaLabel = new JLabel("Seleccione la pregunta secreta");
		 Vector<Catalogo> vector = new Vector<>();
		 vector.addAll(catalogoBO.obtenerPreguntasSecretas());
		 preguntaSecretaComboBox = new JComboBox<Catalogo>(vector);
		 preguntaSecretaComboBox.setRenderer(new GenericRender());
		 repuestaSecretalLabel = new JLabel("Respuesta a pregunta secreta");
		 repuestaSecretaField = new JTextField();;
		
	}
	
	private void agregarLookAndFeel(){
		nombreLabel.setPreferredSize(new Dimension(200, 25));
		nombreLabel.setBackground(new Color(127, 0, 255));
		nombreLabel.setForeground(new Color(255, 255, 255));
		nombreLabel.setOpaque(true);
		
		nombreField.setPreferredSize(new Dimension(200,25));
		nombreField.setBackground(new Color(128, 255, 0));
		nombreField.setForeground(new Color(127, 0, 255));
	}
	
	private void agregarComponentesPanel(){
		JPanel panel = new JPanel();
		panel.add(nombreLabel);
		panel.add(nombreField);
		panel.add(primerApellidoLabel);
		panel.add(primerApellidoField);
		this.add(panel);
		
		JPanel panel2 = new JPanel();
		panel2.add(segundoApellidoLabel);
		panel2.add(segundoApellidoField);
		panel2.add(loginLabel);
		panel2.add(loginField);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.add(passwordLabel);
		panel3.add(passwordField);
		panel3.add(passwordConfirmacionLabel);
		panel3.add(passwordConfirmacionField);
		this.add(panel3);
		
		JPanel panel4 = new JPanel();
		panel4.add(emailLabel);
		panel4.add(emailField);
		panel4.add(preguntaSecretaLabel);
		panel4.add(preguntaSecretaComboBox);
		this.add(panel4);
		
		JPanel panel5 = new JPanel();
		panel5.add(repuestaSecretalLabel);
		panel5.add(repuestaSecretaField);
		this.add(panel5);
		
	}

}
