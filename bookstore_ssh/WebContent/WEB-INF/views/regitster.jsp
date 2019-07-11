<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<style>
.row {
	margin-left: 20px;
	margin-right: 20px;
}

.regitster {
	margin-top: 70px;
}
</style>
</head>
<body>
<c:if test="${sessionScope.locale!=null }">
			<fmt:setLocale value="${locale }"/>
		</c:if>
<fmt:setBundle basename="i18n"/>
<jsp:include page="/WEB-INF/views/commons/nav.jsp"></jsp:include>
	<!--content-->
	<div class="container regitster">
		<div class="row thumbnail">
			<div class="col-sm-12">
				<h1 class="text-center" style="margin-bottom: 30px"><fmt:message key="logout"></fmt:message> </h1>
				<h5 style="text-align: center">
					<font color="red">${message }</font>
				</h5>
			</div>
			<div class="col-sm-6">
				<form action="${pageContext.request.contextPath}/doregitster"
					method="post" class="form-horizontal caption">
					<div class="form-group">
						<label for="username" class="col-sm-3 control-label"><fmt:message key="username"></fmt:message> </label>
						<div class="col-sm-8">
							<input type="text" name="username" class="form-control"
								placeholder="<fmt:message key="username"></fmt:message>">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3 control-label"><fmt:message key="password"></fmt:message></label>
						<div class="col-sm-8">
							<input type="password" name="password" class="form-control"
								placeholder="<fmt:message key="password"></fmt:message>">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3 control-label"><fmt:message key="phonenumber"></fmt:message></label>
						<div class="col-sm-8">
							<input type="password" name="phonenumber" class="form-control"
								id="password2" placeholder="<fmt:message key="phonenumber"></fmt:message>">
						</div>
					</div>
					<div class="form-group">
						<label for="inlineRadio1" class="col-sm-3 control-label">性别</label>
						<div class="col-sm-8">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio1" value="男"><fmt:message key="man"></fmt:message>
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio2" value="女"><fmt:message key="woman"></fmt:message>
							</label>
						</div>

					</div>
					
					<div class="form-group">
						<label for="address" class="col-sm-3 control-label"><fmt:message key="address"></fmt:message></label>
						<div class="col-sm-8">
							<input type="text" name="address" class="form-control"
								id="address" placeholder="<fmt:message key="address"></fmt:message>">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-3 control-label"><fmt:message key="email"></fmt:message></label>
						<div class="col-sm-8">
							<input type="email" name="email" class="form-control" id="email"
								placeholder="<fmt:message key="email"></fmt:message>">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-3 control-label"><fmt:message key="birth"></fmt:message></label>
						<div class="col-sm-8">
							<input type="text" name="birth" class="form-control" id="birth"
								placeholder="<fmt:message key="birth"></fmt:message>">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<input type="submit" class="btn btn-success btn-block" value="<fmt:message key="regitster"></fmt:message>">
							</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-sm-6">
				<div class="caption">
					<h3><fmt:message key="decarehead"></fmt:message></h3>
					<small> <fmt:message key="decare"></fmt:message></small>

				</div>

			</div>

		</div>
	</div>

	<!--footer-->
	<div class="navbar navbar-default navbar-static-bottom">版权声明区</div>
</body>
</html>