package vue;
// package logo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import model.EnvironnementTortue;
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
//	private ArrayList<Tortue> tortues; // la liste des tortues enregistrees
//	private DessinTortue dessinTortue;
	private EnvironnementTortue modele;
	
	public FeuilleDessin(EnvironnementTortue modele) {
		modele.AjoutObservateur(this);
		
		this.setBackground(Color.white);
		this.setSize(new Dimension(600, 400));
		this.setPreferredSize(new Dimension(600, 400));
		
		this.modele = modele;

//		tortues = new ArrayList<Tortue>();
		
//		dessinTortue = new DessinTortue(modele.getTortueCourante());
//		tortues.add(modele.getTortueCourante());
		
	}

//	public void addTortue(Tortue o) {
//		tortues.add(o);
//	}

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
		for(Iterator it = modele.getTortues().iterator();it.hasNext();) {
			Tortue t = (Tortue) it.next();
//			DessinTortue dessinTortue = new DessinTortue(t);
			DessinTortue.drawTurtle(g, t);
		}
	}

	@Override
	public void Update() {
		repaint();
	}
}
