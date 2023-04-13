package sample06_character;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sample04_object.Score;

public class ReaderApp {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		String path = "src/sample06_character/score.txt";
		BufferedReader in = new BufferedReader(new FileReader(path));
		
//		String text1 = in.readLine();
//		String text2 = in.readLine();
//		String text3 = in.readLine();
//		String text4 = in.readLine();
//		String text5 = in.readLine();
//		String text6 = in.readLine();
//
//		System.out.println(text1);
//		System.out.println(text2);
//		System.out.println(text3);
//		System.out.println(text4);
//		System.out.println(text5);	// 한 줄씩 읽어 오는데 빈 란이라 null 출력
//		System.out.println(text6);	// 한 줄씩 읽어 오는데 빈 란이라 null 출력
		
		String text = null;
		while ((text = in.readLine()) != null) {
			Score score = createScore(text);
			System.out.println("[" + score.getName() + "] 학생 성적 정보");
			System.out.println("이름: " + score.getName());
			System.out.println("학년: " + score.getGrade());
			System.out.println("국어: " + score.getKor());
			System.out.println("영어: " + score.getEng());
			System.out.println("수학: " + score.getMath());
			System.out.println("합격여부: " + score.isPassed());
			System.out.println();
		}
		
		in.close();
	}
	
	// 언마샬링
	public static Score createScore(String text) {
		String[] values = text.split(",");
		
		String name = values[0];
		String password = values[1];
		int grade = Integer.parseInt(values[2]); // String -> int
		int kor = Integer.parseInt(values[3]);
		int eng = Integer.parseInt(values[4]);
		int math = Integer.parseInt(values[5]);
		boolean passed = Boolean.parseBoolean(values[6]);	// String -> boolean
		
		Score score = new Score();
		score.setName(name);
		score.setPassword(password);
		score.setGrade(grade);
		score.setKor(kor);
		score.setEng(eng);
		score.setMath(math);
		score.setPassed(passed);
		
		return score;
		
		
	}
}
