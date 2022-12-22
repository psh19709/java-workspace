package app1.copy;

public class StoreService {

	private Product[] products = new Product[5];
	private SellItem[] sellItems = new SellItem[5];
	
	private int productPosition = 0;
	private int sellItemPosition = 0;
	private int productLimit = 5;
	private int sellItemLimit = 5;
	private final int size = 5; 
	
	// 신규상품등록서비스 - 상품정보(Product객체)를 전달받아서 products 배열에 상품정보를 저장한다. 배열의 크기도 조절해보기
	public boolean insertProdect(Product product) {
		boolean isSuccess = false;
		
		if(!isExist(product.getNo())) {
			products[productPosition] = product;
			productPosition++;
			isSuccess = true;
			
			resize();
		}
		return isSuccess;
	}

	private boolean isExist(int no) {
		boolean isProductExist = false;
		for(Product item : products) {
			if(item == null) {
				break;
			}
			if(no == item.getNo()) {
				isProductExist = true;
				break;
			}
		}
		return isProductExist;
	}

	private void resize() {
		if(productPosition == productLimit) {
			productLimit += size;
			Product[] dest = new Product[productLimit];
			System.arraycopy(products, 0, dest, 0, products.length);
			products = dest;
		}
	}

	
	// 기존상품수량증가서비스 
	// 상품번호, 입고수량을 전달받아서 해당 상품이 존재하지 않으면 false 반환
	// 상품번호에 해당하는 상품을 products 배열에서 해당 상품정보를 찾기
	// 해당 상품의 재고수량을 입고수량만큼 증가시키기
	// true를 반환한다.
	
	public boolean updateProduct(int no, int amount) {
		if(!isExist(no)) {
			return false;
		}
		Product product = findProductByNo(no);
		product.setStock(amount);
		return true;
	}

	public Product findProductByNo(int no) {
		Product foundProduct = null;
		for(Product item : products) {
			if(item == null) {
				break;
			}
			if(item.getNo() == no){
				foundProduct = item;
				break;
			}
		}
		return foundProduct;
	}
	
	public SellItem findSellProductByNo(int no) {
		SellItem foundProduct = null;
		for(SellItem item : sellItems) {
			if(item == null) {
				break;
			}
			if(item.getNo() == no){
				foundProduct = item;
				break;
			}
		}
		return foundProduct;
	}
	
	// 판매서비스
	// 상품번호, 판매수량을 전달받아서 해당 상품이 존재하지 않으면 false반환
	// 상품번호에 해당하는 상품정보 찾기
	// 재고수량이 판매수량보다 적으면 false 반환
	// 상품의 재고수량을 판매수량만큼 감소
	
	// 여기 아래부터 못함
	// 판매아이템 객체를 생성해서 판매정보(상품정보에서 번호, 이름, 가격을 가져온다.)를 저장하고 sellItems 배열에 저장한다. 배열의 크기도 조절해보기
	// true를 반환한다.
	
	public boolean sellService(int no, int quantity) {
		if(!isExist(no)) {
			return false;
		}
		Product product = findProductByNo(no);
		if(product.getStock() < quantity) {
			return false;
		}
		// 여기 아래부터 그냥 해봄
		SellItem sellItem = null;
		product.setSellItem(sellItem);
		
		resellsize();
		
		return true;
	}
	
	private void resellsize() {
		if(sellItemPosition == sellItemLimit) {
			sellItemLimit += size;
			Product[] dest = new Product[sellItemLimit];
			System.arraycopy(products, 0, dest, 0, products.length);
			products = dest;
		}
	}
	
	// 전체상품반환서비스
	
	public Product[] getAllProduct() {
		if(productPosition == 0) {
			return new Product[0];
		}
		return products;
	}
	
	// 전체판매상품반환서비스
	public SellItem[] getAllSellProduct() {
		if(sellItemPosition == 0) {
			return new SellItem[0];
		}
		return sellItems;
	}
}
