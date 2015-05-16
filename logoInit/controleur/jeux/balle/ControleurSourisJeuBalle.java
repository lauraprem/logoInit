package controleur.jeux.balle;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.EnvironnementTortue;
import model.JeuDeBalle;
import vue.DessinTortue;
import vue.FenetrePrincipal;
import controleur.ControleurSouris;

public class ControleurSourisJeuBalle extends ControleurSouris{
	
	public ControleurSourisJeuBalle(EnvironnementTortue _model,
			FenetrePrincipal _vue) {
		super(_model, _vue);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {

		// Récupération de la position du click
		Point position = e.getPoint();

		// Recherche si une tortue est sélectionnée
		for (int i = 0; i < model.getTortues().size(); i++) {
			if (position.getX() >= model.getTortues().get(i).getCoor().getX()
					- DessinTortue.getRp()
					&& position.getX() <= model.getTortues().get(i).getCoor()
							.getX()
							+ DessinTortue.getRp()
					&& position.getY() >= model.getTortues().get(i).getCoor()
							.getY()
							- DessinTortue.getRp()
					&& position.getY() <= model.getTortues().get(i).getCoor()
							.getY()
							+ DessinTortue.getRp()) {
				int n = vue.getMenuHaut().getComboBox().get(0)
						.getSelectedIndex();
				((JeuDeBalle)model).setTortueCouranteJeuDeBalle(i);
			}
		}
	}
}
