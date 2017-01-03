package mx.unam.dgscati.pixup.view.desktop.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Utils {
	
	public static void applyLookAndFeel(List<JComponent> componentes){
		for(Component componente : componentes){
			if(componente instanceof JPasswordField){
				componente.setPreferredSize(new Dimension(150, 25));
				componente.setBackground(new Color(0, 0, 102));
				componente.setForeground(new Color(255, 255, 255));
			} else if(componente instanceof JTextField){
				componente.setPreferredSize(new Dimension(200, 25));
				componente.setBackground(new Color(240,248,255));
				componente.setForeground(new Color(255, 50, 255));
			} else if(componente instanceof JLabel){
				componente.setPreferredSize(new Dimension(200,25));
				componente.setBackground(new Color(176,196,222));
				componente.setForeground(new Color(220,20,60));
				((JComponent) componente).setOpaque(true);
			} else if(componente instanceof JComboBox){
				componente.setPreferredSize(new Dimension(200, 25));
				componente.setBackground(new Color(255,250,205));
				componente.setForeground(new Color(0,0,139));
			}
		}
	}
	
	public void addPannel(List<JComponent> componentes,JPanel panel){
		for(JComponent componente : componentes){
			panel.add(componente);
		}
	}

}
