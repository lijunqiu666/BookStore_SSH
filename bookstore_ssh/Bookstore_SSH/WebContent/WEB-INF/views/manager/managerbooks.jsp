<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>管理书籍</title>
</head>
<style>
.bookmanager {
	margin-top: 20px;
}
.navigation{background-color:#ccc !important;}
</style>

<script type="text/javascript">
	$(function() {
		//编辑图书
		$(".edit").click(function() {
			var url =this.href;
			var id = $(this).attr("bookid");
			var pagenumber = $(this).attr("pagenumber");
			var args = {
				"id" : id,
				"time" : new Date().getTime(),
				"pagenumber" : pagenumber
			};
			$.get(url, args, function(book) {
				//$(".modal-body").html(book.title);
				$(".editform").find("input[name=id]").val(book.id);
				$(".editform").find("input[name=title]").val(book.title);
				$(".editform").find("input[name=author]").val(book.author);
				$(".editform").find("input[name=storeNumber]").val(book.storeNumber);
				$(".editform").find("input[name=price]").val(book.price);
				$("#myModal").modal("show");
			}, "json")
		return false;
		})
		
		//删除操作
		$(".delete").click(function() {
			var title = $(this).attr("booktitle");
			var $this = this;
			var flag = confirm("你是否要删除" + title)
			if (flag) {
				var bookid = $(this).attr("bookid");
				var url =this.href;
				var pagenumber = $(this).attr("pagenumber");
				var args = {
					"id" : bookid,
					"time" : new Date().getTime(),
					"pagenumber" : pagenumber
				};
				$.get(url, args, function(data) {
					if(data==1){
					$('#DeleteSuccess').find("h4").html(title+",删除成功!")
					$('#DeleteSuccess').modal('show');
					$this.parentNode.parentNode.remove();						
					}else{
					alert("删除失败!");
					}
				})
			}
		return false;
		})

	})
</script>
<body>
	<%--
	href="<%=request.getContextPath()%>/ManagerServlet?method=deletebooks&id=${book.id }&pagenumber=${page.pageNo }"
	href="<%=request.getContextPath()%>/ManagerServlet?method=editbooks&id=${book.id }&pagenumber=${page.pageNo }"
	 --%>
	<nav class="navbar navbar-inverse navbar-embossed  navbar-static-top">
	<div class="container">
		<ul class="nav navbar-nav">
			<li ><a href="<%=request.getContextPath() %>/manager/backtocenter">首页 <span class="sr-only">(current)</span></a></li>
			<li class="active"><a
				href="<%=request.getContextPath()%>/manager/tomanagerbooks">图书管理</a></li>
			<li><a href="<%=request.getContextPath()%>/manager/tomanagerusers">用户管理</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"class="glyphicon glyphicon-user">${Manager.mgrName}</a></li>
			<li><a href="<%=request.getContextPath()%>/manager/dologout"class="glyphicon glyphicon-off">退出</a></li>
		</ul>
		
	</div>
	</nav>
	<!-- 更更新图书的模态框 -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改图书信息</h4>
				</div>
				<div class="modal-body">
					<form class="editform"
						action="<%=request.getContextPath()%>/manager/doupdatebook?pagenumber=${page.pageNo }"
						method="post">
						<input name="id" type="hidden" value="${book.id }">
						<div class="form-group">
							<label for="exampleInputEmail1">书名</label> <input type=""
								class="form-control" name="title" value=""
								id="exampleInputEmail1" placeholder="title">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">作者</label> <input
								name="author" class="form-control" id="exampleInputPassword1"
								placeholder="Password">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">库存</label> <input
								name="storeNumber" class="form-control"
								id="exampleInputPassword1" placeholder="storeNumber">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">价格</label> <input name="price"
								class="form-control" id="exampleInputPassword1"
								placeholder="price">
						</div>
						<div class="form-group">
							<label for="exampleInputFile">图片</label> <input type="file"
								id="exampleInputFile">
							<p class="help-block">Example block-level help text here.</p>
						</div>
						
						<div class="modal-footer">
							<button type="submit" class="btn btn-success updatebook">更新</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除的模态框 -->
	<div class="modal fade" id="DeleteSuccess" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Modal title</h4>
				</div>
				<div class="modal-body">
					<p>One fine body&hellip;</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- 图书管理列表部分 -->
	<div class="container-fluid bookmanager">
		<div class="row">
			<div class="col-xs-12 col-md-3">
				<form action="<%=request.getContextPath()%>/manager/doaddbook?pagenumber=${page.pageNo }" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label>书名:</label> <input type="text" name="title"
							class="form-control" placeholder="书名">
					</div>
					<div class="form-group">
						<label>作者:</label> <input type="text" name="author"
							class="form-control" placeholder="作者">
					</div>
					<div class="form-group">
						<label>库存:</label> <input type="text" name="storeNumber"
							class="form-control" placeholder="库存">
					</div>
					<div class="form-group">
						<label>单价:</label> <input type="text" name="price"
							class="form-control" placeholder="单价">
					</div>
					<div class="form-group">
						<input type="file" name="file" id="exampleInputFile">
						<p class="help-block">Example block-level help text here.</p>
					</div>

					<button type="submit" class="btn btn-success">添加图书</button>
				</form>
			</div>
			<div class="col-xs-6 col-md-9">
				<table class="table table-condensed table-hover" style="font-size: 14px;">
					<tr>
						<td>书号</td>
						<td>书名</td>
						<td>作者</td>
						<td>发行时间</td>
						<td>价格</td>
						<td>销量</td>
						<td>库存</td>
						<td>评论数</td>
						<td>删除</td>
						<td>修改</td>
					</tr>
					<c:forEach items="${page.list }" var="book">
						<tr>
							<td>${book.id }</td>
							<td>${book.title }</td>
							<td>${book.author }</td>
							<td>${book.publishingDate }</td>
							<td><span>${book.price }</span></td>
							<td>${book.salesAmount }</td>
							<td>${book.storeNumber }</td>
							<td>${book.remark }</td>
							<td><a href="<%=request.getContextPath() %>/manager/dodeletebook"
								class="btn btn-danger btn-sm glyphicon glyphicon-trash delete"
								bookid="${book.id }" booktitle=${book.title }
								pagenumber="${page.pageNo }">删除</a></td>
							<td><a href="<%=request.getContextPath() %>/manager/editbook" class="edit btn-success btn-sm glyphicon glyphicon-pencil"  bookid="${book.id}" pagenumber="${page.pageNo }">编辑</a></td>
						</tr>
					</c:forEach>
				</table>

				<nav aria-label="Page navigation"> 共${page.totalPageNumber }页
				当前:第${page.pageNo }页
				<ul class="pagination  pagination-lg">
					<li><a
						href="${pageContext.request.contextPath}/manager/tomanagerbooks?pagenumber=1"
						aria-label="Previous"> <span aria-hidden="true">首页</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/manager/tomanagerbooks?pagenumber=1">1</a></li>
					<li><a
						href="${pageContext.request.contextPath}/manager/tomanagerbooks?pagenumber=2">2</a></li>
					<li><a
						href="${pageContext.request.contextPath}/manager/tomanagerbooks?pagenumber=3">3</a></li>
					<li><a
						href="${pageContext.request.contextPath}/manager/tomanagerbooks?pagenumber=4">4</a></li>
					<li><a
						href="${pageContext.request.contextPath}/manager/tomanagerbooks?pagenumber=${page.totalPageNumber}"
						aria-label="Next"> <span aria-hidden="true">末页</span>
					</a></li>
				</ul>
				</nav>
			</div>
		</div>

	</div>


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
	<script type="text/javascript">
		window.onload = function() {
			$('.pagination>li').click(function() {
				$(this).addClass("active");
			})
		}
	</script>
</body>
</html>