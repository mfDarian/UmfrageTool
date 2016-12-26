package umfr.helper;

import java.util.ArrayList;

public class Fragebogen implements Klonbar{
	
	private String name;
	private ArrayList<Frage> fragen;
	
	
	public Fragebogen(String name, ArrayList<Frage> fragen) {
		this.name = name;
		this.fragen = fragen;
	}
	
	public Fragebogen(String name) {
		this.name = name;
		this.fragen = new ArrayList<Frage>();
	}
	

	public int maximalPunkte() {
		int maximalPunkte = 0;
		
		for (Frage frage : fragen) {
			maximalPunkte += frage.maximalPunkte();
		}
		
		return maximalPunkte;
	}
	
	public int punktZahl() {
		int punkte = 0;
		
		for (Frage frage : fragen) {
			punkte += frage.punktZahl();
		}
		
		return punkte;
	}

	public void addFrage(Frage frage) {
		fragen.add(frage);
	}
	
	public Fragebogen klonErzeugen() {
		Fragebogen klon = new Fragebogen(this.name);
		for (Frage frage : this.fragen) {
			klon.addFrage(frage.klonErzeugen());
		}
		return klon;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Frage> getFragen() {
		return fragen;
	}


	public void setFragen(ArrayList<Frage> fragen) {
		this.fragen = fragen;
	}
	
	
	

}
