<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 新闻</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/myfunction.js"></script>
<script type="text/javascript" src="js/jquery.min.js" ></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">
	</div>
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
	<div class="left-side">
		<div class="news-list">
			<h4>最新公告</h4>
			<ul class="notice">
			</ul>
		</div>
		<div class="spacer"></div>
		<div class="news-list">
			<h4>新闻动态</h4>
			<ul class="news">
			</ul>
		</div>
	</div>
	<div id="news" class="right-main">
		<h1>${requestScope.news.newsTitle }</h1>
		<h5>${requestScope.news.timeCreated }</h5>
		<div class="content">
		${requestScope.news.newsContent }
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
	getnews();//获取新闻
	getnotice();//获取公告
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
</script>
</html>