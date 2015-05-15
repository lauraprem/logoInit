package model;

public class TortueBalle extends TortueFormesPredefinies{
	
	private TortueFormesPredefinies possesseur;
	
	private int distanceTortueBalle;

    public TortueBalle(TortueFormesPredefinies tortue, int couleur, int distanceTortueBalle) {
        super();
        this.setCouleur(couleur);
        this.possesseur = tortue;
        this.distanceTortueBalle = distanceTortueBalle;
    }

    public void updatePosition(){
        int angle = -possesseur.dir;
        if (angle>180){
            angle=-angle%180;
        }
        Double cosX = Math.cos(Math.toRadians(angle));
        Double sinY = Math.sin(Math.toRadians(angle));
        setCoor((int)(possesseur.getCoor().getX()+(cosX.intValue()*distanceTortueBalle)), (int)(possesseur.getCoor().getY()- (sinY.intValue()*distanceTortueBalle)));
    }

    public boolean fairePasse(TortueFormesPredefinies tortue) {
        if(tortue.calculDistanceEntreTortue(possesseur)<=50&&!tortue.equals(possesseur)){
            possesseur = tortue;
            updatePosition();
            return true;
        }
        updatePosition();
        return false;
    }

}
