package AdirZadok_NirLevy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


//import java.util.Iterator;
//import java.util.LinkedHashSet;
import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;

import Controller.TestServerListener;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Manage {
	//private List<Question> questions;
	//private int numOfQuestions;
	//private int numOfQuestionInTest;
	//private List<Question> testQuestions;
	//private List<Question> questionsForAutoTest;
	//private MySet<Answer> set;
	//private List<Test> tests;
	private TestServerListener listener;
	private SqlConnector connector;

	public Manage() throws ClassNotFoundException, SQLException {
		//this.numOfQuestionInTest = 0;
		//numOfQuestions = 0;
		//questions = new ArrayList<Question>();
		//set = new MySet<Answer>();
		//tests = new ArrayList<Test>();
		//testQuestions = new ArrayList<Question>();
		connector = new SqlConnector();
	}

	public void registerListener(TestServerListener listener) {
		this.listener = listener;
	}

	/*public ArrayList<Question> fireAllDataString() {
		ArrayList<Question> allData = (ArrayList<Question>) questions;
		return allData;

	}*/

	/*public MySet<Answer> getSet() {
		return set;
	}*/

	/*public int getAutoTestLength() {
		return questionsForAutoTest.size();
	}*/

	/*public int getquestionslength() {
		return questions.size();
	}*/

	/*public List<Question> getTestQuestions() {
		return testQuestions;
	}*/

	/*public List<Test> getTests() {
		return tests;
	}*/

	/*public void createManuelTest(int num) {
		testQuestions = new ArrayList<Question>();
		numOfQuestionInTest = 0;
	}*/


	/*public Test pickTest(int num) {
		Test test = tests.get(num - 1);
		return test;
	}*/

	/*public Test copyTest(Test test) throws CloneNotSupportedException {
		test = test.clone();
		return test;
	}*/

	/*public Question createOpenQuestion(String text, String answer) {
		Question question = new OpenQuestion(text, answer);
		return question;
	}*/

	/*public Question createClosedQuestion(String text, int num) {
		boolean check = checkNumAddAnswers(num);
		if (check == false) {
			return null;
		}
		Question question = new ClosedQuestions(text, num);
		return question;
	}*/

	/*public boolean checkNumAddAnswers(int num) {
		if (num > 8 || num < 4) {
			return false;
		}
		return true;
	}*/

	/*public boolean checkQuestionTest(String text) {// check if question exist in test
		if (numOfQuestionInTest == 0) {
			return true;
		}
		List<Question> q = testQuestions;
		for (int i = 0; i < numOfQuestionInTest; i++) {
			if (q.get(i).getText().equalsIgnoreCase(text)) {
				return false;
			}
		}
		return true;
	}*/

	/*public boolean checkAnswerInQuestionTest(Answer answer, ClosedQuestions q) {
		boolean check = q.existAnswerCheck(answer.getText(), 2);
		if (check) {
			return false;
		}
		return true;
	}*/

	/*public boolean checkTypeAnswerForAutoTest(ClosedQuestions q, Answer answer) {
		if (q.checkAnswerToAutoTest(answer) == true) {
			return true;
		}
		return false;
	}*/

	/*public void addAnswerToClosedQuestion(Question question, String text, boolean type) {
		Answer answer = new Answer(text, type);
		set.Add(answer);
		((ClosedQuestions) question).addAnswer(answer);
	}*/

	/*public void addQuestionTotest(Question question) {// adding question to test
		testQuestions.add(question);
		numOfQuestionInTest = numOfQuestionInTest + 1;
	}*/

	/*public void addQuestion(Question question) {
		questions.add(question);
		numOfQuestions = numOfQuestions + 1;
	}*/

	/*public void addAnswerToTest(ClosedQuestions q, Answer answer) {
		q.addAnswerToTest(answer);
	}*/

	/*public Question sendQuestionAutoTest(int num) {
		return questionsForAutoTest.get(num);
	}*/

	/*public ClosedQuestions sendAmericanQuestion(int num) {
		return (ClosedQuestions) questions.get(num - 1);
	}*/

	/*public Question sendQuestion(int num) {
		return questions.get(num - 1);
	}*/

	/*public boolean existQuestionCheck(String text, int ch) {// check if there is already question with the same text
		boolean check = true;
		for (int i = 0; i < numOfQuestions; i++) {
			if (ch == 1 && questions.get(i) instanceof OpenQuestion) {
				check = questions.get(i).equals(text);
				if (check) {
					return false;
				}
			}
			if (ch == 2 && questions.get(i) instanceof ClosedQuestions) {
				check = questions.get(i).equals(text);
				if (check) {
					return false;
				}
			}
		}
		return true;
	}*/

	/*public void organizeQuestionAfterDelete(ClosedQuestions q, int num) {
		q.organizeQuestionAfterDelete(num);
	}*/

	/*public String showSet() {
		return set.toString();
	}*/

	/*public void questionsForAutoTest() {
		List<Question> arr = new ArrayList<Question>();
		for (int i = 0; i < numOfQuestions; i++) {
			if (questions.get(i) instanceof ClosedQuestions
					&& ((ClosedQuestions) questions.get(i)).getNumOfIncorrectAnswers() >= 3
					|| questions.get(i) instanceof OpenQuestion) {
				arr.add(questions.get(i));
				questionsForAutoTest = arr;
			}
		}
	}*/


	/*public String PrintTest() {// print only the questions in the test array
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numOfQuestionInTest; i++) {
			if (testQuestions.get(i) instanceof ClosedQuestions) {
				sb.append((i + 1) + ") " + testQuestions.get(i).getText());
				sb.append(((ClosedQuestions) testQuestions.get(i)).printTest() + "\n");
			}
			if (testQuestions.get(i) instanceof OpenQuestion) {
				sb.append((i + 1) + ") " + testQuestions.get(i).getText() + "\n");
				sb.append("   The answer is: " + ((OpenQuestion) testQuestions.get(i)).getAnswer() + "\n\n");
			}
		}
		return sb.toString();
	}*/

	/*public String PrintOnlyQuestionsTest() {// print the questions for manual test
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numOfQuestionInTest; i++) {
			if (testQuestions.get(i) instanceof ClosedQuestions) {
				sb.append((i + 1) + ") " + testQuestions.get(i).getText() + "\n");
			}

			if (testQuestions.get(i) instanceof OpenQuestion) {
				sb.append((i + 1) + ") " + testQuestions.get(i).getText() + "\n");
			}
		}
		return sb.toString();
	}*/

	/*public String PrintOnlyQuestionsAutoTest() {// print the questions for auto test
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numOfQuestionInTest; i++) {
			if (testQuestions.get(i) instanceof ClosedQuestions) {
				sb.append((i + 1) + ") " + testQuestions.get(i).getText() + "\n");
			}

			if (testQuestions.get(i) instanceof OpenQuestion) {
				sb.append((i + 1) + ") " + testQuestions.get(i).getText() + "\n");
			}
		}
		return sb.toString();
	}*/

	/*public String toString() {// print the whole questions in the system
		StringBuffer sb = new StringBuffer("The questions in the system are :\n\n");
		for (int i = 0; i < numOfQuestions; i++) {
			if (questions.get(i) instanceof ClosedQuestions) {
				sb.append(((ClosedQuestions) questions.get(i)).toString());
			} else if (questions.get(i) instanceof OpenQuestion) {
				sb.append(((OpenQuestion) questions.get(i)).toString());
			}
		}
		return sb.toString();
	}*/

	/*public void createAutoTest(int num, int ch) throws IOException {
		int i = 0;
		boolean check = true;
		questionsForAutoTest();
		numOfQuestionInTest = 0;
		while (i < num) {
			int num1 = (int) (Math.random() * getAutoTestLength()) + 0;
			check = checkQuestionTest(sendQuestionAutoTest(num1).getText());
			while (!check) {
				num1 = (int) (Math.random() * (getAutoTestLength())) + 0;
				check = checkQuestionTest(sendQuestionAutoTest(num1).getText());
			}
			if (sendQuestionAutoTest(num1) instanceof OpenQuestion) {
				addQuestionTotest(sendQuestionAutoTest(num1));
			}
			if (sendQuestionAutoTest(num1) instanceof ClosedQuestions) {
				int r = 0;
				boolean check1 = true, check2 = true;
				Question question = sendQuestionAutoTest(num1);
				int max = ((ClosedQuestions) question).getAmountAnswers() - 2;
				Question qt = createClosedQuestion(sendQuestionAutoTest(num1).getText(), 4);
				addQuestionTotest(qt);
				while (r < 4) {
					int randomPick = (int) (Math.random() * max) + 1;
					check1 = checkAnswerInQuestionTest(((ClosedQuestions) question).sendAnswer(randomPick),
							(ClosedQuestions) qt);

					check2 = checkTypeAnswerForAutoTest((ClosedQuestions) qt,
							((ClosedQuestions) question).sendAnswer(randomPick));

					while (!(check1 && check2)) {
						randomPick = (int) (Math.random() * max) + 1;
						check1 = checkAnswerInQuestionTest(((ClosedQuestions) question).sendAnswer(randomPick),
								(ClosedQuestions) qt);
						check2 = checkTypeAnswerForAutoTest((ClosedQuestions) qt,
								((ClosedQuestions) question).sendAnswer(randomPick));
					}
					Answer ans = ((ClosedQuestions) question).sendAnswer(randomPick);
					addAnswerToClosedQuestion(qt, ans.getText(), ans.getType());
					r = r + 1;
				}
			}
			i = i + 1;
		}
		if (ch == 1) {
			Collections.sort(testQuestions, new CompatreQuestionsByAnswers());
		}
		if (ch == 2) {
			Collections.sort(testQuestions, new CompatreQuestionsByAnswers());
		}
		System.out.println("The questions that you picked are:\n");
		System.out.println(PrintOnlyQuestionsAutoTest());
		System.out.println("The test that has been created:");
		System.out.println(PrintTest());
		addTestToList(testQuestions);
		testQuestions = new ArrayList<Question>();
	}*/

	/*public void addTestToList(List<Question> questionTest) {
		Test test = new Test(questionTest);
		tests.add(test);
	}*/

	/*public void addTest(Test test) {
		tests.add(test);
	}*/

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOfQuestionInTest;
		result = prime * result + numOfQuestions;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + ((questionsForAutoTest == null) ? 0 : questionsForAutoTest.hashCode());
		result = prime * result + ((testQuestions == null) ? 0 : testQuestions.hashCode());
		return result;
	}*/

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manage other = (Manage) obj;
		if (numOfQuestionInTest != other.numOfQuestionInTest)
			return false;
		if (numOfQuestions != other.numOfQuestions)
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (questionsForAutoTest == null) {
			if (other.questionsForAutoTest != null)
				return false;
		} else if (!questionsForAutoTest.equals(other.questionsForAutoTest))
			return false;
		if (testQuestions == null) {
			if (other.testQuestions != null)
				return false;
		} else if (!testQuestions.equals(other.testQuestions))
			return false;
		return true;
	}*/

	public void sendQuestionStringToGuiQuestions() { // PRINT ALL QUESTIONS
		String allQuestion = connector.printQuestion();
		// listener.fireStringToUI(toString());
		listener.fireStringToUI(allQuestion);
	}

	/*public void fireQuestionToMainGui(int i) {
		listener.fireQuestionToMainGui(sendQuestion(i));
	}*/

	public void createClosedQuestionEvent(String s, int i, List<TextField> textFields, // ADD CLOSED QUSTION
			List<ComboBox<Boolean>> typeAnswer) {
		//Question q = createClosedQuestion(s, i);
		//addQuestion(q);
		//for (int k = 0; k < i; k++) {
		//	Answer answer = new Answer(textFields.get(k).getText(), typeAnswer.get(k).getValue());
			//((ClosedQuestions) q).addAnswer(answer);
	//	}
		connector.addCloseQuestion(i, s, textFields, typeAnswer);
		listener.added();
	}

	public void creatAndAddOpenQuestion(String text, String answer) { // ADD OPEN QUESTION
		//Question q = createOpenQuestion(text, answer);
		//addQuestion(q);
		connector.addQuestion(text, "Open Question");
		connector.addOpenQuestion(answer);
		listener.added();
	}

	public void updateExistQuestion(int choice, String update) { // UPDATE EXIST QUESTION
		//Question q = sendQuestion(choice);
		//q.editQuenstion(update);
		connector.updateQuestion(choice, update);
		listener.QuestionChanged();
	}

	public void updateExistClosedQuestionAnswer(String answer, String answerUpdate, int num) { // UPDATE CQ ANSWER
		String s = String.copyValueOf(answer.toCharArray());
		connector.updateCloseQuestionAnswer(s, answerUpdate, num);
		listener.AnswerChecnged();
		//answer.edit(answerUpdate);

	}

	public void updateExistAsnwerOpenQuestion(Integer questionNum, String update) { // UPDATE OQ ANSWER
		//Question q = sendQuestion(questionNum);
		//((OpenQuestion) q).editAnswer(update);
		connector.updateOpenQuestionAnswer(questionNum, update);
		listener.AnswerChecnged();
		
	}

	/*public void createAutoTestEvent(int numQuestions, int choice) throws IOException {
		createAutoTest(numQuestions, choice);
		listener.TestCreated();

	}*/

	public void EarseAnswerFromOpenQuestionEvent(int num) { // ERASE ANSWER FROM OQ
		connector.deleteAnswerFromOpenQuestin(num);
		//Question q = sendQuestion(num);
		//((OpenQuestion) q).editAnswer("");
		listener.AnswerEaresed();

	}

	public void EarseAnswerFromCloseQuestionEvent(String answer, Integer numQuestion) { // EARSE ANSWER FROM CQ
		int check = connector.checkNumOfAnswers(numQuestion);
		if(check ==0)
		{
			listener.cantRemove();	
			return;
		}
		connector.deleteAnswerFromCloseQuestion(answer, numQuestion);
		//Question q = sendQuestion(numOfQuestions);
		//((ClosedQuestions) q).getAnswerByTextAndEarsed(answer);
		listener.AnswerEaresed();
	}

	public void addOpenQuestionToTest(Integer questionNum) throws CloneNotSupportedException { // OQ FOR TEST
		// Question q = sendQuestion(questionNum);
		// OpenQuestion copy = ((OpenQuestion) q).clone();
		// testQuestions.add((Question) copy);
		connector.addopenQuesitonForTest(questionNum);
		listener.addedToTest();
	}

	public void addClosedQuesitonToTest(Integer questionNum, List<String> pickedAnswers) // CQ FOR TEST
			throws CloneNotSupportedException {
	//	Question q = sendQuestion(questionNum);
		//ClosedQuestions copy = ((ClosedQuestions) q).clonewithoutanswers();
		//for (int i = 0; i < pickedAnswers.size(); i++) {
		//	Answer a = pickedAnswers.get(i);
		//	Answer copyanswer = a.clone();
			//copy.addAnswerToTest(copyanswer);
		//}
		//testQuestions.add(copy);
		connector.addTwoCQAnswer(questionNum);
		for (int i = 0; i < pickedAnswers.size(); i++) {
			String str = pickedAnswers.get(i);
			connector.addCloseQuestionToTest(questionNum, str);
		}
		connector.organizeCloseQuestion(questionNum);
		listener.addedToTest();
	}

	public void createManuelTestForGui(Integer num) throws FileNotFoundException, IOException {
		if (num == 0) {
			connector.createTest();
		} else {
			connector.increaseTestCounter();
			listener.TestCreated();
		}
	}

	public void createAutoTestForGui(int numOfQuestions) {
		connector.createTest();
		int i = 0, random = 0;
		boolean happenOnce = false;
		int rounds = 0;
		boolean check2 = true;
		boolean check = true;
		while (i < numOfQuestions) {
			while (check == true) {
				random = (int) (Math.random() * connector.getNumOfQuestion()) + 1;
				random = 5;
				check = connector.checkIfQuestionExistsInTest(random);
			}
			if (check == false) {
				String questionType = connector.getQuestion(random);
				if (questionType.equalsIgnoreCase("open question")) {
					connector.addopenQuesitonForTest(random);
				} else if (questionType.equalsIgnoreCase("close question")) {
					int numOfAnswers = connector.getNumOfAnswers(random);
					while (rounds < 4) {
						while (check2) {
							int random2 = (int) (Math.random() * numOfAnswers) + 1;
							check2 = connector.checkIfAnswerExists(random2, random, happenOnce);
						}
						check2 = true;
						happenOnce = true;
						rounds++;
					}
					connector.addTwoCQAnswer(random);
					connector.organizeCloseQuestion(random);
				}
			}
			check = true;
			i++;
		}
		listener.TestCreated();
	}
	
	public void getAnswerFromSql(int qustionNum) {
		ArrayList<String> answers = connector.getAnswerOfQuestion(qustionNum);
		listener.sendAnswersToGui(answers);
	}

	public void getAnswerForTestFromSql(int num) {
		ArrayList<String> answers = connector.getAnswerOfQuestionForTest(num);
		listener.sendAnswersToGui(answers);
	}
	
	
	public void closeSqlConnector() {
		try {
			connector.close();
			listener.exitAlert();
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
		}

	}

	public void updateDataForGui() {
		List<Integer> openQuesitonNumber = new ArrayList<Integer>();
		List<Integer> closeQuesitonNumber = new ArrayList<Integer>();
		int num = connector.bringData(openQuesitonNumber,closeQuesitonNumber);
		listener.fireDataToGui(num , openQuesitonNumber,closeQuesitonNumber);
	}

	/*public void sendTestsToGui() {
		listener.FireTestsToGui(tests);

	}*/

	/*public void sentTestStringToGui(int k) {
		Test test = tests.get(k - 1);
		String str = test.toStringForGui();
		listener.fireStringToUI(str);
	}*/

	/*public void copyTestForGui(int numOfTest) throws CloneNotSupportedException {
		Test test = tests.get(numOfTest - 1);
		Test copy = test.clone();
		tests.add(copy);
		listener.TestCoprIsDone();
	}*/

	

	

	

}