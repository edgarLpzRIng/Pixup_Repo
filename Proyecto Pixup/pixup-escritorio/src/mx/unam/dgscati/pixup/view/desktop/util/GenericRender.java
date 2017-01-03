package mx.unam.dgscati.pixup.view.desktop.util;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import mx.unam.dgscati.pixup.model.Catalogo;
import mx.unam.dgscati.pixup.model.Colonia;
import mx.unam.dgscati.pixup.model.DisqueraVO;

public class GenericRender extends BasicComboBoxRenderer {
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if(value != null){
			if(value instanceof Catalogo){
				Catalogo catalogo = (Catalogo)value;
				setText(catalogo.getDescripcion());
			} else if(value instanceof Colonia){
				Colonia colonia = (Colonia)value;
				setText(colonia.getNombre());
			} else if(value instanceof DisqueraVO){
				DisqueraVO disquera = (DisqueraVO) value;
				setText(disquera.getNombreDisquera());
			}
		}
		return this;
	}

}
