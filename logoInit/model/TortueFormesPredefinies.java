package model;

public class TortueFormesPredefinies extends Tortue {

	public TortueFormesPredefinies() {
		super();
	}
	
	public TortueFormesPredefinies(int couleur){
		super(couleur);
	}

	public void carre() {
		for (int i = 0; i < 4; i++) {
			avancer(100);
			droite(90);
		}
	}

	public void poly(int n, int a) {
		for (int j = 0; j < a; j++) {
			avancer(n);
			droite(360 / a);
		}
	}

	public void spiral(int n, int k, int a) {
		for (int i = 0; i < k; i++) {
			couleurTrait.couleurSuivante();
			avancer(n);
			droite(360 / a);
			n = n + 1;
		}
	}
}
