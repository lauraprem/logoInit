package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import vue.menus.MenuBas;
import vue.menus.MenuFichier;
import vue.menus.MenuHaut;
import model.EnvironnementTortue;
import model.TortueFormesPredefinies;

public class FenetrePrincipal extends JFrame{

	protected MenuFichier menuAppli;
	protected MenuHaut menuHaut;
	protected MenuBas menuBas;
	protected FeuilleDessin feuille;
	protected EnvironnementTortue modele;

	public FenetrePrincipal(EnvironnementTortue modele) {
		super("un logo tout simple");
		
		this.modele = modele;
		
		getContentPane().setLayout(new BorderLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menuAppli = new MenuFichier();
		setJMenuBar(menuAppli);	// on installe le menu bar

		menuHaut = new MenuHaut(modele);
		getContentPane().add(menuHaut, "North");

		menuBas = new MenuBas(new GridLayout());
		getContentPane().add(menuBas, "South");
		
		creerFeuilleDessin();
		
		getContentPane().add(feuille, "Center");

		pack();
		setVisible(true);
	}

	public MenuFichier getMenuAppli() {
		return menuAppli;
	}

	public void setMenuAppli(MenuFichier menubar) {
		this.menuAppli = menubar;
	}

	public MenuHaut getMenuHaut() {
		return menuHaut;
	}

	public void setMenuHaut(MenuHaut menuHaut) {
		this.menuHaut = menuHaut;
	}

	public MenuBas getMenuBas() {
		return menuBas;
	}

	public void setMenuBas(MenuBas menuBas) {
		this.menuBas = menuBas;
	}

	public FeuilleDessin getFeuille() {
		return feuille;
	}

	public void setFeuille(FeuilleDessin feuille) {
		this.feuille = feuille;
	}
	
	protected void creerFeuilleDessin() {
		feuille = new FeuilleDessin(modele);
	}
}
