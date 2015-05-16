package vue.jeux.balle;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JTextField;

import vue.Extension.MenuHautExtension;
import vue.menus.MenuHaut;
import model.EnvironnementTortue;

public class MenuHautJeuBalle extends MenuHautExtension{
	protected JTextField StringValue;

	public MenuHautJeuBalle(EnvironnementTortue model) {
		super(model);
		
		addButton(toolBar, "Start", "Commencer une partie", null);
	}
}