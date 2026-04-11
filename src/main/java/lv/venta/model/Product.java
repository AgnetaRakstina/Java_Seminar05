package lv.venta.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	//1. mainigie
	@Setter(value = AccessLevel.NONE)
	private long id;
	private String title;
	private float price;
	private int quantity;
	private String description;
	private ProductType productType;
	
	
	private static long counter = 0;
	//2. getters - nak no lombok bibliotekas
	//3. setters - nak no lombok bibliotekas
	//4. abi konstruktori - bez argumenata konstruktors nak no lombok bibliotekas
	public Product(String inputTitle, float inputPrice, int inputQuantity, String inputdescription,
			ProductType inputProductType) {
		setTitle(inputTitle);
		setDescription(inputdescription);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
		setProductType(inputProductType);
		id = counter++;
		
	}
	//5. toString - nak no lombok bibliotekas
	//6. parejas funkcijas
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

}