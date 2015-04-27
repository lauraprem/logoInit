package model;

public class Coordonnees {

	/**
	 * coordonnée x
	 */
	private int x;
	
	/**
	 * coordonnée y
	 */
	private int y;
	
	/**
	 * initialise les coordonnées
	 * @param _x coordonnée x
	 * @param _y coordonnée y
	 */
	public Coordonnees(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	/**
	 * Construit des coordonnées à (0,0) par défaut
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
