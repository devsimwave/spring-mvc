<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">핸들러 메소드의 파라미터 어노테이션</h1>
	
	<!-- 원래는 post 방식이지만 화면 요청을 위해 get방식으로 전달함 -->
	<h3>1. HttpServletRequest로 요청 파라미터 전달받기</h3>
	<button onclick="location.href='${ pageContext.servletContext.contextPath}/first/regist'">파라미터 전달하기</button>
	
	<h3>2. @RequestParam 이용하여 파라미터 전달 받기</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/first/modify'">@RequestParam 이용하기</button>

	<h3>3. @ModelAttribute를 이용하여 파라미터 전달 받기</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/first/search'">@ModelAttribute 이용하기</button>

	<h3>4-1, 4-2. HttpSession 이용하기</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/first/login'">session에 정보 담기</button>
	
	<h3>4. @RequestBody를 이용하여 파라미터 전달받기</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/first/body'">@ReuqestBody 이용하기 </button>
	
</body>
</html>