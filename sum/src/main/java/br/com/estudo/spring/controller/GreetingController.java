package br.com.estudo.spring.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private static final AtomicLong temp = new AtomicLong(); 
	
	@GetMapping(value = "/soma/{numberOne}/{numberTwo}")
	public Double soma(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
			
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) {
			return 0D;
		}
		
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) {
			return Double.parseDouble(number);
		}
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		
		if(strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	
}
