package spring.di.entity;

public class NewlecExam implements Exam {
	private int kor;
	private int eng;
	private int math;
	private int com;

	@Override
	public int total() {
		return kor + eng + math + com;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}
}

/*
 * 즉, DI되는 객체(exam)가 상황에 따라 InlineExamConsole에 꽂힐 수도 있고 GridExamConsole에 꽂힐 수도 있는 것이다.
 * 그리고 그때마다 출력되는 모양이 달라진다.
 * 근데 이걸 매번 소스 코드를 바꿔가며 InlineExamConsole(exam)과 GridExamConsole(exam)을 번갈아가며 사용할 수는 없다.
 * 더군다나 이미 돌아가고 있는 기능의 소스코드를 직접 수정하는 것은 좋지않다.
 * 
 * 이러한 문제를 해결하기위해 new InlineExamConsole(exam), new GridExamConsole(exam) 설정 부분을 외부설정으로 빼야한다.
 * 그로인해 직접적인 수정없이 외부 설정을 바꿈으로인해  new InlineExamConsole(exam), new GridExamConsole(exam) 부분을
 * 변경할 수 있는것이다.
 * 
 * ExamConsole console = new GridExamConsole(exam); 에서 (new GridExamConsole(exam)) 부분을 외부설정으로 빼버리고
 * ExamConsole console = ?;  -->  해당 외부 설정을 바꿈으로 인해서 ? 부분을 변경할 수 있는 것이다.
 * 이때 바로 이러한 '외부 설정으로 빼고 & 조립해주는 과정을 spring이 해주는 것'이다.
 * 
 * spring 덕분에 직접 소스코드를 변경할 필요없이 InlineExamConsole(exam)와 GridExamConsole(exam)을 바꿔낄수 있는 것이다. by 외부설정
 */