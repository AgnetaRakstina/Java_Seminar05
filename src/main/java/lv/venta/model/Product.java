package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProductTable")
@Entity // datu vieniba ka obligati jabut unikala
public class Product {
	//1. mainigie
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Id")
	@Id //ka primara atslega
	@GeneratedValue(strategy = GenerationType.AUTO) // tiks glabat DB automatiska pec auto incrementacijas
	private long id;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Price")
	private float price;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "ProductType")
	private ProductType productType;
	
	//counter id nav vajadzigs, no datu bazes viss ir jau tur veidots
	
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
		
	}
	
	public Product() {
		setTitle("Book");
		setDescription("Just a book");
		setPrice(2.55f);
		setQuantity(5);
		setProductType(productType.other);
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