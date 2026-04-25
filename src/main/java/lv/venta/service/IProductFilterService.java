package lv.venta.service;

import lv.venta.model.ProductType;
import lv.venta.model.Product;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface IProductFilterService {
	//TODO
	//1. funkcija kas izlfiltre produktus pec cenas slieksna
	public abstract ArrayList<Product> filterByPriceLessThan(float threshold) throws Exception;
	
	//2. funkcija kas izfiltre produktus pec tipa
	public abstract ArrayList<Product> filterByType(ProductType type) throws Exception;
	
	//3. funkcijas kas izfiltre profuktus pec padoto keyword un skatas title un description
	public abstract ArrayList<Product> filterByKeyword(String keyword) throws Exception;
	
	//4. kas aprekina videjo cenu visiem produktiem
	public abstract float calculateAvgPrice() throws Exception;
	
}
