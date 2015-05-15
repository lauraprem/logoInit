package controleur;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import model.EnvironnementTortue;
import vue.FenetrePrincipal;

public class ControleurPrincipal {
	private EnvironnementTortue modele;
	private FenetrePrincipal vue;

	public ControleurPrincipal(EnvironnementTortue _modele,
			FenetrePrincipal _vue) {
		modele = _modele;
		vue = _vue;

		for (JMenuItem boutton : vue.getMenuAppli().getListButon()) {
			boutton.addActionListener(new ControleurMenus(modele,vue));
		}
		
		for (JButton boutton : vue.getMenuHaut().getListButon()) {
			boutton.addActionListener(new ControleurMenus(modele,vue));
		}
		
		for (JComboBox comboBox : vue.getMenuHaut().getComboBox()) {
			comboBox.addActionListener(new ControleurCouleur(modele));
		}
		for (JButton boutton : vue.getMenuBas().getListButon()) {
			boutton.addActionListener(new ControleurProc(modele));
		}
		
		//Listeners sur le feuille
        vue.getFeuille().addMouseListener(new ControleurSouris(modele,vue));

	}
}
