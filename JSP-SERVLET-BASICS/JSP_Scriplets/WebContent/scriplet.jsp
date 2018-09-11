<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/*int age = 12;
out.println("My age is : " + age);
*/

if(15 > 10) {
	out.print("15 is greater than 10");
}
out.println("</br>");
for(int i=0; i < 10; i++) {
	out.println("<br/>");
	out.println("We love JSP " + i);
}
%>
</body>
</html>