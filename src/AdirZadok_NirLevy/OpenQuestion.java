package AdirZadok_NirLevy;



public class OpenQuestion extends Question implements Cloneable {
	private String answer;

	public OpenQuestion(String text, String answer) {
		super(text);
		this.answer = answer;
	}

	public void editAnswer(String update) {
		answer = update;
	}

	public String getAnswer() {
		return answer;
	}

	public int AnswerLength() {
		return answer.length();
	}

	@Override
	public OpenQuestion clone() throws CloneNotSupportedException {
		Question q = (Question) super.clone();
		OpenQuestion copy = (OpenQuestion) q;
		return copy;
	}

	public String toString() {
		return "Question number " + getSerialNumber() + " is : " + getText() + "\nThe answer is: " + answer + "\n\n";
	}

}
