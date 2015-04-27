package model;

public class Coordonnees {

	/**
	 * coordonn�e x
	 */
	private int x;
	
	/**
	 * coordonn�e y
	 */
	private int y;
	
	/**
	 * initialise les coordonn�es
	 * @param _x coordonn�e x
	 * @param _y coordonn�e y
	 */
	public Coordonnees(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	/**
	 * Construit des coordonn�es � (0,0) par d�faut
	 */
	public Coordonnees(){
		this(0,0);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
