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
				<td width="180"> <input type="text" id="id" name="id" size="15" required /> 
				<input type="button" value="중복체크" id="checkId" class="btn btn-outline-dark"></td>
				
			</tr>
			<tr height="40">
				<td width="120" align="center"> 패스워드 </td>
				<td width="180"> <input type="password" id="pw" name="pw" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 이메일 </td>
				<td width="180"> <input type="email" id="email" name="email" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 연락처 </td>
				<td width="180"> <input type="tel" id="tel" name="tel" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 취미 </td>
				<td width="180"> <input type="text" id="hobby" name="hobby" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 직업 </td>
				<td width="180"> <input type="text" id="job" name="job" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 나이 </td>
				<td width="180"> <input type="text" id="age" name="age" size="15" required/> </td>
			</tr>
			<tr height="40">
				<td width="120" align="center"> 정보 </td>
				<td width="180"> <input type="text" id="info" name="info" size="15" required/> </td>
			</tr>
			
			<tr height="40">
				<td align="center" colspan="2">
					<input type="submit" value="회원가입" onclick="validCheck(form)"/>
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

<script>
	let check = 0;
	function validCheck(form){
		if(!form.id.value.trim()){
			alert("아이디를 입력해주세요");
			form.id.focus();
			return false;
		}
		if(!form.pw.value.trim()){
			alert("패스워드를 입력해주세요");
			pw.id.focus();
			return false;
		}	
		if(!form.email.value.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
			alert("이메일 형식이 다릅니다");
			form.email.value="test@test.com";
			form.email.focus();
			return false;
		}
		if(!form.tel.value.match(/010-\d{3,4}-\d{4}/)){
			alert("전화번호 형식이 다릅니다");
			form.tel.value="010-1234-1234";
			form.tel.focus();
			return false;
		}
		if(!form.hobby.value.trim()){
			alert("취미를 입력해주세요");
			form.hobby.focus();
			return false;
		}
		if(!form.job.value.trim()){
			alert("취미를 입력해주세요");
			form.job.focus();
			return false;
		}
		if(!form.age.value.trim()){
			alert("나이를 입력해주세요");
			form.age.focus();
			return false;
		}else{
			 if(Number(form.age.value.trim()) < 20 || Number(form.age.value.trim()) > 99 ){
					/* alert("나이 값(20-99)을 정확하게 입력하세요"); */
					alert("미성년자는 가입할 수 없습니다.");
					form.age.focus();
					return false;
			}
		}
		if(!form.info.value.trim()){
			alert("정보를 입력해주세요");
			form.info.focus();
			return false;
		}
		
		if(check == 0){
			alert('id 중복체크 해주세요');
			return false;
		} else if(check == -1){
			alert('id 중복체크 다시하세요');
			return false;
		}
		
		form.submit();
	}
	
	document.getElementById("checkId").addEventListener("click" , () => {
		let id = document.getElementById("id").value.trim();
	
		if(id.length === 0){
		    alert("id 값을 입력해주세요");
		    document.getElementById("id").focus();
		    document.getElementById("id").style.border = "";
		    return;
		}
	
		fetch("loginCheck.do", {
			method : "POST",
			headers : {
				"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
			},
			body : "id=" + id,
		})
		.then(response => response.text())
		.then(getResult)
		.catch(() => alert("error"));
	});
	
	function getResult(data){
		if(data === "valid"){
			alert("이 아이디는 사용이 가능합니다");
			document.getElementById("pw").focus();
			document.getElementById("id").style.border = "2px solid blue";
			check = 1;
		} else if(data === "notValid"){
			alert("이 아이디는 사용이 불가능합니다");
		    document.getElementById("id").value = "";
		    document.getElementById("id").focus();
		    document.getElementById("id").style.border = "2px red solid";
			check = -1;
		}
	}
	
	  document.getElementById("id").addEventListener("keyup", (e)=> {
		    if (e.keyCode === 8) {
		      check = 0;
		    }
		    document.getElementById("id").style.border = "";
		  });
	
</script>