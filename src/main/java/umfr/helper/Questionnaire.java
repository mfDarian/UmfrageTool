package umfr.helper;

import java.util.ArrayList;

public class Questionnaire implements Cloneable{
	
	private String name;
	private ArrayList<Question> fragen;
	private Person interviewer;
	private Person interviewee;
	
	
	public Questionnaire(String name, ArrayList<Question> fragen) {
		this.name = name;
		this.fragen = fragen;
	}
	
	public Questionnaire(String name) {
		this.name = name;
		this.fragen = new ArrayList<Question>();
	}
	

	public int maximalPunkte() {
		int maximalPunkte = 0;
		
		for (Question question : fragen) {
			maximalPunkte += question.maximalPunkte();
		}
		
		return maximalPunkte;
	}
	
	public int punktZahl() {
		int punkte = 0;
		
		for (Question question : fragen) {
			punkte += question.punktZahl();
		}
		
		return punkte;
	}

	public void addFrage(Question question) {
		fragen.add(question);
	}
	
	public Question getFrage(int index) {
		if (fragen.size() >= index) {
			return fragen.get(index);
		}
		return null;
	}
	
	public void removeFrage(Question question) {
		if (fragen.contains(question)) {
			fragen.remove(question);
		}
	}
	
	public Questionnaire klonErzeugen() {
		Questionnaire klon = new Questionnaire(this.name);
		for (Question question : this.fragen) {
			klon.addFrage(question.klonErzeugen());
		}
		return klon;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Question> getFragen() {
		return fragen;
	}


	public void setFragen(ArrayList<Question> fragen) {
		this.fragen = fragen;
	}

	public Person getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Person interviewer) {
		this.interviewer = interviewer;
	}

	public Person getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(Person interviewee) {
		this.interviewee = interviewee;
	}
	
	
	

}
