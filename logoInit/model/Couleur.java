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
	private int idCouleur;
	
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
		idCouleur = c;
		nom = n;
	}

	/**
	 * Couleur noir par défaut
	 */
	public Couleur() {
		idCouleur = 0;
		nom = "";
	}
	
	/**
	 * changer de couleur
	 * @param n couleur a mettre
	 */
	public void couleur(int n) {
		idCouleur = n % 12;
	}

	/**
	 * changer de couleur aléatoriement
	 */
	public void couleurSuivante() {
		couleur(idCouleur + 1);
	}

	public int getIdCouleur() {
		return idCouleur;
	}

	public void setIdCouleur(int couleur) {
		this.idCouleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * transforme la couleur int en Color
	 * 
	 * @return la Color équivalente à l'int couleur
	 */
	public Color decodeColor() {
		switch (idCouleur) {
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


	@Override
	public String toString() {
		return nom;
	}
}
