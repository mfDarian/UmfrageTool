package umfr.exceptions;

public class MinReplyCountException extends Exception {
	
	private int minRepliesChosen;
	private int maxRepliesChosen;
	
	public MinReplyCountException(int minRepliesChosen, int maxRepliesChosen) {
		this.minRepliesChosen = minRepliesChosen;
		this.maxRepliesChosen = maxRepliesChosen;
	}
	
	public String toString() {
		if (minRepliesChosen == maxRepliesChosen) {
			if (minRepliesChosen == 1) {
				return "Bitte geben Sie genau eine Antwort an.";
			} else {
				return "Bitte geben Sie genau " + minRepliesChosen + " Antworten an.";
			}		
		} else {
			if (minRepliesChosen == 1) {
				return "Bitte geben Sie mindestens eine Antwort an.";
			} else {
				return "Bitte geben Sie mindestens " + minRepliesChosen + " Antworten an.";
			}
		}
	}

}
