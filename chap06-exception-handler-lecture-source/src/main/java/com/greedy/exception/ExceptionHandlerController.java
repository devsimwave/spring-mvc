package com.greedy.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ExceptionHandlerController {
	
	@GetMapping("simple-null")
	public String simpleNullPointerExceptionTest() {
		
//		String str = null;
//		System.out.println(str.charAt(0));
		
		System.out.println(10 / 0);
		
		return "main";
				
	}

	@GetMapping("simple-user")
	public String simpleUserExceptionTest() throws MemberRegistException {
		
		boolean check = true;
		if(check) {
			throw new MemberRegistException("당신은 우리와 함께 갈 수 없습니다.");
		}
		return "main";
				
	}

	@GetMapping("annotaion-null")
	public String annotaionNullPointerExceptionTest() {
		
		String str = null;
		System.out.println(str.charAt(0));
		
		return "main";
	}
	
	/* 지역 설정이 우선권을 가진다.*/
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerExceptionHandler(NullPointerException exception) {
		
		System.out.println("여기 핸들러로 오는게 맞는지 확인!");
		
		return "error/nullPointer";
	}
	
	@GetMapping("annotation-user")
	public String annotationUserExceptionTest() throws MemberRegistException {
		
		boolean check = true;
		if(check) {
			throw new MemberRegistException("당신은 안된다니깐??");
		}
		
		return "main";
	}

	@ExceptionHandler(MemberRegistException.class)
	public String userExceptionHandler(Model model, MemberRegistException exception) {
		
		model.addAttribute("exception", exception);
		
		return "error/memberRegist";
	}
}
