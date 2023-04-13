package sample04_object;

import java.io.Serializable;

public class Score implements Serializable { // 직렬화 가능한 객체라는 걸 표현한다. 
	
	/**
	 * 
	 */
	// 컴파일러에게 시리얼버전 생성을 맡기면 버전에 따라 시리얼버전 UID가 다를 수 있어 고정적인 UID를 생성해서 선언해둔다.
	private static final long serialVersionUID = -4403701983491175747L; 

	private String name;
	private transient String password; // transient키워드를 사용해서 직렬화 대상에서 제외
	private int grade;
	private int kor;
	private int eng;
	private int math;
	private boolean passed;
	
	public Score() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
	

}
