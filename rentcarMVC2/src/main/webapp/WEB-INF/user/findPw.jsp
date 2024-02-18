<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
 *{
    padding: 0;
    margin: 0;
    border: none;
}
body{
    font-size: 14px;
    font-family: 'Roboto', sans-serif;
}
.goCenter{
	  display: grid;
  place-items: center;
}
.login-wrapper{

    width: 400px;
    height: 350px;
    padding: 40px;
    box-sizing: border-box;
}

.login-wrapper > h2{
    font-size: 24px;
    color: #6A24FE;
    margin-bottom: 20px;
}
#login-form > input{
    width: 100%;
    height: 48px;
    padding: 0 10px;
    box-sizing: border-box;
    margin-bottom: 16px;
    border-radius: 6px;
    background-color: #F8F8F8;
}
#login-form > input::placeholder{
    color: #D2D2D2;
}
#login-form > input[type="submit"]{
    color: #fff;
    font-size: 16px;
    background-color: #6A24FE;
    margin-top: 20px;
}
#login-form > label{
    color: #999999;
}
a {
	color : black;
	text-decoration: none;
}
.find {
	color : black;
}
</style>
<body>
		<%@include file = "../parts/header.jsp"%>
		<div class = "goCenter">
	    <div class="login-wrapper" align = "center">
	    <c:if test = "${password eq null }">
        <h2>비밀번호 찾기</h2>
        <form method="post" action="${ctx }/findPw.do" id="login-form">
            <input type="text" name="id" placeholder="Id를 입력하세요" required>
            <input type="email" name="email" placeholder="email을 입력하세요" required>
            <input type="submit" value="조회하기">
        </form>
        </c:if>
        <c:if test="${password ne null }">
        <br><br>
        <h1> ${id }님 비밀번호는 <br> ${password }입니다</h1>
        </c:if>
        <!-- <a href="" class= "find"> 비밀번호 찾기 </a> -->
    </div>
    </div>
    <%@include file = "../parts/footer.jsp" %>
</body>
</html>