package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			throw new RuntimeException("orders.txt 읽기 오류", ex);
		}
	}
	
	public int getOrderNo() {
		// orders(List객체)의 맨 마지막번째(orders.size() -1) Order객체의 주문번호보다 1 큰 값
		return orders.get(orders.size() -1).getNo() +1;
	}
	
	public void insertOrder(Order order) {
		orders.add(order);
	}
	
	public List<Order> getOrderByUserId(String userId) {
		List<Order> result = new ArrayList<>();
	
		for (Order order : orders) {
			if (order.getUserId().equals(userId)) {
				result.add(order);
			}
		}
		
		return result;
	}
	
	public void save() {
		try {
			String path = "src/sample09/orders.txt";
			PrintWriter out = new PrintWriter(path);
			
			for(Order order : orders) {
				/*
				 * order.generateText()는 Order객체의 주문 정보를
				 * "10000,2023-04-11,kim,100,1,2000000,2000"과 같은 문자열로 변환해서 반환한다.
				 */
				String text= order.generateText();
				out.println(text);
			}
			out.close();
			
		} catch (IOException ex) {
			throw new RuntimeException("orders.txt 파일 쓰기 오류", ex);
		}
	}

	
	
	
	
}
