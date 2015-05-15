package model;

import java.util.ArrayList;

public class EnvironnementTortuesAmeliorees extends EnvironnementTortue{

	@Override
	protected void creerTortues() {
		this.tortues = new ArrayList<TortueFormesPredefinies>();
		tortues.add(new TortueAmelioree());
	}

	@Override
	public void ajouteTortue(int n) {
		TortueAmelioree t = new TortueAmelioree(n);
		this.tortues.add(t);
		setTortueCourante(tortues.indexOf(t), n);
		this.NotifierObservateur();
	}

	public TortueAmelioree getTortue(int indexTortue){
		return (TortueAmelioree)this.getTortues().get(indexTortue);
	}
	
	public void setName(int tortue, String name){
		getTortue(tortue).setName(name);
		this.NotifierObservateur();
	}
	
}
