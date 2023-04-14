package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository { // 상품정보 -> 영속화 계층 값을 달라면 준다. 로직이 잘 없다.

	private List<Product> products = new ArrayList<>();
	
	public ProductRepository() {
		try {
			String path = "src/sample09/products.txt";
			BufferedReader in = new BufferedReader(new FileReader(path));
			String text = null;
			while((text = in.readLine()) != null) {
				if (text.isBlank()) { // text를 가져왔는데 비어있으면 반복문을 탈출한다.
					break;
				}
				Product product = Product.createProduct(text);
				products.add(product);
			}
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException("products.txt 읽기 오류", ex);
		}
	}
	
	// 조회는 반환값의 갯수를 항상 신경써야 한다.
	/*
	 * 모든 상품정보를 반환한다.
	 * 	반환타입 : List<Product>
	 * 	메서드명 : getProducts
	 * 	매개변수 : 없음
	 */
	public List<Product> getProducts(){
		return products;
	}
	
	/*
	 * 상품번호를 전달 받아서 상품번호와 일치하는 상품정보를 반환한다.
	 * 	반환타입 : Product
	 * 	메서드명 : getProducrByNo
	 * 	매개변수 : int no
	 */
	public Product getProductByNo (int no) {
		for (Product product : products) {
			if (product.getNo() == no) {	// .equlas메서드는 문자열 내용 비교할 때만
				return product;
			}
		}
		return null;
	}
}
