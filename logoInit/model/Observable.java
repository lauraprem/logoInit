package model;

import vue.Observateur;

/**
 *
 * @author Corinne & Laura
 */

public interface Observable {
	public void AjoutObservateur(Observateur o);

	public void SupprimerObservateur(Observateur o);

	// Dès raffraichissement.
	public void NotifierObservateur();
}
