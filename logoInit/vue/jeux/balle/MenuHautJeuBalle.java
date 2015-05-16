package vue.jeux.balle;

import javax.swing.JTextField;

import model.EnvironnementTortue;
import vue.menus.MenuHaut;

public class MenuHautJeuBalle extends MenuHaut {
	protected JTextField StringValue;

	public MenuHautJeuBalle(EnvironnementTortue model) {
		super(model);

		addButton(toolBar, "Start", "Commencer une partie", null);
	}
}