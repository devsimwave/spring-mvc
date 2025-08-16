<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1 align="center">뷰 리졸버를 이용한 뷰 연결하기</h1>
   
   <h3>문자열로 뷰 이름 반환하기</h3>
   <button onclick="location.href='string'">문자열로 뷰 이름 반환</button>
   <h3>문자열로 redirect하기</h3>
   <button onclick="location.href='string-redirect'">문자열로 뷰 이름 반환하여 리다이렉트</button>
	<script>
		const message = decodeURIComponent('${ param.message }').replaceAll("+", " ");
		console.log(message);
		if(message) {
			alert(message);
		}		
	</script>   
   	
   	<h3>문자열로 뷰 이름 반환하면서 flashAttribute</h3>
   	<button onclick="location.href='string-redirect-attr'">문자열로 뷰 이름 반환하여 리다이렉트 & flashAttr 사용하기</button>
   	<script>
   		const flashMessage = '${ requestScope.flashMessage }';				//세션에 값을 담고 있다가 redirect로 넘기면 세션에 있는 값을 지운다.
   		if(flashMessage) {
   			alert(flashMessage);
   		}
   	</script>
   	
   	<h3>ModelAndView로 뷰 이름 지정해서 반환하기</h3>
   	<button onclick="location.href='modelandview'">ModelAndView로 뷰 이름 지정해서 반환받기</button>
   	
   	<h3>ModelAndView로 redirect하기</h3>
   	<button onclick="location.href='modelandview-redirect'">ModelANdView로 뷰 이름 반환하여 리다이렉트</button>
   	<script>
   		const message = decodeURIComponet('${ param.message }').replaceAll("+", " ");
   	</script>
   	
   	<h3>ModelAndView로 뷰 이름 반환하면서 flashAttribute 추가하기</h3>
   	<button onclick="location.href='modelandview-redirect-attr'">ModelAndView로 뷰 이름 반환하여 리다이렉트</button>
   	<script>
   		const flashMessage = '${ requestScope.flashMessage }';
   		if(flashMessage) {
   			alert(flashMessage);
   		}
   	</script>
</body>
</html>