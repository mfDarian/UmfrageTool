package umfr.exceptions;

public class ReplyCountException extends Exception {
	
	private int maxRepliesChosen;
	
	public ReplyCountException(int maxRepliesChosen) {
		this.maxRepliesChosen = maxRepliesChosen;

	}
	
	public String toString() {
		if (maxRepliesChosen <= 1) {
			return "Bitte geben Sie nur eine Antwort an.";
		} else {
			return "Bitte geben Sie maximal " + maxRepliesChosen + " Antworten an.";
		}
	}

}
