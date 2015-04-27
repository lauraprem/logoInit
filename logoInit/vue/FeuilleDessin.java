package vue;
// package logo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import model.Tortue;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre Tortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel implements Observateur {
	private ArrayList<Tortue> tortues; // la liste des tortues enregistrees
	private Tortue tortue;
	private DessinTortue dessinTortue;
	
	public FeuilleDessin() {
		this.setBackground(Color.white);
		this.setSize(new Dimension(600, 400));
		this.setPreferredSize(new Dimension(600, 400));

		tortues = new ArrayList<Tortue>();
		
		// Deplacement de la tortue au centre de la feuille
		tortue = new Tortue();
		tortue.setCoor(500 / 2, 400 / 2);
		dessinTortue = new DessinTortue(tortue);
		tortues.add(tortue);
		
	}

	public void addTortue(Tortue o) {
		tortues.add(o);
	}

	public void reset() {
		for (Iterator it = tortues.iterator();it.hasNext();) {
			Tortue t = (Tortue) it.next();
			t.reset();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
		g.setColor(c);

		showTurtles(g);
		
		
		
	}
	
	public void showTurtles(Graphics g) {
		for(Iterator it = tortues.iterator();it.hasNext();) {
			Tortue t = (Tortue) it.next();
			
			// ajouuuuuuuuuuuut
			dessinTortue.drawTurtle(g);
		}
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}
}
