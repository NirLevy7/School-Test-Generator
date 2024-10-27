package AdirZadok_NirLevy;

import java.util.ArrayList;
import java.util.List;

public class Test implements Cloneable, Comparable<Test> {
	private List<Question> questions;
	private int numOfQuestion;
	private static int counter = 0;
	private int serialNumber;

	public Test(List<Question> q) {
		questions = new ArrayList<Question>();
		this.serialNumber = ++counter;
		if (q != null)
			questions = q;
		if (q == null)
			numOfQuestion = 0;
		else
			numOfQuestion = q.size();
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	
	public int getSerialNumber() {
		return serialNumber;
	}

	
	public int getNumOfQuestion() {
		return numOfQuestion;
	}

	public void addQuestion(Question q) {
		questions.add(q);
		this.numOfQuestion++;
	}

	@Override
	public Test clone() throws CloneNotSupportedException {
		Test temp = (Test) super.clone();
		temp.setQuestions(new ArrayList<Question>());
		for (int i = 0; i < questions.size(); i++) {
			Question q = questions.get(i);
			Question qtemp = q.clone();
			if (qtemp instanceof ClosedQuestions) {

				temp.questions.add((ClosedQuestions) qtemp);
			}
			if (qtemp instanceof OpenQuestion) {

				temp.questions.add((OpenQuestion) qtemp);
			}
		}
		return temp;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < questions.size(); i++) {
			if (questions.get(i) instanceof ClosedQuestions) {
				sb.append((i + 1) + ")" + questions.get(i).getText());
				sb.append(((ClosedQuestions) questions.get(i)).printTest() + "\n");
			}
			if (questions.get(i) instanceof OpenQuestion) {
				sb.append((i + 1) + ")" + questions.get(i).getText() + "\n");
				sb.append("  The answer is: " + ((OpenQuestion) questions.get(i)).getAnswer() + "\n\n");
			}
			System.out.println();
		}
		return sb.toString();
	}

	public String toStringForGui() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < questions.size(); i++) {
			if (questions.get(i) instanceof ClosedQuestions) {
				sb.append((i + 1) + ")" + questions.get(i).getText());
				sb.append(((ClosedQuestions) questions.get(i)).printAnswersGui() + "\n");
			}
			if (questions.get(i) instanceof OpenQuestion) {
				sb.append((i + 1) + ")" + questions.get(i).getText() + "\n");
				sb.append("  The answer is: " + ((OpenQuestion) questions.get(i)).getAnswer() + "\n\n");
			}
			System.out.println();
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOfQuestion;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (numOfQuestion != other.numOfQuestion)
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}

	@Override
	public int compareTo(Test test2) {
		if (this.numOfQuestion > test2.numOfQuestion)
			return -1;
		if (test2.numOfQuestion == this.numOfQuestion)
			return -1;
		else
			return 0;
	}

}

