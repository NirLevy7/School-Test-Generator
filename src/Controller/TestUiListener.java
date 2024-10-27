package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import AdirZadok_NirLevy.Answer;
//import AdirZadok_NirLevy.MyArrayList;
import AdirZadok_NirLevy.Question;
//import AdirZadok_NirLevy.Test;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public interface TestUiListener {
	public void ShowQuestionsString(); 
	//public void sendQuestionToMainGui(int i);
	//public void fireQuestionToMainGui(Question question);
	public void ShowQuestionOnSecondScreen();
	public void addOpenQuestionEvent(String text, String text2);
	public void updateWxistQuestionEvent(int choice , String update);
	public void updateClosedQuestionAnswerEvent(String answer, String text,int num);
	public void updateAnswerOpenQuestionEvent(Integer value, String text);
	//public void CreateAutoTestEvent(int numQuestions, int choice) throws IOException;
	public void EarseAnswerOpenQuestionEvent(Integer value);
	public void EarseClosedQuestionAnswerEvent(String value, Integer value2);
	public void createCloseQuestionEvent(String s , int i, List<TextField> textFields, List<ComboBox<Boolean>> typeAnswer);
	public void addOpenQuestionToTest(Integer questionNum) throws CloneNotSupportedException;
	public void addCloseQuestionToTest(Integer questionNum, List<String> pickedAnswers) throws CloneNotSupportedException;
	public void createManualTest(Integer num) throws FileNotFoundException, IOException;
	//public void sendTestsToCombox();
	//public void sendTestStringToGUi(int k);
	//public void copyTestEvent(int numOftest) throws CloneNotSupportedException;
	//public void ShowString(int num);
	//public void showArrayLists();
	//public void removeFromLists(ArrayList<AdirZadok_NirLevy.Test> jal ,MyArrayList mal);
	//public void printWithIterator(Iterator<Test> it,TextArea t);
//	public void createIterator(MyArrayList mal);
	public void createAutoTestWithSQL(int numQuestions);
	public void closeConnectionToSql();
	public void getAnswerQuestionSql(int i);
	public void getAnswerQuestioForTestOnSql(int num);
	public void updateData();

}
