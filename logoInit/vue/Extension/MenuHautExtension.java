package vue.Extension;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JTextField;

import model.EnvironnementTortue;
import vue.menus.MenuHaut;

public class MenuHautExtension extends MenuHaut {
	protected JTextField StringValue;

	public MenuHautExtension(EnvironnementTortue model) {
		super(model);
		
		toolBar.add(Box.createRigidArea(HGAP));
		addButton(toolBar, "Tortue", "Ajout tortue", null);
		
		toolBar.add(Box.createRigidArea(HGAP));
		StringValue = new JTextField("");
		StringValue.setPreferredSize(new Dimension(80, 5));
		toolBar.add(StringValue);
	}

	public JTextField getStringValue() {
		return StringValue;
	}

	public void setStringValue(JTextField stringValue) {
		StringValue = stringValue;
	}
}