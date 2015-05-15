package vue;

import model.EnvironnementTortue;
import vue.menus.MenuHautExtension;

public class FenetrePrincipalExtension extends FenetrePrincipal {

	public FenetrePrincipalExtension(EnvironnementTortue modele) {
		super(modele);
	}
	
	@Override
	protected void creerFeuilleDessin() {
		feuille = new FeuilleDessinExtension(modele);
	}
	
	@Override
	protected void creerMenuHaut() {
		menuHaut = new MenuHautExtension(modele);
	}
}
