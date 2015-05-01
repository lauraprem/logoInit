package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EnvironnementTortue;

public class ControleurCommandes implements ActionListener {

	private EnvironnementTortue model;

	public ControleurCommandes(EnvironnementTortue model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("ControleurCommandes");
		
		switch (ev.getActionCommand()) {
		case "Avancer":
			model.avancerTortue();
			break;	

		default:
			break;
		}
	}
}
