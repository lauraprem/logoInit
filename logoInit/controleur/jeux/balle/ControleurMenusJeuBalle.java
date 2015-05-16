package controleur.jeux.balle;

import java.awt.event.ActionEvent;

import model.EnvironnementTortue;
import vue.FenetrePrincipal;
import controleur.Extension.ControleurMenusExtention;

public class ControleurMenusJeuBalle extends ControleurMenusExtention {

	public ControleurMenusJeuBalle(EnvironnementTortue model,
			FenetrePrincipal vue) {
		super(model, vue);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		super.actionPerformed(ev);

		switch (ev.getActionCommand()) {
		case "Start":
			// .run
			System.out.println("Run, Run Foreste !");
			break;
		case "Stop":
			System.out.println("Stop, Stop Foreste !");
			break;
		default:
			break;
		}
	}
}
