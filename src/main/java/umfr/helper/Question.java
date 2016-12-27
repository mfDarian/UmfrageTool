package umfr.helper;

import java.util.ArrayList;
import java.io.*;

import umfr.exceptions.MaxReplyCountException;
import umfr.exceptions.MinReplyCountException;

public class Question implements Serializable, Scoreable, Cloneable, Freezeable{
	
	private static String defaultText = "Question";
	
	private String text;
	private ArrayList<Reply> replyList;
	private int minRepliesChosen;
	private int maxRepliesChosen;
	private int repliesChosen;
	private boolean answered;
	private boolean frozen;

	public Question(String text, ArrayList<Reply> replyList, int minRepliesChosen, int maxRepliesChosen) {
		this.text = text;
		this.replyList = replyList;
		registerReplyList(replyList);
		this.minRepliesChosen = minRepliesChosen;
		this.maxRepliesChosen = maxRepliesChosen;
		this.repliesChosen = 0;
	}
	
	public Question(String text, ArrayList<Reply> replyList) {
		this.text = text;
		this.replyList = replyList;
		registerReplyList(replyList);
		this.minRepliesChosen = 1;
		this.maxRepliesChosen = 1;
		this.repliesChosen = 0;
	}
	
	public Question(String text) {
		this.text = text;
		this.replyList = new ArrayList<Reply>();
		this.minRepliesChosen = 1;
		this.maxRepliesChosen = 1;
		this.repliesChosen = 0;
	}
	
	public Question() {
		this.text = defaultText;
		this.replyList = new ArrayList<Reply>();
		this.minRepliesChosen = 1;
		this.maxRepliesChosen = 1;
		this.repliesChosen = 0;
	}
	
	private void registerReplyList(ArrayList<Reply> replyList) {
		for (Reply reply : replyList) {
			reply.setQuestion(this);
		}
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
		reply.setQuestion(this);
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
			reply.setQuestion(null);
		}
	}
	
	public void notifyChosen(Reply reply) throws MaxReplyCountException {
		if (repliesChosen > maxRepliesChosen) {
			reply.setChosen(false);
			throw new MaxReplyCountException(minRepliesChosen, maxRepliesChosen);
		} else {
			repliesChosen++;
		}
	}
	
	public Question getNewClone() {
		Question clone = new Question(this.text, new ArrayList<Reply>(),this.minRepliesChosen, this.maxRepliesChosen);
		for (Reply r : this.replyList) {
			Reply reply = r.getNewClone();
			clone.addReply(reply);
			reply.setQuestion(clone);
		}
		return clone;
	}

	public void freeze() {
		frozen = true;
	}
	
	public boolean isFrozen() {
		return frozen;
	}
	
	public boolean isOptional() {
		return minRepliesChosen == 0;
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
	
	public int getMinRepliesChosen() {
		return minRepliesChosen;
	}
	
	public void setMinRepliesChosen(int minRepliesChosen) {
		this.minRepliesChosen = minRepliesChosen;
	}
	
	public int getMaxRepliesChosen() {
		return maxRepliesChosen;
	}
	
	public void setMaxRepliesChosen(int maxRepliesChosen) {
		this.maxRepliesChosen = maxRepliesChosen;
	}
	
	public int getRepliesChosen() {
		return repliesChosen;
	}
	
	public boolean isAnswered() {
		return answered;
	}
	
	public void setAnswered(boolean answered) throws MinReplyCountException {
		if (repliesChosen < minRepliesChosen) {
			throw new MinReplyCountException(minRepliesChosen, maxRepliesChosen);
		} else {
			this.answered = answered;
		}
	}

}
