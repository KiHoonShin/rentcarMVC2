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
        <h2>내 정보</h2>
        <form method="post" action="${ctx }/deleteUser.do" id="login-form">
           <input type="submit" value="회원 탈퇴">
           아이디 <input value = "${user.id }">
           비밀번호 <input value = "${user.pw}">
           이메일 <input value = "${user.email }">
           연락처 <input value = "${user.tel }">
           취미 <input value = "${user.hobby }">
           직업 <input value = "${user.job }">
           나이 <input value = "${user.age }">
           정보 <input value = "${user.info }">
           
        </form>
    </div>
    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<%@include file = "../parts/footer.jsp" %>
</body>
</html>