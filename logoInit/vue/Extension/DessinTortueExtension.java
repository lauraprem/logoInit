package vue.Extension;

import java.awt.Graphics;

import vue.DessinTortue;
import model.Tortue;
import model.TortueAmelioree;

public class DessinTortueExtension extends DessinTortue {

	public DessinTortueExtension() {
		super();
	}

	@Override
	public void drawTurtleSegements(Graphics graph, Tortue tortue) {
		super.drawTurtleSegements(graph, tortue);
		graph.drawString((((TortueAmelioree) tortue).getName()), (int) Math.round(tortue.getCoor().getX()+getRb()), (int) Math.round(tortue.getCoor().getY()));
	}
}