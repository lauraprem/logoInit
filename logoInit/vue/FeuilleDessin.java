package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import model.EnvironnementTortue;
import model.Tortue;

/**
 * Titre : Logo Description : Un exemple de programme graphique utilisant la
 * celebre Tortue Logo Copyright : Copyright (c) 2000 Societe : LIRMM
 * 
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel implements Observateur {
	protected DessinTortue dessinTortue;
	protected EnvironnementTortue modele;

	public FeuilleDessin(EnvironnementTortue modele) {
		this.modele = modele;
		this.modele.AjoutObservateur(this);

		this.setBackground(Color.white);
		this.setSize(new Dimension(600, 400));
		this.setPreferredSize(new Dimension(600, 400));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();

		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(c);

		showTurtles(g);
	}

	public void showTurtles(Graphics g) {
		creerDessinTortue();
		for (Iterator it = modele.getTortues().iterator(); it.hasNext();) {
			Tortue t = (Tortue) it.next();
			dessinTortue.drawTurtleSegements(g, t);
		}
	}

	@Override
	public void Update() {
		repaint();
	}

	protected void creerDessinTortue() {
		dessinTortue = new DessinTortue();
	}
}
