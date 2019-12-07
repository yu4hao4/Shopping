//登陆信息
function getlogin() {
	var user = sessionStorage.getItem("User");
	if(user == null) {
		var target = $('.help');
		var str = '<a href="shopping.html" class="shopping">购物车</a>' +
			'<a href="login.html">登录</a>' +
			'<a href="register.html">注册</a>' +
			'<a href="guestbook.html">留言</a>';
		target.append(str);
	} else {
		var name = JSON.parse(user).userName;
		var target = $('.help');
		var str = '<a href="shopping.html" class="shopping">购物车</a><lable>' +
			name + '</lable><button onclick="out()">登出</button>' +
			'<a href="guestbook.html">留言</a>';
		target.append(str);
	}
}

//获取栏目
function getnav() {
	var target = $("#nav");
	$.ajax({
		type: "get",
		url: "navList",
		dataType: 'json',
		success: function(resp) {
			for(var row of resp) {
				//上侧
				var str = '<li><a href="goods-list?name=' +
					row.navName + '">' +
					row.navName + '</a></li>';
				target.append(str);
				//左侧
				var navid = row.isBelong;
				if(navid == 1) {
					var target1 = $(".nav_left_1");
					var str1 = '<dd><a href="goods-list?name=' +
						row.navName + '">' +
						row.navName + '</a></dd>';
					target1.append(str1);
				} else if(navid == 2) {
					var target1 = $(".nav_left_2");
					var str1 = '<dd><a href="goods-list?name=' +
						row.navName + '">' +
						row.navName + '</a></dd>';
					target1.append(str1);
				}
			}
		}
	});
}

//获取新闻
function getnews() {
	var target = $(".news-list .news");
	$.ajax({
		type: "get",
		url: "newsList",
		dataType: 'json',
		success: function(resp) {
			for(var row of resp) {
				var str = '<li><a href="news-view?id=' +
					row.newsId + '" target="_blank">' +
					row.newsTitle + '</a></li>';
				target.append(str);
			}
		}
	});
}

//获取公告
function getnotice() {
	var target = $(".news-list .notice");
	$.ajax({
		type: "get",
		url: "noticeList",
		dataType: 'json',
		success: function(resp) {
			for(var row of resp) {
				var str = '<li><a href="notice-view?id=' +
					row.noticeId + '" target="_blank">' +
					row.noticeTitle + '</a></li>';
				target.append(str);
			}
		}
	});
}

//登出
function out() {
	$.ajax({
		type: "get",
		url: "Logout",
		dataType: 'json',
		success: function(resp) {
			if(resp.hasOwnProperty("result")) {
				sessionStorage.removeItem("User");
				window.location.reload();
			}
		}
	});
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