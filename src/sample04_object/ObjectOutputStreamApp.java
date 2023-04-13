package sample04_object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamApp {

	public static void main(String[] args) throws IOException {
		Score score = new Score();
		score.setName("홍길동");
		score.setPassword("zxcv1234");
		score.setGrade(3);
		score.setKor(100);
		score.setEng(80);
		score.setMath(70);
		score.setPassed(true);
		// 변수와 값만 보내는 데이터인아웃풋과 다른점 클래스(클래스 이름)도 같이 보낸다.
		// 객체를 전송할 수 있게 만드는 것-> 직렬화
		// 받은 데이터로 다시 객체를 생성 -> 역직렬화
		// 클래스, 그리고 멤버 변수도 직렬화가 가능해야 한다.
		/*
		 * ObjectOutputStream
		 * 	객체를 직렬화(Serialization)해서 연결된 스트림으로 출력가능하게 하는 스트림이다.
		 * 	주요 API
		 * 		생성자
		 * 			ObjcetOutputStream(ObjectStream out)
		 * 				이 스트림과 연결되는 1차 스트림객체를 전달 받아서 객체를 초기화한다.
		 * 		주요 메서드
		 * 			void writeObject(Object obj)
		 * 				전달받은 객체를 직렬화해서 스트림으로 전송한다.
		 */
		
		String path = "src/sample04_object/obj.sav";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
		
		out.writeObject(score);
		
		out.close();
		
	}
}
