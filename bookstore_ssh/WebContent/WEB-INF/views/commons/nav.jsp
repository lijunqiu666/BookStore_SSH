<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 导航部分 -->
	<nav class="navbar navbar-inverse navbar-embossed  navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">书城</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/getbooks?">首页 <span
						class="sr-only">(current)</span>
				</a></li>
			</ul>
			<form class="navbar-form navbar-left"
				action="${pageContext.request.contextPath}/getbooks" method="post">
				<div class="form-group">
					<input placeholder="最低价" class="form-control" type="text" size="10"
						name="minprice" />
				</div>
				<div class="form-group">
					<input placeholder="最高价" class="form-control" type="text" size="10"
						name="maxprice" />
				</div>
				<div class="form-group">
					<input type="text" value="${param.keyWord}" name="keyword"
						class="form-control" placeholder="请输入关键词">
				</div>
				<div class="form-group">
					<input class="btn btn-default" type="submit" value="搜索" />
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/manager/tologin">后台</a></li><li>
				<li>
				<a class="shoppingcart" href="${pageContext.request.contextPath}/getcartinfo?pagenumber=${page.pageNo }">
						购物车
					<span class="navbar-unread">1</span>
				</a>
				</li>
				<c:if test="${User==null}">
					<li><a href="${pageContext.request.contextPath}/tologin"">登入</a></li>
				</c:if>
				<li><a href="${pageContext.request.contextPath}/toregitster">注册</a></li>
				<c:if test="${User!=null}">
					<li><a class="logout" href="${pageContext.request.contextPath}/logout"">注销</a></li>
					<li class="dropdown"><a href="<%=request.getContextPath()%>/gotouserinfo">
					 <img width=25 src="${pageContext.request.contextPath}/static/imgs/head.jpg" alt="..." class="img-circle"> <span class="caret"></span></a>
					 </li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
<script >
$(function(){
	$(".logout").click(function(){
		var flag=confirm("你确定要退出登入吗?")
		if(flag){
			
		}else{
			return false;			
		}
	})
})
</script>