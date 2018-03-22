$(function(){
	getData();
	//点击查询
	$("#submit").on("click",function(){
		getData();//pageNumber重置为1
	});
});
/**
 * 获取查询参数
 * id：id
 * pageNumber：第几页
 * pageSize：一页几条数据
 * **/
function getParam(pageNumber,pageSize){
	var param = {};
	param.userName = $.trim($("#userName").val());
	param.company = $.trim($("#company").val());
	param.status = $.trim($("#status").val());
	param.name = $.trim($("#name").val());
	param.pageNumber = pageNumber?pageNumber:1;
	param.pageSize = pageSize?pageSize:10;
	return param;
}
/**
 * 获取数据
 * pageNumber：第几页
 * pageSize：一页几条数据
 * **/
function getData(pageNumber,pageSize){
	 //loading start
	 var loading = '<tr><td colspan="7" class="loadingimg"><img src="/static/img/loading.gif" /></td></tr>';
	 $("#table-list").html(loading);
	 //loading end
	 var d = getParam(pageNumber,pageSize);
	 ajax({
         url: "/getUsersInfo.json",
         data: d,
         success: function(data){
        	 //填充table
        	 var list = data.dataList;
        	 var str = '';
        	 if(ifNull(list)||!list.length){
        		 str = '<tr><td colspan="7" style="text-align:center">暂无数据</td></tr>';
        	 }else{
	        	 $.each(list,function(i,item){
	        		 str += '<tr>'+
			                     '<td>'+isNull(item.uid)+'</td>'+
			                     '<td>'+isNull(item.name)+'</td>'+
			                     '<td>'+isNull(item.userName)+'</td>'+
			                     '<td>'+(ifNull(userStatusJsonMap[isNull(item.status)])?isNull(item.status):userStatusJsonMap[isNull(item.status)])+'</td>'+
			                     '<td>'+isNull(item.phone)+'</td>'+
			                     '<td>'+isNull(companyJsonMap[item.company])+'</td>'+
			                     '<td class="user"><span onclick="userSee('+item.uid+')">查看</span><span onclick="userChange('+item.uid+')">修改</span><span onclick="userDel('+item.uid+')">删除</span></td>'+
	                     '</tr>';
	        	 });
        	 }
        	 $("#table-list").html(str);
        	 //分页
        	 pageinit("pageLimit",data,getData);//pageLimit:放置分页div的id值     data:异步返回的数据    getData:回调函数
         }
     });
}
/**
 * 功能查看
 **/
function userSee(id){
	/***do***/
	location.href = "user_info.html?uid="+id;
}
/**
 * 功能修改
 **/
function userChange(id){
	/***do***/
	location.href = "user_change.html?uid="+id;
}
/**
 * 删除功能
 **/
function userDel(id){
	layer.confirm('确认要删除吗？', {
        btn : [ '确定', '取消' ]//按钮
    }, function(index) {
    	layer.close(index);
    	var d = {};
		d.uid = id;
		 ajax({
	        url: "/deleteUsersInfo.json",
	        data: d,
	        success: function(data){
	        	 layer.alert(data.resultMsg,{'title':"提示"},function(index1){
	        		 getData();
	        		 layer.close(index1);
	        	 });
	        }
	    });
    }); 
}

function userPrint(id){
	/***do***/
	window.open("user_print.html?uid="+id);
}