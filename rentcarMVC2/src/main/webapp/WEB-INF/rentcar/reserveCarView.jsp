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
	
	<c:if test = "${categoryCar eq null }">
	<c:if test ="${search eq null }">
	<table>
		<tr height="60">
		<td align="center" colspan="3">
			<font size="6" color="gray">최신형 자동차</font>
		</td>
		</tr>
		<tr height="240">
 		 <c:forEach var="vo" items="${mainImgList}">
			<td width="333" align="center">
			<a href="${ctx }/carInfo.do?no=${vo.no}">
				<img alt="" src="img/${vo.img}" width="300" height="220">
			</a><p>
			<font size="3" color="gray"><b>차량명 | ${vo.name }</b></font>
			</td>
		</c:forEach>
		</tr>
	</table>
	 </c:if>
	</c:if>
			<c:if test = "${search ne null }"> 
				<table>
				<tr height="60">
				<td align="center" colspan="3"><font size="6" color="gray"> 전체 렌트카 보기 </font></td>
				</tr>
				 <c:forEach var= "vo" items="${allRentcarList }" varStatus = "status">
				 <c:if test="${(status.count % 3) eq 1  }"> 
				<tr height="220">
				 </c:if>
				<td width="333" align="center">
				<a href="${ctx }/carInfo.do?no=${vo.no }">
						<img alt="" src="img/${vo.img }" width="300" height="200">
				</a>
				<p>
						<font size="3" color="gray"><b>차량명 | ${vo.name }</b></font></td>
			  </c:forEach>
				</tr>
				</table>
		</c:if>
	<c:if test ="${categoryCar ne null }">
		
			<table>
			<tr height="60">
				<td align="center" colspan="3"><font size="6" color="gray">${temp}
						자동차</font></td>
			</tr>
			  <c:forEach var= "vo" items="${categoryCar }" varStatus = "status">
				 <c:if test="${(status.count % 3) eq 1  }"> 
				<tr height="220">
				 </c:if>
				<td width="333" align="center">
				<a href="${ctx }/carInfo.do?no=${vo.no }">
						<img alt="" src="img/${vo.img }" width="300" height="200">
				</a>
				<p>
						<font size="3" color="gray"><b>차량명 | ${vo.name }</b></font></td>
			  </c:forEach>
				</tr>
				</table>
		
	</c:if>
	<!-- ================================================== -->
	
	<hr size="3" color="red">
	<p>
	<font size="4" color="gray"><b>차량 검색 하기</b></font>
	
	<form action="${ctx }/carList.do" method="post">
		<font size="3" color="gray"><b>차량 검색 하기</b></font>&nbsp;&nbsp;
		<select name="category">
			<option value="1">소형</option>
			<option value="2">중형</option>
			<option value="3">대형</option>
		</select>
		<input type="submit" value="검색" />&nbsp;&nbsp;
	</form>
	<%-- button은 form 밖에 위치시키기 --%>
	<button onclick="location.href='${ctx}/carList.do?search=all'">전체 검색</button>
	
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