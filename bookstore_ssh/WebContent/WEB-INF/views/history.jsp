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
	<jsp:include page="/WEB-INF/views/commons/nav.jsp"></jsp:include>
	<div class="container" style="margin-top: 70px">
		<div class="row">

			<div class="col-xs-8 col-sm-6">用户:${User.username } 交易记录</div>
			<div class="col-xs-4 col-sm-6 text-right">
				<a class="btn btn-default"
					href="<%=request.getContextPath()%>/gotouserinfo">个人中心</a>
			</div>
		</div>


		<c:forEach items="${User.trades }" var="trade">
			<table class="table table-bordered  table-striped ">
				<tr>
					<td><font style="font-weight: 700" color="#303030">订单编号:${trade.tradeId }</font></td>
					<td>图书</td>
					
					<td>时间: <fmt:formatDate value="${trade.tradeTime }"
							pattern="yyyy年MM月dd日   hh:mm:ss" />
					</td>
					<td>订单状态</td>
				</tr>
				<c:forEach items="${trade.items}" var="item">
					<tr>
						<td>书名:${item.book.title }</td>
						<td><img width=100 src="/file2/${item.book.imgpath}"></td>
						<td>数量:${item.quantity }</td>
						<td>
						<c:if test="${item.orderstatus.statuName=='已发货' }">
						已发货
						<img height=40 src="<%=request.getContextPath() %>/static/Flat-UI-master/img/icons/svg/paper-bag.svg" alt="Pocket">
						</c:if>
						<c:if test="${item.orderstatus.statuName=='已付款' }">
						已付款
						<img height=40 src="<%=request.getContextPath() %>/static/Flat-UI-master/img/icons/svg/retina.svg" alt="Retina">						
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:forEach>
	</div>
</body>
</html>