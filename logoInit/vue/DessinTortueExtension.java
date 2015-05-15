package vue;

import java.awt.Graphics;

import model.Tortue;
import model.TortueAmelioree;

public class DessinTortueExtension extends DessinTortue {

	public DessinTortueExtension() {
		super();
	}

	@Override
	public void drawTurtle(Graphics graph, Tortue tortue) {
		super.drawTurtle(graph, tortue);
		graph.drawString((((TortueAmelioree) tortue).getName()), (int) Math.round(tortue.getCoor().getX()+getRb()), (int) Math.round(tortue.getCoor().getY()));
	}
}