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

		<form action="${ctx }/carOption.do"	method="post">

			<table>
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">
							${vo.name } 차량 선택
					</font></td>
				</tr>
				<tr>
					<td rowspan="6" width="500" align="center"><img alt=""
						src="img/${vo.img }" width="450"></td>
					<td width="250" align="center">차량이름</td>
					<td width="250" align="center">${vo.name }</td>
				</tr>
				
				<tr>
					<td width="250" align="center">총 승차인원</td>
					<td width="250" align="center">${vo.usepeople }</td>
				</tr>
				<tr>
					<td width="250" align="center">차량수량</td>
					<td width="250" align="center">
					<select name="qty">
					<c:forEach var ="i" begin="1" end="${vo.total_qty}">
						<c:if test = "${i eq 1}">
							<option value="1" selected >1</option>
						</c:if>
						<c:if test="${i > 1 }">
							<option value="${i}">${i}</option>
						</c:if>
					</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td width="250" align="center">차량분류</td>
					<td width="250" align="center">${temp}</td>
				</tr>
				<tr>
					<td width="250" align="center">대여가격</td>
					<td width="250" align="center">${vo.price}원</td>
				</tr>
				<tr>
					<td width="250" align="center">제조회사</td>
					<td width="250" align="center">${vo.company }</td>
				</tr>
				<tr>
					<td width="250" align="center">
					
						<%-- 이전 차량에 관한 정보 --%> 
						<input type="hidden" name="no" value="${vo.no }" /> 
						<input type="hidden" name="img"	value="${vo.img }" /> 
						<input type="hidden" name="price" value="${vo.price }" /> 
						<input type="submit" value="옵션선택후 렌트 예약 하기" />
						
					</td>
				</tr>
			</table>

			<br />
			<br />
			<br /> <font size="5" color="gray">차랑 정보 보기</font>
			<p>${vo.info } </p>
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