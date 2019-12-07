<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li><a href="user.html">用户</a></li>
			<li><a href="product.html">商品</a></li>
			<li class="current"><a href="guestbook.html">留言</a></li>
			<li><a href="news.html">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap" id="welcomegreet">
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.html">新增</a></em><a href="user.html">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="productClass-add.html">新增</a></em><a href="productClass.html">分类管理</a></dd>
				<dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.html">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>回复留言</h2>
		<div class="manage">
			<form action="manage-result" onsubmit="return toVaild_guest()">
				<table class="form">
					<input name="id" value="${requestScope.guestView.guestId }" hidden="hidden">
					<tr>
						<td class="field">留言ID：</td>
						<td><input type="text" class="text" name="orderId" value="${requestScope.guestView.guestId }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">留言姓名：</td>
						<td><input type="text" class="text" name="name" value="${requestScope.guestView.userName }" readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="field">留言内容：</td>
						<td><textarea readonly="readonly">${requestScope.guestView.guestContent }</textarea></td>
					</tr>
					<tr>
						<td class="field">回复内容：</td>
						<td><textarea id="replyContent" name="replyContent"></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="留言更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 安博教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>