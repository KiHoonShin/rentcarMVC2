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
				<%@include file = "parts/header.jsp"%>
			</td>
		</tr>
		<%-- center 부분 --%>
		<tr align="center">
			<td align="center" width="1000">
				  <table>
					<tr height="500">
					 <td align="center">
						<img alt="" src="img/페라리.jpg" width="1000">
					 </td>
					</tr>
				  </table>
			</td>
		</tr>
		<%-- bottom 부분 --%>
		<tr height="100" align="center">
			<td align="center" width="1000">
				<%@include file = "parts/footer.jsp" %>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>