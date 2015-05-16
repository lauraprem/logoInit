package controleur.Extension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import controleur.ControleurPrincipal;
import model.EnvironnementTortue;
import vue.FenetrePrincipal;

public class ControleurPrincipalExtension extends ControleurPrincipal {

	public ControleurPrincipalExtension(EnvironnementTortue _modele,
			FenetrePrincipal _vue) {
		super(_modele, _vue);
	}

	@Override
	public void AddControleurMenu() {
		for (JMenuItem boutton : vue.getMenuAppli().getListButon()) {
			boutton.addActionListener(new ControleurMenusExtention(modele,vue));
		}
		
		for (JButton boutton : vue.getMenuHaut().getListButon()) {
			boutton.addActionListener(new ControleurMenusExtention(modele,vue));
		}
	}

}