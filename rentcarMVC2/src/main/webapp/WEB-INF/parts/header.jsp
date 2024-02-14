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
<body>
	<table>
		<tr height="70">
			<td colspan="4">
				<a href="${ctx}/main.do" style="text-decoration: none">
				<img alt="" src="img/rent_logo.jpg" height="120">
				</a>
			</td>
			<td align="center" width="200">
			<c:if test="${log eq null }">
				GUEST님
				<button onclick="location.href='${ctx}/loginCheck.do'"> 로그인 </button>&nbsp;&nbsp;
				<button onclick="location.href='${ctx}/joinUser.do'"> 회원가입 </button>
				</c:if>
	
			<c:if test = "${log ne null}">
				${log}님
				<button onclick="location.href='${ctx}/loginCheck.do'"> 로그아웃 </button> 
			</c:if>
			</td>
		</tr>
		<tr height="50">
			<td align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="${ctx }/uploadCarImg.do" 
				style="text-decoration: none">예 약 하 기</a></font>
			</td>
			<td align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="${ctx }/viewReserve.do" 
				style="text-decoration: none">예 약 확 인</a></font>
			</td>
			<td align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="#" style="text-decoration: none">자유게시판</a></font>
			</td>
			<td align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="#" style="text-decoration: none">이  벤  트</a></font>
			</td>
			<td align="center" width="200" bgcolor="darkgray">
				<font color="white" size="5"><a href="#" style="text-decoration: none">고 객 센 터</a></font>
			</td>
		</tr>
	</table>
</body>
</html>