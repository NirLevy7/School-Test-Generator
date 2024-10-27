package View;

import javafx.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import AdirZadok_NirLevy.Answer;
import AdirZadok_NirLevy.ClosedQuestions;
import AdirZadok_NirLevy.OpenQuestion;
import AdirZadok_NirLevy.Question;
import Controller.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlendMode;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UITest {
	private TestUiListener listener;
	//private Question question;
	ArrayList<String> questionAnswers;
	//private List<Test> tests;
	private int numOfQuestions;
	private int numOfQuestionsForTest;
	List<Integer> OpenQuestionsNum;
	List<Integer> ClosedQuestionsNum;
	private TextArea allData;


	public UITest(Stage stage) {
		questionAnswers = new ArrayList<String>();
		//tests = new ArrayList<Test>();
		numOfQuestionsForTest = 0;
		//question = null;
		allData = new TextArea("");
		numOfQuestions = 5;
		OpenQuestionsNum = new ArrayList<Integer>();
		ClosedQuestionsNum = new ArrayList<Integer>();
		//OpenQuestionsNum.add(1);
		//OpenQuestionsNum.add(2);
		//OpenQuestionsNum.add(4);
		//ClosedQuestionsNum.add(3);
		//ClosedQuestionsNum.add(5);
		stage.setTitle("Test System");
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.TOP_CENTER);
		gPane.setHgap(10);
		gPane.setVgap(10);
		Label welcomeLabel = new Label("Welcome to Test Creation System!");
		Label chooseLabel = new Label("Please Choose One From The Followin Options:");
		Label createQuestionLabel = new Label("Please Enter The Type Of Question Ypu Want To Add");
		createQuestionLabel.setBlendMode(BlendMode.DARKEN);
		createQuestionLabel.setTextFill(Color.BLACK);
		Label l2 = new Label("please enter a Closed question Text : ");
		Label l2a = new Label("How Much Answers :  ");
		ComboBox<Integer> answerAtClosedQuestionCreation = new ComboBox<Integer>();
		answerAtClosedQuestionCreation.getItems().addAll(4, 5, 6, 7, 8);
		Label openQuestionCreationTextLabel = new Label("please enter a Opened question Text: ");
		Label openQuestionAnswerCreationLabel = new Label("Please write answer: ");
		Label updateQuestionLabel = new Label("Section Of Update Exist Question: ");
		updateQuestionLabel.setBlendMode(BlendMode.DARKEN);
		updateQuestionLabel.setTextFill(Color.BLACK);
		Label labelSection3a = new Label("Please Enter Number Of Question You Want To Update: ");
		Label labelSection3b = new Label("Please Enter The Update Text: ");
		Label labelSection4 = new Label("Section Of Update Exist Answer/Earse Answer: ");
		labelSection4.setBlendMode(BlendMode.DARKEN);
		labelSection4.setTextFill(Color.BLACK);
		Label labelSection4a = new Label("Please Write the type of Question you watn to update the answer: ");
		Label labelSection4b = new Label("Please Enter The Number Of Question: ");
		Label labelSection4c = new Label("Please Write The Update Text Of The Question's Answer: ");
		Label labelSection4d = new Label("If you choose Closed Question Please seleced which answer");
		Label labelSection5 = new Label("Section Of Automatic Test Creation: ");
		labelSection5.setBlendMode(BlendMode.DARKEN);
		labelSection5.setTextFill(Color.BLACK);
		Label labelSection5a = new Label("How Much Questions You Want In the Test: ");
		Label labelSection5b = new Label("How do You Want To Orgenaize The Test: ");
		Label manualTestLabel = new Label("Section Of Manual Test Creation: ");
		manualTestLabel.setBlendMode(BlendMode.DARKEN);
		manualTestLabel.setTextFill(Color.BLACK);
		Label manualTestLabelTypeQuestion = new Label("Which Type Of Question You Want To Add: ");
		//ComboBox<String> manualTestTypeCombox = new ComboBox<String>();
		//manualTestTypeCombox.getItems().addAll("Open Question", "Closed Question");
		Label manualTestLabelWhichQuestion = new Label("Which Question You Want To Add:");
		ComboBox<Integer> manualTestQuestionsNumbers = new ComboBox<Integer>();
		TextField f2 = new TextField();
		TextField f3a = new TextField();
		TextField f3 = new TextField();
		TextField textFieldSection3a = new TextField();
		TextField textFieldSection4 = new TextField();
		TextField textFieldSection5 = new TextField();
		textFieldSection5.setMinWidth(5.0);
		
		//comboBox3.getItems().addAll(1, 2, 3, 4, 5);
		//ComboBox<String> comboBox4a = new ComboBox<String>();
		//comboBox4a.getItems().addAll("Open Question", "Closed Question");
		//ComboBox<Integer> comboBox4b = new ComboBox<Integer>();
		//ComboBox<String> comboBox4a5 = new ComboBox<String>();
		//comboBox4a5.getItems().addAll("Open Question", "Closed Question");
		//ComboBox<Integer> comboBox4b5 = new ComboBox<Integer>();
		ComboBox<String> comboBox4c = new ComboBox<String>();
		ComboBox<String> comboBox4c5 = new ComboBox<String>();
		//ComboBox<String> comboBox5a = new ComboBox<String>();
		//comboBox5.getItems().addAll(1, 2, 3, 4, 5);
		//comboBox5a.getItems().addAll("InstenSort - choice number (1)", "By Answer - choice number (2)");

		Button btn2 = new Button("Create Closed Question");
		Button btn2a = new Button("Create Open Question");
		Button btn3 = new Button("Update Question Text");
		Button btn4 = new Button("Update Answer text");
		Button btn5 = new Button("Earse Answer");
		Button btn6 = new Button("Add Question To Manuel Test");
		Button btn7 = new Button("Create Automatic Test");
		//Button btn11 = new Button("Remove");
		btn7.setScaleX(1.00);
		ToggleGroup tg = new ToggleGroup();
		RadioButton section1 = new RadioButton(" (1) Show All Questions In The System");
		RadioButton section2 = new RadioButton(" (2) Add new question and answer");
		RadioButton section3 = new RadioButton(" (3) Update exists question");
		RadioButton section4 = new RadioButton(" (4) Update exists answer");
		RadioButton section5 = new RadioButton(" (5) Erase answer of question");
		RadioButton section6 = new RadioButton(" (6) Manual test creation");
		RadioButton section7 = new RadioButton(" (7) Automatic test creation");
		//RadioButton section8 = new RadioButton(" (8) Copy of exist test");
		Button exit = new Button("EXIT");
		//RadioButton section9 = new RadioButton(" (9) Collection with duplicates");
	//	RadioButton section10 = new RadioButton("(10) Collection without duplicates");
		//RadioButton section11 = new RadioButton("(11) Create arraylist and iterator");
		//RadioButton section12 = new RadioButton("(12) Observers");
		section1.setToggleGroup(tg);
		section2.setToggleGroup(tg);
		section3.setToggleGroup(tg);
		section4.setToggleGroup(tg);
		section5.setToggleGroup(tg);
		section6.setToggleGroup(tg);
		section7.setToggleGroup(tg);
		//section8.setToggleGroup(tg);
		//section9.setToggleGroup(tg);
		//section10.setToggleGroup(tg);
		//section11.setToggleGroup(tg);
		//section12.setToggleGroup(tg);
		gPane.add(welcomeLabel, 0, 0);
		gPane.add(chooseLabel, 0, 1);
		gPane.add(section1, 0, 2);
		gPane.add(section2, 0, 3);
		gPane.add(section3, 0, 4);
		gPane.add(section4, 0, 5);
		gPane.add(section5, 0, 6);
		gPane.add(section6, 0, 7);
		gPane.add(section7, 0, 8);
		//gPane.add(section8, 0, 9);
		gPane.add(exit, 0, 9);
		//gPane.add(section9, 0, 10);
		//gPane.add(section10, 0, 11);
		//gPane.add(section11, 0, 12);
		//gPane.add(section12, 0, 13);
		stage.setScene(new Scene(gPane, 350, 325));
		section1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				listener.updateData();
				Stage stage1 = new Stage();
				stage1.setTitle("All Questions In The System");
				GridPane gp = new GridPane();
				gp.setAlignment(Pos.TOP_LEFT);
				Label firstrow = new Label();
				gp.add(firstrow, 0, 0);
				gp.add(allData, 0, 1);
				allData.setPrefHeight(600);
				allData.setEditable(false);
				listener.ShowQuestionsString();
				stage1.setScene(new Scene(gp, 500, 650));
				stage1.show();
				section1.setSelected(false);
				/*
				 * stage1.setOnCloseRequest(event -> { Alert alert = new
				 * Alert(Alert.AlertType.INFORMATION);
				 * alert.setContentText("This window cannot be closed"); alert.showAndWait();
				 * event.consume(); });
				 */
			}
		});

		section2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				listener.updateData();
				Stage stage2 = new Stage();
				stage2.setTitle("New Question Creation");
				GridPane gp2 = new GridPane();
				RadioButton closedQuestionCoice = new RadioButton("Closed Question");
				RadioButton openQuestionCoice = new RadioButton("Open Question");
				l2.setDisable(true);
				f2.setDisable(true);
				l2a.setDisable(true);
				answerAtClosedQuestionCreation.setDisable(true);
				btn2.setDisable(true);
				openQuestionCreationTextLabel.setDisable(true);
				f3.setDisable(true);
				btn2a.setDisable(true);
				f3a.setDisable(true);
				openQuestionAnswerCreationLabel.setDisable(true);
				openQuestionCoice.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						stage2.setOnCloseRequest(event -> {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setContentText("You have to finish to create the question");
							alert.showAndWait();
							event.consume();
						});
						closedQuestionCoice.setVisible(false);
						l2.setVisible(false);
						f2.setVisible(false);
						l2a.setVisible(false);
						answerAtClosedQuestionCreation.setVisible(false);
						btn2.setVisible(false);
						btn2a.setDisable(false);
						f3a.setDisable(false);
						openQuestionAnswerCreationLabel.setDisable(false);
						openQuestionCreationTextLabel.setDisable(false);
						f3.setDisable(false);
					}
				});
				closedQuestionCoice.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						stage2.setOnCloseRequest(event -> {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setContentText("You have to finish to create the question");
							alert.showAndWait();
							event.consume();
						});
						openQuestionCreationTextLabel.setVisible(false);
						f3.setVisible(false);
						openQuestionAnswerCreationLabel.setVisible(false);
						f3a.setVisible(false);
						btn2a.setVisible(false);
						openQuestionCoice.setVisible(false);
						l2.setDisable(false);
						f2.setDisable(false);
						l2a.setDisable(false);
						answerAtClosedQuestionCreation.setDisable(false);
						btn2.setDisable(false);
					}
				});
				gp2.setHgap(5);
				gp2.setVgap(5);
				gp2.setAlignment(Pos.TOP_CENTER);
				gp2.add(createQuestionLabel, 0, 0);
				gp2.add(closedQuestionCoice, 0, 1);
				gp2.add(l2, 0, 2);
				gp2.add(f2, 0, 3);
				gp2.add(l2a, 0, 4);
				gp2.add(answerAtClosedQuestionCreation, 0, 5);
				gp2.add(btn2, 0, 6);

				btn2.setOnAction(new EventHandler<ActionEvent>() { // add Closed Question

					@Override
					public void handle(ActionEvent arg0) {
						if (answerAtClosedQuestionCreation.getValue() == null || f2.getText() == "") {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("ERROR");
							alert.setHeaderText("Empty Fields");
							alert.setContentText("You didn't fill all fields");
							alert.showAndWait();
							// f2.clear();
						} else {
							String s = f2.getText();
							Stage dialog = new Stage();
							dialog.setOnCloseRequest(event -> {
								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.setContentText("Please finish to add the answers to the question");
								alert.showAndWait();
								event.consume();
							});
							dialog.setTitle("Answers For Closed Question");
							GridPane gp = new GridPane();
							gp.setHgap(10);
							gp.setVgap(10);
							gp.setAlignment(Pos.TOP_LEFT);
							List<TextField> textFields = new ArrayList<TextField>();
							List<ComboBox<Boolean>> typeAnswer = new ArrayList<ComboBox<Boolean>>();
							for (int i = 0; i < answerAtClosedQuestionCreation.getValue(); i++) {
								Label l = new Label("Answer Number " + (i + 1));
								TextField txt = new TextField();
								ComboBox<Boolean> type = new ComboBox<Boolean>();
								type.getItems().addAll(true, false);
								textFields.add(txt);
								typeAnswer.add(type);
								gp.add(l, 0, i);
								gp.add(txt, 1, i);
								gp.add(type, 2, i);
							}
							Button addAnswersButton = new Button("Add Answers");
							addAnswersButton.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									for (int i = 0; i < answerAtClosedQuestionCreation.getValue(); i++) {
										if ((textFields.get(i).getText() == "")
												|| (typeAnswer.get(i).getValue() == null)) {
											Alert alert = new Alert(AlertType.ERROR);
											alert.setTitle("ERROR");
											alert.setHeaderText("Empty Fields");
											alert.setContentText("You didn't fill all fields");
											alert.showAndWait();
											return;
										}
									}

									dialog.close();
									// String s = f2.getText();
									int i = answerAtClosedQuestionCreation.getValue();
									listener.createCloseQuestionEvent(s, i, textFields, typeAnswer);
									listener.ShowQuestionOnSecondScreen();
								}
							});
							gp.add(addAnswersButton, 1, answerAtClosedQuestionCreation.getValue() + 1);
							Scene dialogv = new Scene(gp, 500, 400);
							dialog.setScene(dialogv);
							dialog.show();
							numOfQuestions = numOfQuestions + 1;
							ClosedQuestionsNum.add(numOfQuestions);
							//updateComboBox(numOfQuestions, comboBox3, null);
							//updateComboBox(numOfQuestions, comboBox5, null);
							f2.clear();
							stage2.close();
							openQuestionCreationTextLabel.setVisible(true);
							f3.setVisible(true);
							openQuestionAnswerCreationLabel.setVisible(true);
							f3a.setVisible(true);
							btn2a.setVisible(true);
							openQuestionCoice.setVisible(true);
						}
					}
				});
				gp2.add(openQuestionCoice, 0, 7);
				gp2.add(openQuestionCreationTextLabel, 0, 8);
				gp2.add(f3, 0, 9);
				gp2.add(openQuestionAnswerCreationLabel, 0, 10);
				gp2.add(f3a, 0, 11);
				gp2.add(btn2a, 0, 12);
				btn2a.setOnAction(new EventHandler<ActionEvent>() { // add Open Question

					@Override
					public void handle(ActionEvent arg0) {
						if (f3a.getText().equals("") || f3.getText().equals("")) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("ERROR");
							alert.setHeaderText("Error At Open Question Creation");
							alert.setContentText("You can't create a Question with No Answer Or No Question Text");
							alert.showAndWait();
						} else {
							listener.addOpenQuestionEvent(f3.getText(), f3a.getText());
							f3.setText("");
							f3a.setText("");
							numOfQuestions = numOfQuestions + 1;
							OpenQuestionsNum.add(numOfQuestions);
							//updateComboBox(numOfQuestions, comboBox3, null);
							//updateComboBox(numOfQuestions, comboBox5, null);
							listener.ShowQuestionOnSecondScreen();
							stage2.close();
							l2.setVisible(true);
							f2.setVisible(true);
							l2a.setVisible(true);
							answerAtClosedQuestionCreation.setVisible(true);
							btn2.setVisible(true);
						}
					}
				});

				stage2.setScene(new Scene(gp2, 500, 500));
				stage2.show();
				section2.setSelected(false);
			}
		});

		section3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				listener.updateData();
				Stage stage3 = new Stage();
				stage3.setTitle("Updating Exist Question");
				ComboBox<Integer> comboBox3 = new ComboBox<Integer>();
				for(int i=1; i<=numOfQuestions ; i++)
				{
					comboBox3.getItems().add(i);
				}
				GridPane gp3 = new GridPane();
				gp3.setAlignment(Pos.TOP_CENTER);
				gp3.setHgap(5);
				gp3.setVgap(5);
				gp3.add(updateQuestionLabel, 0, 0);
				gp3.add(labelSection3a, 0, 1);
				gp3.add(comboBox3, 0, 2);
				gp3.add(labelSection3b, 0, 3);
				gp3.add(textFieldSection3a, 0, 4);
				gp3.add(btn3, 0, 5);
				btn3.setOnAction(new EventHandler<ActionEvent>() { // Update Exist Question

					@Override
					public void handle(ActionEvent arg0) {
						int choice = comboBox3.getValue();
						String s = textFieldSection3a.getText();
						listener.updateWxistQuestionEvent(choice, s);
						textFieldSection3a.setText("");
						listener.ShowQuestionOnSecondScreen();
						stage3.close();
					}
				});
				stage3.setScene(new Scene(gp3, 400, 180));
				stage3.show();
				section3.setSelected(false);

			}
		});

		

		section4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Stage stage4 = new Stage();
				listener.updateData();
				ComboBox<String> comboBox4a = new ComboBox<String>();
				comboBox4a.getItems().addAll("Open Question", "Closed Question");
				ComboBox<Integer> comboBox4b = new ComboBox<Integer>();
				comboBox4a.setDisable(false);
				comboBox4b.setDisable(false);
				comboBox4c.setDisable(false);
				//Stage stage4 = new Stage();
				stage4.setTitle("Updating Answer In Exist Question");
				GridPane gp4 = new GridPane();
				//comboBox4a.getItems().addAll("Open Question", "Closed Question");
				gp4.setAlignment(Pos.TOP_CENTER);
				gp4.setHgap(5);
				gp4.setVgap(5);
				gp4.add(labelSection4, 0, 0);
				gp4.add(labelSection4a, 0, 1);
				gp4.add(comboBox4a, 0, 2);
				comboBox4a.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						//comboBox4b.getItems().clear();
						if (comboBox4a.getValue().equals("Open Question")) {
							if(comboBox4b.getItems() !=null) {
								comboBox4b.getItems().clear();
							}
							ArrayList<Integer> open = new ArrayList<Integer>();
							open.addAll(OpenQuestionsNum);
							comboBox4b.getItems().addAll(open);
							labelSection4d.setVisible(false);
							comboBox4c.setVisible(false);
						} else {
							if(comboBox4b.getItems() !=null) {
								comboBox4b.getItems().clear();
							}
							ArrayList<Integer> close = new ArrayList<Integer>();
							close.addAll(ClosedQuestionsNum);
							comboBox4b.getItems().addAll(close);
							labelSection4d.setVisible(true);
							comboBox4c.setVisible(true);
						}
					}
				});
				gp4.add(labelSection4b, 0, 3);
				gp4.add(comboBox4b, 0, 4);
				comboBox4b.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						comboBox4a.setDisable(true);
						comboBox4c.getItems().clear();
						int i = comboBox4b.getValue();
						listener.getAnswerQuestionSql(i);
						//listener.sendQuestionToMainGui(i);
						addAnswersTocomboBox4c(comboBox4c, questionAnswers);
					}

				});
				gp4.add(labelSection4d, 0, 5);
				gp4.add(comboBox4c, 0, 6);
				gp4.add(labelSection4c, 0, 7);
				gp4.add(textFieldSection4, 0, 8);
				gp4.add(btn4, 0, 9);
				btn4.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						comboBox4a.setDisable(false);
						if (comboBox4a.getValue().equals("Closed Question")) {
							listener.updateClosedQuestionAnswerEvent(comboBox4c.getValue(),
									textFieldSection4.getText(),comboBox4b.getValue());
						} else {
							listener.updateAnswerOpenQuestionEvent(comboBox4b.getValue(), textFieldSection4.getText());

						}
						listener.ShowQuestionOnSecondScreen();
						textFieldSection4.setText("");
						stage4.close();
					}

				});
				stage4.setScene(new Scene(gp4, 400, 400));
				stage4.show();
				section4.setSelected(false);

			}
		});
		
		/*comboBox4a.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				//comboBox4b.getItems().clear();
				if (comboBox4a.getValue().equals("Open Question")) {
					if(comboBox4b.getItems() !=null) {
						comboBox4b.getItems().clear();
					}
					ArrayList<Integer> open = new ArrayList<Integer>();
					open.addAll(OpenQuestionsNum);
					comboBox4b.getItems().addAll(open);
					labelSection4d.setVisible(false);
					comboBox4c.setVisible(false);
				} else {
					if(comboBox4b.getItems() !=null) {
						comboBox4b.getItems().clear();
					}
					ArrayList<Integer> close = new ArrayList<Integer>();
					close.addAll(ClosedQuestionsNum);
					comboBox4b.getItems().addAll(close);
					labelSection4d.setVisible(true);
					comboBox4c.setVisible(true);
				}
			}
		});*/

		/*comboBox4a5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				comboBox4b5.getItems().clear();
				if (comboBox4a5.getValue().equals("Open Question")) 
				{
					
					comboBox4b5.getItems().addAll(OpenQuestionsNum);
					labelSection4d.setVisible(false);
					comboBox4c5.setVisible(false);
				} else {
					
					comboBox4b5.getItems().addAll(ClosedQuestionsNum);
					labelSection4d.setVisible(true);
					comboBox4c5.setVisible(true);
				}
			}
		});*/

		/*comboBox4b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				comboBox4a.setDisable(true);
				comboBox4c.getItems().clear();
				int i = comboBox4b.getValue();
				listener.getAnswerQuestionSql(i);
				//listener.sendQuestionToMainGui(i);
				addAnswersTocomboBox4c(comboBox4c, questionAnswers);
			}

		});*/

		/*comboBox4b5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				comboBox4c5.getItems().clear();
				//comboBox4a5.setDisable(true);
				int i = comboBox4b5.getValue();
				listener.getAnswerQuestionSql(i);
				//listener.sendQuestionToMainGui(i);
				addAnswersTocomboBox4c(comboBox4c5, questionAnswers);
			}

		});*/

		section5.setOnAction(new EventHandler<ActionEvent>() {//

			@Override
			public void handle(ActionEvent arg0) {
				listener.updateData();
				Stage stage5 = new Stage();
				GridPane gp5 = new GridPane();
				gp5.setAlignment(Pos.TOP_CENTER);
				gp5.setHgap(5);
				gp5.setVgap(5);
				Label earseLabel = new Label("Please choose the Question's type: ");
				ComboBox<String> comboBox4a5 = new ComboBox<String>();
				comboBox4a5.getItems().addAll("Open Question", "Closed Question");
				ComboBox<Integer> comboBox4b5 = new ComboBox<Integer>();
				gp5.add(labelSection4, 0, 0);
				gp5.add(earseLabel, 0, 1);
				gp5.add(comboBox4a5, 0, 2);
				comboBox4a5.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						comboBox4b5.getItems().clear();
						if (comboBox4a5.getValue().equals("Open Question")) 
						{
							
							comboBox4b5.getItems().addAll(OpenQuestionsNum);
							labelSection4d.setVisible(false);
							comboBox4c5.setVisible(false);
						} else {
							
							comboBox4b5.getItems().addAll(ClosedQuestionsNum);
							labelSection4d.setVisible(true);
							comboBox4c5.setVisible(true);
						}
					}
				});
				gp5.add(labelSection4b, 0, 3);
				comboBox4b5.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						comboBox4c5.getItems().clear();
						//comboBox4a5.setDisable(true);
						int i = comboBox4b5.getValue();
						listener.getAnswerQuestionSql(i);
						//listener.sendQuestionToMainGui(i);
						addAnswersTocomboBox4c(comboBox4c5, questionAnswers);
					}

				});
				gp5.add(comboBox4b5, 0, 4);
				gp5.add(labelSection4d, 0, 5);
				gp5.add(comboBox4c5, 0, 6);
				gp5.add(btn5, 0, 7);
				btn5.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						if (comboBox4a5.getValue().equals("Closed Question")) {
							listener.EarseClosedQuestionAnswerEvent(comboBox4c5.getValue(), comboBox4b5.getValue());
						} else {
							listener.EarseAnswerOpenQuestionEvent(comboBox4b5.getValue());
						}
						listener.ShowQuestionOnSecondScreen();
						comboBox4c5.getItems().remove(comboBox4c5.getValue());
						stage5.close();
					}
				});
				stage5.setScene(new Scene(gp5, 400, 300));
				stage5.show();
				section5.setSelected(false);

			}
		});

		section6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				listener.updateData();
				try {
					listener.createManualTest(0);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Stage stage6 = new Stage();
				stage6.setTitle("Manual Test Creation");
				numOfQuestionsForTest = 0;
				ArrayList<Integer> copyClose = (ArrayList<Integer>) ClosedQuestionsNum;
				ArrayList<Integer> copyOpen = (ArrayList<Integer>) OpenQuestionsNum;
				ComboBox<String> manualTestTypeCombox = new ComboBox<String>();
				manualTestTypeCombox.getItems().addAll("Open Question", "Closed Question");
				GridPane gp6 = new GridPane();
				Button btn6a = new Button("Create Manual Test");
				//ComboBox<String> comboBox6 = new ComboBox<String>();
				//comboBox6.getItems().addAll("InstenSort - choice number (1)", "By Answer - choice number (2)");
				gp6.setHgap(5);
				gp6.setVgap(5);
				gp6.setAlignment(Pos.TOP_CENTER);
				gp6.add(manualTestLabelTypeQuestion, 0, 0);
				gp6.add(manualTestTypeCombox, 0, 1);
				gp6.add(manualTestLabelWhichQuestion, 0, 2);
				gp6.add(manualTestQuestionsNumbers, 0, 3);
				//Label l = new Label("Please choose how to sort the question :");
				//gp6.add(l, 0, 5);
				//gp6.add(comboBox6, 0, 6);
				gp6.add(btn6, 0, 4);
				Label lab = new Label("After you picked at least 1 question please press here:");
				gp6.add(lab, 0, 7);
				gp6.add(btn6a, 0, 8);
				stage6.setOnCloseRequest(event -> {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("You have to finish to create the test ");
					alert.showAndWait();
					event.consume();
				});
				manualTestTypeCombox.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						manualTestQuestionsNumbers.getItems().clear();
						if (manualTestTypeCombox.getValue().equals("Closed Question")) {
							manualTestQuestionsNumbers.getItems().addAll(copyClose);
						} else {
							manualTestQuestionsNumbers.getItems().addAll(copyOpen);
						}
					}
				});

				btn6.setOnAction(new EventHandler<ActionEvent>() { // add question to test button

					@Override
					public void handle(ActionEvent arg0) {
						
						if (manualTestQuestionsNumbers.getValue() == null || manualTestTypeCombox.getValue() == null) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("ERROR");
							alert.setHeaderText("Error At Choose Question To Test");
							alert.setContentText("You can't add a question without type or question's number");
							alert.showAndWait();
						}

						if (manualTestTypeCombox.getValue().equals("Open Question")) {
							try {
								int i = manualTestQuestionsNumbers.getValue();
								listener.addOpenQuestionToTest(i);
								numOfQuestionsForTest++;
								int k = findInt(copyOpen, i);
								manualTestQuestionsNumbers.getItems().remove(k);
							} catch (CloneNotSupportedException e) {
								e.printStackTrace();
							}
						}

						if (manualTestTypeCombox.getValue().equals("Closed Question")) {
							Stage dialog = new Stage();
							dialog.setOnCloseRequest(event -> {
								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.setContentText("This window cannot be closed");
								alert.showAndWait();
								event.consume();
							});
							dialog.setTitle("Answers For Closed Question In Test");
							
							GridPane gp = new GridPane();
							Button AddAnswerInTest = new Button("Add Answers");
							Button pick = new Button("Pick");
							gp.setHgap(10);
							gp.setVgap(10);
							gp.setAlignment(Pos.TOP_CENTER);
							int num = manualTestQuestionsNumbers.getValue();
							//listener.sendQuestionToMainGui(num);
							//listener.getAnswerQuestioForTestOnSql(num);
							listener.getAnswerQuestionSql(num);
							//List<String> list = addAnswersToList(question);
							ComboBox<String> answers = new ComboBox<String>();
							for (int i = 0; i < questionAnswers.size(); i++) {
								answers.getItems().add(questionAnswers.get(i));
							}
							gp.add(answers, 0, 0);
							gp.add(pick, 0, 1);
							gp.add(AddAnswerInTest, 0, 3);
							List<String> pickedAnswers = new ArrayList<String>();
							pick.setOnAction(new EventHandler<ActionEvent>() { // pick answer for closed question

								@Override
								public void handle(ActionEvent arg0) {
									boolean check = checkIfExist(pickedAnswers, answers.getValue());
									if (check == false) {
										pickedAnswers.add(answers.getValue());
									} else {
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("ERROR");
										alert.setHeaderText("You are already picked that answer");
										alert.showAndWait();
									}
								}

							});
							AddAnswerInTest.setOnAction(new EventHandler<ActionEvent>() { // add answers for closed
																							// quesiton

								@Override
								public void handle(ActionEvent arg0) {
									if (pickedAnswers.size() < 4) {
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("ERROR");
										alert.setHeaderText("You Have to pick at least 4 answers!");
										alert.showAndWait();
									} else {
									try {
										//int i = manualTestQuestionsNumbers.getValue();
										listener.addCloseQuestionToTest(manualTestQuestionsNumbers.getValue(),
												pickedAnswers);
										numOfQuestionsForTest++;
										//int k = findInt(copyClose, i);
										//manualTestQuestionsNumbers.getItems().remove(k);
										dialog.close();
									} catch (CloneNotSupportedException e) {
										e.printStackTrace();
									}
								}
								}
							});
							dialog.setScene(new Scene(gp, 300, 300));
							dialog.show();
						}
					}

				});

				btn6a.setOnAction(new EventHandler<ActionEvent>() { // create manual test button

					@Override
					public void handle(ActionEvent arg0) {
						//if (numOfQuestionsForTest < 1 || comboBox6.getValue() == null) {
							if (numOfQuestionsForTest < 1) {
							/*Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("ERROR");
							alert.setHeaderText("You have to add at least one question and select the sort type");
							alert.showAndWait();*/
							Alert("ERROR", "You have to add at least one question");
						}
						try {
							//manualTestTypeCombox.setValue(null);
							//int k = getNumberFromStringQuestion(comboBox6.getValue(), 1);
							listener.createManualTest(1);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						stage6.close();
					}
				});
				stage6.setScene(new Scene(gp6, 300, 300));
				stage6.show();
				section6.setSelected(false);
			}
		});

		section7.setOnAction(new EventHandler<ActionEvent>() {// Automatic Test Creation

			@Override
			public void handle(ActionEvent arg0) {
				listener.updateData();
				Stage stage7 = new Stage();
				stage7.setTitle("Automatic Test Creation");
				GridPane gp7 = new GridPane();
				gp7.setHgap(5);
				gp7.setVgap(5);
				gp7.setAlignment(Pos.TOP_CENTER);
				ComboBox<Integer> comboBox5 = new ComboBox<Integer>();
				for(int i=1 ; i<=numOfQuestions ; i++)
				{
					comboBox5.getItems().add(i);
				}
				gp7.add(labelSection5, 0, 0);
				gp7.add(labelSection5a, 0, 1);
				gp7.add(comboBox5, 0, 2);
				//gp7.add(labelSection5b, 0, 3);
				//gp7.add(comboBox5a, 0, 4);
				gp7.add(btn7, 0, 5);
				btn7.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						int numQuestions = comboBox5.getValue();
						//int choice = getNumberFromStringQuestion(comboBox5a.getValue(), 1);
						//try {
							//listener.CreateAutoTestEvent(numQuestions, choice);
							listener.createAutoTestWithSQL(numQuestions);
						//} catch (IOException e) {
						//	e.printStackTrace();
					//	}
							stage7.close();
					}
				});
				stage7.setScene(new Scene(gp7, 300, 200));
				stage7.show();
				section7.setSelected(false);

			}
		});

		/*section8.setOnAction(new EventHandler<ActionEvent>() {// copy Test

			@Override
			public void handle(ActionEvent arg0) {
				listener.sendTestsToCombox();
				Stage stage8 = new Stage();
				stage8.setTitle("Copy Exist Test");
				GridPane gp8 = new GridPane();
				gp8.setAlignment(Pos.TOP_CENTER);
				gp8.setHgap(10);
				gp8.setVgap(10);
				Label headline = new Label("Section Of Copy Exist Test : ");
				headline.setBlendMode(BlendMode.DARKEN);
				headline.setTextFill(Color.BLACK);
				Label chooseLabel = new Label("Please choose which test you want to see:");
				ComboBox<String> testsCombox = new ComboBox<String>();
				Button showTestButton = new Button("Show Test");
				Label chooseTestCopy = new Label("Please choose the test that you want to copy:");
				ComboBox<String> testsCombox2 = new ComboBox<String>();
				Button copyButton = new Button("Copy Test");
				for (int i = 0; i < tests.size(); i++) {
					testsCombox.getItems().add("Test number (" + (i + 1) + ")");
					testsCombox2.getItems().add("Test number (" + (i + 1) + ")");
				}
				gp8.add(headline, 0, 0);
				gp8.add(chooseLabel, 0, 1);
				gp8.add(testsCombox, 0, 2);
				gp8.add(showTestButton, 0, 3);
				showTestButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						Stage stage8a = new Stage();
						stage8a.setTitle("Showing Test Stage");
						GridPane gp8a = new GridPane();
						gp8a.add(allData, 0, 0);
						allData.setPrefHeight(600);
						allData.setEditable(false);
						stage8a.setScene(new Scene(gp8a, 300, 240));
						stage8a.show();
						int k = getNumberFromStringQuestion(testsCombox.getValue(), 1);
						listener.sendTestStringToGUi(k);

					}
				});
				gp8.add(chooseTestCopy, 0, 4);
				gp8.add(testsCombox2, 0, 5);
				gp8.add(copyButton, 0, 6);
				copyButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						int k = getNumberFromStringQuestion(testsCombox2.getValue(), 1);
						try {
							listener.copyTestEvent(k);
							stage8.close();
						} catch (CloneNotSupportedException e) {
							e.printStackTrace();
						}
					}
				});
				stage8.setScene(new Scene(gp8, 300, 240));
				stage8.show();
				section8.setSelected(false);

			}
		});*/

		exit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				numOfQuestions =0;
				OpenQuestionsNum = null;
				ClosedQuestionsNum = null;
				listener.closeConnectionToSql();
				stage.close();
				
			}
		});
		

		stage.show();
	}


	public void registerListener(TestUiListener listener) {
		this.listener = listener;
	}

	public void addAnswersTocomboBox4c(ComboBox<String> cbAnswer, ArrayList<String> answers) {
		for (int i = 0; i < answers.size(); i++) {
			cbAnswer.getItems().add(answers.get(i));
		}
	}

	private int getNumberFromStringQuestion(String str, int i) {
		String[] arr = str.split("[()]");
		return Integer.parseInt(arr[i]);
	}

	/*public void QuestionFromServer(Question question) {
		this.question = question;
	}*/

	private void updateComboBox(int numOfQuestions, ComboBox<Integer> comboBox, List<Integer> num) {
		if (num == null) {
			comboBox.getItems().addAll(numOfQuestions);
		} else {
			comboBox.getItems().addAll(num);

		}
	}

	public List<Answer> addAnswersToList(Question question) {
		if (question instanceof OpenQuestion) {
			return null;
		}
		List<Answer> arr = ((ClosedQuestions) question).getAnswers();
		List<Answer> arr2 = new ArrayList<Answer>();
		int size = arr.size();
		for (int i = 2; i < size; i++) {
			arr2.add(arr.get(i));
		}
		return arr2;
	}

	public void refresh(String text) {
		allData.setText(text);
	}

	

	/*public void GerTestsFromServer(List<Test> tests) {
		this.tests = tests;
	}*/

	
	public int findInt(ArrayList<Integer> arr, int num) {
		for (int j = 0; j < arr.size(); j++) {
			if (arr.get(j) == num) {
				return j;
			}

		}
		return 0;
	}

	public boolean checkIfExist(List<String> arr, String answer) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(answer)) {
				return true;
			}
		}
		return false;
	}
	
	public void Alert(String head , String body) { 
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(head);
		alert.setHeaderText(body);
		alert.showAndWait();
	}


	public void updateQuestionAnswerList(ArrayList<String> answers) {
		questionAnswers = answers;
		
	}


	public void updataAllData(int num, List<Integer> openQuesitonNumber, List<Integer> closeQuesitonNumber) {
		numOfQuestions = num;
		OpenQuestionsNum.clear();
		ClosedQuestionsNum.clear();
		for(int i=0; i<openQuesitonNumber.size(); i++)
		{
			OpenQuestionsNum.add(openQuesitonNumber.get(i));
		}
		for(int i=0; i<closeQuesitonNumber.size(); i++)
		{
			ClosedQuestionsNum.add(closeQuesitonNumber.get(i));
		}
	}
}
