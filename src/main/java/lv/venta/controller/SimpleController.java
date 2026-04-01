package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

@Controller
@RequestMapping("/simple")
public class SimpleController {
	
							//uz kadu pieprasijumu izsaukt
	@GetMapping("/page") //localhost:8080/simple/page
	public String getShowPage() {
		System.out.println("Mans pirmais kontrollieris ir izsaukts");
		return "show-page"; //ka sauc html lapa kur paradit, tiks paradita show-page.html lapa ieks web parluka
	}
	
	@GetMapping("/data")            //\/ modelis no kura iegust datus
	public String getDataInPage(Model model) { //localhost:8080/simple/data
		System.out.println("izpildas datu kontrolieris");
		Random rand = new Random();
		String data = "@Karina " + rand.nextInt(2010, 2026); //lai katru reizi dati ir citadaki
		model.addAttribute("package", data);
		return "show-data-page"; //tiks paradita show-data-page.html lapa
	}
	
	@GetMapping("/product") //localhost:8080/simple/product
	public String getProductInPage(Model model) {
		Product prod = new Product("Abols", 0.99f, 5, "Garsigs", ProductType.fruit);
		model.addAttribute("package", prod);
		return "show-one-product-page"; //tiks paradita show one product page.html lapa
	}
	
}
