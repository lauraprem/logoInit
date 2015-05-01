package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import vue.Observateur;

/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 Source originale : J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/2001

 **************************************************************************/

/** La classe Tortue qui se deplace en coordonnees polaires **/

public class Tortue {

	// ----------- Attributs statiques -----------\\
	/**
	 * Rapport radians/degr�s pour la conversion
	 */
	protected static final double ratioDegRad = 0.0174533;

	// ----------- Attributs -----------\\

	/**
	 * Direction de la tortue (angle en degr�)
	 */
	protected int dir;

	/**
	 * true lorsque le crayon est baiss�, faux s'il est lev�. True par d�faut
	 */
	protected boolean crayon;

	/**
	 * Couleur du trait
	 */
	protected Couleur couleur;

	/**
	 * {@link Coordonnees} de la Tortue
	 */
	protected Point coor; // Coordonnees
	// de la tortue

	private ArrayList<Observateur> observateurs;

	/**
	 * Liste des {@link Segment} qui forment la trace de la tortue
	 */
	protected ArrayList<Segment> listSegments;

	// ----------- Constructeur -----------\\
	public Tortue() {
		listSegments = new ArrayList<Segment>();
		observateurs = new ArrayList<Observateur>();
		reset();
	}

	// ------------ Getter && Setter ------------\\
	public Point getCoor() {
		return coor;
	}

	public void setCoor(Point coor) {
		this.coor = coor;
	}

	public void setCoor(int x, int y) {
		this.coor.x = x;
		this.coor.y = y;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur.setIdCouleur(couleur);
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public boolean isCrayon() {
		return crayon;
	}

	public void setCrayon(boolean crayon) {
		this.crayon = crayon;
	}

	public ArrayList<Segment> getListSegments() {
		return listSegments;
	}

	public void setListSegments(ArrayList<Segment> listSegments) {
		this.listSegments = listSegments;
	}

	public static double getRatiodegrad() {
		return ratioDegRad;
	}

	// ----------- Methodes -----------\\
	public void reset() {
		// on initialise la position de la tortue
		coor = new Point(500 / 2, 400 / 2);
		dir = -90;
		couleur = new Couleur();
		crayon = true;
		listSegments.clear();
	}

	/** les procedures de base de fonctionnement de la tortue */

	// avancer de n pas
	public void avancer(int dist) {
		int newX = (int) Math.round(coor.getX() + dist
				* Math.cos(ratioDegRad * dir));
		int newY = (int) Math.round(coor.getY() + dist
				* Math.sin(ratioDegRad * dir));

		if (crayon == true) {
			Segment seg = new Segment();

			seg.getPtStart().x = coor.x;
			seg.getPtStart().y = coor.y;
			seg.getPtEnd().x = newX;
			seg.getPtEnd().y = newY;
			seg.setColor(couleur.decodeColor());

			listSegments.add(seg);
		}

		coor.x = newX;
		coor.y = newY;
	}

	// aller a droite
	public void droite(int ang) {
		dir = (dir + ang) % 360;
	}

	// aller a gauche
	public void gauche(int ang) {
		dir = (dir - ang) % 360;
	}

	// baisser le crayon pour dessiner
	public void baisserCrayon() {
		crayon = true;
	}

	// lever le crayon pour ne plus dessiner
	public void leverCrayon() {
		crayon = false;
	}
}
