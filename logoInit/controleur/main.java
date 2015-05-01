package controleur;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Tortue;
import vue.FenetrePrincipal;

public class main {
	
	public static void main(String[] args) {
		FenetrePrincipal vue= new FenetrePrincipal();
		Tortue modele = new Tortue();
		
		vue.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				super.windowClosing(arg0);
				System.exit(0);
			}
		});
		vue.setVisible(true);

		ControleurPrincipal controleurPrincipal = new ControleurPrincipal(modele, vue);

		
		
	}

	
}
