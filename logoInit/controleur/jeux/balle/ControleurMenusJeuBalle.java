package controleur.jeux.balle;

import java.awt.event.ActionEvent;

import model.EnvironnementTortue;
import model.JeuDeBalle;
import vue.FenetrePrincipal;
import controleur.Extension.ControleurMenusExtention;

public class ControleurMenusJeuBalle extends ControleurMenusExtention {

	public ControleurMenusJeuBalle(EnvironnementTortue model,
			FenetrePrincipal vue) {
		super(model, vue);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
//		super.actionPerformed(ev);

		switch (ev.getActionCommand()) {
		case "Avancer":
			this.setVitesse();
			((JeuDeBalle)model).setAction(0);
			break;
		case "Droite":
			this.setVitesse();
			((JeuDeBalle)model).setAction(2);
			break;
		case "Gauche":
			this.setVitesse();
			((JeuDeBalle)model).setAction(1);
			break;
		case "Start":
			(new Thread((JeuDeBalle) model)).start();
			System.out.println("Run, Run Foreste !");
			break;
		case "Stop":
			(new Thread((JeuDeBalle) model)).stop();
			System.out.println("Stop, Stop Foreste !");
			break;
		default:
			break;
		}
	}
}
