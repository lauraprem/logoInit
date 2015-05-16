package vue.jeux.balle;

import model.EnvironnementTortue;
import vue.FenetrePrincipal;

public class FenetrePrincipalJeuBalle extends FenetrePrincipal {

	public FenetrePrincipalJeuBalle(EnvironnementTortue modele) {
		super(modele);
	}
	
	@Override
	protected void creerFeuilleDessin() {
		feuille = new FeuilleDessinJeuBalle(modele);
	}
	
	@Override
	protected void creerMenuHaut() {
		menuHaut = new MenuHautJeuBalle(modele);
	}
}
