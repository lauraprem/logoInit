package vue.jeux.balle;

import model.EnvironnementTortue;
import vue.FeuilleDessin;

public class FeuilleDessinJeuBalle extends FeuilleDessin {

	public FeuilleDessinJeuBalle(EnvironnementTortue modele) {
		super(modele);
	}

	@Override
	protected void creerDessinTortue() {
		dessinTortue = new DessinTortueJeuBalle();
	}
}
