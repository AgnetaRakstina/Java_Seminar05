package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;

@Service
public class ProductCRUDServiceImpl implements IProductCRUDService {
	
	@Autowired
	private IProductRepo prodRepo;
	

	@Override
	public void create(String title, float price, int quantity, String description, ProductType type) throws Exception {
		if (title == null || !title.matches("[A-Z]{1}[a-z]{2,30}") 
				|| price < 0 || price > 1000 
				|| quantity < 0 || quantity > 1000
				|| description == null || !description.matches("[A-Za-z 0-9]{0,400}")
				|| type == null ) {
			throw new Exception ("kads no ievades argumentiem nav atbilstoss");
		}
		
		if(prodRepo.existsByTitleAndPriceAndDescriptionAndProductType(title, price, description, type)) {
			Product productFromDB = prodRepo.findByTitleAndPriceAndDescriptionAndProductType(title, price, description, type);
		
			int newQuantity = productFromDB.getQuantity() + quantity;
			productFromDB.setQuantity(newQuantity);
			prodRepo.save(productFromDB);
			
		} else {
			Product newProduct = new Product(title, price, quantity, description, type);
			prodRepo.save(newProduct);
		}
		
		
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(prodRepo.count()==0) {
			throw new Exception("Produktu tabula DB ir tuksa");
		}
		
		ArrayList<Product> allProductsFromDB = (ArrayList<Product>) prodRepo.findAll();
		
		return allProductsFromDB;
	}

	@Override
	public Product retrieveById(long id) throws Exception {
		// TODO noteikti parbaudit vai id ir negativs
		if(id <= 0) {
			throw new Exception("Id nevar but negativs vai nulle");
		}
		if(!prodRepo.existsById(id)) {
			throw new Exception("Produkts ar sadu id neeksiste DB");
		}
		//tad no DB izgustam pec id un atgriezam
		Product productFromDB = prodRepo.findById(id).get();
		
		return productFromDB;
	}

	@Override
	public void updateById(long id, String title, float price, int quantity, String description, ProductType type)
			throws Exception {
		Product productFromDB = retrieveById(id);
		
		if(title == null || !title.matches("[A-Z]{1}[a-z ]{2,30}")
				|| price < 0 || price > 1000
				|| quantity < 0 || quantity > 100
				|| description == null || !description.matches("[A-Za-z 0-9]{0,400}")
				|| type == null) {
			throw new Exception("Kads no ievades artgumentiem nav atbilstoss");
		}
		
		if(!productFromDB.getTitle().equals(title))
		{
			productFromDB.setTitle(title);
		}
		
		if(productFromDB.getPrice() != price)
		{
			productFromDB.setPrice(price);
		}
		
		
		if(productFromDB.getQuantity() != quantity)
		{
			productFromDB.setQuantity(quantity);
		}
		
		
		if(!productFromDB.getDescription().equals(description))
		{
			productFromDB.setDescription(description);
		}
		
		
		if(!productFromDB.getProductType().equals(type))
		{
			productFromDB.setProductType(type);
		}
		
		prodRepo.save(productFromDB);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		Product productFromDB = retrieveById(id);
		prodRepo.delete(productFromDB);
		
	}
	
	
	
	
	
	
	
	
}
