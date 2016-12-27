package umfr.helper;

//Comment

public class Reply implements Scoreable, Cloneable {
	
	private Question question;
	private String text;
	private int score;
	private boolean chosen;
	
	public Reply(String text, int score) {
		this.text = text;
		this.score = score;
	}
	
	public Reply(String text) {
		this.text = text;
		this.score = 0;
	}
	
	public Reply getNewClone() {
		Reply clone = new Reply(this.text, this.score);
		return clone;
	}

	public final String getText() {
		return text;
	}

	public final void setText(String text) {
		this.text = text;
	}

	public final int score() {
		return score;
	}
	
	public final int maximumScore() {
		return score;
	}

	public final void setScore(int score) {
		this.score = score;
	}
	
	public final boolean isChosen() {
		return chosen;
	}
	
	public final void setChosen(boolean chosen) {
		this.chosen = chosen;
	}
	
	

}
