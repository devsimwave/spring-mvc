package com.greedy.parameter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id") 				// session 영역에 추가를 하라는 어노테이션
public class FirstController {
	
	@GetMapping("/regist")
	public void regist() {}
	
	/* 매개변수에다 선언하는 객체를 커맨드 객체라고 한다. 타입이 정해져있다. 1. HttpServletRequest,*/ 
	/* 1.HttpServletRequest를 매개변수로 선언하여 파라미터로 전달받은 값 꺼내기
	 * 핸들러 메소드의 메개변수로 HttpServletResoponse 타입도 선언이 가능하다.
	 * 상위 타입인 ServletRequest, ServletResponse도 사용 가능하다.
	 * */
	@PostMapping("/regist")
	public String registMenu(Model model, HttpServletRequest request) { 		
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		
		String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하였습니다!"; 
		
		model.addAttribute("message", message);
		
		return "first/messagePrinter";
	}

	@GetMapping("/modify")
	public void modify() {}
	
	/*2. @RequestParam
	 * 요청 파라미터를 매핑하여 호출 시 값을 넣어주는 어노테이션이다. 매개변수 앞에 사용한다.
	 * form의 name 속성값과 매개변수의 이름이 다른 경우 @RequestParam("name")을 설정하면 된다.
	 * 또한 어노테이션은 생략 가능하지만 명시적으로 작성하는 것이 의미 파악에 쉽다.
	 * 
	 * required 속성은 전달하는 form의 name 속성이 일치하는 것이 없는 경우 400에러가 발생하는데
	 * required 속성을 false로 하게 되면 해당 name값이 존재하지 않아도 null로 처리하며 에러가 발생하지 않는다.
	 * 기본값은 true이다.
	 * 
	 * input 태그에 값을 입력하지 않으면 빈 문자열("")이 넘어오게 되는데, 이 때  parsing관련 에러가 발생할 수 있다.
	 * 값이 넘어오지 않는 경우 defaultValue를 이용하게 되면 기본값으로 사용할 수 있게 된다.
	 * */
	@PostMapping("/modify")
	public String modifyMenuPrice(Model model,
//			@RequestParam String modifyName,
			@RequestParam(required = false) String modifyName,
//			@RequestParam int modifyPrice) {
			@RequestParam(defaultValue = "0") int modifyPrice) {
		
		String message = modifyName + "메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
		
		model.addAttribute("message", message);
		
		return "first/messagePrinter";
		
	}

	/*맵보다 DTO 사용 권장*/
	@PostMapping("/modifyAll")
	public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) {
		
		String modifyMenu = parameters.get("modifyName2");
		int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));
		
		String message = "메뉴의 이름을 " + modifyMenu + "(으)로, 가격을 " + modifyPrice + "원으로 변경하였습니다.";
		
		model.addAttribute("message", message);
		
		return "first/messagePrinter";
		
	}

	@GetMapping("/search")
	public void searchMenu() {}
	
	/*3. @ModelAttribute를 이용하는 방법
	 *   DTO가은 모델을 커맨드 객체로 전달받는다.
	 *   
	 * @ModelAttribute의 경우 커맨드 객체를 생성하여 매개변수로 전달해준 뒤 해당 인스턴스를 Model에 담는다.
	 * 경우에 따라 폼에서 입력한 값을 다음 화면으로 바로 전달해야 하는 경우가 발생하는데, 이 때 유용하게 사용할 수 있다.
	 * @ModelAttribute("모델에 담을key값)을 지정할 수 있으며, 지정하지 않으면 타입의 앞글자를 소문자로 한 네이밍 규칙을 따른다.
	 * 
	 * 해당 어노테이션은 생략이 가능하지만 명시적으로 작성해주는게 좋다.*/
	
	/* MenuDTO 타입의 인스턴스를 담아서 호출한다. 
	 * @ModelAttribute("menu")키값으로 이름을 지정하면 포워딩 할때 이 키값으로 정보를 가져올 수 있다. */
	@PostMapping("/search")
	public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {
		
		System.out.println("MenuDTO : " + menu);
		
		return "first/searchResult";
	}

	@GetMapping("/login")
	public void login() {}
	
	/* 3-1. session 이용하기
	 * HttpSession을 매개변수로 선언하면 핸드러 메소드 호출 시 세션객체를 넣어서 호출한다.
	 * */
	@PostMapping("/login1")
	public String sessionTest1(HttpSession session, @RequestParam String id) {
		
		session.setAttribute("id", id);
		
		return "first/loginResult";
	}

	@GetMapping("/logout1")
	public String logoutTest1(HttpSession session) {
		
		session.invalidate();
		
		return "first/loginResult";
	}
	
	/* Model은 request영역에 값을 저장하는데*/
	@PostMapping("login2")
	public String sessionTest2(Model model, @RequestParam String id) {
		
		model.addAttribute("id", id);
		
		return "first/loginResult";
	}
	
	@GetMapping("/logout2")
	public String logoutTest2(SessionStatus sessionStatus) {
		
		/* */
		sessionStatus.setComplete();
		
		return "first/loginResult";
	}
	
	@GetMapping("body")
	public void body() {}
	
	/* body영역에 받아온 데이터를 통으로 가져올 수 있다.
	 * 일반적으로 사용하지 않지만 이러한 방법도 있다.*/
	@PostMapping("body")
	public String bodyTest(@RequestBody String body, 
			@RequestHeader("content-type") String contentType,
			@CookieValue("JSESSIONID") String sessionId) { 
			
		System.out.println(body);
		System.out.println(contentType);
		System.out.println(sessionId);
		
		return "first/bodyResult";
	}
}
