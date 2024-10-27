package Controller;


import AdirZadok_NirLevy.*;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import View.*;

public class TestController implements TestServerListener, TestUiListener {
	private Manage server;
	private UITest gui;

	public TestController(Manage server, UITest gui) {
		this.server = server;
		this.gui = gui;

		server.registerListener(this);
		gui.registerListener(this);

	}

	public void ShowQuestionsString() {// FromQuestionsGui
		server.sendQuestionStringToGuiQuestions();

	}

	@Override
	public void fireStringToUI(String text) {// ToQuestionsGui
		gui.refresh(text);
	}

	/*@Override
	public void sendQuestionToMainGui(int i) {
		server.fireQuestionToMainGui(i);
	}/*

	/*@Override
	public void fireQuestionToMainGui(Question question) {
		gui.QuestionFromServer(question);

	}*/

	@Override
	public void ShowQuestionOnSecondScreen() {
		ShowQuestionsString();
	}

	@Override
	public void addOpenQuestionEvent(String text, String text2) {// CommantFromUI
		server.creatAndAddOpenQuestion(text, text2);

	}

	@Override
	public void added() {// CommandFromServer
		//gui.addQuestionWindow();
		gui.Alert("Your Question Added", "Your Question Added Sucsesfully");

	}

	@Override
	public void updateWxistQuestionEvent(int choice, String update) {
		server.updateExistQuestion(choice, update);
	}

	@Override
	public void QuestionChanged() {
		//gui.QuestionChangedWindow();
		gui.Alert("Your Question Has Changed","Your Question Changed Sucsesfully");
	}

	@Override
	public void updateClosedQuestionAnswerEvent(String answer, String answerUpdate , int num) {
		server.updateExistClosedQuestionAnswer(answer, answerUpdate,num);
	}

	@Override
	public void AnswerChecnged() {
		//gui.AnswerChecnged();
		gui.Alert("Your Question Has Changed", "Your Question Changed Sucsesfully");
	}

	@Override
	public void updateAnswerOpenQuestionEvent(Integer QuestionNum, String Update) {
		server.updateExistAsnwerOpenQuestion(QuestionNum, Update);
	}

	/*@Override
	public void CreateAutoTestEvent(int numQuestions, int choice) throws IOException {
		server.createAutoTestEvent(numQuestions, choice);
	}*/

	@Override
	public void TestCreated() {
	//	gui.TestCreated();
		gui.Alert("Your Test Has Created", "Your Test Created Sucsesfully");
	}

	@Override
	public void EarseAnswerOpenQuestionEvent(Integer value) {
		server.EarseAnswerFromOpenQuestionEvent(value);
	}

	@Override
	public void AnswerEaresed() {
		//gui.AnswerEaresedAlert();
		gui.Alert("Your Choosen Answer Has Earesed", "Your Answer Earesed Sucsesfully");
	}

	@Override
	public void EarseClosedQuestionAnswerEvent(String answer, Integer numQuestion) {
		server.EarseAnswerFromCloseQuestionEvent(answer, numQuestion);
	}

	@Override
	public void createCloseQuestionEvent(String s, int i, List<TextField> textFields,
			List<ComboBox<Boolean>> typeAnswer) {
		server.createClosedQuestionEvent(s, i, textFields, typeAnswer);
	}

	@Override
	public void addOpenQuestionToTest(Integer questionNum) throws CloneNotSupportedException {
		server.addOpenQuestionToTest(questionNum);
	}

	@Override
	public void addedToTest() {
	//	gui.QuestionAddedToTestAlert();
		gui.Alert("Your Question Added To Test ", "Your Question Added Sucsesfully To The Test");

	}

	@Override
	public void addCloseQuestionToTest(Integer questionNum, List<String> pickedAnswers)
			throws CloneNotSupportedException {
		server.addClosedQuesitonToTest(questionNum, pickedAnswers);
	}

	@Override
	public void createManualTest(Integer num) throws FileNotFoundException, IOException {
		server.createManuelTestForGui(num);
	}

	/*@Override
	public void sendTestsToCombox() {
		server.sendTestsToGui();
	}*/

	/*@Override
	public void FireTestsToGui(List<Test> tests) {
		gui.GerTestsFromServer(tests);
	}*/

	/*@Override
	public void sendTestStringToGUi(int k) {
		server.sentTestStringToGui(k);
	}*/

	/*@Override
	public void copyTestEvent(int numOfTest) throws CloneNotSupportedException {
		server.copyTestForGui(numOfTest);
		
	}*/

	/*@Override
	public void TestCoprIsDone() {
		//gui.TestCopiedAlert();
		gui.Alert("Your Test Is Copied", "Your Test Copied Sucsesfully");
	}*/

	@Override
	public void createAutoTestWithSQL(int numQuestions)  {
		server.createAutoTestForGui(numQuestions);
		
	}

	@Override
	public void closeConnectionToSql() {
		server.closeSqlConnector();
		
	}

	@Override
	public void exitAlert() {
		gui.Alert("Exiting The Program", "Thank you , Bye Bye");
	}

	@Override
	public void getAnswerQuestionSql(int qustionNum) {
		server.getAnswerFromSql(qustionNum);
		
	}

	@Override
	public void sendAnswersToGui(ArrayList<String> answers) {
		gui.updateQuestionAnswerList(answers);
		
	}

	@Override
	public void getAnswerQuestioForTestOnSql(int num) {
		server.getAnswerForTestFromSql(num);

	}

	@Override
	public void updateData() {
		server.updateDataForGui();
		
	}

	@Override
	public void fireDataToGui(int num, List<Integer> openQuesitonNumber, List<Integer> closeQuesitonNumber) {
		gui.updataAllData(num,openQuesitonNumber,closeQuesitonNumber);
	}

	@Override
	public void cantRemove() {
		gui.Alert("Cant Remove The Answer", "you cant eares an answers from question with 4 answers");
	}
	






}
