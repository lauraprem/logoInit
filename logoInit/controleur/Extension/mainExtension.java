package controleur.Extension;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.EnvironnementTortue;
import model.EnvironnementTortuesAmeliorees;
import vue.FenetrePrincipal;
import vue.Extension.FenetrePrincipalExtension;

public class mainExtension {
	
	public static void main(String[] args) {
		EnvironnementTortuesAmeliorees modele = new EnvironnementTortuesAmeliorees();
		FenetrePrincipalExtension vue= new FenetrePrincipalExtension(modele);

		vue.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				super.windowClosing(arg0);
				System.exit(0);
			}
		});
		vue.setVisible(true);

		ControleurPrincipalExtension controleurPrincipal = new ControleurPrincipalExtension(modele, vue);
	}

	
}
