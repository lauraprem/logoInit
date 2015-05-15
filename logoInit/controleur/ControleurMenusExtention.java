package controleur;

import model.EnvironnementTortue;
import model.EnvironnementTortuesAmeliorees;
import vue.FenetrePrincipal;
import vue.menus.MenuHautExtension;

public class ControleurMenusExtention extends ControleurMenus {

	public ControleurMenusExtention(EnvironnementTortue model,
			FenetrePrincipal vue) {
		super(model, vue);
	}

	@Override
	public void addTortue() {
		int n = vue.getMenuHaut().getComboBox().get(0).getSelectedIndex();
		MenuHautExtension menu = (MenuHautExtension)(vue.getMenuHaut());
		String nom = menu.getStringValue().getText();
		((EnvironnementTortuesAmeliorees) model).ajouteTortue(n,nom);
	}
}
