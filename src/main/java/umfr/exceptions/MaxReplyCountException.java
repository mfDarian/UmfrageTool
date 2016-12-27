package umfr.exceptions;

public class MaxReplyCountException extends Exception {
	
	private int minRepliesChosen;
	private int maxRepliesChosen;
	
	public MaxReplyCountException(int minRepliesChosen, int maxRepliesChosen) {
		this.minRepliesChosen = minRepliesChosen;
		this.maxRepliesChosen = maxRepliesChosen;

	}
	
	public String toString() {
		if (minRepliesChosen == maxRepliesChosen) {
			if (maxRepliesChosen <= 1) {
				return "Bitte geben Sie genau eine Antwort an.";
			} else {
				return "Bitte geben Sie genau " + maxRepliesChosen + " Antworten an.";
			}
		} else {
			if (maxRepliesChosen <= 1) {
				return "Bitte geben Sie nur eine Antwort an.";
			} else {
				return "Bitte geben Sie maximal " + maxRepliesChosen + " Antworten an.";
			}			
		}
	}

}
