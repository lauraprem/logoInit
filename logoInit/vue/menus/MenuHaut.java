package vue.menus;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import model.EnvironnementTortue;

public class MenuHaut extends JPanel{
	public static final Dimension VGAP = new Dimension(1, 5);
	public static final Dimension HGAP = new Dimension(5, 1);

	private ArrayList<JButton> listButon;
	private ArrayList<JComboBox> comboBox;
	private JTextField inputValue;

	public MenuHaut(EnvironnementTortue model) {

		listButon = new ArrayList<JButton>();
		comboBox = new ArrayList<JComboBox>();

		JToolBar toolBar = new JToolBar();

		addButton(toolBar, "Effacer", "Nouveau dessin", "/icons/index.png");
		addButton(toolBar, "Tortue", "Ajout tortue", null);
		
		toolBar.add(Box.createRigidArea(HGAP));
		inputValue = new JTextField(
				Integer.toString(model.getDis()), 5);
		toolBar.add(inputValue);
		this.add(toolBar);
		addButton(toolBar, "Avancer", "Avancer 50", null);
		addButton(toolBar, "Droite", "Droite 45", null);
		addButton(toolBar, "Gauche", "Gauche 45", null);
		addButton(toolBar, "Lever", "Lever Crayon", null);
		addButton(toolBar, "Baisser", "Baisser Crayon", null);

		// Create the combo box
		JLabel colorLabel = new JLabel("   Couleur: ");
		toolBar.add(colorLabel);
		JComboBox colorList = new JComboBox(model.couleurstoStringChaine());
		toolBar.add(colorList);

		comboBox.add(colorList);
	}
	

	public JTextField getInputValue() {
		return inputValue;
	}


	public void setInputValue(JTextField inputValue) {
		this.inputValue = inputValue;
	}


	public ArrayList<JButton> getListButon() {
		return listButon;
	}

	public void setListButon(ArrayList<JButton> listButon) {
		this.listButon = listButon;
	}

	public ArrayList<JComboBox> getComboBox() {
		return comboBox;
	}

	public void setListComboBox(ArrayList<JComboBox> comboBox) {
		this.comboBox = comboBox;
	}

	// utilitaires pour installer des boutons et des menus
	public void addButton(JComponent p, String name, String tooltiptext,
			String imageName) {
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
		listButon.add(b);
	}
}
