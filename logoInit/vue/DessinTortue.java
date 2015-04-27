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
		double alpha = Math.atan((float) tortue.getRb()
				/ (float) tortue.getRp());
		// Rayon de la fleche
		double r = Math.sqrt(tortue.getRp() * tortue.getRp() + tortue.getRb()
				* tortue.getRb());
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
