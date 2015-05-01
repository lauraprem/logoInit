package model;

import java.util.ArrayList;

public class EnvironnementTortue {
	private Tortue tortue;
	private Couleur couleurCourante;
	private int dis;
	private ArrayList<Couleur> listCouleur;
	
	public EnvironnementTortue() {
		listCouleur = new ArrayList<Couleur>();
		this.initDefautCouleurs();

		dis = 45;

		tortue = new Tortue();
	}
	
	public Tortue getTortue() {
		return tortue;
	}

	public void setTortue(Tortue tortue) {
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

	public Couleur getCouleurCourante() {
		return couleurCourante;
	}

	public void setCouleurCourante(Couleur couleurCourante) {
		this.couleurCourante = couleurCourante;
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

		couleurCourante = listCouleur.get(5);
	}

	public String[] couleurstoStringChaine() {
		String[] tabColorStrings = new String[listCouleur.size()];
		for (int i = 0; i < listCouleur.size(); i++) {
			tabColorStrings[i] = listCouleur.get(i).toString();
		}

		return tabColorStrings;
	}
}
