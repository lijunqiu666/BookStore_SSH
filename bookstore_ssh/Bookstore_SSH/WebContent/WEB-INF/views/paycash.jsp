<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<style>
.paycash{margin-top:70px;}
</style>
<body>
	<jsp:include page="/WEB-INF/views/commons/nav.jsp"></jsp:include>
	<!--content-->
<div class="container paycash">
<div class="alert alert-success alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Tip!</strong>尊敬的: ${User.username },你一共购买了${Cart.bookNumber }件商品,您应该支付金额<span class="glyphicon glyphicon-yen"></span>${Cart.totalMoney}元
</div>


	<h6><c:if test="${message!=null }"><font color="red">${message }</font></c:if></h6>
    <div class="row thumbnail center">
        <div class="col-sm-12">
            <h1 class="text-center" style="margin-bottom: 30px">用户结账</h1>
        </div>
        <div class="col-sm-6">
            <form action="${pageContext.request.contextPath}/dopaycash" method="post" class="form-horizontal caption">
                <div class="form-group">
                    <label  class="col-sm-3 control-label">账户</label>
                    <div class="col-sm-8">
                        <input type="text"  name="accountId" class="form-control" id="username" placeholder="账户">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password" name="password"  class="form-control"  placeholder="密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">记住我
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-5">
                        <button type="submit" class="btn btn-success btn-block">支付</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-5">
                       <a class="btn btn-default btn-block" href="<%=request.getContextPath() %>/getcartinfo">返回购物车</a>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-6">
            <div class="caption">
                <h3>免责声明</h3>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            </div>

        </div>

    </div>
</div>


<!--footer-->
<div class="navbar navbar-default navbar-static-bottom">
    版权声明区
</div>
</body>
</html>