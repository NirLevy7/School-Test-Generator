package Controller;

import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;


import AdirZadok_NirLevy.Question;
import AdirZadok_NirLevy.Test;
//import id209134782_id315699694.MyArrayList;
//import javafx.scene.control.TextArea;
//import id209134782_id315699694.MyArrayList;
//import javafx.scene.control.TextArea;

public interface TestServerListener {
	//public void fireQuestionToMainGui(Question sendQuestion);
	public void fireStringToUI(String string);
	public void added();
	public void QuestionChanged();
	public void AnswerChecnged();
	public void TestCreated();
	public void AnswerEaresed();
	public void addedToTest();
	//public void FireTestsToGui(List<Test> tests);
	//public void TestCoprIsDone();
	//public void moveListsToGui(ArrayList<Test> jal ,MyArrayList mal);
	//public void moveIteratorToGui(Iterator<Test> it);
	//public void cantRemove();
	//public void fireStringToUI2(String string,TextArea t);
	public void exitAlert();
	public void sendAnswersToGui(ArrayList<String> answers);
	public void fireDataToGui(int num, List<Integer> openQuesitonNumber, List<Integer> closeQuesitonNumber);
	public void cantRemove();
}
