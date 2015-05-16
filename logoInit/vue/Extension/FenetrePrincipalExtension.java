package vue.Extension;

import model.EnvironnementTortue;
import vue.FenetrePrincipal;

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
