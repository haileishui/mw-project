var uid = "";
$(function(){
	uid = request.QueryString("uid");
	if(ifNull(uid)){
		layer.alert("请求参数为空，请返回重新操作",{"title":"提示"});
	}else{
		//获取数据
		getData();
	}
});
/**
 * 获取查询参数
 * id：id
 * **/
function getParam(){
	var param = {};
	param.uid = uid;
	return param;
}
/**
 * 获取数据
 * 信息回显
 * pageNumber：第几页
 * pageSize：一页几条数据
 * **/
function getData(){
	 var d = getParam();
	 ajax({
         url: "/getUsersInfoById.json",
         data: d,
         success: function(data){
        	 //填充table
        	 var list = data.dataList;
        	 var str = '';
//        	 if(ifNull(list)||!list.length){
//        		 str = '<div style=" padding:20px 0; background-color:#ffffff; text-align:center;">暂无数据</div>';
//        		 $("#order2-content").html(str);
//        	 }else{
        		 //填充input value 值
        	 	$("#uid").val(isNull(data.uid));
        		$("#name").val(isNull(data.name));
         		$("#userName").val(isNull(data.userName));
         		$("#password").val(isNull(data.password));
         		$("#status").val(isNull(data.status));
         		$("#phone").val(isNull(data.phone));
         		$("#company").val(isNull(data.company));
//        	 }
        	 //分页
//        	 pageinit("pageLimit",data,getData);//pageLimit:放置分页div的id值     data:异步返回的数据    getData:回调函数
         }
     });
}

function update(){
	var d = {};
	d.uid = $("#uid").val();
	d.name = $("#name").val();
	d.userName = $("#userName").val();
	d.password = $("#password").val();
	d.status = $("#status").val();
	d.phone = $("#phone").val();
	d.company = $("#company").val();
	 ajax({
         url: "/updateUsersInfo.json",
         data: d,
         success: function(data){
        	 layer.alert(data.resultMsg,{'title':"提示"},function(){
        		 history.back();
        	 });
         }
     });
	//addUsersInfo.json
}