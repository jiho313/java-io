package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {// 주문정보 -> 영속화 계층 값을 달라면 준다. 로직이 잘 없다.
	// 객체를 여러 개 담을 땐 항상 리스트. 부모 타입은 항상 자식 객체의 상위객체가 되면 좋다.
	private List<Order> orders = new ArrayList<>();
	
	public OrderRepository() {
		try {
			String path = "src/sample09/orders.txt";
			BufferedReader in = new BufferedReader(new FileReader(path));
			String text = null;
			while ((text = in.readLine()) != null) {
				if (text.isBlank()) { // text를 가져왔는데 비어있으면 반복문을 탈출한다. isEmpty보다 유용
					break;
				}
				Order order = Order.createOrder(text);
				orders.add(order);
			}
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException("order.txt 읽기 오류", ex);
		}
	}

}
