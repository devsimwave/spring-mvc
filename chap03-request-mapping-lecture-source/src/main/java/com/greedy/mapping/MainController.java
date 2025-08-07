package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/* value속성 생략 가능 */
	@RequestMapping("/")
	public String main() {
		
		return "main";
	}
}
