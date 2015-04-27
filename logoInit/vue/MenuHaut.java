package vue;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MenuHaut extends JPanel implements Observateur {
	public static final Dimension VGAP = new Dimension(1, 5);
	public static final Dimension HGAP = new Dimension(5, 1);
	
	public MenuHaut(){
		JToolBar toolBar = new JToolBar();
		toolBar.add(Box.createRigidArea(HGAP));
		JTextField inputValue = new JTextField("45", 5);
		toolBar.add(inputValue);
		this.add(toolBar);

		addButton(toolBar, "Effacer", "Nouveau dessin", "/icons/index.png");

//		toolBar.add(Box.createRigidArea(HGAP));
//		inputValue = new JTextField("45", 5);
//		toolBar.add(inputValue);
		addButton(toolBar, "Avancer", "Avancer 50", null);
		addButton(toolBar, "Droite", "Droite 45", null);
		addButton(toolBar, "Gauche", "Gauche 45", null);
		addButton(toolBar, "Lever", "Lever Crayon", null);
		addButton(toolBar, "Baisser", "Baisser Crayon", null);

		String[] colorStrings = { "noir", "bleu", "cyan", "gris fonce", "rouge", "vert", "gris clair", "magenta", "orange", "gris", "rose", "jaune" };

		// Create the combo box
//		toolBar.add(Box.createRigidArea(HGAP));
		JLabel colorLabel = new JLabel("   Couleur: ");
		toolBar.add(colorLabel);
		JComboBox colorList = new JComboBox(colorStrings);
		toolBar.add(colorList);

		colorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int n = cb.getSelectedIndex();
//				courante.setColor(n);
			}
		});
	}
	
	// utilitaires pour installer des boutons et des menus
		public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
			JButton b;
			if ((imageName == null) || (imageName.equals(""))) {
				b = (JButton) p.add(new JButton(name));
			} else {
				java.net.URL u = this.getClass().getResource(imageName);
				if (u != null) {
					ImageIcon im = new ImageIcon(u);
					b = (JButton) p.add(new JButton(im));
				} else
					b = (JButton) p.add(new JButton(name));
				b.setActionCommand(name);
			}

			b.setToolTipText(tooltiptext);
			b.setBorder(BorderFactory.createRaisedBevelBorder());
			b.setMargin(new Insets(0, 0, 0, 0));
//			b.addActionListener(this);
		}

		@Override
		public void Update() {
			// TODO Auto-generated method stub
			
		}
}
