package umfr.helper;

//Comment

public class Antwort {
	
	private String text;
	private int punkte;
	private boolean gesetzt;
	
	public Antwort(String text, int punkte) {
		this.text = text;
		this.punkte = punkte;
	}
	
	public Antwort(String text) {
		this.text = text;
		this.punkte = 0;
	}

	public final String getText() {
		return text;
	}

	public final void setText(String text) {
		this.text = text;
	}

	public final int getPunkte() {
		return punkte;
	}

	public final void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	
	public final boolean isGesetzt() {
		return gesetzt;
	}
	
	public final void setGesetzt(boolean gesetzt) {
		this.gesetzt = gesetzt;
	}
	
	

}
