package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;

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
	 * Taille de la pointe de la fleche
	 */
	protected static final int rp = 10;

	/**
	 * Taille de la base de la fleche
	 */
	protected static final int rb = 5;

	/**
	 * Rapport radians/degrés pour la conversion
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
	protected Coordonnees coor; // Coordonnees de la tortue

	/**
	 * Direction de la tortue (angle en degré)
	 */
	protected int dir;

	/**
	 * true lorsque le crayon est baissé, faux s'il est levé. True par défaut
	 */
	protected boolean crayon;

	/**
	 * Couleur du trait
	 */
	protected int coul;

	// ----------- Constructeur -----------\\

	public Tortue() {
		listSegments = new ArrayList<Segment>();
		reset();
	}

	// ----------- Methodes -----------\\

	public void reset() {
		// on initialise la position de la tortue
		coor = new Coordonnees();
		dir = -90;
		coul = 0;
		crayon = true;
		listSegments.clear();
	}

	public void drawTurtle(Graphics graph) {
		if (graph == null) {
			return;
		}

		// Dessine les segments
		for (Iterator it = listSegments.iterator(); it.hasNext();) {
			Segment seg = (Segment) it.next();
			seg.drawSegment(graph);
		}

		// Calcule les 3 coins du triangle a partir de
		// la position de la tortue p
		Point p = new Point(coor.getX(), coor.getY());
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
		Point p2 = new Point((int) Math.round(p.x + r * Math.cos(theta)),
				(int) Math.round(p.y - r * Math.sin(theta)));
		arrow.addPoint(p2.x, p2.y);
		arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta + alpha)),
				(int) Math.round(p2.y + r * Math.sin(theta + alpha)));

		// Base2
		arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta - alpha)),
				(int) Math.round(p2.y + r * Math.sin(theta - alpha)));

		arrow.addPoint(p2.x, p2.y);
		graph.setColor(Color.green);
		graph.fillPolygon(arrow);
	}

	protected Color decodeColor(int c) {
		switch (c) {
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

	/** les procedures de base de fonctionnement de la tortue */

	// avancer de n pas
	public void avancer(int dist) {
		int newX = (int) Math.round(coor.getX() + dist
				* Math.cos(ratioDegRad * dir));
		int newY = (int) Math.round(coor.getY() + dist
				* Math.sin(ratioDegRad * dir));

		if (crayon == true) {
			Segment seg = new Segment();

			seg.ptStart.x = coor.getX();
			seg.ptStart.y = coor.getY();
			seg.ptEnd.x = newX;
			seg.ptEnd.y = newY;
			seg.color = decodeColor(coul);

			listSegments.add(seg);
		}

		coor.setX(newX);
		coor.setY(newY);
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

	// pour changer de couleur de dessin
	public void couleur(int n) {
		coul = n % 12;
	}

	public void couleurSuivante() {
		couleur(coul + 1);
	}

	/** quelques classiques */

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
			couleur(coul + 1);
			avancer(n);
			droite(360 / a);
			n = n + 1;
		}
	}

	// ------------ Getter && Setter ------------\\

	public Coordonnees getCoor() {
		return coor;
	}

	public void setCoor(Coordonnees coor) {
		this.coor = coor;
	}

	public void setCoor(int x, int y) {
		this.coor.setX(x);
		this.coor.setY(y);
	}

	public void setColor(int n) {
		coul = n;
	}

	public int getColor() {
		return coul;
	}

}
