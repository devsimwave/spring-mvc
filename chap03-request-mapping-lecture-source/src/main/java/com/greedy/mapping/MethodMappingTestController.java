package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {
	
	/* RequestMapping 설정에  method 방식을 지정하지 않으면 get/post 요청 둘 다 처리
	 * DispatchServlet에서 요청한거에 따른 url 정보를 가져와야되는데 그 역할을 하는게
	 * RequestMappint어노테이션이다. @RequestMapping url 작성 후  Bean에 등록을 한다.
	 * Bean에 등록된 ReuqestMapping url 정보를 DispatchServlet로 보내준다. */
	
	/*	Model 값을 담아줄 수 있는 공간
	 *	서블릿 배울 땐 request.addAttribute를 사용했지만 의존관계가 높아져 유지보수성에 좋지 않다.
	 *	그래서 Model이라는 공간을 빌린다.*/
	@RequestMapping("/menu/regist")
	public String registMenu(Model model) {
		
		/* Servlet에서 request영역에 추가해준다 키 밸류 값으로 추가해주는 개념이랑 비슷하다 생각 */
		model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
	/*get방식 요청만 허용 POST로 요청 시 405페이지 뜬다. */
	@RequestMapping(value="/menu/modify", method=RequestMethod.GET)
	public String modifyMenu(Model model) {
		
		model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	/* 요청 메소드별 전용 어노테이션(since 4.3) 메소드 단위에서만 사용 가능하다.
	 * 핸들러 메소드를 조금 더 간결하게 작성할 수 있게 해준다.
	 * 요청메소드 			어노테이션
	 * POST				@PostMapping INSERT
	 * Get 				@GetMapping  SELECT
	 * DELETE			@DeleteMapping DELETE(RESTAPI)  
	 * PUT 				@PutMapping    UPDATE(RESTAPI)
	 * GET만 header를 이용한 방식, 나머지는 body를 읽는 방식
	 * post와 put방식은 멱등성 방식의 차이를 가지고 있다.
	 * 멱등성이란 : 
	 * HTTP 프로토콜이 신뢰성 있는 프로토콜인 이유 : */
	
	@GetMapping("/menu/delete")
	public String getDelete(Model model) {
		
		model.addAttribute("message", "GET 방식의 삭제용 핸들러 메소드 호출함...");
		
		return "mappingResult"; 
	}

	@PostMapping("/menu/delete")
	public String postDeleteMenu(Model model) {
		
		model.addAttribute("message", "POST 방식의 삭제용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
}
