package controleur.jeux.balle;

import java.awt.event.ActionEvent;

import controleur.ControleurMenus;
import controleur.Extension.ControleurMenusExtention;
import model.EnvironnementTortue;
import model.EnvironnementTortuesAmeliorees;
import vue.FenetrePrincipal;
import vue.Extension.MenuHautExtension;

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
			//.run
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
