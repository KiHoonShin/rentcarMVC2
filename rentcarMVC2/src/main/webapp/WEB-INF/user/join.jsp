<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<table>
		<%-- top 부분 --%>
		<tr height="120" align="center">
			<td align="center" width="1000">
				<%@include file = "../parts/header.jsp"%>
			</td>
		</tr>
		<%-- center 부분 --%>
		<tr align="center">
			<form action="${ctx }/joinUser.do" method="post"> 
		<table border="1">
			<tr height="100">
				<td align="center" colspan="2"> 
					<font size="6" color="gray"> 회원가입 </font> 
				</td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 아이디 </td>
				<td width="180"> <input type="text" name="id" size="15" required /> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 패스워드 </td>
				<td width="180"> <input type="password" name="pw" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 이메일 </td>
				<td width="180"> <input type="email" name="email" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 연락처 </td>
				<td width="180"> <input type="tel" name="tel" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 취미 </td>
				<td width="180"> <input type="text" name="hobby" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 직업 </td>
				<td width="180"> <input type="text" name="job" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 나이 </td>
				<td width="180"> <input type="text" name="age" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 정보 </td>
				<td width="180"> <input type="text" name="info" size="15" required/> </td>
			</tr>
			
			<tr height="40">
				<td align="center" colspan="2">
					<input type="submit" value="회원가입" />
				</td>
			</tr>
		</table>
	</form>
		</tr>
		<%-- bottom 부분 --%>
		<tr height="100" align="center">
			<td align="center" width="1000">
				<%@include file = "../parts/footer.jsp" %>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>