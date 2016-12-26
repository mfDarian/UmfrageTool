package umfr.test;

import umfr.helper.*;

public class Main {
	public static void main(String[] args) {
		
		print("Start Test");
		
		//Einen Fragebogen erstellen
		Fragebogen fragebogen = new Fragebogen("Test Fragebogen");
		
		//Drei Fragen mit Antworten erstellen
		Frage frage1 = new Frage("Wieviel ist 1+1?");
		Antwort f1a1 = new Antwort("7");
		Antwort f1a2 = new Antwort("2");
		Antwort f1a3 = new Antwort("1");
		frage1.addAntwort(f1a1);
		frage1.addAntwort(f1a2);
		frage1.addAntwort(f1a3);
		
		Frage frage2 = new Frage("Wieviel ist 8-3?");
		Antwort f2a1 = new Antwort("5");
		Antwort f2a2 = new Antwort("2");
		Antwort f2a3 = new Antwort("1");
		Antwort f2a4 = new Antwort("17");
		frage2.addAntwort(f2a1);
		frage2.addAntwort(f2a2);
		frage2.addAntwort(f2a3);
		frage2.addAntwort(f2a4);

		Frage frage3 = new Frage("Wieviel ist 15/3?");
		Antwort f3a1 = new Antwort("4");
		Antwort f3a2 = new Antwort("3");
		Antwort f3a3 = new Antwort("5");
		frage3.addAntwort(f3a1);
		frage3.addAntwort(f3a2);
		frage3.addAntwort(f3a3);
		
		//Die Fragen dem Bogen hinzufügen
		fragebogen.addFrage(frage1);
		fragebogen.addFrage(frage2);
		fragebogen.addFrage(frage3);
		
		
		//Ablaufsteuerung erzeugen
		AblaufSteuerung steuerung = AblaufSteuerung.getAblaufSteuerung();
		
		//Den Fragebogen laden
		steuerung.ladeFragebogen(fragebogen);
		
		steuerung.alleFragenDrucken();
		
		print("Ende Test");

	}
	
	private static void print(String text) {
		if (text != null) {
			System.out.println(text);
		}
	}

}
