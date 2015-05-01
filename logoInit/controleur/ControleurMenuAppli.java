package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Tortue;

public class ControleurMenuAppli implements ActionListener {

	private Tortue tortue;

	public ControleurMenuAppli(Tortue _t) {
		tortue = _t;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("ControleurMenuAppli");
//		if (ev.getActionCommand() == "Quitter") {
//			System.out.println("QUITTER");
//			System.exit(0);
//		}
	}

}
