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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$(":text").change(function(){
		var value=$(this).val();
		var id=$(this).attr("name");
		var url="updateitem";
		var title=$(this).attr("title");
		var args={"id":id,"number":value,"time":new Date()};
		var flag=confirm("是否要修改<<"+title+">>的数量");
		
		$.post(url,args,function(data){
			var bookNumber=data.bookNumber;
			var totalMoney=data.totalMoney;
			$('.booknumber').text(bookNumber +"件商品 ");
			$('.totalmoney').html(totalMoney+"元");
		},"json");
	});
})
</script>
<body>
<jsp:include page="/WEB-INF/views/commons/nav.jsp"></jsp:include>
<!--content-->
<div class="container" style="margin-top:100px;">

<c:if test="${Cart.bookNumber==0}">
	<div class="container text-center">
	<h2 class="text-center">购物车为空
	</h2>
	<br>
	<br>
	<a class="btn btn-success " href="<%=request.getContextPath()%>/getbooks">返回购物</a>	
	</div>
</c:if>
<c:if test="${Cart.bookNumber!=0}">
    <div class="row thumbnail center">
        <div class="col-sm-12">
            <h1 class="text-center" style="margin-bottom: 30px">购物车</h1>
        </div>
        <div class=" list-group">
            <div class="col-sm-12 thumbnail">
                <div class="col-sm-2 line-center">图书</div>
                <div class="col-sm-2 line-center">书名</div>
                <div class="col-sm-2 line-center">单价</div>
                <div class="col-sm-2 line-center">作者</div>
                <div class="col-sm-2 line-center">数量 </div>
                <div class="col-sm-2 line-center">操作</div>
            </div>
			<c:forEach items="${Cart.books}" var="item">
            <div class="col-sm-12  list-group-item">
                <div class="col-sm-3 line-center" style="width: 150px;height: 50px;">
                    <img src="/file2/${item.value.book.imgpath }" style="height: 100%;" alt=""/>
                </div>
                <div class="col-sm-2 line-center">${item.value.book.title }</div>
                <div class="col-sm-2 line-center">${item.value.book.price}</div>
                <div class="col-sm-2 line-center">${item.value.book.author }</div>
                <div class="col-sm-2 line-center">
                    <input type="text" title="${item.value.book.title }" name="${item.value.book.id }" class="small" value="${item.value.quantity }"/>
                </div>
                <div class="col-sm-2 line-center">
             
                	<a class="btn btn-danger" href="<%=request.getContextPath()%>/deleteitem?id=${item.value.book.id }">删除</a>
                	
                </div>
            </div>
            </c:forEach>
            <div class="col-sm-12 thumbnail">
                <div class=" col-sm-offset-4 col-sm-2 text-right">总数：</div>
                <div class="col-sm-2 booknumber">${Cart.bookNumber}件商品</div>
                <div class="col-sm-2 text-right ">总价：</div>
                <div class="col-sm-2 totalmoney" >${Cart.totalMoney}元</div>
            </div>
        </div>
        <div class="col-sm-offset-7 col-sm-5" style="padding: 30px;">
        	<a class="btn btn-primary"  href="${pageContext.request.contextPath}/gotopaycash">结算购物车</a>
          	<a class="btn btn-primary" href="${pageContext.request.contextPath}/getbooks?pagenumber=${param.pagenumber}&minprice=${param.minprice}&maxprice=${param.maxprice}">继续购物</a>
          	<a class="btn btn-primary" href="${pageContext.request.contextPath}/cleancart">清空购物车</a>
        </div>
    </div>
</c:if>
</div>
<!--footer-->
<div class="navbar navbar-default navbar-fixed-bottom">
    版权声明区${Cart.bookNumber}
</div>
</body>
</html>
