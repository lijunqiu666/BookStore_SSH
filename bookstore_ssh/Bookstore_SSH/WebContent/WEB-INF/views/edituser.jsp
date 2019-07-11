<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/static/bootstrap/bootstrap/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#username").change(function(){
		var value=$(this).val();
		value=$.trim(value);
		var url="ajaxvaildataname";
		var args={"username":value,"date":new Date()};
		$.get(url,args,function(data){
			if(data==1){
				alert("该用户名已经被占用")
			}else if(data==0){
				alert("该用户名可以使用");
			}else{
				alert("服务器错误,或网络错误");
			}
		})
		
	})
})
</script>
</head>
<body>
	<center>
			<%
				Map<String, String> genders = new HashMap();
					genders.put("女", "女");
					genders.put("男", "男");
					request.setAttribute("genders", genders);
			%>

	<h1>编辑资料${message }</h1>
	
	<form:form action="${pageContext.request.contextPath}/doupdateuserinfo" method="post" modelAttribute="user">
	<table cellpadding="20" cellspacing="0" border="1">
		<form:hidden path="id"/>
		<form:hidden path="password"/>
		<tr>
			<td>用户名</td>
			<td><form:input path="username" id="username" /></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
		<tr>
			<td>电话</td>
			<td><form:input path="phonenumber" /></td>
		</tr>
		<tr>
			<td>生日</td>
			<td><form:input path="birth" /></td>
		</tr>
		<tr>
			<td>注册时间</td>
			<td><form:input path="createTime" disabled="true" /></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><div class="form-group">
				<label for="exampleInputEmail1">性别:</label>
				<form:radiobuttons  path="sex" items="${genders }" />	
				</div>
			</td>
		</tr>
		<tr>
			<td>操作</td>
			<td colspan="2">
			<form:button>确定修改</form:button> &nbsp;&nbsp;&nbsp;&nbsp; 
			<a href="${pageContext.request.contextPath}/gotouserinfo">返回</a></td>
		</tr>
	</table>
		
	</form:form>
	</center>
</body>
</html>