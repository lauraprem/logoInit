package model;

public class TortueBalle extends TortueFormesPredefinies {

	private TortueFormesPredefinies possesseur;

	private int distanceTortueBalle;

	private long temps;

	public TortueBalle(TortueFormesPredefinies tortue, int couleur, int distanceTortueBalle) {
		super();
		this.setCouleur(couleur);
		this.possesseur = tortue;
		this.distanceTortueBalle = distanceTortueBalle;
		this.temps = System.currentTimeMillis();
	}

	public void updatePosition() {
		int angle = -possesseur.dir;
		if (angle > 180) {
			angle = -angle % 180;
		}
		Double cosX = Math.cos(Math.toRadians(angle));
		Double sinY = Math.sin(Math.toRadians(angle));
		setCoor((int) (possesseur.getCoor().getX() + (cosX.intValue() * distanceTortueBalle)), (int) (possesseur.getCoor().getY() - (sinY.intValue() * distanceTortueBalle)));
	}

	public boolean fairePasse(TortueFormesPredefinies tortue) {
		if (tortue.calculDistanceEntreTortue(possesseur) <= 50 && !tortue.equals(possesseur) && (System.currentTimeMillis() - temps) > 5000) {
			possesseur = tortue;
			updatePosition();
			return true;
		}
		updatePosition();
		temps = System.currentTimeMillis();
		return false;
	}

	public TortueFormesPredefinies getPossesseur() {
		return possesseur;
	}

	public void setPossesseur(TortueFormesPredefinies possesseur) {
		this.possesseur = possesseur;
	}

	public int getDistanceTortueBalle() {
		return distanceTortueBalle;
	}

	public void setDistanceTortueBalle(int distanceTortueBalle) {
		this.distanceTortueBalle = distanceTortueBalle;
	}

	public long getTemps() {
		return temps;
	}

	public void setTemps(long temps) {
		this.temps = temps;
	}

}
