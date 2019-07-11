<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/index.css">
<script type="text/javascript">
	
</script>
<body>
	<jsp:include page="/WEB-INF/views/commons/nav.jsp"></jsp:include>
	<!-- 广告牌 -->
	<div class="jumbotron masthead">
		<div class="container">
			<h1>Bookstore</h1>
			<h3>简洁、便捷、让阅读更迅速、简单。</h3>
			<p class="masthead-button-links">
				<a class="btn btn-lg btn-primary btn-shadow " role="button"">更多好书</a>
			</p>
		</div>
		<div class="bc-social">
			<!-- 书籍搜索部分 -->
			<div class="container-fluid ">
				<input type="hidden" name="minprice" value="${param.minprice}" /> <input
					type="hidden" name="maxprice" value="${param.maxprice}" /> <input
					type="hidden" name="keyWord" value="${param.keyWord}" />
			</div>
		</div>
	</div>
	<!-- 书籍展示部分 -fluid-->
	<div class="container">
		<div class="row">
			<c:forEach items="${page.list }" var="book">
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<img class="img-rounded" src="/file2/${book.imgpath}"
							alt="${book.title}" class="img-thumbnail">
						<div class="caption">
							<h4>
								<a class="booktitle" title="查看${book.title }的详细信息"
									href="${pageContext.request.contextPath}/getbookinfo?id=${book.id}&pagenumber=${page.pageNo }">${book.title }</a>
							</h4>
							<p class="bookinfo">
								<span class="author">作者:${book.author }</span><br> <span
									class="price">价格:<strong class="bookprice">￥${book.price }元&nbsp;&nbsp;&nbsp;
										<span class="label label-danger">包邮</span>
								</strong></span><br> <span class="publishtime">发行时间:${book.publishingDate }</span><br>
								<span class="saleamount">月销量:${book.salesAmount }笔</span><br>
								<span class="storenumber">库存:${book.storeNumber }条</span><br>
								<span class="remark">评论:${book.remark }条</span><br> <a
									class="btn btn-block btn-lg btn-primary" role="button"
									href="${pageContext.request.contextPath}/getbookinfo?id=${book.id}&pagenumber=${page.pageNo }">查看详情</a>
						</div>
					</div>
				</div>

			</c:forEach>
		</div>
		<!-- 分页 -->
		<nav class="center">
		<p>共${page.totalPageNumber }页 当前:第${page.pageNo }页</p>
		<ul class="pagination  pagination-lg">
			<li><a
				href="${pageContext.request.contextPath}/getbooks?pagenumber=1"
				aria-label="Previous"> <span aria-hidden="true">首页</span></a></li>
			<li class="active"><a
				href="${pageContext.request.contextPath}/getbooks?pagenumber=1">1</a></li>
			<li><a
				href="${pageContext.request.contextPath}/getbooks?pagenumber=2">2</a></li>
			<li><a
				href="${pageContext.request.contextPath}/getbooks?pagenumber=3">3</a></li>
			<li><a
				href="${pageContext.request.contextPath}/getbooks?pagenumber=4">4</a></li>
			<li><a
				href="${pageContext.request.contextPath}/getbooks?pagenumber=${page.totalPageNumber}"
				aria-label="Next"> <span aria-hidden="true">末页</span>
			</a></li>
		</ul>
		</nav>
	</div>
	<c:if test="${Cart!=null}">
		<a class=" shoppingcart"
			href="<%=request.getContextPath() %>/CartServlet?method=getCartInfo&pagenumber=${page.pageNo }">查看购物车</a>
	</c:if>
	<a id="scrollUp" href="#top"
		style="position: fixed; z-index: 2147483647; display: block;"><i
		class="fa fa-angle-up"></i></a>
	<!--footer-->
	<div class="navbar navbar-default navbar-static-bottom">版权声明区</div>
</body>
<script type="text/javascript">
	
</script>
<!-- 
<script type="text/javascript">
	$(function() {
		//让所有的a标签带上查询条件
		$('.pagination a').click(function() {
			var priceStr = $(":hidden").serialize();
			var hrefStr = this.href + "&" + priceStr;
			window.location.href = hrefStr;
			return false;
			
		})
		
	})
</script>
 -->
</html>
<%--
	<li ><a href="${pageContext.request.contextPath}/getbooks?pagenumber=1" aria-label="Previous"> <span aria-hidden="true">首页</span></a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/getbooks?pagenumber=1">1</a></li>
			<li><a href="${pageContext.request.contextPath}/getbooks?pagenumber=2">2</a></li>
			<li><a href="${pageContext.request.contextPath}/getbooks?pagenumber=3">3</a></li>
			<li><a href="${pageContext.request.contextPath}/getbooks?pagenumber=4">4</a></li>
			<li><a href="${pageContext.request.contextPath}/getbooks?pagenumber=${page.totalPageNumber}"aria-label="Next"> <span aria-hidden="true">末页</span>
			</a></li>
 --%>
