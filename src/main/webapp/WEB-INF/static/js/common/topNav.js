/*右侧栏顶部用户名称*/
var name = getCookieValueByName("xsyName");
var xsyUsername = getCookieValueByName("xsyUsername");
$("#xsy-username").html(name);
if(xsyUsername=="admin"){
	$(".admin-see").css("display","block");
}
/**
 * 判断用户是否登录 如果没有登录则跳转到登录页面
 * **/
checkLogin();
function checkLogin(){
	//如果用户名cookie为空则重新登录
	if(ifNull(xsyUsername)){
		logoutSuccess();
		return;
	}
	//如果用户名cookie不为空则异步请求一下是否登录
	$.ajax({
		url:'/doLogin.json',  
		data:{},    
		type:'post', 
		cache:false, 
		dataType:'text',
		success:function(d) { 
			var data = text2json(d);
			if(!data.isSuccess){
				//用户未登录则退出退出
				logoutSuccess();
			}
		 },     
		error : function(data, status, e) {   
		}  
 	}); 
}
/**
 * 退出接口
 * 
 **/
$("#logout").on("click",function(){
	ajax({
		url : '/logout.json',
		data : {
		},
		success : function(data) {
			//退出成功
			logoutSuccess(data);
		}
	});
});
/**
 * 删除用户名cookie  并跳转到登录页面
 * **/
function logoutSuccess(){
	DelCookie("xsyUsername");
	DelCookie("xsyName");
	location.href = "/";
}