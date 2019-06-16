<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Login Page</h1>
<form:form method="POST" modelAttribute="UserCmd">
Enter Username::<form:input path="username"/><br>
Enter Password::<form:input path="password"/><br>
<input type="submit" value="Login">
</form:form><br>
<c:if test="${result ne null}">
<h3 style="color:green">${result}</h3>
</c:if> 