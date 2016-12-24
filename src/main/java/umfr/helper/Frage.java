package umfr.helper;

import java.util.ArrayList;

public class Frage {
	
	private static String standardText = "Frage ";
	private static int frageNummer = 0;
	
	private String text;
	private ArrayList<Antwort> antworten;
	private boolean fakultativ;
	private boolean beantwortet;

	public Frage(String text, ArrayList<Antwort> antworten, boolean fakultativ) {
		frageNummer++;
		this.text = text;
		this.antworten = antworten;
		this.fakultativ = fakultativ;
	}
	
	public Frage(String text, ArrayList<Antwort> antworten) {
		frageNummer++;
		this.text = text;
		this.antworten = antworten;
		this.fakultativ = false;
	}
	
	public Frage(String text) {
		frageNummer++;
		this.text = text;
		this.antworten = new ArrayList<Antwort>();
		this.fakultativ = false;
	}
	
	public Frage() {
		frageNummer++;
		this.text = standardText + frageNummer;
		this.antworten = new ArrayList<Antwort>();
		this.fakultativ = false;
	}

	
	public void addAntwort(Antwort antwort) {
		antworten.add(antwort);
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
	public boolean istObligatorisch() {
		return fakultativ;
	}
	public void setFakultativ(boolean fakultativ) {
		this.fakultativ = fakultativ;
	}
	public boolean istBeantwortet() {
		return beantwortet;
	}
	public void setBeantwortet(boolean beantwortet) {
		this.beantwortet = beantwortet;
	}

}
