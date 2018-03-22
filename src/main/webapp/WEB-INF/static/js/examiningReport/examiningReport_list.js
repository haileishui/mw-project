$(function(){
	getData();
	//判断表单是否有信息如果有则加载一下数据
	setHistoryList();
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
	param.id = $.trim($("#id").val());
	param.weituodanwei = $.trim($("#weituodanwei").val());
	param.jianceren = $.trim($("#jianceren").val());
	param.jianceriqiStart = $.trim($("#jianceriqiStart").val());
	param.jianceriqiEnd = $.trim($("#jianceriqiEnd").val());
	param.baogaobianhao = $.trim($("#baogaobianhao").val());
	param.title = $.trim($("#title").val());
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
	 var loading = '<tr><td colspan="19" class="loadingimg"><img src="/static/img/loading.gif" /></td></tr>';
	 $("#table-list").html(loading);
	 //loading end
	 var d = getParam(pageNumber,pageSize);
	 ajax({
         url: "/getExaminingReportList.json",
         data: d,
         success: function(data){
        	 //填充table
        	 var list = data.dataList;
        	 var str = '';
        	 if(ifNull(list)||!list.length){
        		 str = '<tr><td colspan="19" style="text-align:center">暂无数据</td></tr>';
        	 }else{
	        	 $.each(list,function(i,item){
	        		 str += '<tr>'+
			                     '<td>'+isNull(item.id)+'</td>'+
			                     '<td>'+isNull(item.baogaobianhao)+'</td>'+
			                     '<td>'+isNull(item.weituodanwei)+'</td>'+
			                     '<td>'+isNull(item.dizhi)+'</td>'+
			                     '<td>'+isNull(item.youbian)+'</td>'+
			                     '<td>'+isNull(item.lianxidianhua)+'</td>'+
			                     '<td>'+isNull(item.lianxiren)+'</td>'+
			                     '<td>'+isNull(item.tianqiqingkuang)+'</td>'+
			                     '<td>'+isNull(item.dimianzhuangkuang)+'</td>'+
			                     '<td>'+isNull(item.jianceyiqi)+'</td>'+
			                     '<td>'+isNull(item.jianceriqi)+'</td>'+
//			                     '<td>'+isNull(item.jianceyiju)+'</td>'+
//			                     '<td>'+isNull(item.cunzaiwenti)+'</td>'+
//			                     '<td>'+isNull(item.jiancejielun)+'</td>'+
			                     '<td>'+isNull(item.youxiaoqiStart)+'</td>'+
			                     '<td>'+isNull(item.youxiaoqiEnd)+'</td>'+
			                     '<td>'+isNull(item.jianceren)+'</td>'+
			                     '<td>'+isNull(item.jiaohe)+'</td>'+
			                     '<td>'+isNull(item.pizhunren)+'</td>'+
			                     '<td>'+isNull(item.jiancejine)+'</td>'+
			                     '<td>'+isNull(companyJsonMap[item.title])+'</td>'+
			                     '<td class="user"><span onclick="userSee('+item.id+')">查看</span><span onclick="userChange('+item.id+')">修改</span><span onclick="userDel('+item.id+')">删除</span><span onclick="userPrint('+item.id+')">打印预览</span></td>'+
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
	location.href = "examiningReport_info.html?id="+id;
}
/**
 * 功能修改
 **/
function userChange(id){
	/***do***/
	location.href = "examiningReport_change.html?id="+id;
}
/**
 * 删除功能
 **/
function userDel(id){
	/***do***/
	layer.confirm('确认要删除吗？', {
        btn : [ '确定', '取消' ]//按钮
    }, function(index) {
//    	layer.close(index);
    	var d = {};
		d.id = id;
		 ajax({
	        url: "/deleteExaminingReport.json",
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
/**
 * 删除功能
 **/
function userPrint(id){
	/***do***/
	window.open("examiningReport_print.html?id="+id);
}
function statisticsPrint(){
	var url = "examiningReportStatistics_print.html?weituodanwei="+$.trim($("#weituodanwei").val());
	if(!ifNull($.trim($("#jianceren").val()))){
		url+="&jianceren="+$.trim($("#jianceren").val());
	}
	if(!ifNull($.trim($("#jianceriqiStart").val()))){
		url+="&jianceriqiStart="+$.trim($("#jianceriqiStart").val());
	}
	if(!ifNull($.trim($("#jianceriqiEnd").val()))){
		url+="&jianceriqiEnd="+$.trim($("#jianceriqiEnd").val());
	}
	if(!ifNull($.trim($("#baogaobianhao").val()))){
		url+="&baogaobianhao="+$.trim($("#baogaobianhao").val());
	}
	if(!ifNull($.trim($("#title").val()))){
		url+="&title="+$.trim($("#title").val());
	}
	if(!ifNull($.trim($("#jiancejine").val()))){
		url+="&jiancejine="+$.trim($("#jiancejine").val());
	}
	window.open(url);
}