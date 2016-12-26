package umfr.helper;

import java.util.ArrayList;

public class Question implements Scoreable, Cloneable, Freezeable{
	
	private static String defaultText = "Question";
	
	private String text;
	private ArrayList<Reply> replyList;
	private boolean optional;
	private boolean answered;
	private boolean frozen;

	public Question(String text, ArrayList<Reply> replyList, boolean optional) {
		this.text = text;
		this.replyList = replyList;
		this.optional = optional;
	}
	
	public Question(String text, ArrayList<Reply> replyList) {
		this.text = text;
		this.replyList = replyList;
		this.optional = false;
	}
	
	public Question(String text) {
		this.text = text;
		this.replyList = new ArrayList<Reply>();
		this.optional = false;
	}
	
	public Question() {
		this.text = defaultText;
		this.replyList = new ArrayList<Reply>();
		this.optional = false;
	}
	
	public int maximumScore() {
		int maximumScore = 0;
		
		for (Reply reply : replyList) {
			maximumScore += reply.score();
		}
		
		return maximumScore;
	}
	
	public int score() {
		int punkte = 0;
		
		for (Reply reply : replyList) {
			if (reply.isChosen() == true) {
				punkte += reply.score();
			}
		}
		
		return punkte;
	}

	
	public void addReply(Reply reply) {
		replyList.add(reply);
	}
	
	public Reply getReply(int index) {
		if (replyList.size() >= index) {
			return replyList.get(index);
		}
		return null;
	}
	
	public void removeReply(Reply reply) {
		if (replyList.contains(reply)) {
			replyList.remove(reply);
		}
	}
	
	public Question getNewClone() {
		Question clone = new Question(this.text, new ArrayList<Reply>(), this.optional);
		for (Reply reply : this.replyList) {
			clone.addReply(reply.getNewClone());
		}
		return clone;
	}

	public void freeze() {
		frozen = true;
	}
	
	public boolean getFrozen() {
		return frozen;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(ArrayList<Reply> replyList) {
		this.replyList = replyList;
	}
	public boolean isOptional() {
		return optional;
	}
	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	public boolean isAnswered() {
		return answered;
	}
	public void setAnswered(boolean answered) {
		this.answered = answered;
	}

}
