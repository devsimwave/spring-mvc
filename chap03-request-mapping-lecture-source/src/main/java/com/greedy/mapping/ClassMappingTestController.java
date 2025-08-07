package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*") 																				/* 공통적인 부분을 클래스위에 어노테이션을 달아주면 똑같은 url 입력 안해도됨. */ 
public class ClassMappingTestController {

	@GetMapping("/regist")
	public String registOrder(Model model) {
		
		model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
	/* 다중 등록*/ 
	@RequestMapping(value= {"modify", "delete"}, method=RequestMethod.POST)
	public String modifyAndDelete(Model model) {
		
		model.addAttribute("message", "POST 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
	/* pathVariable
	 * 핸들러 메소드에서 요청 객체를 들춰서 전달된 값을 꺼내볼 필요 없이 url 경로에 위치한 값을 value로 인식하는 방법이다.
	 * 특히 REST형 웹 서비스를 설계할 때 유용하다.
	 * */
	 @GetMapping("/detail/{orderNo}")
 	 public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo) {       			/* 키 값을 받아  int orderNo에 초기화 */
		 
		 model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출함...");
		 
		 return "mappingResult";
	 }

	 /*  url이 준비되어 있지 않은 경우?
	  *  하위레벨에 대한 매핑 정보를 설정하지 않았을 때 default값으로  나온다. */
	 @RequestMapping
	 public String otherRequest(Model model) {
		 
		 model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 아직 준비되지 않았음...");
		 
		 return "mappingResult";
	 }
}
