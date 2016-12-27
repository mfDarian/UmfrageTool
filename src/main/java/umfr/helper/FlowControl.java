package umfr.helper;

import umfr.exceptions.MustBeFrozenException;
import java.io.*;

public final class FlowControl {
	
	private static FlowControl flowControll;
	
	private Questionnaire template;
	private Questionnaire questionnaire;
	
	// private weil Singleton
	private FlowControl() {
		
	}
	
	public static FlowControl getFlowControll() {
		if (flowControll == null) {
			flowControll = new FlowControl();
		}
		return flowControll;
	}
	
	public void loadQuestionnaire(Questionnaire questionnaire) throws MustBeFrozenException {
		if (questionnaire.isFrozen()) {
			template = questionnaire;
			this.questionnaire = template.getNewClone();
		} else {
			throw new MustBeFrozenException(questionnaire, "Template");
		}
	}
	
	public void saveQuestionnaire(String path) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
			os.writeObject(questionnaire);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace(); //TODO
		}
	}
	
	public void openQuestionnaire(String path) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
			Questionnaire template = (Questionnaire) is.readObject();
			is.close();
		} catch (Exception ex) {
			ex.printStackTrace(); //TODO
		}
	}
	
	public void printAllQuestions() {
		for (Question question : questionnaire.getQuestionList()) {
			System.out.println(question.getText());
			for (Reply reply : question.getReplyList()){
				System.out.println(" _ " + reply.getText());
			}
		}
	}

}
