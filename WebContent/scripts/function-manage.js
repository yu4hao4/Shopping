// JavaScript Document

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
function greet(){
	var time = getDate();
	var target = $("#welcomegreet");
	var str='管理员您好，今天是'+time+'，欢迎回到管理后台。';
	target.append(str);
}

//用户表单验证
function toVaild(){
	var userName = $('#userName').val().trim();
	var passWord =$('#passWord').val().trim();
	if(userName == null || userName=="") {
		alert("用户名不得为空！");
		return false;
	}
	if(passWord == null || passWord=="") {
		alert("密码不得为空！");
		return false;
	}
}

//栏目表单验证
function toVaild_nav(){
	var userName = $('#className').val().trim();
	if(userName == null || userName=="") {
		alert("栏目名不得为空！");
		return false;
	}
}

//新闻表单验证
function toVaild_news(){
	var userName = $('#newsTitle').val().trim();
	if(userName == null || userName=="") {
		alert("新闻标题不得为空！");
		return false;
	}
}

//留言表单验证
function toVaild_guest(){
	var userName = $('#replyContent').val().trim();
	if(userName == null || userName=="") {
		alert("回复内容不得为空！");
		return false;
	}
}

//商品表单验证
function toVaild_pro(){
	var productName = $('#productName').val().trim();
	var productPrice = $('#productPrice').val().trim();
	var isDiscount = $('#isDiscount').val().trim();
	if(productName == null || productName=="") {
		alert("商品名不得为空！");
		return false;
	}else if(productPrice == null || productPrice==""){
		alert("商品价格不得为空！");
		return false;
	}else if(isDiscount == null || isDiscount==""){
		alert("折扣力度不得为空！");
		return false;
	}
}

