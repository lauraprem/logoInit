package vue.jeux.balle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import model.Tortue;
import model.TortueBalle;
import vue.DessinTortue;
import vue.Extension.DessinTortueExtension;

public class DessinTortueJeuBalle extends DessinTortueExtension {

	public DessinTortueJeuBalle() {
		super();
	}

	public void drawTurtle(Graphics graph, Tortue tortue) {
		if (graph == null) {
			return;
		}

		if (tortue instanceof TortueBalle) {
			drawDisque(graph, tortue);
		} else {
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
