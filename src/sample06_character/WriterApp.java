package sample06_character;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import sample04_object.Score;

public class WriterApp {

	public static void main(String[] args) throws IOException {
		
		// 텍스트 데이터를 출력하는 PrintWriter객체를 생성한다.
		String path = "src/sample06_character/score.txt";
		PrintWriter out = new PrintWriter(path);
		
		// 학생 성적 정보를 표현하는 Score객체를 생성하고, 성적 정보를 저장한다.
		Score score = new Score();
		score.setName("홍길동");
		score.setPassword("zxcv1234");
		score.setGrade(3);
		score.setKor(100);
		score.setEng(80);
		score.setMath(70);
		score.setPassed(true);
		
		// 마샬링
		// Score객체에 저장된 성적 정보를 ,로 구분된 문자열로 생성할 StringJoiner객체를 생성한다.
		StringJoiner joiner = new StringJoiner(",");
		// StringJoiner객체의 add(String value) 메서드를 실행해서 값을 추가한다.
		joiner.add(score.getName())					// 이미 String이라 형변환 필요 없음 
			.add(score.getPassword()) 				// 이미 String이라 형변환 필요 없음 
			.add(String.valueOf(score.getGrade()))	// int -> String
			.add(String.valueOf(score.getKor()))
			.add(String.valueOf(score.getEng()))
			.add(String.valueOf(score.getMath()))
			.add(String.valueOf(score.isPassed()));	// boolena -> String
		// StringJoiner객체의 toString() 메서드는 StringJoier객체의 추가된 값을
		// 지정된 구분문자(,)로 이어진 하나의 문자열로 반환한다.
		String text = joiner.toString();
		
		// 아무리 많이 실행해도 덮어쓰기가 기본이기에 한 줄만 등록되어있다.
		out.println(text);
		out.println(text);
		out.println(text);
		out.println(text);
		
		
		out.close();
		
		
	}
}
