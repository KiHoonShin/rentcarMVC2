<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class = "goCenter">
	    <div class="login-wrapper" align = "center">
        <h2>회원가입</h2>
        <form method="post" action="${ctx }/joinUser.do" id="login-form">
            <input type="text" name="id" id = "id" placeholder="Id" autofocus required>
            <input type="password" id = "pw" name="pw" placeholder="Password" required>
            <input type="email" id="email" name="email" placeholder="email" required>
            <input type="tel" id = "tel" name="tel" placeholder="tel" required>
            <input type="text" id = "job" name="job" placeholder="job" required>
            <input type="text" id = "age" name="age" placeholder="age" required>
            <input type="text" id = "info" name="info" placeholder="info" required>
            <input type="button" value="회원가입" onclick="validCheck(form)">
        </form>
    </div>
    </div>
</body>
</html>