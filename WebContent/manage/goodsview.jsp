<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<script type="text/javascript" src="../js/jquery.min.js" ></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li><a href="user.html">用户</a></li>
			<li class="current"><a href="product.html">商品</a></li>
			<li><a href="guestbook.html">留言</a></li>
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
		<h2>修改商品</h2>
		<div class="manage">
			<form action="manage-result" method="get" onsubmit="return toVaild_pro()">
				<table class="form">
					<input name="id" value="${requestScope.goods.goodsId }" hidden="hidden" />
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" id="productName" class="text" name="productName" value="${requestScope.goods.goodsName }" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId" id="parentId">
								<option value="音乐">音乐</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" id="productPrice" class="text tiny" name="productPrice" value="${requestScope.goods.goodsPrice }"/> 元</td>
					</tr>
					<tr>
						<td class="field">商品内容：</td>
						<td><input type="text" class="text" name="productContent" value="${requestScope.goods.goodsContent }"/></td>
					</tr>
					<tr>
						<td class="field">折扣：</td>
						<td><input type="text" id="isDiscount" class="text tiny" name="isDiscount" value="${requestScope.goods.isDiscount }"/></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="商品修改" /></label></td>
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
<script>
	greet();
//获取栏目
$(function() {
	var target=$('#navList');
	var nownav = '${requestScope.goods.goodsType }';
	$.ajax({
		type: 'get',
		url: 'navList_M',
		dataType: 'json',
		success: function(resp) {
				for(var i = 1; i < resp.length; i++) {
					var row = resp[i];
					var option = document.createElement('option');
					option.setAttribute('value', row.navName);
					var rownav = row.navName;
					if(rownav==nownav){
						option.setAttribute('selected','selected')
					}
					option.innerHTML = row.navName;
					parentId.appendChild(option);
				}
		}
	});
})
</script>
</html>