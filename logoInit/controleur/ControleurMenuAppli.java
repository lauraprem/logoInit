package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EnvironnementTortue;

public class ControleurMenuAppli implements ActionListener {

	private EnvironnementTortue model;

	public ControleurMenuAppli(EnvironnementTortue model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("ControleurMenuAppli");
		
		switch (ev.getActionCommand()) {
		case "Quitter":
			System.exit(0);
			break;
		case "Effacer":
//			model.
			break;
		case "Avancer":
			model.avancerTortue();
			break;
		case "Droite":
			model.tournerDroiteTortue();
			break;
		case "Gauche":
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
}
