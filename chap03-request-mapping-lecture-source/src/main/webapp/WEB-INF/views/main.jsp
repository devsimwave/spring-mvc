<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">spring MVC mapping 테스트</h1>
	
	<h2>1. 메소드 요청 매핑하기 </h2>
	<h3>GET : /menu/regist</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/menu/regist'">GET 메뉴 요청 등록</button>
	
	<h3>POST : /menu/regist</h3>
	<form action="${ pageContext.servletContext.contextPath }/menu/regist" method="post">
		<button type="submit">POST 메뉴 등록 요청</button>
	</form>
	
	<h3>GET : /menu/modify</h3>
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/menu/modify'">GET 메뉴 요청 수정</button>
	
	<h3>POST : /menu/modify</h3>
	<form action="${ pageContext.servletContext.contextPath }/menu/modify" method="post">
		<button type="submit">POST 메뉴 수정 요청</button>
	</form>
	
	<h3>GET : /menu/delete</h3>
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/menu/delete'">GET 메뉴 삭제 요청</button>
	
	<h3>POST : /menu/delete</h3>
	<form action="${ pageContext.servletContext.contextPath }/menu/delete" method="post">
		<button type="submit">POST 메뉴 삭제  요청</button>
	</form>
	
	<h2>2. 클래스에 요청 매핑하기</h2>
	<h3>GET : /order/regist</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/order/regist'">GET 주문 등록 요청</button>
	
	<h3>POST : /order/modify</h3>
	<form action="${ pageContext.servletContext.contextPath }/order/modify" method="post">
		<button type="submit">POST 주문 수정  요청</button>
	</form>

	<h3>POST : /order/delete</h3>
	<form action="${ pageContext.servletContext.contextPath }/order/delete" method="post">
		<button type="submit">POST 주문 삭제  요청</button>
	</form>
	
	<h3>GET : /order/detail/{orderNo}</h3>
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/order/detail/3'">GET 주문 상세 보기 요청</button>
	
</body>
</html>