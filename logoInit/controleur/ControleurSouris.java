package controleur;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.EnvironnementTortue;
import vue.DessinTortue;
import vue.FenetrePrincipal;

public class ControleurSouris implements MouseListener {

	private EnvironnementTortue model;
	private FenetrePrincipal vue;

	public ControleurSouris(EnvironnementTortue _model,FenetrePrincipal _vue) {
		model = _model;
		vue = _vue;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		// Récupération de la position du click
		Point position = e.getPoint();
		
		// Recherche si une tortue est sélectionnée
		for (int i = 0; i < model.getTortues().size(); i++) {
			if(position.getX()>=model.getTortues().get(i).getCoor().getX()-DessinTortue.getRp()
					&& position.getX()<=model.getTortues().get(i).getCoor().getX()+DessinTortue.getRp()
				&& position.getY()>=model.getTortues().get(i).getCoor().getY()-DessinTortue.getRp()
					&& position.getY()<=model.getTortues().get(i).getCoor().getY()+DessinTortue.getRp()){
				int n = vue.getMenuHaut().getComboBox().get(0).getSelectedIndex();
				model.setTortueCourante(i,n);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
