package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserRepository { // 사용자 정보 -> 영속화 계층 값을 달라면 준다. 로직이 잘 없다.
	
	// users.txt파일에 기록된 사용자 정보가 저장되는 객체다.
	private List<User> users = new ArrayList<>();

	public UserRepository() {
		try {
			String path ="src/sample09/users.txt";
			BufferedReader in = new BufferedReader(new FileReader(path));
			String text = null;
			while ((text = in.readLine()) != null) {
				if (text.isBlank()) { // text를 가져왔는데 비어있으면 반복문을 탈출한다.
					break;
				}
				User user = User.createUser(text);
				users.add(user);
			}
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException("users.txt 파일 읽기 오류", ex);
		}
	}
	
	/*
	 * 아이디를 전달받아서 아이디에 해당하는 사용자정보를 반환한다.
	 * 	반환타입 : User
	 * 	메서드명 : getUserById
	 * 	매개변수 : String id
	 */
	public User getUserById (String id) {
		for (User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public void save() {
		try {
			String path = "src/sample09/users.txt";
			PrintWriter out = new PrintWriter(path);
			
			for(User user : users) {
				/*
				 * user.generateText()는 User객체의 사용자 정보를
				 * "hong,zxcv1234,홍길동,1000"과 같은 문자열로 변환해서 반환한다.
				 */
				String text= user.generateText();
				out.println(text);
			}
			out.close();
			
		} catch (IOException ex) {
			throw new RuntimeException("users.txt 파일 쓰기 오류", ex);
		}
	}
}
