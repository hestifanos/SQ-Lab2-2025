package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import com.ontariotechu.sofe3980U.BinaryAPIResult;

@RestController
public class BinaryAPIController {

	@GetMapping("/&")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/subtract")
	public String subtractString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
					   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  Binary.subtract(number1,number2).getValue();
		// http://localhost:8080/subtract?operand1=1010&operand2=0011
	}

	@GetMapping("/subtract_json")
	public BinaryAPIResult subtractJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
					   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  new BinaryAPIResult(number1,"subtract",number2,Binary.subtract(number1,number2));
		// http://localhost:8080/subtract?operand1=1010&operand2=0011
	}

	@GetMapping("/*")
	public String multiplyString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
					   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return number1.mult(number2).getValue();
		// http://localhost:8080/multiply?operand1=1010&operand2=0011
	}


	

}