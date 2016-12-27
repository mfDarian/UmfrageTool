package umfr.helper;

import java.util.ArrayList;

public class Questionnaire implements Scoreable, Cloneable, Freezeable{
	
	private String name;
	private ArrayList<Question> questionList;
	private Person interviewer;
	private Person interviewee;
	private boolean frozen;
	
	
	public Questionnaire(String name, ArrayList<Question> questionList) {
		this.name = name;
		this.questionList = questionList;
	}
	
	public Questionnaire(String name) {
		this.name = name;
		this.questionList = new ArrayList<Question>();
	}
	

	public int maximumScore() {
		int maximumScore = 0;
		for (Question question : questionList) {
			maximumScore += question.maximumScore();
		}
		return maximumScore;
	}
	
	public int score() {
		int score = 0;
		for (Question question : questionList) {
			score += question.score();
		}
		return score;
	}

	public void addQuestion(Question question) {
		questionList.add(question);
	}
	
	public Question getQuestion(int index) {
		if (questionList.size() >= index) {
			return questionList.get(index);
		}
		return null;
	}
	
	public void removeQuestion(Question question) {
		if (questionList.contains(question)) {
			questionList.remove(question);
		}
	}
	
	public Questionnaire getNewClone() {
		Questionnaire clone = new Questionnaire(this.name);
		for (Question question : this.questionList) {
			clone.addQuestion(question.getNewClone());
		}
		return clone;
	}
	
	public void freeze() {
		frozen = true;
	}
	
	public boolean isFrozen() {
		return frozen;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
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