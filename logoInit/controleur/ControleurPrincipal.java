package controleur;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;

import model.EnvironnementTortue;
import vue.FenetrePrincipal;

public class ControleurPrincipal {
	private EnvironnementTortue modele;
	private FenetrePrincipal vue;

	public ControleurPrincipal(EnvironnementTortue _modele, FenetrePrincipal _vue) {
		modele = _modele;
		vue = _vue;

		for (JMenuItem boutton : vue.getMenuAppli().getListButon()) {
			boutton.addActionListener(new ControleurMenuAppli(modele));
		}
		
		for (JComboBox comboBox : vue.getMenuHaut().getComboBox()) {
			comboBox.addActionListener(new ControleurMenuHaut(modele));
		}
		
		for (JButton boutton : vue.getMenuBas().getListButon()) {
			boutton.addActionListener(new ControleurMenuBas(modele));
		}
		for (JButton boutton : vue.getMenuHaut().getListButon()) {
			boutton.addActionListener(new ControleurMenuHaut(modele));
		}

	}
}
