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
<div align="center">
	<table>
		<%-- top 부분 --%>
<%-- 		<tr height="120" align="center">
			<td align="center" width="1000">
				<%@include file = "../parts/header.jsp"%>
			</td>
		</tr> --%>
		<%-- center 부분 --%>
		<tr align="center">
<%-- 			<form action="${ctx }/logInOut.do" method="post"> 
		<table border="1">
			<tr height="100">
				<td align="center" colspan="2"> 
					<font size="6" color="gray"> 로그인 </font> 
				</td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 아이디 </td>
				<td width="180"> <input type="text" name="id" size="15" /> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 패스워드 </td>
				<td width="180"> <input type="password" name="pw" size="15" /> </td>
			</tr>
			<tr height="40">
				<td align="center" colspan="2">
					<input type="submit" value="로그인" />
				</td>
			</tr>
		</table>
	</form> --%>
		</tr>
		<%-- bottom 부분 --%>
<%-- 		<tr height="100" align="center">
			<td align="center" width="1000">
				<%@include file = "../parts/footer.jsp" %>
			</td>
		</tr> --%>
	</table>
	</div>
	<%@include file = "../parts/header.jsp"%>
		<div class = "goCenter">
	    <div class="login-wrapper" align = "center">
        <h2>Login</h2>
        <form method="post" action="${ctx }/logInOut.do" id="login-form">
            <input type="text" name="id" placeholder="Id">
            <input type="password" name="pw" placeholder="Password">
<!--             <label for="remember-check">
                <input type="checkbox" id="remember-check">아이디 저장하기
            </label> -->
            <input type="submit" value="Login">
        </form>
        <a href="${ctx }/findPw.do" class= "find"> 비밀번호 찾기 </a>
    </div>
    </div>
    <%@include file = "../parts/footer.jsp" %>
</body>
</html>