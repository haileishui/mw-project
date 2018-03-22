var username = getCookieValueByName("xsyUsername");
var code = request.QueryString("code");
/**
 * 判断用户是否登录 如果登录且username不为空则跳转到首页
 * **/
checkLogin();
function checkLogin(){
	//如果用户名cookie不为空则判断是否登录
	if(!ifNull(username)){
		//异步请求一下是否登录  如果登录则跳转到首页
		$.ajax({
			url:'/doLogin.json',  
			data:{},    
			type:'post', 
			cache:false, 
			dataType:'text',
			success:function(d) {  
				var data = text2json(d);
				if(data.isSuccess){
					//用户登录跳转到首页
					location.href = "/static/index.html";
				}
			 },     
			error : function(data, status, e) {   
			}  
	 	});
	}
}
/**
 * 登录接口
 * username：用户名
 * password：密码
 * **/
//$("#submit").on("click",function(){
//	doLogin();
//});
function doLogin(){
	var username = $.trim($("#username").val());
	var password = $.trim($("#password").val());
	if(ifNull(username)){
		layer.alert('请输入用户名',{'title':"提示"});
		return false;
	}
	if(ifNull(password)){
		layer.alert('请输入密码',{'title':"提示"});
		return false;
	}
	ajax({
		url : '/doLogin.json',
		data : { 
			username:username,
			password:password
		},
		loading:true,
		success : function(data) {
			//登录成功
			loginSuccess(data);
		}
	});
	return false;
}
/**
 * 设置用户名cookie  并跳转到首页
 * **/
function loginSuccess(data){
	setCookie("xsyUsername", data.userName);
	setCookie("xsyName", data.name);
	location.href = "/static/index.html";
}