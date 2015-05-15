package vue.menus;

import javax.swing.Box;
import javax.swing.JTextField;

import model.EnvironnementTortue;

public class MenuHautExtension extends MenuHaut{
	protected JTextField StringValue;

	public MenuHautExtension(EnvironnementTortue model) {
		super(model);
		
		toolBar.add(Box.createRigidArea(HGAP));
		StringValue = new JTextField("                                  ");
		toolBar.add(StringValue);
	}

	public JTextField getStringValue() {
		return StringValue;
	}

	public void setStringValue(JTextField stringValue) {
		StringValue = stringValue;
	}
}