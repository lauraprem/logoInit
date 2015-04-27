package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;

import vue.Observateur;

/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 Source originale : J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/2001

 **************************************************************************/

/** La classe Tortue qui se deplace en coordonnees polaires **/

public class Tortue implements Observable {

	// ----------- Attributs statiques -----------\\

	/**
	 * Taille de la pointe de la fleche
	 */
	protected static final int rp = 10;

	/**
	 * Taille de la base de la fleche
	 */
	protected static final int rb = 5;

	/**
	 * Rapport radians/degr�s pour la conversion
	 */
	protected static final double ratioDegRad = 0.0174533;

	// ----------- Attributs -----------\\

	/**
	 * Liste des {@link Segment} qui forment la trace de la tortue
	 */
	protected ArrayList<Segment> listSegments;

	/**
	 * {@link Coordonnees} de la Tortue
	 */
	protected Point coor;						// Coordonnees
	// de la tortue

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

	private ArrayList<Observateur> observateurs;

	// ----------- Constructeur -----------\\

	public Tortue() {
		listSegments = new ArrayList<Segment>();
		observateurs = new ArrayList<Observateur>();
		reset();
	}

	// ----------- Methodes -----------\\

	public void reset() {
		// on initialise la position de la tortue
		coor = new Point();
		dir = -90;
		couleur = new Couleur();
		crayon = true;
		listSegments.clear();
	}

	public void drawTurtle(Graphics graph) {
		if (graph == null) {
			return;
		}

		// Dessine les segments
		for (Iterator<Segment> it = listSegments.iterator(); it.hasNext();) {
			Segment seg = (Segment) it.next();
			seg.drawSegment(graph);
		}

		// Calcule les 3 coins du triangle a partir de
		// la position de la tortue p
		Point p = new Point(coor);
		Polygon arrow = new Polygon();

		// Calcule des deux bases
		// Angle de la droite
		double theta = ratioDegRad * (-dir);
		// Demi angle au sommet du triangle
		double alpha = Math.atan((float) rb / (float) rp);
		// Rayon de la fleche
		double r = Math.sqrt(rp * rp + rb * rb);
		// Sens de la fleche

		// Pointe
		Point p2 = new Point((int) Math.round(p.x + r * Math.cos(theta)), (int) Math.round(p.y - r * Math.sin(theta)));
		arrow.addPoint(p2.x, p2.y);
		arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta + alpha)), (int) Math.round(p2.y + r * Math.sin(theta + alpha)));

		// Base2
		arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta - alpha)), (int) Math.round(p2.y + r * Math.sin(theta - alpha)));

		arrow.addPoint(p2.x, p2.y);
		graph.setColor(Color.green);
		graph.fillPolygon(arrow);
	}

	/** les procedures de base de fonctionnement de la tortue */

	// avancer de n pas
	public void avancer(int dist) {
		int newX = (int) Math.round(coor.getX() + dist * Math.cos(ratioDegRad * dir));
		int newY = (int) Math.round(coor.getY() + dist * Math.sin(ratioDegRad * dir));

		if (crayon == true) {
			Segment seg = new Segment();

			seg.ptStart.x = coor.x;
			seg.ptStart.y = coor.y;
			seg.ptEnd.x = newX;
			seg.ptEnd.y = newY;
			seg.color = couleur.decodeColor();

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

	// ------------ Getter && Setter ------------\\

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
		this.couleur.setCouleur(couleur);
	}

}
