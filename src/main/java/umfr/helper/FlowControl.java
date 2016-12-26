package umfr.helper;

public final class AblaufSteuerung {
	
	private static AblaufSteuerung steuerung;
	
	private Fragebogen vorlage;
	private Fragebogen fragebogen;
	
	// private weil Singleton
	private AblaufSteuerung() {
		
	}
	
	public static AblaufSteuerung getAblaufSteuerung() {
		if (steuerung == null) {
			steuerung = new AblaufSteuerung();
		}
		return steuerung;
	}
	
	public void ladeFragebogen(Fragebogen fragebogen) {
		vorlage = fragebogen;
		this.fragebogen = fragebogen.klonErzeugen();
	}
	
	public void alleFragenDrucken() {
		for (Frage frage : fragebogen.getFragen()) {
			System.out.println(frage.getText());
			for (Antwort antwort : frage.getAntworten()){
				System.out.println(" _ " + antwort.getText());
			}
		}
	}

}
