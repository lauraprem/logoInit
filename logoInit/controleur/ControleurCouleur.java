package controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.EnvironnementTortue;

public class ControleurCouleur implements ActionListener {

	private EnvironnementTortue model;

	public ControleurCouleur(EnvironnementTortue _model) {
		model = _model;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		JComboBox cb = (JComboBox) ev.getSource();
		int n = cb.getSelectedIndex();
		
		model.setCouleur(n);
	}
}
