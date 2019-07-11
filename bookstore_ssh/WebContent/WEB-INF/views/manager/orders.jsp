<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="container" style="margin-top: 40px">
		<c:forEach items="${User.trades }" var="trade">
			<table class="table table-bordered  table-striped ">
				<tr>
					<td><font style="font-weight: 700" color="#303030">订单编号:${trade.tradeId }</font></td>
					<td>图书</td>
					
					<td>时间: <fmt:formatDate value="${trade.tradeTime }"
							pattern="yyyy年MM月dd日   hh:mm:ss" />
					</td>
					<td>订单状态</td>
					<td>发货</td>
				</tr>
				<c:forEach items="${trade.items}" var="item">
					<tr>
						<td>书名:${item.book.title }</td>
						<td><img width=100 src="/file2/${item.book.imgpath}"></td>
						<td>数量:${item.quantity }</td>
						<td><c:if test="${item.orderstatus.statuName=='已付款' }">
							等待发货
						</c:if>
						<c:if test="${item.orderstatus.statuName=='已发货' }">
							已经发货
						</c:if></td>
						<td><a class="btn btn-danger" href="<%=request.getContextPath() %>/manager/sendGoods?tradeitemid=${item.tradeItemId }&username=${User.username}" >点击发货</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:forEach>
	</div>
</body>
</html>