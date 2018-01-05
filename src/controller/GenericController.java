package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Product;

@Controller
public class GenericController extends ParentController {
	
	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ModelAndView home() throws IOException {
		ModelAndView modelAndView = new ModelAndView("productList");
		List<Product> productList = productService.read();
		modelAndView.addObject("productList", productList);
		return modelAndView;
	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView errorPage() {

		ModelAndView modelAndView = new ModelAndView("404");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/401", method = RequestMethod.GET)
	public String error() {
		return "401";
	}

}
