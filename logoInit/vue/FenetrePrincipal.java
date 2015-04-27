package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetrePrincipal extends JFrame implements Observateur {

	private MenuAppli menubar;
	private MenuHaut menuHaut;
	private MenuBas menuBas;
	
	public FenetrePrincipal() {
		super("un logo tout simple");
		getContentPane().setLayout(new BorderLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menubar = new MenuAppli();
		setJMenuBar(menubar);	// on installe le menu bar
		
		menuHaut = new MenuHaut();
		getContentPane().add(menuHaut, "North");
		
		menuBas = new MenuBas(new GridLayout());
		getContentPane().add(menuBas, "South");
		
		FeuilleDessin feuille = new FeuilleDessin();
		
		getContentPane().add(feuille, "Center");
		
		pack();
		setVisible(true);
	}

	public MenuAppli getMenubar() {
		return menubar;
	}

	public void setMenubar(MenuAppli menubar) {
		this.menubar = menubar;
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
		// TODO Auto-generated method stub
		
	}
}
