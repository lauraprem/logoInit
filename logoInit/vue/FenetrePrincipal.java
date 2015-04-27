package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FenetrePrincipal extends JFrame implements Observateur {
	
	private JTextField inputValue;

	public FenetrePrincipal() {
		super("un logo tout simple");
		getContentPane().setLayout(new BorderLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MenuAppli menubar = new MenuAppli();
		setJMenuBar(menubar);	// on installe le menu bar
		
		MenuHaut menuHaut = new MenuHaut();
		getContentPane().add(menuHaut, "North");
		
		MenuBas menuBas = new MenuBas(new GridLayout());
		getContentPane().add(menuBas, "South");
		
		FeuilleDessin feuille = new FeuilleDessin();
		
		getContentPane().add(feuille, "Center");
		
		pack();
		setVisible(true);
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
