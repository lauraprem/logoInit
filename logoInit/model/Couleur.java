package model;

import java.awt.Color;

/**
 * 
 * @author Laura & Corinne
 *
 */
public class Couleur {

	/**
	 * une couleur représenté par un entier
	 */
	private int couleur;
	
	/**
	 * une couleur représenté par un nom
	 */
	private String nom;
	
	/**
	 *  construteur paramétré
	 * @param c
	 * @param nom
	 */
	public Couleur(int c, String n) {
		couleur = c;
		nom = n;
	}

	/**
	 * Couleur noir par défaut
	 */
	public Couleur() {
		couleur = 0;
		nom = "";
	}

	/**
	 * transforme la couleur int en Color
	 * @return la Color équivalente à l'int couleur
	 */
	public Color decodeColor() {
		switch (couleur) {
			case 0:
				return (Color.black);
			case 1:
				return (Color.blue);
			case 2:
				return (Color.cyan);
			case 3:
				return (Color.darkGray);
			case 4:
				return (Color.red);
			case 5:
				return (Color.green);
			case 6:
				return (Color.lightGray);
			case 7:
				return (Color.magenta);
			case 8:
				return (Color.orange);
			case 9:
				return (Color.gray);
			case 10:
				return (Color.pink);
			case 11:
				return (Color.yellow);
			default:
				return (Color.black);
		}
	}

	/**
	 * changer de couleur
	 * @param n couleur a mettre
	 */
	public void couleur(int n) {
		couleur = n % 12;
	}

	/**
	 * changer de couleur aléatoriement
	 */
	public void couleurSuivante() {
		couleur(couleur + 1);
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}
}
