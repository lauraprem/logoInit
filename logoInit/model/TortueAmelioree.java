package model;

import java.util.ArrayList;
import java.util.List;

public class TortueAmelioree extends TortueFormesPredefinies{
	
	private String name;
	
	private List<TortueAmelioree> tortuesConnues;
	
    public TortueAmelioree() {
        super();
        this.tortuesConnues = new ArrayList<TortueAmelioree>();
        this.name = "Robert";
    }

    public TortueAmelioree(String name) {
        super();
        this.tortuesConnues = new ArrayList<TortueAmelioree>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTortueConnue(TortueAmelioree t) {
        if (!equals(t))
        	tortuesConnues.add(t);
    }

    public void removeTortueConnue(TortueAmelioree t) {
    	tortuesConnues.remove(t);
    }

    public void avancer(int dist) {
        super.avancer(dist);
    }

    public void bonjour(){
        for (TortueAmelioree uneTortue : tortuesConnues) {
            double distanceEntreTortue = calculDistanceEntreTortue(uneTortue);
            if (distanceEntreTortue <= 15) {
                System.out.println("Coucou " + uneTortue.getName() + " !");
                uneTortue.avancer(30);
            }
        }
    }
    
    public double calculDistanceEntreTortue(TortueAmelioree t) {
        double calc;
        calc = Math.sqrt(Math.pow(this.getCoor().getX() - t.getCoor().getX(), 2) + Math.pow(this.getCoor().getY() - t.getCoor().getY(), 2));
        return calc;
    }
	
	
}