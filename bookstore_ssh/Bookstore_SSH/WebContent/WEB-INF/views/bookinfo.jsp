<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>
.row {
	margin-left: 20px;
	margin-top:70px;
	margin-right: 20px;
}
.center {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 导航栏 -->
	<jsp:include page="/WEB-INF/views/commons/nav.jsp"></jsp:include>
	<div class="row thumbnail">
		<div class="col-sm-4">
			<img style="display: block;" src="/file2/${book.imgpath}"
				data-holder-rendered="true">
			<div class="caption center">
				<h3>书名:${book.title }</h3>
				<p>作者:${book.author }</p>
				<p>价格:${book.price }</p>
				<p>出版日期:${book.publishingDate }</p>
				<p>
					<a class="btn btn-primary btn-block" role="button"
						href="${pageContext.request.contextPath}/addtocart?id=${book.id }&pagenumber=${page.pageNo}"><span class="glyphicon glyphicon-shopping-cart"></span>加入购物车</a>
					<a class="btn btn-default btn-block" role="button"
						href="${pageContext.request.contextPath}/getbooks?pagenumber=${param.pagenumber}&pagenumber=${param.pagenumber}&minprice=${param.minprice}&keyWord=${param.keyWord}">返回首页</a>
				</p>
			</div>
		</div>
		<div class="col-sm-8">
			<div class="caption">
				<h3>图书介绍</h3>
				<blockquote>
	            <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus.</p>
	            <small>Steve Jobs, CEO Apple</small>
	          </blockquote>
				<p >一.功能分析: A.用户: 1.查看图书 >>点击图书查看购物车 >>带条件(minprice-maxprice)分页查询
					>>对图书进行分页 2.将图书放入购物车:(把图书放在session中,不进行持久化) 3.查看购物车 4.修改购物车
					>>删除购物车中的单个购物项 >>清空购物车 >>修改购物车中购物项的数量 5.结账 >>用户填写用户名和信用卡号 6.查看交易记录
					B.管理员: 1.管理图书:a>删除图书,b>添加图书,c>删除图书,d>分页查找图书,f>上传图书 二 . 总体架构
					MVC设计模式: M----->:model:(pojo)java实体类
					V------>view:(jsp+el表达式+jstl)显示层 C-------> Controller(Servlet)控制器
					三.使用的知识点 数据库：MySQL 数据源：C3P0</p>
				<p>
					还珠格格》是一部改编自琼瑶同名小说的古装清宫喜剧，由孙树培导演、琼瑶亲自担任编剧，赵薇、林心如、苏有朋、周杰、陈志朋、张铁林、范冰冰等联合主演。 [1] 
					该剧讲述了乾隆之女紫薇到北京城与失散多年的父亲相认。在走投无路之际遇上女飞贼小燕子，并结为姐妹。小燕子为她想办法混入宫，但在阴差阳错中与紫薇互换了身份，成为清宫中的“还珠格格”并深受乾隆宠爱的故事。 [2]  该剧于1998年4月28日在台湾中视首播；10月28日引进内地播出后最高收视突破62.8%，创造中国电视剧有数据统计后的收视纪录。 [3]  
				并获得第17届中国电视金鹰奖最佳连续剧奖，女主角赵薇获得最佳女演员奖。
				</p>
			</div>

		</div>

	</div>
	<div class="navbar navbar-default navbar-static-bottom">
		<div class="container-fluid" style="padding:50px 100px;">
			<!--footer-->
			<small>
			版权声明区 本网站（网站地址）刊载的所有内容，包括文字、图片、音频、视频、软件、程序、以及网页版式设计等均在网上搜集。
			访问者可将本网站提供的内容或服务用于个人学习、研究或欣赏，以及其他非商业性或非盈利性用途，但同时应遵守著作权法及其他相关法律的规定，不得侵犯本网站及相关权利人的合法权利。除此以外，将本网站任何内容或服务用于其他用途时，须征得本网站及相关权利人的书面许可，并支付报酬。
			本网站内容原作者如不愿意在本网站刊登内容，请及时通知本站，予以删除。
			</small>

		</div>

	</div>
</body>
</html>