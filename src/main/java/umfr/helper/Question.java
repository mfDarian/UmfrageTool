package umfr.helper;

import java.util.ArrayList;

public class Question implements Cloneable {
	
	private static String standardText = "Question";
	
	private String text;
	private ArrayList<Reply> antworten;
	private boolean fakultativ;
	private boolean beantwortet;

	public Question(String text, ArrayList<Reply> antworten, boolean fakultativ) {
		this.text = text;
		this.antworten = antworten;
		this.fakultativ = fakultativ;
	}
	
	public Question(String text, ArrayList<Reply> antworten) {
		this.text = text;
		this.antworten = antworten;
		this.fakultativ = false;
	}
	
	public Question(String text) {
		this.text = text;
		this.antworten = new ArrayList<Reply>();
		this.fakultativ = false;
	}
	
	public Question() {
		this.text = standardText;
		this.antworten = new ArrayList<Reply>();
		this.fakultativ = false;
	}
	
	public int maximalPunkte() {
		int maximalPunkte = 0;
		
		for (Reply reply : antworten) {
			maximalPunkte += reply.getPunkte();
		}
		
		return maximalPunkte;
	}
	
	public int punktZahl() {
		int punkte = 0;
		
		for (Reply reply : antworten) {
			if (reply.isGesetzt() == true) {
				punkte += reply.getPunkte();
			}
		}
		
		return punkte;
	}

	
	public void addAntwort(Reply reply) {
		antworten.add(reply);
	}
	
	public Reply getAntwort(int index) {
		if (antworten.size() >= index) {
			return antworten.get(index);
		}
		return null;
	}
	
	public void removeAntwort(Reply reply) {
		if (antworten.contains(reply)) {
			antworten.remove(reply);
		}
	}
	
	public Question klonErzeugen() {
		Question klon = new Question(this.text, new ArrayList<Reply>(), this.fakultativ);
		for (Reply reply : this.antworten) {
			klon.addAntwort(reply.klonErzeugen());
		}
		return klon;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<Reply> getAntworten() {
		return antworten;
	}
	public void setAntworten(ArrayList<Reply> antworten) {
		this.antworten = antworten;
	}
	public boolean istFakultativ() {
		return fakultativ;
	}
	public void setFakultativ(boolean fakultativ) {
		this.fakultativ = fakultativ;
	}
	public boolean isBeantwortet() {
		return beantwortet;
	}
	public void setBeantwortet(boolean beantwortet) {
		this.beantwortet = beantwortet;
	}

}
