package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import model.EnvironnementTortue;

public class FenetrePrincipal extends JFrame implements Observateur {

	private MenuAppli menuAppli;
	private MenuHaut menuHaut;
	private MenuBas menuBas;

	public FenetrePrincipal(EnvironnementTortue modele) {
		super("un logo tout simple");
		
		modele.AjoutObservateur(this);
		
		getContentPane().setLayout(new BorderLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menuAppli = new MenuAppli(modele);
		setJMenuBar(menuAppli);	// on installe le menu bar

		menuHaut = new MenuHaut(modele);
		getContentPane().add(menuHaut, "North");

		menuBas = new MenuBas(new GridLayout(),modele);
		getContentPane().add(menuBas, "South");

		FeuilleDessin feuille = new FeuilleDessin(modele);

		getContentPane().add(feuille, "Center");

		pack();
		setVisible(true);
	}

	public MenuAppli getMenuAppli() {
		return menuAppli;
	}

	public void setMenuAppli(MenuAppli menubar) {
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

	@Override
	public void Update() {
		// TODO
		System.out.println("Update Principale");
	}
}
