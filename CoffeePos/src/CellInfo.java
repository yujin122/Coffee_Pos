
public class CellInfo {
	
	private String name;
	private int price;
	private int count;
	private int tPrice;

	public CellInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public CellInfo(String name, int price, int count, int tPrice) {
		this.name = name;
		this.price = price;
		this.count = count;
		this.tPrice = tPrice;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int uPrice) {
		this.price = uPrice;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int gettPrice() {
		return tPrice;
	}

	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}

}
