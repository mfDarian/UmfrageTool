package umfr.helper;

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
	
	public void loadQuestionnaire(Questionnaire questionnaire) {
		template = questionnaire;
		this.questionnaire = template.getNewClone();
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
