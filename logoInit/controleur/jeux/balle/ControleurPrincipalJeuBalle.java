package controleur.jeux.balle;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import model.EnvironnementTortue;
import vue.FenetrePrincipal;
import controleur.Extension.ControleurPrincipalExtension;

public class ControleurPrincipalJeuBalle extends ControleurPrincipalExtension {

	public ControleurPrincipalJeuBalle(EnvironnementTortue _modele,
			FenetrePrincipal _vue) {
		super(_modele, _vue);
	}

	@Override
	public void AddControleurMenu() {
		for (JMenuItem boutton : vue.getMenuAppli().getListButon()) {
			boutton.addActionListener(new ControleurMenusJeuBalle(modele, vue));
		}

		for (JButton boutton : vue.getMenuHaut().getListButon()) {
			boutton.addActionListener(new ControleurMenusJeuBalle(modele, vue));
		}
	}
}