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
			<form name="fileForm" action="${ctx }/uploadCarImg.do" method="post" enctype="multipart/form-data""> 
		<table border="1">
			<tr height="100">
				<td align="center" colspan="2"> 
					<font size="6" color="gray"> 차량 등록 </font> 
				</td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 차량 이름 </td>
				<td width="180"> <input type="text" name="name" size="15" required /> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 차량 종류 </td>
				<td width="180"> <input type="number" name="category" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 렌트 가격 </td>
				<td width="180"> <input type="number" name="price" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 승차 인원 </td>
				<td width="180"> <input type="number" name="usepeople" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 렌트카 총 수량 </td>
				<td width="180"> <input type="number" name="total_qty" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 차량 회사 </td>
				<td width="180"> <input type="text" name="company" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 차량 이미지 </td>
				<td width="180"> <input type="file" name="uploadFile" size="15" required accept="image/*"/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 차량 정보 </td>
				<td width="180"> <input type="text" name="info" size="15" required/> </td>
			</tr>
<%-- 			  <tr>
   			 <td colspan="2" align="center">
      		 <input type="button" value="사진 업로드" class='col-3 btn btn-success' id="uploadBtn"/> 
      		 <input type="submit" value="수정하기" class='col-3 btn btn-primary' <c:if test="${loginId!=vo.id and loginId!='admin'}"> 
    	              disabled="disabled"
          	      </c:if>/>
     		  <input type="button" value="사진 삭제" class='col-3 btn btn-warning' id="deleteBtn"   <c:if test="${loginId!=vo.id and loginId!='admin'}"> 
    	              disabled="disabled"
          	      </c:if>/> 
  			  </td>
  			</tr> --%>
			<tr height="40">
				<td align="center" colspan="2">
					<input type="submit" value="등록하기" />
				</td>
			</tr>
			
		</table>
	</form>
	
<%-- 	<div id="upload">
		<form id="imgForm">
			<input id="uploadFile" type="file" name="uploadFile" accept="image/*">
			<input type="hidden" name="num" value="${vo.num}"/>
		</form>
	</div> --%>
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

<script>

</script>