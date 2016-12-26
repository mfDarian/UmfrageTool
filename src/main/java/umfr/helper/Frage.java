package umfr.helper;

import java.util.ArrayList;

public class Frage implements Klonbar {
	
	private static String standardText = "Frage";
	
	private String text;
	private ArrayList<Antwort> antworten;
	private boolean fakultativ;
	private boolean beantwortet;

	public Frage(String text, ArrayList<Antwort> antworten, boolean fakultativ) {
		this.text = text;
		this.antworten = antworten;
		this.fakultativ = fakultativ;
	}
	
	public Frage(String text, ArrayList<Antwort> antworten) {
		this.text = text;
		this.antworten = antworten;
		this.fakultativ = false;
	}
	
	public Frage(String text) {
		this.text = text;
		this.antworten = new ArrayList<Antwort>();
		this.fakultativ = false;
	}
	
	public Frage() {
		this.text = standardText;
		this.antworten = new ArrayList<Antwort>();
		this.fakultativ = false;
	}
	
	public int maximalPunkte() {
		int maximalPunkte = 0;
		
		for (Antwort antwort : antworten) {
			maximalPunkte += antwort.getPunkte();
		}
		
		return maximalPunkte;
	}
	
	public int punktZahl() {
		int punkte = 0;
		
		for (Antwort antwort : antworten) {
			if (antwort.isGesetzt() == true) {
				punkte += antwort.getPunkte();
			}
		}
		
		return punkte;
	}

	
	public void addAntwort(Antwort antwort) {
		antworten.add(antwort);
	}
	
	public Antwort getAntwort(int index) {
		if (antworten.size() >= index) {
			return antworten.get(index);
		}
		return null;
	}
	
	public Frage klonErzeugen() {
		Frage klon = new Frage(this.text, new ArrayList<Antwort>(), this.fakultativ);
		for (Antwort antwort : this.antworten) {
			klon.addAntwort(antwort.klonErzeugen());
		}
		return klon;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<Antwort> getAntworten() {
		return antworten;
	}
	public void setAntworten(ArrayList<Antwort> antworten) {
		this.antworten = antworten;
	}
	public boolean istFakultativ() {
		return fakultativ;
	}
	public void setFakultativ(boolean fakultativ) {
		this.fakultativ = fakultativ;
	}
	public boolean isBeantwortet() {
		return beantwortet;
	}
	public void setBeantwortet(boolean beantwortet) {
		this.beantwortet = beantwortet;
	}

}
