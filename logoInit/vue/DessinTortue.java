package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;

import model.Segment;
import model.Tortue;

public class DessinTortue {
	/**
	 * Taille de la pointe de la fleche
	 */
	protected static final int rp = 10;

	/**
	 * Taille de la base de la fleche
	 */
	protected static final int rb = 5;
	
	private Tortue tortue;

	public DessinTortue(Tortue tortue) {
		super();
		this.tortue = tortue;
	}

	public void drawTurtle(Graphics graph) {
		if (graph == null) {
			return;
		}

		// Dessine les segments
		for (Iterator<Segment> it = tortue.getListSegments().iterator(); it
				.hasNext();) {
			Segment seg = (Segment) it.next();
			seg.drawSegment(graph);
		}

		// Calcule les 3 coins du triangle a partir de
		// la position de la tortue p
		Point p = new Point(tortue.getCoor());
		Polygon arrow = new Polygon();

		// Calcule des deux bases
		// Angle de la droite
		double theta = tortue.getRatiodegrad() * (-tortue.getDir());
		// Demi angle au sommet du triangle
		double alpha = Math.atan((float) rb
				/ (float) rp);
		// Rayon de la fleche
		double r = Math.sqrt(rp * rp + rb
				* rb);
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
}
