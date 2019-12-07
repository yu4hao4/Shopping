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
<script type="text/javascript" src="../js/jquery.min.js" ></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li class="current"><a href="user.html">用户</a></li>
			<li><a href="product.html">商品</a></li>
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
				<dd><em><a href="nav-add.html">新增</a></em><a href="nav.html">分类管理</a></dd>
				<dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.html">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form action="manage-result" onsubmit="return toVaild()">
				<table class="form">
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" id="userName" class="text" name="userName" readonly="readonly" value="${requestScope.userView.userName }"/></td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text" class="text" name="name" value="${requestScope.userView.personName }"/></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" id="passWord" class="text" name="passWord" value="${requestScope.userView.passWord }" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><c:choose>
							<c:when test="${requestScope.userView.sex ==true}">
							<input type="radio" name="sex" value="1" checked="checked"/>男
							<input type="radio" name="sex" value="0" />女
							</c:when>
							<c:otherwise>
							<input type="radio" name="sex" value="1">男
      						<input type="radio" name="sex" checked="checked" value="0">女
      						</c:otherwise>
						</c:choose></td>
							
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<select name="sel1" id="sel1">
       							<option>1998</option>
   							</select>
							<select name="sel2" id="sel2">
    							<option>06</option>
    						</select>
							<select name="sel3" id="sel3">
   								<option>22</option>
   							</select>
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value="${requestScope.userView.telphone }" /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address" value="${requestScope.userView.location }" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
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
	var d = '${requestScope.userView.birthday }';
	var d_date={};
	d_date.year=d.split('-')[0];
	d_date.month=d.split('-')[1];
	d_date.day=d.split('-')[2];
	
	//生成日期
	$(function() {
		//生成1900年-2100年
		for(var i = 1900; i <= 2100; i++) {
			var option = document.createElement('option');
			option.setAttribute('value', i);
			if(i==d_date.year){
				option.setAttribute('selected','selected')
			}
			option.innerHTML = i;
			sel1.appendChild(option);
		}
		//生成1月-12月
		for(var i = 1; i <= 12; i++) {
			var option = document.createElement('option');
			option.setAttribute('value', i);
			if(i==d_date.month){
				option.setAttribute('selected','selected')
			}
			option.innerHTML = i;
			sel2.appendChild(option);
		}
		//生成1日—31日
		for(var i = 1; i <= 31; i++) {
			var option = document.createElement('option');
			option.setAttribute('value', i);
			if(i==d_date.day){
				option.setAttribute('selected','selected')
			}
			option.innerHTML = i;
			sel3.appendChild(option);
		}
	})

	//获取当前年月日
	function getDate(){
		var myDate = new Date;
		var year = myDate.getFullYear();//获取当前年
		var yue = myDate.getMonth()+1;//获取当前月
		var day = myDate.getDate();//获取当前日
		var date = year+"-"+yue+"-"+day
		return date;
	}

	//问候语
	greet();

</script>
</html>