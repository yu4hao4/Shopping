<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 全部商品</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/myfunction.js"></script>
<script type="text/javascript" src="js/jquery.min.js" ></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.html">首页</a></li>
			<li class="nav_1"><a href="javascript:void(0);"  id="1"  onclick="bignav(this.id)">图书</a></li>
			<li class="nav_2"><a href="javascript:void(0);"  id="2"  onclick="bignav(this.id)">百货</a></li>
			<li class="nav_3"><a href="javascript:void(0);"  id="3"  onclick="bignav(this.id)">家居</a></li>
			<li class="nav_4"><a href="javascript:void(0);"  id="4"  onclick="bignav(this.id)">食物</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix" id="nav">
		</ul>
	</div>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl class="nav_left_1">
				<dt>图书音像</dt>
			</dl>
			<dl class="nav_left_2">
				<dt>百货</dt>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix" id="scan">
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="clear"></div>
			<ul class="product clearfix" id="goodslist">
				<!--<li>
					<dl>
						<dt><a href="product-view.html" target="_blank"><img src="images/product/1.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html" target="_blank">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dd class="price">￥108.0</dd>
					</dl>
				</li>-->
				<c:forEach items="${requestScope.goodslist}"  var="goods" varStatus="status">
				<li>
					<dl>
						<dt><a href="goodsView?id=${goods.goodsId}" target="_blank"><img src="${goods.goodsImg}" /></a></dt>
						<dd class="title"><a href="goodsView?id=${goods.goodsId}" target="_blank">${goods.goodsName}</a></dd>
						<dd class="price">${goods.goodsPrice}</dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix" id="goodsPager">
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 安博教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
<script>
//加载
$(function() {
	getlogin();//获取登陆信息
	getnav();//获取栏目
})

//获得商品页数
$(function() {
	var target=$('#goodsPager');
	var yeshu = ${requestScope.yeshu};
	 if(yeshu==1){
			return;
	} 
		for(var i=1;i<=yeshu;i++){
			var str='<li><a href="javascript:find('+i+')">'+
			i+'</a></li>';
			target.append(str);
		}
})

//从session中取出最近浏览的5个商品
	$(function() {
		var browse = JSON.parse(sessionStorage.getItem("browse"));
		if(browse!=null){
			for(var row of browse){
				var target = $('#scan');
				var str = '<dt><img src="'+
				row.goodsImg+'" style="width: 54px; height: 54px;"/></dt><dd><a href="goodsView?id='+
				row.goodsId+'">'+
				row.goodsName+'</a></dd>';
				target.append(str);
			}
		}
		})
	
	//一级标题查找二级标签 一级标签：图书/百货/家居/食物
function bignav(id) {
	var target = $("#nav");
	//清空二级标签
	target.html("");
	$(".current").removeClass('current');
	var nav_big = '.nav_' + id;
	$(nav_big).addClass('current');
	var req = {};
	req.id = id;
	$.ajax({
		type: "get",
		url: "navFind",
		data: req,
		dataType: 'json',
		success: function(resp) {
			for(var row of resp) {
				//上侧
				var str = '<li><a href="goods-list?name=' +
					row.navName + '">' +
					row.navName + '</a></li>';
				target.append(str);
			}
		}
	});
}

function find(yeshu){
	var req={};
		req.yeshu=yeshu;
		$.ajax({
				type:"get",
				url:"guestList",
				data:req,
				dataType:'json',
				success:function(resp){
					window.location.reload();
					}
			});	
}
</script>
</html>