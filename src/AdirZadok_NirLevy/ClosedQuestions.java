package AdirZadok_NirLevy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class ClosedQuestions extends Question implements Cloneable ,Serializable {
	private List<Answer> answers;
	private int numOfAnswers;
	private int amountAnswers;
	private int numCorrectAnswers;
	private int numOfIncorrectAnswers;
	private int numOfCharctersInAnswers;

	public ClosedQuestions(String text, int num) {
		super(text);
		this.numOfIncorrectAnswers = 0;
		this.numOfAnswers = 0;
		this.numCorrectAnswers = 0;
		this.amountAnswers = (num + 2);
		this.numOfCharctersInAnswers = 0;
		answers = new ArrayList<Answer>();
		answers.add(new Answer("there is more than one corect answer", false));
		answers.add(new Answer("None of the Answers is corect", true));
	}

	public int getAmountAnswers() {
		return amountAnswers;
	}

	public int getNumOfCharctersInAnswers() {
		return numOfCharctersInAnswers;
	}

	public int getNumCorrectAnswers() {
		return numCorrectAnswers;
	}

	public int getNumOfIncorrectAnswers() {
		return numOfIncorrectAnswers;
	}

	public int getNumOfAnswers() {
		return numOfAnswers;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void editAnswer(String update, int num) {
		answers.get(num - 1).edit(update);
	}

	public void addAnswer(Answer answer) {
		if (answer.getType() == (false)) {
			numOfIncorrectAnswers++;
		}
		answers.add(answer);
		numOfAnswers = numOfAnswers + 1;
	}
	
	public void updateNumOfAnswrs() {
		this.numOfAnswers++;
	}

	public boolean checkAnswerToAutoTest(Answer answer) {// add answer for American Question in test
		if (numCorrectAnswers == 0 && answer.getType() == (true)) {
			answers.get(1).editType(false);
			numCorrectAnswers = numCorrectAnswers + 1;
			return true;
		}
		if (numCorrectAnswers == 1 && answer.getType() == (true)) {
			return false;
		}
		return true;
	}

	public void addAnswerToTest(Answer answer) {// add answer for American Question in test
		updateTypeForTest(answer);
		answers.add(answer);
		numOfAnswers = numOfAnswers + 1;
	}

	public void updateTypeForTest(Answer answer) {
		if (answer.getType() == (true)) {
			answers.get(1).editType(false);
			numCorrectAnswers++;
		}
		if (numCorrectAnswers - 1 >= 0 && answer.getType() == (true)) {
			answer.editType(false);
			answers.get(0).editType(true);
			numCorrectAnswers++;
		}
	}

	public Answer sendAnswer(int num) {
		return answers.get(num + 1);
	}

	public boolean existAnswerCheck(String text, int num) {
		if (numOfAnswers == 0) {
			return false;
		}
		for (int i = num; i < numOfAnswers + 2; i++) {
			if (answers.get(i).getText().equalsIgnoreCase(text)) {
				return true;
			}
		}
		return false;
	}
	
	public void getAnswerByTextAndEarsed(Answer answer) {
		for(int i=0 ; i<answers.size() ; i++) {
			if(answers.get(i).getText().equals(answer.getText())){
				organizeQuestionAfterDelete(i);
				return;
			}
		}
	}

	public void organizeQuestionAfterDelete(int num) {
		answers.remove(num);
	}

	public String AnswersForFile() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < answers.size(); i++) {
			numOfCharctersInAnswers = numOfCharctersInAnswers + answers.get(i).getText().length();
			if (answers.get(i).getType() == true) {
				sb.append((i + 1) + ") " + answers.get(i).getText() + "\n");
			}
		}
		return sb.toString();
	}

	@Override
	public ClosedQuestions clone() throws CloneNotSupportedException {
		ClosedQuestions q = (ClosedQuestions) super.clone();
		ClosedQuestions copy = q;
		q.setAnswers(new ArrayList<Answer>());
		for (int i = 0; i < answers.size(); i++) {
			copy.answers.add(answers.get(i).clone());

		}
		copy.numOfAnswers = copy.answers.size() - 2;
		return copy;
	}
	
	public ClosedQuestions clonewithoutanswers() throws CloneNotSupportedException {
		ClosedQuestions q = (ClosedQuestions) super.clone();
		ClosedQuestions copy = q;
		copy.setAnswers(new ArrayList<Answer>());			
		copy.answers.add(new Answer("there is more than one corect answer", false));
		copy.answers.add(new Answer("None of the Answers is corect", true));
		return copy;
	}

	public String printTest() {// to String for test
		StringBuffer sb = new StringBuffer();
		if (numCorrectAnswers > 1) {
			for (int i = 1; i < numOfAnswers + 2; i++) {
				answers.get(i).editType(false);
			}
		}
		sb.append("\n   The optional answers are: \n\n");
		for (int i = 0; i < answers.size(); i++) {
			sb.append((i + 1) + ") " + answers.get(i).toString() + "\n");
		}
		return sb.toString();
	}

	public String printAnswers() { // to String for test
		StringBuffer sb = new StringBuffer();
		sb.append("The optional answers are:\n");
		for (int i = 2; i < (numOfAnswers + 2); i++) {
			sb.append((i - 1) + ") " + answers.get(i).toString() + "\n");
		}
		return sb.toString();
	}

	public String toString() { // to String for option 1
		StringBuffer sb = new StringBuffer();
		sb.append("Question number " + getSerialNumber() + " is: " + getText() + "\n");
		sb.append("The optional answers are:\n\n");
		for (int i = 2; i < answers.size(); i++) {
			sb.append((i - 1) + ") " + answers.get(i).toString() + "\n");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String printAnswersGui() { // to String for Gui
		StringBuffer sb = new StringBuffer();
		sb.append("\n The optional answers are:\n");
		for (int i = 0; i < answers.size(); i++) {
			sb.append((i + 1) + ") " + answers.get(i).getText() + "\n");
		}
		return sb.toString();
	}

}
