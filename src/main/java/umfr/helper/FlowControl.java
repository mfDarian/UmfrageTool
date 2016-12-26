package umfr.helper;

public final class FlowControl {
	
	private static FlowControl steuerung;
	
	private Questionnaire vorlage;
	private Questionnaire questionnaire;
	
	// private weil Singleton
	private FlowControl() {
		
	}
	
	public static FlowControl getAblaufSteuerung() {
		if (steuerung == null) {
			steuerung = new FlowControl();
		}
		return steuerung;
	}
	
	public void ladeFragebogen(Questionnaire questionnaire) {
		vorlage = questionnaire;
		this.questionnaire = questionnaire.klonErzeugen();
	}
	
	public void alleFragenDrucken() {
		for (Question question : questionnaire.getFragen()) {
			System.out.println(question.getText());
			for (Reply reply : question.getAntworten()){
				System.out.println(" _ " + reply.getText());
			}
		}
	}

}
