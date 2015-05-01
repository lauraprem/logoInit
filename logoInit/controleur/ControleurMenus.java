package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EnvironnementTortue;
import vue.FenetrePrincipal;

public class ControleurMenus implements ActionListener {

	private EnvironnementTortue model;
	private FenetrePrincipal vue;

	public ControleurMenus(EnvironnementTortue model, FenetrePrincipal vue) {
		this.model = model;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		switch (ev.getActionCommand()) {
		case "Quitter":
			System.exit(0);
			break;
		case "Effacer":
			model.reset();
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

	public void setVitesse() {
		try {
			int v = Integer.parseInt(vue.getMenuHaut().getInputValue()
					.getText());
			model.setDis(v);
		} catch (NumberFormatException ex) {
			System.err.println("ce n'est pas un nombre : "
					+ vue.getMenuHaut().getInputValue().getText());
		}
	}
}
