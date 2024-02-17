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
		  <table>
			<tr height="100">
				<td align="center" colspan="11"> 
					<font size="6" color="gray"> 차량 예약 완료 화면 </font> 
				</td>
			</tr>
		 </table>
		 <c:if test = "${size eq 0 }">
		 <table>
		 				<tr height="100">
				<td align="center" colspan="11"> 
					<font size="6" color="black"> 예약된 차량이 없습니다 </font> <br>
<%-- 					<button onclick="location.href='${ctx}/main.do'">홈</button>&nbsp;&nbsp;
					<button onclick="location.href='${ctx}/carList.do'">예약하기</button> --%>
				</td>
			</tr>
			<tr>
					<td align="center" colspan="11">
						<input type="button" value="홈" onclick="location.href='${ctx}/main.do'" /> &nbsp;&nbsp;&nbsp;
						<input type="button" value="차량 예약하기" onclick="location.href='${ctx}/carList.do'" />
					</td>
			</tr>
		</table>
		 </c:if>
		 <c:if test="${size > 0 }">
		<table border="1">
			<tr height="40">
				<td width="150" align="center"> 이미지 </td>
				<td width="150" align="center"> 이름 </td>
				<td width="150" align="center"> 대여일 </td>
				<td width="60" align="center"> 대여기간 </td>
				<td width="100" align="center"> 금액 </td>
				<td width="60" align="center"> 수량 </td>
				<td width="60" align="center"> 보험 </td>
				<td width="60" align="center"> wifi </td>
				<td width="60" align="center"> 베이비시트 </td>
				<td width="60" align="center"> 네비게이션 </td>
				<td width="90" align="center"> 삭제 </td>
			</tr>
			
	<c:forEach var = "vo" items="${list}">
		<tr height="70">	
			<!-- vo.no == rentcar no 일때 rentcar img 출력 -->
			<c:forEach var = "rentcar" items = "${rentcarList }">
			<c:if test = "${vo.no eq rentcar.no }">
			<td height="70" align="center">
				<img src="img/${rentcar.img}"  width="120" height="70">
			</td>
			<td width="100" align="center">${rentcar.name }</td>
			</c:if>
			</c:forEach>
			<td width="150" align="center">${vo.rday }</td>
			<td width="150" align="center">${vo.dday }</td>
			<c:forEach var = "rentcar" items = "${rentcarList }">
			<c:if test = "${vo.no eq rentcar.no }">
			<td width="100" align="center">${rentcar.price } 원</td>
			</c:if>
			</c:forEach>
			<%-- <td width="100" align="center">${vo.price } 원</td> --%>
			<td width="60" align="center">${vo.qty }</td>
			<td width="100" align="center">${vo.usein }</td>
			<td width="60" align="center">${vo.usewifi }</td>
			<td width="60" align="center">${vo.usenavi }</td>
			<td width="60" align="center">${vo.useseat}</td>
			<td width="90" align="center">
				<button onclick="location.href='${ctx}/deleteCar.do?resSeq=${vo.reserve_seq }&qty=${vo.qty }&no=${vo.no }'">삭제</button>
			</td>
			
		</tr>
	</c:forEach>
		</table>
	</c:if>
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