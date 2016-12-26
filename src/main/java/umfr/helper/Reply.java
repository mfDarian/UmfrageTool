package umfr.helper;

//Comment

public class Reply implements Cloneable {
	
	private String text;
	private int punkte;
	private boolean gesetzt;
	
	public Reply(String text, int punkte) {
		this.text = text;
		this.punkte = punkte;
	}
	
	public Reply(String text) {
		this.text = text;
		this.punkte = 0;
	}
	
	public Reply klonErzeugen() {
		Reply klon = new Reply(this.text, this.punkte);
		return klon;
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
