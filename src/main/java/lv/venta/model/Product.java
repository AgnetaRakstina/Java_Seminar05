package lv.venta.model;

//import lombok.Getter;


//@Getter
//@Setter
//@NoArgsConstructor
//@toString
public class Product {
	//1. mainigie
	//@Setter(value = AccessLevel.NONE);
	private long id;
	private String title;
	private float price;
	private int quantity;
	private String description;
	private ProductType productType;
	
	//2. getteri - nak no lombok bibliotekas
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public float getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getDescription() {
		return description;
	}
	public ProductType getProductType() {
		return productType;
	}
	//3. setteri - nak no lombok bibliotekas
		public void setId(long id) {
		this.id = id;
	}
	public void setTitle(String title) {
	this.title = title;
	}
		public void setPrice(float price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	//4.1 bezargument konstr - nak no lombok bibliotekas
	
	
	//4.2 argument konstr
	public Product(String inputTitle, float inputPrice, int inputQuantity, String inputDescription, ProductType inputProductType) {
		setTitle(inputTitle);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
		setDescription(inputDescription);
		setProductType(inputProductType);
	}

	//5. toString - nak no lombok
	
	//6. citas funkcijas
	
	
	
	
}
