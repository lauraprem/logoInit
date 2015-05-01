package vue;

import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.EnvironnementTortue;

public class MenuBas extends JPanel {
	
	private ArrayList<JButton> listButon;
	
	public MenuBas(LayoutManager layout){
		super(layout);
		
		listButon = new ArrayList<JButton>();
		
		JButton b20 = new JButton("Proc1");
		listButon.add(b20);
		this.add(b20);
		JButton b21 = new JButton("Proc2");
		listButon.add(b21);
		this.add(b21);
		JButton b22 = new JButton("Proc3");
		listButon.add(b22);
		this.add(b22);
	}

	public ArrayList<JButton> getListButon() {
		return listButon;
	}

	public void setListButon(ArrayList<JButton> listButon) {
		this.listButon = listButon;
	}
}
