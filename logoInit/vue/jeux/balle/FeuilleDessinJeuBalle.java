package vue.jeux.balle;

import vue.FeuilleDessin;
import model.EnvironnementTortue;

public class FeuilleDessinJeuBalle extends FeuilleDessin{
	
	public FeuilleDessinJeuBalle(EnvironnementTortue modele) {
		super(modele);
	}
	
	@Override
	protected void creerDessinTortue() {
		dessinTortue = new DessinTortueBalle();
	}	
}
