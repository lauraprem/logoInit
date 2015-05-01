package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EnvironnementTortue;

public class ControleurMenuBas implements ActionListener {

	private EnvironnementTortue tortue;

	public ControleurMenuBas(EnvironnementTortue _t) {
		tortue = _t;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("ControleurMenuBas");
	}

}
