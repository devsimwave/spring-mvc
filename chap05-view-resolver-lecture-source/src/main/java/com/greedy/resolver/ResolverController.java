package com.greedy.resolver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

	@GetMapping("string")
	public String stringReturning(Model model) {
		
		model.addAttribute("message", "문자열로 뷰 이름 반환함");
		
		return "result";
	}

	@GetMapping("string-redirect")
	public String stringRedirect(Model model) throws UnsupportedEncodingException {
		
		/* 강제로 쿼리스트링을 만들어 전송을 한다.*/
		model.addAttribute("message", URLEncoder.encode("문자열로 뷰 이름 반환하며 뷰 이름 반환하여 리다이렉트", "UTF-8"));
		
		/**/
		return "redirect:main";
	}
	
	@GetMapping("string-redirect-attr")
	public String stringRedirectFlashAttribute(RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("flashMessage", "리다이렉트 attr 사용하여 redirect...");
		
		return "redirect:main";
	}
	
	
	@GetMapping("modelandview")
	public ModelAndView modelAndViewReturning(ModelAndView mv) {
	
		mv.addObject("message", "ModelAndView를 이용한 모델과 뷰 반환");
		mv.setViewName("result");
		
		return mv;
	}

	@GetMapping("modelandview-redirect")
	public ModelAndView ModelAndViewRedirect(ModelAndView mv) throws UnsupportedEncodingException {
		
		mv.addObject("message", URLEncoder.encode("ModelAndView를 이용한 redirect", "UTF-8"));
		mv.setViewName("redirect:main");
		
		return mv;
	}
	
	@GetMapping("modelandview-redirect-attr")
	public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr) {
		
		/*addFlashAttribute 세션에 담는다.*/
		rttr.addFlashAttribute("flashMessage", "ModelAndView를 이용한 redirect");
		mv.setViewName("redirect:main");
		
		return mv;
	}

}
