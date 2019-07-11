	$(function() {
		$(".pagination>li").click(function() {
			$(".row").empty();
			$('.pagination>li').removeClass('active');
			$(this).addClass("active");
			var priceStr = $(":hidden").serialize();
			var url="getpage";
			var args={"pagenumber":$(this).index(),"date":new Date()};
			$.get(url,args,function(page){
				//将之前row中的内容移除
				buidProducts(page.list);
			})
			return false;
		})
		//构建商品列表
		function buidProducts(list) {
			for (var i = 0; i < list.length; i++) {
				CreateBooks(list[i]);
			}
		}
		//creatbooks
		function CreateBooks(book) {
			var item = $('<div class="col-sm-6 col-md-3 item">'
					+ '<div class="thumbnail">'
					+ '<img class="img-rounded" src="/file2/'+book.imgpath+'" class="img-thumbnail">'
					+ '<div class="caption">'
					+ ' <h4>'
					+ ' <a class="booktitle" title="查看'+book.title+'的详细信息"' +
            ' href="">'+book.title+''
					+ ' </a>'
					+ '  </h4>'
					+ ' <p class="bookinfo">'
					+ ' <span class="author">作者:'+book.author+'</span><br> <span class="price">价格:<strong' +
            '  class="bookprice">￥'+book.price+'元&nbsp;&nbsp;&nbsp;'
					+ ' <span class="label label-danger">包邮</span>'
					+ '</strong></span><br> <span class="publishtime">发行时间:'+book.publishingDate+'</span><br>'
					+ ' <span class="saleamount">月销量:'+book.salesAmount+'笔</span><br>'
					+ '  <span class="storenumber">库存:'+book.storeNumber+'条</span><br>'
					+ ' <span class="remark">评论:'+book.remark+'条</span><br> <a class="btn btn-block btn-lg btn-primary"' +
            '   role="button"' +
            ' href="${pageContext.request.contextPath}/getbookinfo?id='+book.id+'&pagenumber=${page.pageNo }">查看详情</a>'
					+ '  </div>' + '</div>' + '</div>')
			$('.row').append(item);

		}
	})