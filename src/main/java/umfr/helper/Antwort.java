package umfr.helper;

public class Antwort {
	
	private String text;
	private int score;
	
	public Antwort(String text, int score) {
		this.text = text;
		this.score = score;
	}

	public final String getText() {
		return text;
	}

	public final void setText(String text) {
		this.text = text;
	}

	public final int getScore() {
		return score;
	}

	public final void setScore(int score) {
		this.score = score;
	}
	
	

}
