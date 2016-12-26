package umfr.test;

import umfr.helper.*;

public class Main {
	public static void main(String[] args) {
		
		print("Start Test");
		
		//Einen Questionnaire erstellen
		Questionnaire questionnaire = new Questionnaire("Test Questionnaire");
		
		//Drei Fragen mit Antworten erstellen
		Question frage1 = new Question("Wieviel ist 1+1?");
		Reply f1a1 = new Reply("7");
		Reply f1a2 = new Reply("2");
		Reply f1a3 = new Reply("1");
		frage1.addAntwort(f1a1);
		frage1.addAntwort(f1a2);
		frage1.addAntwort(f1a3);
		
		Question frage2 = new Question("Wieviel ist 8-3?");
		Reply f2a1 = new Reply("5");
		Reply f2a2 = new Reply("2");
		Reply f2a3 = new Reply("1");
		Reply f2a4 = new Reply("17");
		frage2.addAntwort(f2a1);
		frage2.addAntwort(f2a2);
		frage2.addAntwort(f2a3);
		frage2.addAntwort(f2a4);

		Question frage3 = new Question("Wieviel ist 15/3?");
		Reply f3a1 = new Reply("4");
		Reply f3a2 = new Reply("3");
		Reply f3a3 = new Reply("5");
		frage3.addAntwort(f3a1);
		frage3.addAntwort(f3a2);
		frage3.addAntwort(f3a3);
		
		//Die Fragen dem Bogen hinzufügen
		questionnaire.addFrage(frage1);
		questionnaire.addFrage(frage2);
		questionnaire.addFrage(frage3);
		
		
		//Ablaufsteuerung erzeugen
		FlowControl steuerung = FlowControl.getAblaufSteuerung();
		
		//Den Questionnaire laden
		steuerung.ladeFragebogen(questionnaire);
		
		steuerung.alleFragenDrucken();
		
		print("Ende Test");

	}
	
	private static void print(String text) {
		if (text != null) {
			System.out.println(text);
		}
	}

}
