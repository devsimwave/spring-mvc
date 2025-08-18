<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1 align="center">파일 업로드하기</h1>
   
   <h3>single file 업로드</h3>
   <form action="single-file" method="post" encType="multipart/form-data">
      파일 : <input type="file" name="singleFile"><br>
      파일 설명 : <input type="text" name="singleFileDescription">
      <input type="submit">
   </form>
   
   <!-- multiple 속성 추가해야 파일 여러개 선택 가능  -->
   <h3>multi file 업로드</h3>
   <form action="multi-file" method="post" encType="multipart/form-data">
      파일 : <input type="file" name="multiFiles" multiple><br>
      파일 설명 : <input type="text" name="multiFileDescription">
      <input type="submit">
   </form>
   
</body>
</html>