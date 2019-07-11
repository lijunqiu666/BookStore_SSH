<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/Flat-UI-master/dist/css/flat-ui.min.css" />
<script src="<%=request.getContextPath()%>/static/bootstrap/bootstrap/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/Flat-UI-master/dist/js/flat-ui.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.row {margin-left: 10px;margin-right: 10px;}
.cart {margin-top: 70px;}
</style>
<body>
	<%
		HttpSession Session = request.getSession();
		String code = (String) request.getParameter("code");
		if (code != null) {
			if ("en".equals(code)) {

				session.setAttribute("locale", Locale.US);
			}
			if ("zh".equals(code)) {
				session.setAttribute("locale", Locale.CHINA);
			}
		}
	%>
	<c:if test="${sessionScope.locale!=null }">
		<fmt:setLocale value="${locale }" />
	</c:if>
	<fmt:setBundle basename="i18n" />

	<jsp:include page="/WEB-INF/views/commons/nav.jsp"></jsp:include>
	<!--content-->
	<div class="container cart">
		<div class="row thumbnail center">
			<div class="col-sm-12">
				<h1 class="text-center" style="margin-bottom: 30px">
					<fmt:message key="title"></fmt:message><br>
				</h1>
				<h5 style="color:red" class="text-center">${message }</h5>
			</div>
			<div class="col-sm-6">
					
				<form action="${pageContext.request.contextPath}/dologin"
					method="post" class="form-horizontal caption">
					<div class="form-group">
						<label for="username" class="col-sm-3 control-label"> <fmt:message
								key="username"></fmt:message>
						</label>
						<div class="col-sm-8">
							<input name="username" type="text" class="form-control"
								id="username"
								placeholder="<fmt:message key="username"></fmt:message>">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3 control-label"> <fmt:message
								key="password"></fmt:message>
						</label>
						<div class="col-sm-8">
							<input name="password" type="password" class="form-control"
								id="password" placeholder="密码">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3 control-label"> <fmt:message
								key="taken"></fmt:message>
						</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="imgcode" />
						</div>
						<div class="col-sm-3">
							<img src="${pageContext.request.contextPath}/validateColor" />
						</div>

						<label class="col-sm-2 control-label"> <a
							href="<%=request.getContextPath()%>/tologin"><fmt:message
									key="change"></fmt:message> </a>
						</label>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<div class="checkbox">
								<label> <input type="checkbox">记住我
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<button type="submit" class="btn btn-success btn-block">登录</button>
							<br> <a href="<%=request.getContextPath()%>/tologin?code=en">English</a>
							&nbsp;&nbsp;|&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/tologin?code=zh">中文</a>
						</div>

					</div>

				</form>

			</div>
			<div class="col-sm-6">
				<div class="caption">
					<h3>
						<fmt:message key="decarehead"></fmt:message>
					</h3>
					<small> <fmt:message key="decare"></fmt:message>
					</small>
				</div>

			</div>

		</div>
	</div>
	<!--footer-->
	<div class="navbar navbar-default navbar-static-bottom">
		版权声明区${message }</div>

</body>
</html>