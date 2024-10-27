package AdirZadok_NirLevy;


import Controller.TestController;
import View.UITest;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Manage server = new Manage();
		/*Question q1 = new OpenQuestion("What is the capital of Spain?", "Madrid");
		Question q2 = new OpenQuestion("Where is Paris?", "France");
		Question q3 = new ClosedQuestions("What the lower place in the world? and where is it?", 4);
		Question q4 = new OpenQuestion("What is the biggest city in Israel?", "Jerusalem");
		Question q5 = new ClosedQuestions("Which of the list are countries in the United States?", 6);
		server.addQuestion(q1);
		server.addQuestion(q2);
		server.addQuestion(q3);
		server.addQuestion(q4);
		server.addQuestion(q5);
		server.addAnswerToClosedQuestion(q3, "The Kineret in Israel", false);
		server.addAnswerToClosedQuestion(q3, "Lac Assal in Africa ", false);
		server.addAnswerToClosedQuestion(q3, "Death Valley National Park in US", false);
		server.addAnswerToClosedQuestion(q3, "Dead sea in Israel", true);
		server.addAnswerToClosedQuestion(q5, "New York", true);
		server.addAnswerToClosedQuestion(q5, "Chicago", false);
		server.addAnswerToClosedQuestion(q5, "California", true);
		server.addAnswerToClosedQuestion(q5, "Houston", false);
		server.addAnswerToClosedQuestion(q5, "Las Vegas", false);
		server.addAnswerToClosedQuestion(q5, "Clivland", false);*/
		UITest view = new UITest(stage);
		TestController testController = new TestController(server, view);
	}

}
