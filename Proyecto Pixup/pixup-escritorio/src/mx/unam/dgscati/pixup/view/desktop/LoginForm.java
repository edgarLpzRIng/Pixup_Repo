package mx.unam.dgscati.pixup.view.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.management.NotCompliantMBeanException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mx.unam.dgscati.pixup.bo.UsuarioBO;
import mx.unam.dgscati.pixup.bo.impl.UsuarioBOImpl;
import mx.unam.dgscati.pixup.model.Usuario;

public class LoginForm extends JFrame{

	private JLabel 			usuarioLabel;
	private JTextField		usuarioField;
	private JLabel			passwordLabel;
	private JPasswordField	passwordField;
	private JButton			ingresarButton;
	private JButton			registrarButton;
	private JButton			disquerasButton;
	
	private UsuarioBO 		usuarioBO;
	
	public LoginForm() {
		super();
		usuarioBO = new UsuarioBOImpl();
		inicializarVentana();
		inicialirzaForma();
		agregarComponentesPanel();
	}
	
	private void inicializarVentana(){
		this.setTitle("Pixup Desktop");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void inicialirzaForma(){
		usuarioLabel = new JLabel("Usuario:");
		usuarioField = new JTextField();
		passwordLabel = new JLabel("Password:");
		passwordField = new JPasswordField();
		ingresarButton = new JButton("Ingresar a Pixup");
		registrarButton = new JButton("Registrar en Pixup");
		disquerasButton = new JButton("Modulo de Disqueras");
		
		usuarioLabel.setBounds(300, 200, 200, 25);
		usuarioField.setBounds(600, 200, 300, 25);
		
		passwordLabel.setBounds(300, 300, 200, 25);
		passwordField.setBounds(600, 300, 300, 25);
		
		ingresarButton.setBounds(300, 400, 400, 50);
		registrarButton.setBounds(300, 500, 400, 50);
		disquerasButton.setBounds(300, 600, 400, 50);
		
		//Inicializar los Listener de los botones
		agregarRegistrarButtonListener();
		agregarIngresarButtonListener();
		agregarDisquerasButtonListener();
		
	}
	
	private void agregarIngresarButtonListener(){
		ingresarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> errores = validateForm();
				if(!errores.isEmpty()){
					displayMessages(errores);
				} else {
					String login = usuarioField.getText();
					String password = String.valueOf(passwordField.getPassword());
					Usuario usuario = usuarioBO.autenticarUsuario(new Usuario(login, password));
					if(usuario!=null){
						HomeForm homeForm = new HomeForm();
						homeForm.setVisible(true);
						LoginForm.this.dispose();
					} else {
						JOptionPane.showMessageDialog(LoginForm.this, "No se encontró el usuario, favor de validar los datos",
								"Usuario/Password inválidos", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
	
	private void agregarRegistrarButtonListener(){
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistroForm registroForm = new RegistroForm();
				registroForm.setVisible(true);
				registroForm.pack();
				LoginForm.this.dispose();
			}
		});
	}
	
	private void agregarDisquerasButtonListener(){
		disquerasButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DisqueraForm disqueraForm = new DisqueraForm();
				disqueraForm.setVisible(true);
				disqueraForm.pack();
				LoginForm.this.dispose();
			}
		});
	}
	
	private void agregarComponentesPanel(){
		this.add(usuarioLabel);
		this.add(usuarioField);
		this.add(passwordLabel);
		this.add(passwordField);
		this.add(ingresarButton);
		this.add(registrarButton);
		this.add(disquerasButton);
	}
	
	private List<String> validateForm(){
		List<String> errores = new ArrayList<>(2);
		if(usuarioField.getText() == null || usuarioField.getText().isEmpty()){
			errores.add("El campo usuario es requerido");
		}
		if(passwordField.getPassword() == null || String.valueOf(passwordField.getPassword()).isEmpty()){
			errores.add("El campo contraseña es requerido");
		}
		return errores;
	}
	
	private void displayMessages(List<String> mensajes){
		StringBuilder message2Display = new StringBuilder();
		for(String mensaje : mensajes){
			message2Display.append(mensaje).append("\n");
		}
//		if(!message2Display.isEmpty()){
			JOptionPane.showMessageDialog(null, message2Display, "Validación de Datos", JOptionPane.ERROR_MESSAGE);
//		}
	}
	
}
