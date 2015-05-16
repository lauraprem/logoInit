package model;

import java.util.ArrayList;
import java.util.Random;

public class JeuDeBalle extends EnvironnementTortuesAmeliorees implements Runnable {

	protected final int maxX = 500;

	protected final int maxY = 400;

	/**
	 * 0 : avancer ; 1 : gauche ; 2 : droite
	 */
	protected int actionTortueCoruante;

	public JeuDeBalle(int nbTortues) {
		super();
		initTortues(nbTortues);

	}

	/**
	 * 
	 * @param action 0 : avancer ; 1 : gauche ; 2 : droite
	 * @return
	 */
	public synchronized void setAction(int action, int vitesse) {
		this.setDis(vitesse);
		this.actionTortueCoruante = action;
	}

	public synchronized void setTortueCouranteJeuDeBalle(int index) {
		if (index != 0 && index < tortues.size()) {
			tortueCourante = index;
		}
	}

	public synchronized void monter(){
		tortues.get(tortueCourante).leverCrayon();
	}
	
	public synchronized void baisser(){
		tortues.get(tortueCourante).baisserCrayon();
	}
	
	private void initTortues(int nbTortues) {
		tortues.clear();
		Random rand = new Random();
		TortueAmelioree t;
		int couleur = 4;
		for (int i = 0; i < nbTortues; i++) {
			if (i == nbTortues / 2) {
				couleur = 1;
			}
			t = new TortueAmelioree(couleur);
			t.setCoor(rand.nextInt(maxX), rand.nextInt(maxY));
			t.leverCrayon();
			tortues.add(t);
			this.ajouterTortuesConnues(t);
		}
		tortues.add(0, new TortueBalle(tortues.get(rand.nextInt(tortues.size())), couleur, 15));
		getBalle().updatePosition();
		tortueCourante = -1;
		actionTortueCoruante = -1;
		NotifierObservateur();
	}

	@Override
	public void run() {
		Random rand = new Random();
		int a;
		while (true) {
			for (int i = 1; i < tortues.size(); i++) {
				if (i != tortueCourante || actionTortueCoruante != -1) {
					if (i == tortueCourante) {
						a = actionTortueCoruante;
						actionTortueCoruante = -1;
					} else {
						// déplacer tortue
						a = rand.nextInt(3);
					}
					// déplacer tortue
					switch (a) {
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
						getBalle().updatePosition();
						for (TortueAmelioree uneTortue : ((TortueAmelioree) tortues.get(i)).getTortuesConnues()) {
							boolean p = getBalle().fairePasse(uneTortue);
							if (p) {
								break;
							}
						}
					}
				}
				this.NotifierObservateur();
			}
			try {
				Thread.currentThread().sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

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

	@Override
	public void reset() {
		initTortues(tortues.size());
	}

}
