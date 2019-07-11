<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
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
<title>管理中心</title>
</head>

<script type="text/javascript">
	$(function() {
		$(".Logout").click(function() {
			var flag = confirm("确定要退出登入吗?");
			if (flag) {
				return;
			} else {
				return false;
			}
		})
	})
</script>
<body>
	<nav class="navbar navbar-inverse navbar-embossed  navbar-fixed-top">
	<div class="container">
		<ul class="nav navbar-nav">
			<li class="active"><a
				href="<%=request.getContextPath()%>/manager/backtocenter">首页 <span
					class="sr-only">(current)</span></a></li>
			<li><a
				href="<%=request.getContextPath()%>/manager/tomanagerbooks">图书管理</a></li>
			<li ><a
				href="<%=request.getContextPath()%>/manager/tomanagerusers">用户管理</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#" class="glyphicon glyphicon-user">${Manager.mgrName}</a></li>
			<li><a href="<%=request.getContextPath()%>/manager/dologout"
				class="glyphicon glyphicon-off">退出</a></li>
		</ul>
	</div>
	</nav>
	<!--警告框-->
	<div class="container" style="margin-top: 80px;">
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">热度视图</div>
					<div class="panel-body">

						<p>${hotbooks[0].title}热度：<fmt:formatNumber type="number"
								value="${hotbooks[0].salesAmount/5970*100} "
								maxFractionDigits="2" />
							%
						</p>
						<div class="progress">
							<div
								class="progress-bar progress-bar-success progress-bar-striped active"
								role="progressbar"
								aria-valuenow="${hotbooks[0].salesAmount/5970*100 }"
								aria-valuemin="0" aria-valuemax="100" style="width: 80%"></div>
						</div>
						<p>${hotbooks[1].title}热度：<fmt:formatNumber type="number"
								value="${hotbooks[2].salesAmount/5970*100} "
								maxFractionDigits="2" />
							%
						</p>
						<div class="progress">
							<div
								class="progress-bar progress-bar-info  progress-bar-striped active"
								role="progressbar"
								aria-valuenow="${hotbooks[1].salesAmount/5970*100 }"
								aria-valuemin="0" aria-valuemax="100" style="width: 60%"></div>
						</div>
						<p>${hotbooks[2].title}热度：<fmt:formatNumber type="number"
								value="${hotbooks[3].salesAmount/5970*100} "
								maxFractionDigits="2" />
							%
						</p>
						<div class="progress">
							<div
								class="progress-bar progress-bar-warning progress-bar-striped active"
								role="progressbar"
								aria-valuenow="${hotbooks[2].salesAmount/5970*100 }"
								aria-valuemin="0" aria-valuemax="100" style="width: 40%"></div>
						</div>
						<p>${hotbooks[3].title}热度：<fmt:formatNumber type="number"
								value="${hotbooks[4].salesAmount/5970*100} "
								maxFractionDigits="2" />
							%
						</p>
						<div class="progress">
							<div
								class="progress-bar progress-bar-danger progress-bar-striped active"
								role="progressbar"
								aria-valuenow="${hotbooks[3].salesAmount/5970*100 }"
								aria-valuemin="0" aria-valuemax="100" style="width: 30%"></div>
						</div>

					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">团队联系手册</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">站长(李小龙)：<span
								class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13134848615
							</li>
							<li class="list-group-item">技术(大牛哥)：<span
								class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13456127694
							</li>
							<li class="list-group-item">推广(张二哥)：<span
								class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13457815482
							</li>
							<li class="list-group-item">客服(王女士)：<span
								class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13134567782&nbsp;&nbsp;<span
								class="glyphicon glyphicon-phone-alt"></span>&nbsp;&nbsp;028-888888
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">网站热书</div>
					<ul class="list-group">
						<c:forEach items="${hotbooks }" var="book">
							<li class="list-group-item"><a href="index.html"> <span
									class="glyphicon glyphicon-list-alt"> </span>&nbsp;&nbsp;${book.title }
									<a class="pull-right btn btn-success btn-sm">查看</a> <small
									class="pull-left"> 月销量:${book.salesAmount }笔 </small>


							</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">网站数据统计</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>统计项目</th>
									<th>今日</th>
									<th>昨日</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">注册会员</th>
									<td>200</td>
									<td>400</td>
								</tr>
								<tr>
									<th scope="row">登录会员</th>
									<td>4100</td>
									<td>5112</td>
								</tr>
								<tr>
									<th scope="row">今日发帖</th>
									<td>1540</td>
									<td>4511</td>
								</tr>
								<tr>
									<th scope="row">转载次数</th>
									<td>150</td>
									<td>110</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-6"></div>
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">团队留言板</div>
					<div class="panel-body"></div>
				</div>
			</div>
		</div>
	</div>



	<!--footer-->
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<p>
					Copyright&nbsp;©&nbsp;2012-2015&nbsp;&nbsp;www.maiziedu.com&nbsp;&nbsp;蜀ICP备13014270号-4
				</p>
			</div>
		</div>
	</div>
	</footer>
	<!--footer-->
</body>
</html>