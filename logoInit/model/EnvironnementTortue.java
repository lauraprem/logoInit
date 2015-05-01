package model;

import java.util.ArrayList;

import vue.Observateur;

public class EnvironnementTortue implements Observable{
	private TortueFromesPredefinies tortue;
	private int dis;
	private ArrayList<Couleur> listCouleur;
	
	private ArrayList<Observateur> observateurs;

	public EnvironnementTortue() {
		observateurs= new ArrayList<Observateur>();
		listCouleur = new ArrayList<Couleur>();
		this.initDefautCouleurs();

		dis = 45;

		tortue = new TortueFromesPredefinies();
	}

	public Tortue getTortue() {
		return tortue;
	}

	public void setTortue(TortueFromesPredefinies tortue) {
		this.tortue = tortue;
	}

	public ArrayList<Couleur> getListCouleur() {
		return listCouleur;
	}

	public void setListCouleur(ArrayList<Couleur> listCouleur) {
		this.listCouleur = listCouleur;
	}

	public void addListCouleur(Couleur couleur) {
		this.listCouleur.add(couleur);
	}

	public int getDis() {
		return dis;
	}

	public void setDis(int dis) {
		this.dis = dis;
	}

	public void initDefautCouleurs() {
		String[] colorStrings = { "noir", "bleu", "cyan", "gris fonce",
				"rouge", "vert", "gris clair", "magenta", "orange", "gris",
				"rose", "jaune" };

		for (int i = 0; i < colorStrings.length; i++) {
			listCouleur.add(new Couleur(i, colorStrings[i]));
		}
	}

	public String[] couleurstoStringChaine() {
		String[] tabColorStrings = new String[listCouleur.size()];
		for (int i = 0; i < listCouleur.size(); i++) {
			tabColorStrings[i] = listCouleur.get(i).toString();
		}

		return tabColorStrings;
	}
	public void proc1() {
		tortue.carre();
		this.NotifierObservateur();
	}

	public void proc2() {
		tortue.poly(60, 8);
		this.NotifierObservateur();
	}

	public void proc3() {
		tortue.spiral(50, 40, 6);
		this.NotifierObservateur();
	}
	
	public void setCouleur(int couleur) {
		tortue.setCouleur(couleur);
		this.NotifierObservateur();
	}
	
	public void reset() {
		tortue.reset();
		this.NotifierObservateur();
	}

	public void avancerTortue() {
		tortue.avancer(dis);
		this.NotifierObservateur();
	}

	public void tournerDroiteTortue() {
		tortue.droite(dis);
		this.NotifierObservateur();
	}

	public void tournerGaucheTortue() {
		tortue.gauche(dis);
		this.NotifierObservateur();
	}

	public void baisser() {
		tortue.baisserCrayon();
		this.NotifierObservateur();
	}

	public void monter() {
		tortue.leverCrayon();
		this.NotifierObservateur();
	}

	@Override
	public void AjoutObservateur(Observateur o) {
		observateurs.add(o);
	}

	@Override
	public void SupprimerObservateur(Observateur o) {
		observateurs.remove(o);
	}

	@Override
	public void NotifierObservateur() {
		for (Observateur obs : observateurs) {
			obs.Update();
		}
	}
}
