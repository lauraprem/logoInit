package vue.Extension;

import vue.FeuilleDessin;
import model.EnvironnementTortue;

public class FeuilleDessinExtension extends FeuilleDessin{
	
	public FeuilleDessinExtension(EnvironnementTortue modele) {
		super(modele);
	}

	@Override
	protected void creerDessinTortue() {
		dessinTortue = new DessinTortueExtension();
	}	
}
