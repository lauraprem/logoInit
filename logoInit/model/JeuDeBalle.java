package model;

import java.util.ArrayList;
import java.util.Random;

public class JeuDeBalle extends EnvironnementTortuesAmeliorees implements Runnable {

	protected final int maxX = 500;

	protected final int maxY = 400;

	public JeuDeBalle(int nbTortues) {
		super();
		initTortues(nbTortues);
	}

	private void initTortues(int nbTortues) {
		tortues.clear();
		Random rand = new Random();
		TortueAmelioree t;
		int couleur = 5;
		for (int i = 0; i < nbTortues; i++) {
			if (i == nbTortues / 2) {
				couleur = 2;
			}
			t = new TortueAmelioree(couleur);
			t.setCoor(rand.nextInt(maxX), rand.nextInt(maxY));
			t.leverCrayon();
			tortues.add(t);
		}
		tortues.add(0, new TortueBalle(tortues.get(rand.nextInt(tortues.size())), couleur, 15));
		tortueCourante = -1;
	}

	@Override
	public void run() {
		Random rand = new Random();
		int action;
		while (true) {
			for (int i = 1; i < tortues.size(); i++) {
				if (i != tortueCourante) {
					//déplacert tortue
					action = rand.nextInt(3);
					switch (action) {
						case 0:
							tortues.get(i).avancer(dis);
							break;
						case 1:
							tortues.get(i).gauche(dis);
							break;
						case 2:
							tortues.get(i).droite(dis);
					}
					// si possesseuse balle, faire passe
					if (tortues.get(i).equals(getBalle().getPossesseur())) {
						for (TortueAmelioree uneTortue : ((TortueAmelioree) tortues.get(i)).getTortuesConnues()) {
							if (getBalle().fairePasse(uneTortue)) {
								break;
							}
						}
					}
					this.NotifierObservateur();
				}
			}
		}
	}

	// private void deplacerTortuesAleatoirement() {
	// Random rand = new Random();
	// int action;
	// for (int i = 1; i < tortues.size(); i++) {
	// action = rand.nextInt(3);
	// switch (action) {
	// case 0:
	// tortues.get(i).avancer(dis);
	// break;
	// case 1:
	// tortues.get(i).gauche(dis);
	// break;
	// case 2:
	// tortues.get(i).droite(dis);
	// }
	// if (tortues.get(i).equals(getBalle().getPossesseur())) {
	// for (TortueAmelioree uneTortue : ((TortueAmelioree)
	// tortues.get(i)).getTortuesConnues()) {
	// if(getBalle().fairePasse(tortues.get(i))){
	// break;
	// }
	// }
	// }
	// }
	// }

	public ArrayList<TortueFormesPredefinies> getTortues() {
		return tortues;
	}

	public void setTortues(ArrayList<TortueFormesPredefinies> tortues) {
		this.tortues = tortues;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public TortueBalle getBalle() {
		return (TortueBalle) tortues.get(0);
	}

}
