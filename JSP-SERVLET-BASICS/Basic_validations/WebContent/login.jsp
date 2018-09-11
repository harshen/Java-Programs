<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function validate() {
	var len = document.forms["sample"]["password"].value.length;
	if(len < 6){
		alert("Password lenght is less than 6 character");
		return false;
	}else{
		return true;
	}
}
</script>
</head>																																																																																																																																																																																																																																																																																																																																																																																																																																																
<body>
<form action="/Basic_validations/Controller" method="post" name="sample" onsubmit="return validate()">
<label for="email">Email : </label><input type="text" id="email" name="email" required />
<br/>
<br/>
<label for="password">Password : </label><input type="password" id="password" name="password" maxlength="10" required />
<br/>
<br/>
<input type="submit" value="Login"/>
</form>
</body>
</html>