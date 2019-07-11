<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/bootstrap/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/Flat-UI-master/dist/css/flat-ui.min.css" />
<script
	src="<%=request.getContextPath()%>/static/bootstrap/bootstrap/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/static/bootstrap/bootstrap/js/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/Flat-UI-master/dist/js/flat-ui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center  style="margin-top:100px" >
	<h4>管理员登入页面</h4>
		<c:if test="${message!=null }">${message }</c:if>
	<form action="<%=request.getContextPath() %>/manager/dologin" method="post">
	<table cellpadding="10" cellspacing="0">
		<tr>
			<td>管理员:</td>
			<td><input type="text" name="managerName" value="${param.managerName }"/></td>
		</tr>
		<tr>
			<td>密码::</td>
			<td><input type="password" name="managerPassword" value="${param.managerPassword }"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="登入"/></td>
			<td><a href="<%=request.getContextPath()%>/index.jsp">返回主页</a></td>
		</tr>
	</table>
	</form>
	</center>

</body>
</html>