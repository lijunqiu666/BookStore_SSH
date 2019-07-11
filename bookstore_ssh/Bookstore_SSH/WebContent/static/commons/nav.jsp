
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
				<li><a href="<%=request.getContextPath()%>/getbooks">首页 <span
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
				<li><a
					href="${pageContext.request.contextPath}/ManagerServlet?method=ToManagerLoginPage">后台</a>
				</li>
				<li>
				<li><a
					href="${pageContext.request.contextPath}/getcartinfo?pagenumber=${page.pageNo }">
						<img
						src="${pageContext.request.contextPath}/static/imgs/new_car.png">购物车
						<c:if test="${Cart.bookNumber>0}">
							<span class="badge">${Cart.bookNumber}</span>
						</c:if>
				</a></li>
				<c:if test="${User==null}">
				<li><a href="${pageContext.request.contextPath}/tologin"">登入</a></li>
				</c:if>
				<li><a href="${pageContext.request.contextPath}/toregitster">注册</a></li>
				<c:if test="${User!=null} ">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">个人中心<span
						class="caret"></span></a>
				</c:if>
				
				<c:if test="${User!=null}">
					<!-- 个人中心 -->
				<li><a href="${pageContext.request.contextPath}/logout"">注销</a></li>
					<li class="dropdown"><a
						href="<%=request.getContextPath() %>/gethistory">
							<img width=25 src="${pageContext.request.contextPath}/static/imgs/head.jpg"
							alt="..." class="img-circle"> <span class="caret"></span>
					</a></li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>