package model;

import java.util.ArrayList;

import vue.Observateur;

public class EnvironnementTortue implements Observable {
	private TortueFormesPredefinies tortueCourante;
	private int dis;
	private ArrayList<Couleur> listCouleur;

	private ArrayList<Observateur> observateurs;

	private ArrayList<TortueFormesPredefinies> tortues;

	public EnvironnementTortue() {
		observateurs = new ArrayList<Observateur>();
		listCouleur = new ArrayList<Couleur>();
		tortues = new ArrayList<TortueFormesPredefinies>();
		this.initDefautCouleurs();
		
		dis = 45;

		tortueCourante = new TortueFormesPredefinies();
	}

	public Tortue getTortueCourante() {
		return tortueCourante;
	}

	public void setTortueCourante(TortueFormesPredefinies tortue) {
		this.tortueCourante = tortue;
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
	
	public ArrayList<TortueFormesPredefinies> getTortues() {
		return tortues;
	}

	public void setTortues(ArrayList<TortueFormesPredefinies> tortues) {
		this.tortues = tortues;
	}

	public void ajouteTortue(TortueFormesPredefinies t){
		this.tortues.add(t);
	}
	
	public void suprimeTortue(TortueFormesPredefinies t){
		this.tortues.remove(t);
	}
	
	public void initDefautCouleurs() {
		String[] colorStrings = { "noir", "bleu", "cyan", "gris fonce", "rouge", "vert", "gris clair", "magenta", "orange", "gris", "rose", "jaune" };

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
		tortueCourante.carre();
		this.NotifierObservateur();
	}

	public void proc2() {
		tortueCourante.poly(60, 8);
		this.NotifierObservateur();
	}

	public void proc3() {
		tortueCourante.spiral(50, 40, 6);
		this.NotifierObservateur();
	}

	public void setCouleur(int couleur) {
		tortueCourante.setCouleur(couleur);
		this.NotifierObservateur();
	}

	public void reset() {
		tortueCourante.reset();
		this.NotifierObservateur();
	}

	public void avancerTortue() {
		tortueCourante.avancer(dis);
		this.NotifierObservateur();
	}

	public void tournerDroiteTortue() {
		tortueCourante.droite(dis);
		this.NotifierObservateur();
	}

	public void tournerGaucheTortue() {
		tortueCourante.gauche(dis);
		this.NotifierObservateur();
	}

	public void baisser() {
		tortueCourante.baisserCrayon();
		this.NotifierObservateur();
	}

	public void monter() {
		tortueCourante.leverCrayon();
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
