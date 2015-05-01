package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurQuitter implements ActionListener {

	public EcouteurQuitter(){
		
	}
		@Override
		public void actionPerformed(ActionEvent e) {
//			if (e.getActionCommand() == "Quitter") {
			System.out.println("QUITTER");
				 System.exit(0);
//			}
	}
}
