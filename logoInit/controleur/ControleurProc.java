package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EnvironnementTortue;

public class ControleurProc implements ActionListener {

	private EnvironnementTortue model;

	public ControleurProc(EnvironnementTortue _model) {
		model = _model;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		switch (ev.getActionCommand()) {
		case "Proc1":
			model.proc1();
			break;
		case "Proc2":
			model.proc2();
			break;
		case "Proc3":
			model.proc3();
			break;

		default:
			break;
		}
	}

}
