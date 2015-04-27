package vue;

import java.awt.Event;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuAppli extends JMenuBar implements Observateur {
	
	JMenu menuFile;
	JMenu menuCommandes;
	JMenu menuHelp; 
	
	public MenuAppli(){

		menuFile = new JMenu("File"); // on installe le premier menu
		this.add(menuFile);
		addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
		addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);
		

		menuCommandes = new JMenu("Commandes"); // on installe le premier
		this.add(menuCommandes);
		addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
		addMenuItem(menuCommandes, "Droite", "Droite", -1);
		addMenuItem(menuCommandes, "Gauche", "Gauche", -1);
		addMenuItem(menuCommandes, "Lever Crayon", "Lever", -1);
		addMenuItem(menuCommandes, "Baisser Crayon", "Baisser", -1);

		menuHelp = new JMenu("Aide"); // on installe le premier menu
		this.add(menuHelp);
		addMenuItem(menuHelp, "Aide", "Help", -1);
		addMenuItem(menuHelp, "A propos", "About", -1);

		
	}

	public void addMenuItem(JMenu m, String label, String command, int key) {
		JMenuItem menuItem;
		menuItem = new JMenuItem(label);
		m.add(menuItem);

		menuItem.setActionCommand(command);
//		menuItem.addActionListener(this);
		if (key > 0) {
			if (key != KeyEvent.VK_DELETE)
				menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
			else
				menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
		}
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
