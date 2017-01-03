package mx.unam.dgscati.pixup.view.desktop;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import mx.unam.dgscati.pixup.bo.DisqueraBO;
import mx.unam.dgscati.pixup.bo.impl.DisqueraBOImpl;
import mx.unam.dgscati.pixup.model.DisqueraVO;
import mx.unam.dgscati.pixup.view.desktop.util.GenericRender;
import mx.unam.dgscati.pixup.view.desktop.util.Utils;

public class DisqueraForm extends JFrame{
	
	private static final long serialVersionUID = 1L;
	//Pestaña Registrar Disquera
	private JLabel 			disqueraRegistroLabel;
	private JTextField 		disqueraRegistroField;
	private JButton			guardarDisqueraButton;
	
	//Pestaña Editar Disquera
	private JLabel 			seleccionaDisqueraLabel;
	private JComboBox<DisqueraVO>	disquerasComboBox;
	private JLabel 			nuevaDisqueraLabel;
	private JTextField		nuevaDisqueraField;
	private JButton			editarDisqueButton;
	
	//Pestaña Eliminar Disquera
	private JLabel 			seleccionaDisqueraDeleteLabel;
	private JComboBox<DisqueraVO>	disquerasDeleteComboBox;
	private JButton			borrarButton;
	
	private JTabbedPane 	pestanias;
	
	private List<JComponent> componentesAdd;
	private List<JComponent> componentesUpdate;
	private List<JComponent> componentesDelete;
	
	Vector<DisqueraVO> vectorDisquera;
	
	private DisqueraBO		disqueraBO;
	
	public DisqueraForm (){
		super();
		disqueraBO = new DisqueraBOImpl();
		
		//Panel de pestañas
		pestanias = new JTabbedPane();
		
		inicializarVentana();
		inicializarForma();
		agregaPanelPestanias();
		
		//Aplicar LookAndFeel
		Utils.applyLookAndFeel(componentesAdd);
		Utils.applyLookAndFeel(componentesUpdate);
		Utils.applyLookAndFeel(componentesDelete);
		
		agregarListeners();
	}
	
	public List<Component> obtieneComponentes(){
		Component[] arrayComponent = this.getComponents();
		return Arrays.asList(arrayComponent);
	}
	
	private void inicializarVentana(){
		this.setTitle("Modulo de Disquera");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));//////
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void inicializarForma(){
		
		disqueraRegistroLabel = new JLabel("Nombre Disquera");
		disqueraRegistroField = new JTextField();
		guardarDisqueraButton = new JButton("Guardar");
		
		//Inicializar forma
		vectorDisquera = new Vector<>();
		vectorDisquera.addAll(disqueraBO.obtenerDisqueras());
		
		seleccionaDisqueraLabel = new JLabel("Seleccione Disquera");
		disquerasComboBox = new JComboBox<DisqueraVO>(vectorDisquera);
		disquerasComboBox.setRenderer(new GenericRender());
		nuevaDisqueraLabel = new JLabel("Nuevo Nombre");
		nuevaDisqueraField = new JTextField();
		editarDisqueButton = new JButton("Editar");
		
		seleccionaDisqueraDeleteLabel = new JLabel("Seleccione Disquera");
		disquerasDeleteComboBox = new JComboBox<DisqueraVO>(vectorDisquera);
		disquerasDeleteComboBox.setRenderer(new GenericRender());
		borrarButton = new JButton("Eliminar");
		
		componentesAdd = Arrays.asList(new JComponent[]{
				disqueraRegistroLabel,disqueraRegistroField,guardarDisqueraButton
		});
		
		componentesUpdate = Arrays.asList(new JComponent[]{
				seleccionaDisqueraLabel,disquerasComboBox,nuevaDisqueraLabel,nuevaDisqueraField,editarDisqueButton
		});
		
		componentesDelete = Arrays.asList(new JComponent[]{
				seleccionaDisqueraDeleteLabel,disquerasDeleteComboBox,borrarButton
		});
		
	}
	
	private void agregaPanelPestanias(){
		
		//Panel Registro Disquera
		JPanel registraDisqueraPanel = obtienePanel(componentesAdd);
		
		//Panel Registro Disquera
		JPanel editaDisqueraPanel = obtienePanel(componentesUpdate);
				
		//Panel Registro Disquera
		JPanel eliminaDisqueraPanel = obtienePanel(componentesDelete);
		
		pestanias.add("Registrar Disquera", registraDisqueraPanel);
		pestanias.add("Actualiza Disquera", editaDisqueraPanel);
		pestanias.add("Eliminar Disquera", eliminaDisqueraPanel);
		
		this.add(pestanias);
	}
	
	private JPanel obtienePanel(List<JComponent> componentes){
		JPanel panel = new JPanel();
		//Panel Registro Disquera
		for(JComponent componente : componentes){
			panel.add(componente);
		}
		return panel;
	}
	
	private void agregarListeners(){
		guardarDisqueraButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!disqueraRegistroField.getText().isEmpty()){
					DisqueraVO disquera = new DisqueraVO();
					disquera.setNombreDisquera(disqueraRegistroField.getText());
					disquera = disqueraBO.registrarDisquera(disquera);
					if(disquera!=null && disquera.getIdDisquera()!=null && disquera.getIdDisquera()>0){
						JOptionPane.showMessageDialog(DisqueraForm.this, "La disquera "+disquera.getNombreDisquera()+" se registró exitosamente.",
								"Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
						actulizaDisqueraCombo();
					} else {
						JOptionPane.showMessageDialog(DisqueraForm.this, "No se pudo registrar la disquera. Contacte a su adminisztrador de sistema",
								"Eror al registrar", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(DisqueraForm.this, "Debe escribir el nombre de la disquera a agregar.",
							"Error al guardar", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		editarDisqueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(disquerasComboBox.getSelectedItem()!=null && !nuevaDisqueraLabel.getText().isEmpty()){
					DisqueraVO disquera = (DisqueraVO) disquerasComboBox.getSelectedItem();
					disquera.setNombreDisquera(nuevaDisqueraField.getText());
					disquera = disqueraBO.actualizarDisquera(disquera);
					if(disquera.getIdDisquera()!=null && disquera.getIdDisquera()>0){
						JOptionPane.showMessageDialog(DisqueraForm.this, "La disquera "+disquera.getNombreDisquera()+" se actualizó exitosamente.",
								"Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
						actulizaDisqueraCombo();
					} else {
						JOptionPane.showMessageDialog(DisqueraForm.this, "No se pudo actualizar la disquera. Contacte a su adminisztrador de sistema",
								"Eror al actualizar", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(DisqueraForm.this, "Debe seleccionar la disquera a editar y \n"
							+ "escribir el nuevo nombre de la disquera a agregar.","Error al guardar", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
				
		borrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(disquerasDeleteComboBox.getSelectedItem()!=null){
					DisqueraVO disquera = (DisqueraVO) disquerasDeleteComboBox.getSelectedItem();
					disqueraBO.borrarDisquera(disquera);
					
					JOptionPane.showMessageDialog(DisqueraForm.this, "La disquera "+disquera.getNombreDisquera()+" se borró exitosamente.",
							"Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
					
					actulizaDisqueraCombo();
					
				} else {
					JOptionPane.showMessageDialog(DisqueraForm.this, "Debe seleccionar la disquera a borrar .",
							"Error al guardar", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public void actulizaDisqueraCombo(){
		vectorDisquera = new Vector<>();
		vectorDisquera.addAll(disqueraBO.obtenerDisqueras());
		disquerasComboBox.removeAllItems();
		disquerasDeleteComboBox.removeAllItems();
		for(DisqueraVO disquera : vectorDisquera){
			disquerasComboBox.addItem(disquera);
//			disquerasDeleteComboBox.addItem(disquera);
		}
		nuevaDisqueraField.setText("");
		disqueraRegistroField.setText("");
	}

}
