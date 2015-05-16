package vue.jeux.balle;

import javax.swing.JTextField;

import model.EnvironnementTortue;
import vue.Extension.MenuHautExtension;

public class MenuHautJeuBalle extends MenuHautExtension {
	protected JTextField StringValue;

	public MenuHautJeuBalle(EnvironnementTortue model) {
		super(model);

		addButton(toolBar, "Start", "Commencer une partie", null);
		addButton(toolBar, "Stop", "Arrêter une partie", null);
	}
}