package controleur.jeux.balle;

import java.awt.event.ActionEvent;

import model.EnvironnementTortue;
import model.JeuDeBalle;
import vue.FenetrePrincipal;
import controleur.ControleurMenus;

public class ControleurMenusJeuBalle extends ControleurMenus {

	public ControleurMenusJeuBalle(EnvironnementTortue model,
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
			((JeuDeBalle)model).reset();
			break;
		case "Avancer":
			((JeuDeBalle)model).setAction(0,this.setVitesse());
			break;
		case "Droite":
			((JeuDeBalle)model).setAction(2,this.setVitesse());
			break;
		case "Gauche":
			((JeuDeBalle)model).setAction(1,this.setVitesse());
			break;
		case "Start":
			(new Thread((JeuDeBalle) model)).start();
			break;
		case "Lever":
			((JeuDeBalle)model).monter();
			break;
		case "Baisser":
			((JeuDeBalle)model).baisser();
			break;

		default:
			break;
		}
	}
}
