<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div class="container">
	<h2>交易记录</h2>
	<c:forEach items="${User.trades }" var="trade">
			<table class="table table-bordered  table-striped">
				<tr>
					<td><font style="font-weight:700" color="red">交易ID:${trade.tradeId }</font></td>
					<td>交易时间: <fmt:formatDate value="${trade.tradeTime }" pattern="yyyy年MM月dd日  hh:mm:ss"/> </td>
				</tr>
				<c:forEach items="${trade.items}" var="item">
					<tr>
						<td>书名:${item.book.title }</td>
						<td>数量:${item.quantity }</td>
					</tr>
				</c:forEach>
			</table>
	</c:forEach>
		</div>
</body>
</html>