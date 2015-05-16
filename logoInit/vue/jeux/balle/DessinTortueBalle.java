package vue.jeux.balle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import vue.DessinTortue;
import model.Tortue;
import model.TortueBalle;

public class DessinTortueBalle extends DessinTortue {

	public DessinTortueBalle() {
		super();
	}

	public void drawTurtleSegements(Graphics graph, Tortue tortue) {
		if (graph == null) {
			return;
		}

		// Dessine les segments
		drawSegements(graph, tortue);

		drawTurtle(graph, tortue);
	}
	
	public void drawTurtle(Graphics graph, Tortue tortue) {
		if (graph == null) {
			return;
		}

		// Dessine les segments
		drawSegements(graph, tortue);
		
		if(tortue instanceof TortueBalle){
			drawDisque(graph, tortue);
		}else{
			drawTriangle(graph, tortue);
		}
	}

	public void drawDisque(Graphics graph, Tortue tortue) {
		Point p = new Point(tortue.getCoor());
		Graphics2D g2d = (Graphics2D) graph.create();
		Ellipse2D arrow = new Ellipse2D.Double(p.getX() - (rp / 2), p.getY()
				- (rp / 2), rp, rp);

		graph.setColor(tortue.getCouleurTortue().decodeColor());
		g2d.fill(arrow);
	}
}
