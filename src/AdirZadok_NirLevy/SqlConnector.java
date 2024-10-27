package AdirZadok_NirLevy;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SqlConnector {
	private Connection con = null;
	private Statement st; 
	int testCounter =1;
	int indicationCounter =0;
	int numOfQuestions = 5;
	
	
	public SqlConnector() throws ClassNotFoundException, SQLException {
		// Load the MySQL driver
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    String dbUrl =  "jdbc:mysql://localhost:3306/tests_db";
	    con = DriverManager.getConnection(dbUrl,"root","AdirAfeka1");
	    st = con.createStatement(); 
	}
	
	void updateNumOfQuestion(){
		try {
			String str = "select QID from questiontable";
			ResultSet rs = st.executeQuery(str);
			while(rs.next()) {
				int id = rs.getInt("QID");
				if(id > numOfQuestions) {
					numOfQuestions = id;
				}
			}
			rs.close();
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
	}
	
	
	public int bringData(List<Integer> openQuesitonNumber, List<Integer> closeQuesitonNumber) {
		updateNumOfQuestion();
		try {
			String str = "select OQID from openquestiontable";
			ResultSet rs1 = st.executeQuery(str);
			while(rs1.next()) {
				int id = rs1.getInt("OQID");
				openQuesitonNumber.add(id);
			}
			rs1.close();
			str = "select CQID from closequestiontable";
			ResultSet rs2 = st.executeQuery(str);
			while(rs2.next()) {
				int id = rs2.getInt("CQID");
				closeQuesitonNumber.add(id);
			}
			rs1.close();
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
		return numOfQuestions;
	}
	
	
	public void close() throws SQLException  {
		con.close();
	}
	
	public int getNumOfQuestion() {
		return numOfQuestions;
	}
	
	/*public void updateQuestion(int id , String text) {
		try {
		String str = " UPDATE questionTable";
		st.executeUpdate(str);
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
		}
	}*/
	
	
	
	/*public void getAllQuestions() {
		String str = " ";
	}*/
	
	
	public String printQuestion() {
		StringBuffer sb = new StringBuffer();
		try {
			int number;
			String questionText;
			//String type;
			String answerText;
			int numOfAnswers;
			String CQanswer;
			String indication;
			String str = "select QID , questionText,questionType,answerText,numOfAnswers,answer,indication from questiontable"
					+ " left join openquestiontable on (QID=OQID)"
					+ "left join closequestiontable on (QID = CQID)"
					+ " left join closequestion_answer_table"
					+ " on (closequestion_answer_table.CID = questiontable.QID)";
			ResultSet rs = st.executeQuery(str);
			while(rs.next())
			{
				number = rs.getInt("QID");
				questionText = rs.getString("questionText");
				sb.append(number + ") " + questionText + "\n");
				if(rs.getString("questionType").equalsIgnoreCase("Open Question")) {
					answerText = rs.getString("answerText");
					sb.append("The answer is : " + answerText + "\n\n");
					//rs.next();
				}
				else {
					sb.append("The answers are:\n");
					numOfAnswers = rs.getInt("numOfAnswers");
					for(int i = 0; i < numOfAnswers; i++) {
						CQanswer = rs.getString("answer");
						indication = rs.getString("indication");
						sb.append("\t" + (i+1) + ") " + CQanswer + " ---> " + indication + "\n");
						sb.append("\n");
						if(i!=numOfAnswers-1)
						rs.next();					}
				}
			}
			return sb.toString();
			//st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
		return sb.toString();
	}
	
	
	
	public void addQuestion( String text , String type) {
		try {
			numOfQuestions +=1;
			String str = "INSERT into questionTable VALUES(" + numOfQuestions + ","+"'"+text+"'"+","+"'"+type+"')";
			st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
	}
	
	public void addOpenQuestion( String answer) {
		try {
			String str = "INSERT into openQuestionTable VALUES(" + numOfQuestions +",'"+answer+"')";
			st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
	}
	
	public void addCloseQuestion(int num, String text, List<TextField> textFields, List<ComboBox<Boolean>> typeAnswer ) {
		try {
			addQuestion(text, "Close Question");
			addCloseQuestionAnswer(numOfQuestions ,textFields,typeAnswer );
			String str = "INSERT into closeQuestionTable VALUES(" + numOfQuestions +","+ num+")";
			st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
	}
	
	
	
	public void addCloseQuestionAnswer(int id ,List<TextField> textFields, List<ComboBox<Boolean>> typeAnswer ) {
		try {
			for(int i=0 ; i<textFields.size() ; i++) {
			String str = "INSERT into closequestion_answer_table VALUES(" + id +",'"+textFields.get(i).getText()+"','" +typeAnswer.get(i).getValue().toString()+"')";
			st.executeUpdate(str);
			}
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
	}
	
	
	public void updateOpenQuestionAnswer(int num,String update) {
		try {
			String str = "UPDATE openquestiontable SET answerText='" +update+"' WHERE OQID = "+num; 
			st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
	}
	
	
	public void updateQuestion(int id , String text) {
		try {
			String str = "UPDATE questionTable SET questionText='" +text+"' WHERE QID = " +id; 
			st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
		
	}

	public void updateCloseQuestionAnswer(String text, String answerUpdate, int num) {
		try {
			String str = "UPDATE closequestion_answer_table SET answer='" +answerUpdate+ "' WHERE CID = '" + num + "' AND answer= '"+text+"' "; 
			st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
		
	}

	public void deleteAnswerFromOpenQuestin(int id) {
		try {
			String str = "UPDATE openquestiontable SET answerText=' ' WHERE OQID ="+id;  
			st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}	
	}

	public void deleteAnswerFromCloseQuestion(String text, Integer id) {
		try {
			String str = "DELETE FROM closequestion_answer_table WHERE CID ="+id + " AND answer='" + text +"'";  
			st.executeUpdate(str);
			String str2 = "update closequestiontable set numOfAnswers = numOfAnswers-1 where CQID ="+id;
			st.executeUpdate(str2);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}	
	}

	public void addopenQuesitonForTest(int questionNum) {
		try {
			String str = "INSERT into test_questionstable VALUES (" + testCounter +"," + questionNum + ")";  
			st.executeUpdate(str);
			String str2 = "UPDATE testtable SET numOfQuesitons = numOfQuesitons + 1 WHERE TID =" + testCounter;
			st.executeUpdate(str2);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}	
	}

	public void addCloseQuestionToTest(int questionNum, String pick) {
		try {
			ResultSet rs = null;
			String str;
			//int indicationCounter =0;
			/*String str = "INSERT into test_questionstable VALUES (" + testCounter +"," + questionNum + ")";  
			st.executeUpdate(str);
			str = "INSERT into closequestions_fortesttable "
					+ "VALUES (" + testCounter +"," + questionNum +"," + "'None of the Answers is corect'" + "," + "'true'" +")";
			st.executeUpdate(str);
			str = "INSERT into closequestions_fortesttable "
					+ "VALUES (" + testCounter +"," + questionNum +"," + "'There is more than one corect answer'" + "," +"'true'" +")";
			st.executeUpdate(str);*/
			String str2= "select CQID,numOfAnswers,answer,indication from closequestiontable left join closequestion_answer_table on CQID=CID"
					+ " and CQID =" + questionNum+ " and answer ='" + pick +"'";
			 rs = st.executeQuery(str2);
			 if(st.execute(str2)) {
				 rs = st.getResultSet();
			 }
			rs.next();
			int num =  rs.getInt("CQID");
				while(num != questionNum ) {
					rs.next();
					num= rs.getInt("CQID");
				} 
					String text = rs.getString("answer");
					String indication = rs.getString("indication");
					if(indication.equalsIgnoreCase("true"))
						indicationCounter++;
					str = "INSERT into closequestions_fortesttable "
							+ "VALUES (" + testCounter +"," + questionNum +",'" + text + "','" +indication +"')";
					st.executeUpdate(str);
			//organizeCloseQuestion(questionNum)
			//String str3 = "UPDATE testtable SET numOfQuesitons = numOfQuesitons + 1 WHERE TID =" + testCounter;
			//st.executeUpdate(str3);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}	
	}

	public void addTwoCQAnswer(int questionNum ) {
		try {
			String str = "INSERT into test_questionstable VALUES (" + testCounter +"," + questionNum + ")";  
			st.executeUpdate(str);
			str = "INSERT into closequestions_fortesttable "
					+ "VALUES (" + testCounter +"," + questionNum +"," + "'None of the Answers is corect'" + "," + "'true'" +")";
			st.executeUpdate(str);
			str = "INSERT into closequestions_fortesttable "
					+ "VALUES (" + testCounter +"," + questionNum +"," + "'There is more than one corect answer'" + "," +"'true'" +")";
			st.executeUpdate(str);
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
		}
		
		
	}

	public void organizeCloseQuestion(int questionNum) {
		try {
			Statement st1 = con.createStatement();
			String str;
			if(indicationCounter ==0) {
			   str = "UPDATE closequestions_fortesttable SET indication = 'false'"
			   		+ " WHERE answer = 'there is more than one corect answer' and questionId=" + questionNum;
			   st.executeUpdate(str);
			}
			else if(indicationCounter ==1) {
				 str = "UPDATE closequestions_fortesttable SET indication = 'false'"
					   		+ " WHERE answer = 'There is more than one corect answer' and questionId=" + questionNum;
					   st.executeUpdate(str);
			     str = "UPDATE closequestions_fortesttable SET indication = 'false'"
						   		+ " WHERE answer = 'None of the Answers is corect' and questionId=" + questionNum;
						   st.executeUpdate(str);
			}
			else{
				str = "select CQID,numOfAnswers,answer,indication from closequestiontable left join  closequestions_fortesttable"
						+ " on CQID=questionId and questionId=" + questionNum;
				ResultSet rs = st.executeQuery(str);
				while(rs.next()) {
				//rs.next();
					/*while(rs.getInt("CQID") != questionNum ) {
						rs.next();
					} */
				//	while(rs.getInt("CQID") == questionNum && rs.next()) {
					if(rs.getInt("CQID") == questionNum) {
					String answer = rs.getString("answer");
					if(rs.getString("indication").equalsIgnoreCase("true")) {
						str = "UPDATE  closequestions_fortesttable SET indication = 'false'"
						   		+ " WHERE answer ='" +answer+ "' and questionId=" + questionNum;
						  st1.executeUpdate(str);
					}
				}
					//}
				}
				str = "UPDATE  closequestions_fortesttable SET indication = 'true'"
				   		+ " WHERE answer = 'There is more than one corect answer' and questionId=" + questionNum;
				   st.executeUpdate(str);
			}
			String str3 = "UPDATE testtable SET numOfQuesitons = numOfQuesitons + 1 WHERE TID =" + testCounter;
			st.executeUpdate(str3);
			indicationCounter =0;
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
		}
		
	}

	public void createTest() {
		try {
			String str = "INSERT into testtable VALUES (" + testCounter +"," + 0 + ")";  
			st.executeUpdate(str);
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}	
	}

	public void increaseTestCounter() {
		testCounter++;
		
	}

	public String getQuestion(int random) {
		
		String type = getQuestionType(random);
		return type;
	}

	private String getQuestionType( int random) {
		StringBuffer sb = new StringBuffer();
		try {
			String str = "select questionType from questiontable where QID = " +random; 
			st.executeQuery(str);
			ResultSet rs = st.executeQuery(str);
			rs.next();
			 sb.append(rs.getString("questionType"));
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}	
		return sb.toString();
	}

	public boolean checkIfQuestionExistsInTest(int random) {
		try {
			String str = "select questionId from test_questionstable";
			ResultSet rs = st.executeQuery(str);
			while(rs.next()) {
				int num = rs.getInt("questionId");
				if(num==random)
					return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}

	public int getNumOfAnswers(int random) {
		try {
			String str = "select numOfAnswers from closequestiontable where CQID = " + random;
			ResultSet rs = st.executeQuery(str);
			while(rs.next()) {
				int num = rs.getInt("numOfAnswers");
				return num;
			}
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	public boolean checkIfAnswerExists(int random , int questionNum, boolean happenOnce) {
		try {
			int num =0;
			String str = "select answer from closequestion_answer_table where CID =" + questionNum;
			ResultSet rs = st.executeQuery(str);
			while(num<random) {
				rs.next();
				num++;
			}
			String answer = rs.getString("answer");
			//String indication = rs.getString("indication");
			rs.close();
			if(happenOnce == true) {
			 boolean check = checkifExists(answer , questionNum);
			 if(!check) {
				 /*str = "INSERT into closequestions_fortesttable "
							+ "VALUES (" + testCounter +"," + questionNum +",'" + answer + "','" +indication +"')";
					st.executeUpdate(str);*/
				 addCloseQuestionToTest(questionNum, answer);
					return false;
			 } else {
				 return true;
			 }
			} else {
				 addCloseQuestionToTest(questionNum, answer);
					return false;
			}
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkifExists(String answer , int questionNum) {
		try {
			String str = "select answer from closequestions_fortesttable where TID =" + testCounter+ 
					" and questionId = " +questionNum;
			Statement st1 = con.createStatement();
			ResultSet rs = st.executeQuery(str);
			ResultSet rs1 = st1.executeQuery(str);
			if(rs1.next() == false) {
				return false;
			}
			while(rs.next()) {
				String ans = rs.getString("answer");
				if(ans.equalsIgnoreCase(answer)) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<String> getAnswerOfQuestion(int qustionNum) {
		ArrayList<String> answers = new ArrayList<String>();
		try {
			
			String str = "select answer from closequestion_answer_table where CID=" + qustionNum;
			ResultSet rs = st.executeQuery(str);
			while(rs.next()){
				answers.add(rs.getString("answer"));
			}
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
		}
		return answers;
	}

	public ArrayList<String> getAnswerOfQuestionForTest(int questionNum) {
		ArrayList<String> answers = new ArrayList<String>();
		try {
			
			String str = "select answer,indication from closequestion_answer_table where CID=" + questionNum;
			ResultSet rs = st.executeQuery(str);
			while(rs.next()){
				String answer = rs.getString("answer") + "--->" + rs.getString("indication") ;
				answers.add(answer);
			}
		} catch (SQLException e) {
			System.out.println("SQL EXEPTION: " + e.getMessage());
			e.printStackTrace();
		}
		return answers;
	}

	public int checkNumOfAnswers(Integer numQuestion) {
		int num =0;
		int res =0;
			String check = "select numOfAnswers from closequestiontable where CQID =" + numQuestion;
			try {
				ResultSet rs = st.executeQuery(check);
				rs = st.executeQuery(check);
				while(rs.next()){
					 num = rs.getInt("numOfAnswers");
				}
				
			} catch (SQLException e) {
				System.out.println("SQL EXEPTION: " + e.getMessage());
			}
			if(num ==4)
				res=0; 
			else
				res =1;
			return res;
			
}
}
