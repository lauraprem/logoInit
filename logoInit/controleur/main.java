package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import vue.FenetrePrincipal;

public class main {
	static FenetrePrincipal vue;

	public static void main(String[] args) {
		vue = new FenetrePrincipal();

		vue.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				super.windowClosing(arg0);
				System.exit(0);
			}
		});

		vue.setVisible(true);
	}

	
}
