<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 商品详情</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/myfunction.js"></script>
<script type="text/javascript" src="js/jquery.min.js" ></script>
</head>
<body onload="reserve()">
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
			<!--<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>-->
		</ul>
	</div>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl class="nav_left_1">
				<dt>图书音像</dt>
				<!--<dd><a href="product-list.html">图书</a></dd>-->
			</dl>
			<dl class="nav_left_2">
				<dt>百货</dt>
				<!--<dd><a href="product-list.html">运动健康</a></dd>-->
			</dl>
		</div>
	</div>
	<div id="product" class="main">
		<h1>${requestScope.goods.goodsName }</h1>
		<div class="infos">
			<div class="thumb"><img src="${requestScope.goods.goodsImg}" style="width: 100px;height: 100px" /></div>
			<div class="buy">
				<p>商城价：<span class="price">${requestScope.goods.goodsPrice }</span></p>
				<p>折扣：${requestScope.goods.isDiscount *10} 折</p>
				<div class="button"><input type="button" name="button" value="" onclick="toPay()" />
				<a href="javascript:void(0);" onclick="toBuy()">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${requestScope.goods.goodsContent }<br />
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
var U_NAME;
	
//加载
$(function() {
	getlogin();//获取登陆信息
	getnav();//获取栏目
})	
	
//把对象存入浏览记录
function reserve() {
	var goodsobj = {};
	goodsobj.goodsName = '${requestScope.goods.goodsName }';
	goodsobj.goodsImg = '${requestScope.goods.goodsImg }';
	goodsobj.goodsId = '${requestScope.goods.goodsId }';
	var browse = JSON.parse(sessionStorage.getItem("browse"));
	//判断是否第一次存入
	if(browse == null) {
		browse = new Array();
	}
	//判断数组中是否存在该对象
	for(var i=0;i<browse.length;i++){
		var row = browse[i];
		if(goodsobj.goodsId===row.goodsId){//数组中存在
			browse.splice(i,1);
		}
	}
	browse.unshift(goodsobj);
	//判断数组大小 最大为5 超过就去掉最后一位
	if(browse.length>5){
		browse.pop();
	}
	sessionStorage.setItem("browse", JSON.stringify(browse));
}


//检查登录情况
function cheak(){
	var user = sessionStorage.getItem("User");
	if(user == null) {
		alert("请先登录！");
		location.href="login.html";
	}else{
		let name = JSON.parse(user).userName;
		U_NAME = name;
	}
}

//将物品放入购物车
function toBuy(){
	cheak();
	
	var goodsobj = {};
	goodsobj.goodsId = '${requestScope.goods.goodsId }';
	goodsobj.goodsName = '${requestScope.goods.goodsName }';
	goodsobj.goodsImg = '${requestScope.goods.goodsImg }';
	goodsobj.goodsPrice = '${requestScope.goods.goodsPrice }';
	goodsobj.goodsnumber = 1;
	var customer = JSON.parse(getCookie(U_NAME));
	//判断是否第一次存入
	if(customer == null || customer.length===0) {
		customer = new Array();
		customer.unshift(goodsobj);
	}else{
		//判断数组中是否存在该对象
		for(var i=0;i<customer.length;i++){
			var row = customer[i];
			if(goodsobj.goodsId===row.goodsId){//数组中存在
				row.goodsnumber=row.goodsnumber +1;
			}else{
				customer.unshift(goodsobj);
				break;
			}
		}
	}
	
	
	setCookie(U_NAME,JSON.stringify(customer));
	//delCookie('thecookie');
}

//立即购买
function toPay(){
	cheak();
	var goodsobj = {};
	goodsobj.goodsId = '${requestScope.goods.goodsId }';
	goodsobj.goodsName = '${requestScope.goods.goodsName }';
	goodsobj.goodsImg = '${requestScope.goods.goodsImg }';
	goodsobj.goodsPrice = '${requestScope.goods.goodsPrice }';
	goodsobj.goodsnumber = 1;
	var customer = JSON.parse(getCookie(U_NAME));
	//判断是否第一次存入
	if(customer == null || customer.length==0) {
		customer = new Array();
		customer.unshift(goodsobj);
	}else{
		//判断数组中是否存在该对象
		for(var i=0;i<customer.length;i++){
			var row = customer[i];
			if(goodsobj.goodsId==row.goodsId){//数组中存在
				row.goodsnumber=row.goodsnumber +1;
			}else{
				customer.unshift(goodsobj);
				break;
			}
		}
	}
	setCookie(U_NAME,JSON.stringify(customer));
	location.href="shopping.html";
}

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

</script>
</html>