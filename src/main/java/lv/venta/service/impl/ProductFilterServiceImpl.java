package lv.venta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.service.IProductFilterService;
import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;

import java.util.ArrayList;

@Service
public class ProductFilterServiceImpl implements IProductFilterService {
	
	@Autowired
	private IProductRepo prodRepo;
	
	
	@Override
	public ArrayList<Product> filterByPriceLessThan(float threshold) throws Exception {
		if (threshold <= 0) {
			throw new Exception("Ievadita cenai jabut pozitivai");
		}
		ArrayList<Product> result = prodRepo.findByPriceLessThan(threshold);
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu, kuru cena ir mazaka par " + threshold + " eur");
		}
		
		return result;
	}
	
	@Override
	public ArrayList<Product> filterByType(ProductType type) throws Exception {
		if (type == null) {
			throw new Exception("Produkta tips nevar but null");
		}
		
		ArrayList<Product> result = prodRepo.findByProductTypeEquals(type);
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu, kura ietilpst produkta tipa " + type);
		}
		
		return result;
	}
	
	@Override
	public ArrayList<Product> filterByKeyword(String keyword) throws Exception {
		if (keyword == null || keyword.isEmpty()) {
			throw new Exception("Nav padots atslegas vards");
		}
		
		ArrayList<Product> result = 
				prodRepo.findByTitleContainingOrDescriptionContaining(keyword, keyword); // 2 reizes jo gan title gan descrption
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu, kuri sava nosaukuma vai apraksta satur atslega vardu: " + keyword);
		}
		
		return result;
	}
	
	public float calculateAvgPrice() throws Exception {
		if (prodRepo.count() == 0) {
			throw new Exception ("DB nav produktu un nevar aprekinat videjo cenu");
		}
		float result = prodRepo.calculateAvrPriceFromDB();
				
		return result;
	}
	
	
	
	
	
	
	
	
}
