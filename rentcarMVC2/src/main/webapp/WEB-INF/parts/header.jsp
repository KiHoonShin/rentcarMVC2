<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap" rel="stylesheet">
<style>
body {
  background: white;
}
h1 {
  position: relative;
  text-align: center;
  color: #353535;
  font-size: 50px;
  font-family: "Cormorant Garamond", serif;
}

.frame {
  width: 90%;
  margin: 10px auto;
  text-align: center;
}
button {
  margin: 20px;
  outline: none;
}
.custom-btn {
  width: 130px;
  height: 40px;
  padding: 10px 25px;
  border: 2px solid #000;
  font-family: 'Lato', sans-serif;
  font-weight: 500;
  background: transparent;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
}
.btn-7 {
   background: #000;
  color: #fff;
  line-height: 42px;
  padding: 0;
  border: none;
  z-index: 1;
   -webkit-transition: all 0.3s linear;
  transition: all 0.3s linear;
}
.btn-7:hover {
  background: transparent;
  color: #000;
}
.btn-7:before,
.btn-7:after {
  position: absolute;
  content: "";
  left: 0;
  width: 100%;
  height: 50%;
  right: 0;
  z-index: -1;
  background: #000;
  transition: all 0.3s ease;
}
.btn-7:before {
  top: 0;
}
.btn-7:after {
  bottom: 0;
}
.btn-7:hover:before,
.btn-7:hover:after {
  height: 0;
  background-color: #000;
}

a {
	color : black;
	text-decoration: none;
}
.menu:hover{
transform:scale(1.05); 
}
.printId {
	font-weight: bold;
	font-size : 2rem;
}
</style>
<body>
	<table>
		<tr height="70">
			<td colspan="4">
				<a href="${ctx}/main.do" style="text-decoration: none">
				<img alt="" src="img/rent_logo.jpg" height="120">
				</a>
			</td>
			<td align="center" width="200">
			<div class = "frame">
			<c:if test="${log eq null }">
			<div class = "printId">
				GUEST님
				</div>
				<button class="custom-btn btn-7" onclick="location.href='${ctx}/logInOut.do'"> 로그인 </button>
				<button class="custom-btn btn-7" onclick="location.href='${ctx}/joinUser.do'"> 회원가입 </button>
				</c:if>
	
			<c:if test = "${log ne null}">
			<div class = "printId">
				${log}님
				</div>
				<button class="custom-btn btn-7" onclick="location.href='${ctx}/logInOut.do'"> 로그아웃 </button> 
				<button class="custom-btn btn-7" onclick="location.href='${ctx}/deleteUser.do'"> 회원탈퇴 </button>
			<c:if test = "${log == 'admin' }">
			<button class="custom-btn btn-7" onclick="location.href='${ctx}/insertCar.do'"> 차량 등록 </button> 
			</c:if>
			</c:if>
			</div>
			</td>
		</tr>
		<tr height="50">
			<td class ="menu" align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="${ctx }/carList.do" 
				style="text-decoration: none">예 약 하 기</a></font>
			</td>
			<td class ="menu" align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="${ctx }/viewReserve.do" 
				style="text-decoration: none">예 약 확 인</a></font>
			</td>
			<td class ="menu" align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="#" style="text-decoration: none">자유게시판</a></font>
			</td>
			<td class ="menu" align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="#" style="text-decoration: none">이  벤  트</a></font>
			</td>
			<td class ="menu" align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="#" style="text-decoration: none">고 객 센 터</a></font>
			</td>
		</tr>
	</table>
</body>
</html>