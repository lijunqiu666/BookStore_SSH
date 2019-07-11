<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/commons/nav.jsp"></jsp:include>
	<!--content-->
	<div class="container userinfo">
		<div class="row thumbnail center col-sm-12">
			<a class=" fui-home" href="<%=request.getContextPath()%>/getbooks">返回首页</a>
			<div class="col-sm-12">
				<h1 class="text-center" style="margin-bottom: 30px">个人中心</h1>
			</div>
			
		<%
			Map<String, String> genders = new HashMap();
			genders.put("女", "女");
			genders.put("男", "男");
			request.setAttribute("genders", genders);
		%>

		<h5 class="text-center">用户资料</h5>

		<form:form action="" method="post" modelAttribute="user">
			
			<table class="table text-center" >
				<tr >
					<td>用户名</td>
					<td><form:input  path="username" disabled="true" /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><form:input path="address" disabled="true" /></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><form:input path="email" disabled="true" /></td>
				</tr>
				<tr>
				<tr>
					<td>电话</td>
					<td><form:input path="phonenumber" disabled="true" /></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><form:input path="birth" disabled="true" /></td>
				</tr>
				<tr>
					<td>注册时间</td>
					<td><form:input path="createTime" disabled="true" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><div class="form-group">
							<label for="exampleInputEmail1">性别:</label>
							<form:radiobuttons disabled="true" path="sex" items="${genders }" />
						</div></td>
				</tr>
				<tr>
					<td>操作</td>
					<td colspan="2">
					<a class="btn btn-success" href="${pageContext.request.contextPath}/toedituser">修改信息</a>
					<a class="btn btn-success" href="${pageContext.request.contextPath}/gethistory">我的交易</a>
					<a class="btn btn-success" href="${pageContext.request.contextPath}/getbooks">返回首页</a></td>
				</tr>
			</table>
				

		</form:form>
	

			
		</div>
	</div>

	
</body>
</html>