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
			System.out.println("QUITTER");
			System.exit(0);
			break;

		default:
			break;
		}
	}
}
