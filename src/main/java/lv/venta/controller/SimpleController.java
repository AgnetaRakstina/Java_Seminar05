package lv.venta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/simple")
public class SimpleController {
	
							//uz kadu pieprasijumu izsaukt
	@GetMapping("/page") //localhost:8080/simple/page
	public String getShowPage() {
		System.out.println("Mans pirmais kontrollieris ir izsaukts");
		return "show-page"; //ka sauc html lapa kur paradit, tiks paradita show-page.html lapa ieks web parluka
	}
	
	
	
	
	
}
