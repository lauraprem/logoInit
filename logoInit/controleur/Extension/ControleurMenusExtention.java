package controleur.Extension;

import java.awt.event.ActionEvent;

import model.EnvironnementTortue;
import model.EnvironnementTortuesAmeliorees;
import model.TortueAmelioree;
import vue.FenetrePrincipal;
import vue.Extension.MenuHautExtension;
import controleur.ControleurMenus;

public class ControleurMenusExtention extends ControleurMenus {

	public ControleurMenusExtention(EnvironnementTortue model,
			FenetrePrincipal vue) {
		super(model, vue);
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		switch (ev.getActionCommand()) {
		case "Quitter":
			System.exit(0);
			break;
		case "Effacer":
			((EnvironnementTortuesAmeliorees)model).reset();
			break;
		case "Tortue":
			addTortue();
			break;
		case "Avancer":
			this.setVitesse();
			model.avancerTortue();
			break;
		case "Droite":
			this.setVitesse();
			model.tournerDroiteTortue();
			break;
		case "Gauche":
			this.setVitesse();
			model.tournerGaucheTortue();
			break;
		case "Lever":
			model.monter();
			break;
		case "Baisser":
			model.baisser();
			break;

		default:
			break;
		}
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
