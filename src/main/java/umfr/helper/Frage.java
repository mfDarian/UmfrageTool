package umfr.helper;

import java.util.ArrayList;

public class Frage {
	
	private String text;
	private ArrayList<Antwort> antworten;
	private boolean mandatory;

	public Frage(String text, ArrayList<Antwort> antworten, boolean mandatory) {
		this.text = text;
		this.antworten = antworten;
		this.mandatory = mandatory;
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
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

}
