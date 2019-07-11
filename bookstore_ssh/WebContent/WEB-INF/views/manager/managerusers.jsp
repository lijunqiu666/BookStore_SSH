<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style>
 .modal-open{
       overflow-y: scroll;
    }
    body{
        padding-right:15px!important;
    }
</style>
<body>
	<nav class="navbar navbar-inverse navbar-embossed  navbar-static-top">
	<div class="container" >
		<ul class="nav navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/manager/backtocenter">首页 <span
					class="sr-only">(current)</span></a></li>
			<li><a
				href="<%=request.getContextPath()%>/manager/tomanagerbooks">图书管理</a></li>
			<li class="active"><a
				href="<%=request.getContextPath()%>/manager/tomanagerusers">用户管理</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#" class="glyphicon glyphicon-user">${Manager.mgrName}</a></li>
			<li><a href="<%=request.getContextPath()%>/manager/dologout"
				class="glyphicon glyphicon-off">退出</a></li>
		</ul>
		
	</div>
	</nav>
	
	<div class="container" style="margin-top:20px;">
	<!-- 用户信息 -->
	<table class="table table-condensed table-hover"
		style="font-size: 14px;">
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>电话</td>
			<td>地址</td>
			<td>性别</td>
			<td>注册时间</td>
			<td>操作</td>
			<td>修改</td>
		</tr>
		<c:forEach items="${page.list }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.phonenumber }</td>
				<td>${user.address }</td>
				<td><span>${user.sex }</span></td>
				<td>${user.createTime }</td>
				<td><a href="<%=request.getContextPath() %>/manager/getuserorders?username=${user.username}" class="btn btn-default">查看</a></td>
				<td><a href="<%=request.getContextPath() %>/manager/editbook"
					class="edit btn-success btn-sm glyphicon glyphicon-pencil"
					bookid="${book.id}" pagenumber="${page.pageNo }">编辑</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				共${page.totalPageNumber }页 当前:第${page.pageNo }页 &nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/manager/tomanagerusers?pageNo=1">首页</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/manager/tomanagerusers?pageNo=${page.prevPage}">上一页</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/manager/tomanagerusers?pageNo=${page.nextPage}">下一页</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/manager/tomanagerusers?pageNo=${page.totalPageNumber}">末页</a>
			</td>
		
		</tr>
	</table>
	
	
	</div>
	<hr>
	
</body>
</html>