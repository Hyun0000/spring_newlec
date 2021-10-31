package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		Exam exam = new NewlecExam();
		
		// 1.inline 형식으로 출력(한 줄로 출력)
		ExamConsole console = new InlineExamConsole(exam);
		// InlineExamConsole가 exam 객체를 조립하고 있는 것이다. --> 이 작업이 바로 'DI'이다.
		
		// 2. 표 형식으로 출력
		// ExamConsole console = new GridExamConsole(exam);
		// GridExamConsole가 exam 객체를 조립하고 있는 것이다. --> 이 작업이 바로 'DI'이다.

		console.print();
	}
}