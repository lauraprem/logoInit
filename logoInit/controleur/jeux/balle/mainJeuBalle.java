package controleur.jeux.balle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.JeuDeBalle;
import vue.jeux.balle.FenetrePrincipalJeuBalle;

public class mainJeuBalle {

	public static void main(String[] args) {
		JeuDeBalle modele = new JeuDeBalle(8);
		FenetrePrincipalJeuBalle vue = new FenetrePrincipalJeuBalle(modele);

		vue.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				super.windowClosing(arg0);
				System.exit(0);
			}
		});
		vue.setVisible(true);

		ControleurPrincipalJeuBalle controleurPrincipal = new ControleurPrincipalJeuBalle(
				modele, vue);
	}

}