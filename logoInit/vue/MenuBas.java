package vue;

import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBas extends JPanel implements Observateur {
	public MenuBas(LayoutManager layout){
		super(layout);
		JButton b20 = new JButton("Proc1");
		this.add(b20);
		JButton b21 = new JButton("Proc2");
		this.add(b21);
		JButton b22 = new JButton("Proc3");
		this.add(b22);
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}
}
