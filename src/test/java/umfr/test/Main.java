package umfr.test;

import umfr.helper.*;

public class Main {
	public static void main(String[] args) {
		
		Frage f1 = new Frage();
		Frage f2 = new Frage();
		Frage f3 = new Frage();
		Frage f4 = new Frage("Wie heisst du?");
		Frage f5 = new Frage();
		
		print(f1.getText());
		print(f2.getText());
		print(f3.getText());
		print(f4.getText());
		print(f5.getText());
		
		print(f5.toString());
		
		
		
	}
	
	private static void print(String text) {
		if (text != null) {
			System.out.println(text);
		}
	}

}
