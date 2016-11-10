package com.onlinequiz;

public class QuizModel {

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	protected String question;
	protected String option1;
	protected String option2;
	protected String option3;
	protected String option4;
	protected String answer;
	
	public QuizModel(String q,String o1,String o2,String o3,String o4,String ca){
		this.question = q;
		this.option1  = o1;
		this.option2  = o2;
		this.option3  = o3;
		this.option4  = o4;
		
		this.answer = ca;
	}
	
	public String toString(){
		return ("\n"+"  "+question+"\n"+"A "+option1+"\n"+"B "+option2+"\n"+"C "+option3+"\n"+"D "+option4+"\n");
	}
	
	public QuizModel(){};
	
}
