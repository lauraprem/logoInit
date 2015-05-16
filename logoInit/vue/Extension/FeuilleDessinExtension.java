package vue.Extension;

import model.EnvironnementTortue;
import vue.FeuilleDessin;

public class FeuilleDessinExtension extends FeuilleDessin {

	public FeuilleDessinExtension(EnvironnementTortue modele) {
		super(modele);
	}

	@Override
	protected void creerDessinTortue() {
		dessinTortue = new DessinTortueExtension();
	}
}
