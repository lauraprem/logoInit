package controleur.Extension;

import controleur.ControleurMenus;
import model.EnvironnementTortue;
import model.EnvironnementTortuesAmeliorees;
import vue.FenetrePrincipal;
import vue.Extension.MenuHautExtension;

public class ControleurMenusExtention extends ControleurMenus {

	public ControleurMenusExtention(EnvironnementTortue model,
			FenetrePrincipal vue) {
		super(model, vue);
	}

	@Override
	public void addTortue() {
		int n = vue.getMenuHaut().getComboBox().get(0).getSelectedIndex();
		MenuHautExtension menu = (MenuHautExtension) (vue.getMenuHaut());
		String nom = menu.getStringValue().getText();

		if (nom.equals("")) {
			((EnvironnementTortuesAmeliorees) model).ajouteTortue(n);
		} else {
			((EnvironnementTortuesAmeliorees) model).ajouteTortue(n, nom);
		}
	}
}
