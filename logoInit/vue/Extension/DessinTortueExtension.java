package vue.Extension;

import java.awt.Graphics;

import model.Tortue;
import model.TortueAmelioree;
import vue.DessinTortue;

public class DessinTortueExtension extends DessinTortue {

	public DessinTortueExtension() {
		super();
	}

	@Override
	public void drawTurtle(Graphics graph, Tortue tortue) {
		
		graph.drawString((((TortueAmelioree) tortue).getName()),
				(int) Math.round(tortue.getCoor().getX() + getRb()),
				(int) Math.round(tortue.getCoor().getY()));
	}
}