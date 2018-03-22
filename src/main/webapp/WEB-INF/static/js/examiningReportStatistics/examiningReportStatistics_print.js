//var id = "";
var param = {};
$(function(){
//	id = request.QueryString("id");
//	if(ifNull(id)){
//		layer.alert("请求参数为空，请返回重新操作",{"title":"提示"});
//	}else{
		//获取数据
		getData();
//	}
});
/**
 * 获取查询参数
 * id：id
 * **/
function getParam(){
	
	param.weituodanwei = request.QueryString("weituodanwei"); 
	param.jianceren = request.QueryString("jianceren");
	param.jianceriqiStart =request.QueryString("jianceriqiStart"); 
	param.jianceriqiEnd = request.QueryString("jianceriqiEnd");
	param.baogaobianhao = request.QueryString("baogaobianhao");
	param.title =request.QueryString("title");
	param.jiancejine =request.QueryString("jiancejine");
	return param;
}
/**
 * 获取数据
 * 信息回显
 * **/
function getData(){
	//回显以后写上不可编辑代码
	$("input,textarea").attr("disabled","disabled");
	//end
	 var d = getParam();
	 ajax({
         url: "/getExaminingReportPrintList",
         data: d,
         success: function(data){
        	 //填充table
        	 var list = data.jsonArray;
        	 var str = '';
        	 if(ifNull(list)||!list.length){
        		 str = '<div style=" padding:20px 0; background-color:#ffffff; text-align:center;">暂无数据</div>';
        		 $("#order2-content").html(str);
        	 }else{
        		 $.each(list,function(i,item){
	        		 str += '<tr>'+
			                     '<td>'+ (i+1) +'</td>'+
			                     '<td>'+isNull(item.baogaobianhao)+'</td>'+
			                     '<td>'+isNull(item.weituodanwei)+'</td>'+
			                     '<td>'+isNull(item.lianxiren)+'</td>'+
			                     '<td>'+isNull(item.lianxidianhua)+'</td>'+
			                     '<td>'+isNull(item.jianceren)+'</td>'+
			                     '<td>'+isNull(item.jiancejine)+'</td>'+
//			                     '<td></td>'+
			                     '<td>'+isNull(item.jianceriqi)+'</td>'+
			                     '<td>'+isNull(item.youxiaoqiEnd)+'</td>'+
//			                     '<td></td>'+
			                     '<td></td>'+
	                     '</tr>';
	        	 });
        		 $("#fzjl-table").append(str);
        	 }
         }
     });
}