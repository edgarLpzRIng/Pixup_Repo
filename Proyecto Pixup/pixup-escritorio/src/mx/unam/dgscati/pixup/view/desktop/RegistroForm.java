package mx.unam.dgscati.pixup.view.desktop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mx.unam.dgscati.pixup.bo.CatalogoBO;
import mx.unam.dgscati.pixup.bo.ColoniaBO;
import mx.unam.dgscati.pixup.bo.UsuarioBO;
import mx.unam.dgscati.pixup.bo.impl.CatalogoBOImpl;
import mx.unam.dgscati.pixup.bo.impl.ColoniaBOImpl;
import mx.unam.dgscati.pixup.bo.impl.UsuarioBOImpl;
import mx.unam.dgscati.pixup.model.Catalogo;
import mx.unam.dgscati.pixup.model.Colonia;
import mx.unam.dgscati.pixup.model.Domicilio;
import mx.unam.dgscati.pixup.model.TipoDomicilio;
import mx.unam.dgscati.pixup.model.Usuario;
import mx.unam.dgscati.pixup.view.desktop.util.GenericRender;
import mx.unam.dgscati.pixup.view.desktop.util.Utils;

public class RegistroForm extends JFrame{
	
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
	private JComboBox<Colonia> coloniaComboBox;
	
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
	private JComboBox<Colonia> coloniaFacturacionComboBox;
	
	private JButton			enviarButton;
	
	private List<JComponent> componentes;
	
	private CatalogoBO		catalogoBO;
	private ColoniaBO		coloniaBO;
	private UsuarioBO		usuarioBO;
	
//	private JButton			registrarButton;
//	private JButton			cancelarButton;
	
	public RegistroForm (){
		super();
		catalogoBO = new CatalogoBOImpl();
		coloniaBO = new ColoniaBOImpl();
		inicializarVentana();
		inicializarForma();
		agregarComponentesPanel();
		//agregarLookAndFeel();
		Utils.applyLookAndFeel(componentes);
		agregarListeners();
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
		repuestaSecretaField = new JTextField();
		
		//Inicializar los datos de domicilio.
		domicilioLabel = new JLabel("Datos Domicilio");
		calleLabel = new JLabel("Calle");
		calleField = new JTextField();
		numeroExteriorLabel = new JLabel("No. Ext");
		numeroExteriorField = new JTextField();
		numeroInteriorLabel = new JLabel("No. Int");
		numeroInteriorField = new JTextField();
		codigoPostalLabel = new JLabel("Codigo Postal");
		codigoPostalField = new JTextField();
		codigoPostalButton = new JButton("Buscar Colonia");
		municipioLabel = new JLabel("Municipio");
		municipioValueLabel = new JLabel();
		estadoLabel = new JLabel("Estado");
		estadoValueLabel = new JLabel();
		facturacionCheckbox  = new JCheckBox("Dom. Facturacion");
		coloniaComboBox = new JComboBox<Colonia>();
		coloniaComboBox.setRenderer(new GenericRender());
		
		//Inicializar los datos Domicilio Facturación.
		domicilioFacturacionLabel = new JLabel("Datos Domicilio de Facturación");
		calleFacturacionLabel = new JLabel("Calle Facturación");
		calleFacturacionField = new JTextField();
		numeroExteriorFacturacionLabel = new JLabel("No. Ext Facturación");
		numeroExteriorFacturacionField = new JTextField();
		numeroInteriorFacturacionLabel = new JLabel("No. Int Facturación");
		numeroInteriorFacturacionField = new JTextField();
		codigoPostalFacturacionLabel = new JLabel("Codigo Postal Facturación");
		codigoPostalFacturacionField = new JTextField();
		codigoPostalFacturacionButton = new JButton("Buscar Colonia Facturación");
		municipioFacturacionLabel = new JLabel("Municipio Facturación");
		municipioValueFacturacionLabel = new JLabel();
		estadoFacturacionLabel = new JLabel("Estado Facturación");
		estadoValueFacturacionLabel = new JLabel();
		coloniaFacturacionComboBox= new JComboBox<Colonia>();
		coloniaFacturacionComboBox.setRenderer(new GenericRender());
		
		enviarButton = new JButton("Alta Usuario");
		
		componentes = Arrays.asList(new JComponent[]{nombreLabel,nombreField,primerApellidoLabel,primerApellidoField,segundoApellidoLabel,
				segundoApellidoField,loginLabel,loginField,passwordLabel,passwordField,passwordConfirmacionLabel,passwordConfirmacionField,emailLabel,emailField,
				preguntaSecretaLabel,preguntaSecretaComboBox,repuestaSecretalLabel,repuestaSecretaField,
				
				domicilioLabel,calleLabel,calleField,numeroExteriorLabel,numeroExteriorField,numeroInteriorLabel,numeroInteriorField,codigoPostalLabel,
				codigoPostalField,codigoPostalButton,coloniaComboBox,municipioLabel,municipioValueLabel,estadoLabel,estadoValueLabel,facturacionCheckbox,
				
				domicilioFacturacionLabel,calleFacturacionLabel,calleFacturacionField,numeroExteriorFacturacionLabel,numeroExteriorFacturacionField,
				numeroInteriorFacturacionLabel,numeroInteriorFacturacionField,codigoPostalFacturacionLabel,codigoPostalFacturacionField,codigoPostalFacturacionButton,
				coloniaFacturacionComboBox,municipioFacturacionLabel,municipioValueFacturacionLabel,estadoFacturacionLabel,estadoValueFacturacionLabel,
				
				enviarButton
		});
		
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
		JPanel panel = null;
		int cont = 0;
		for(JComponent componente : componentes){
			if(cont == 0){
				panel = new JPanel();
			}
			panel.add(componente);
			cont++;
			if(cont == 4){
				cont=0;
				this.add(panel);
			}
		}
		if(cont>0){
			this.add(panel);
		}
	}
	
	private void agregarListeners(){
		codigoPostalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(codigoPostalField != null && !codigoPostalField.getText().isEmpty()){
					List<Colonia> colonias = coloniaBO.obtenerColoniaPorCP(codigoPostalField.getText());
					coloniaComboBox.removeAllItems();
					municipioValueLabel.setText("");
					estadoValueLabel.setText("");
					if(!colonias.isEmpty()){
						Colonia coloniaSelec = colonias.get(0);
						municipioValueLabel.setText(coloniaSelec.getMunicipio().getNombre());
						estadoValueLabel.setText(coloniaSelec.getMunicipio().getEstado().getNombre());
						for(Colonia colonia : colonias){
							coloniaComboBox.addItem(colonia);
						}
					} else {
						JOptionPane.showMessageDialog(RegistroForm.this, "No se encontraron colonias para el código postal dado.",
								"Colonia no encontrada", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
				
		coloniaComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(coloniaComboBox.getItemCount()>0){
					Colonia colonia = (Colonia) coloniaComboBox.getSelectedItem();
					municipioValueLabel.setText(colonia.getMunicipio().getNombre());
					estadoValueLabel.setText(colonia.getMunicipio().getEstado().getNombre());
				}
			}
		});
		
		/******************** Facturación ********************/
		codigoPostalFacturacionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(codigoPostalFacturacionField != null && !codigoPostalFacturacionField.getText().isEmpty()){
					List<Colonia> colonias = coloniaBO.obtenerColoniaPorCP(codigoPostalFacturacionField.getText());
					coloniaFacturacionComboBox.removeAllItems();
					municipioValueFacturacionLabel.setText("");
					estadoValueFacturacionLabel.setText("");
					if(!colonias.isEmpty()){
						Colonia coloniaSelec = colonias.get(0);
						municipioValueFacturacionLabel.setText(coloniaSelec.getMunicipio().getNombre());
						estadoValueFacturacionLabel.setText(coloniaSelec.getMunicipio().getEstado().getNombre());
						for(Colonia colonia : colonias){
							coloniaFacturacionComboBox.addItem(colonia);
						}
					} else {
						JOptionPane.showMessageDialog(RegistroForm.this, "No se encontraron colonias para el código postal dado.",
								"Colonia no encontrada", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		coloniaFacturacionComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(coloniaFacturacionComboBox.getItemCount()>0){
					Colonia colonia = (Colonia) coloniaFacturacionComboBox.getSelectedItem();
					municipioValueFacturacionLabel.setText(colonia.getMunicipio().getNombre());
					estadoValueFacturacionLabel.setText(colonia.getMunicipio().getEstado().getNombre());
				}
			}
		});
		
		enviarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setNombre(nombreField.getText());
				usuario.setPrimerApellido(primerApellidoField.getText());
				usuario.setSegundoApellido(segundoApellidoField.getText());
				usuario.setLogin(loginField.getText());
				usuario.setContrasenia(String.valueOf(passwordField.getPassword()));
				usuario.setCorreoElectronico(emailField.getText());
				usuario.setPreguntaSecreta((Catalogo)preguntaSecretaComboBox.getSelectedItem());
				usuario.setRespuestaSecreta(repuestaSecretaField.getText());
				
				List<Domicilio> domicilios = new ArrayList<>(2);
				
				Domicilio domicilioEnvio = new Domicilio();
				domicilioEnvio.setCalle(calleField.getText());
				domicilioEnvio.setNumeroExterior(numeroExteriorField.getText());
				domicilioEnvio.setNumeroInterior(numeroInteriorField.getText());
				domicilioEnvio.setColonia((Colonia)coloniaComboBox.getSelectedItem());
				domicilioEnvio.setTipoDomicilio(new TipoDomicilio(1));
				domicilios.add(domicilioEnvio);
				
				//Facturacion
				Domicilio domicilioFacturacion = new Domicilio();
				domicilioFacturacion.setCalle(calleFacturacionField.getText());
				domicilioFacturacion.setNumeroExterior(numeroExteriorFacturacionField.getText());
				domicilioFacturacion.setNumeroInterior(numeroInteriorFacturacionField.getText());
				domicilioFacturacion.setColonia((Colonia)coloniaFacturacionComboBox.getSelectedItem());
				domicilioFacturacion.setTipoDomicilio(new TipoDomicilio(2));
				domicilios.add(domicilioFacturacion);
				
				usuarioBO = new UsuarioBOImpl();
				try{
					Usuario usuarioCreado = usuarioBO.registrarUsuario(usuario, domicilios);
					
					JOptionPane.showMessageDialog(RegistroForm.this, "El usuario se registró correctamente con el identificador: "
							+usuarioCreado.getIdentificador(),
							"Usuario Registrado", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception ex){
					JOptionPane.showMessageDialog(RegistroForm.this, "Error al registrar el usuario:\n"+ex.getMessage(),
							"Error Registro Usuario", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
//	private Vector<Colonia> obtenerColonias(String cp){
//		return (cp != null && !cp.isEmpty()) ? new Vector<>(coloniaBO.obtenerColoniaPorCP(cp)) : null;
//	}

}
