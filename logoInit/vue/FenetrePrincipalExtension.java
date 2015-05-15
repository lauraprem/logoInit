package vue;

import model.EnvironnementTortue;

public class FenetrePrincipalExtension extends FenetrePrincipal{

	public FenetrePrincipalExtension(EnvironnementTortue modele) {
		super(modele);
	}

	@Override
	protected void creerFeuilleDessin() {
		feuille = new FeuilleDessinExtension(modele);
	}
}
