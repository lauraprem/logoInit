package controleur;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import model.Tortue;
import vue.FenetrePrincipal;

public class ControleurPrincipal {
	private Tortue modele;
	private FenetrePrincipal vue;

	/*
	 * public ControleurPrincipal(JeuDeTetris _modele, FenetreJeu _vue) {
	 * super(_modele); vue = _vue;
	 * 
	 * //Listeners des vues vue.getPrincipalPanel().addKeyListener(new
	 * ControleurClavier(modele));
	 * 
	 * // le modele pourra indiquer les mises à jours modele.addObserver(vue);
	 * (new Thread(modele)).start();
	 * 
	 * // rend visible la fenêtre de la vue vue.setVisible(true); }
	 */

	public ControleurPrincipal(Tortue _modele, FenetrePrincipal _vue) {
		modele = _modele;
		vue = _vue;

		for (JMenuItem boutton : vue.getMenuAppli().getListButon()) {
			boutton.addActionListener(new ControleurMenuAppli(modele));
		}
		for (JButton boutton : vue.getMenuBas().getListButon()) {
			boutton.addActionListener(new ControleurMenuBas(modele));
		}
		for (JButton boutton : vue.getMenuHaut().getListButon()) {
			boutton.addActionListener(new ControleurMenuHaut(modele));
		}

	}
}
