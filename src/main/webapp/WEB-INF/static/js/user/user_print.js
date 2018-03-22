var id = "";
$(function(){
	id = request.QueryString("id");
	if(ifNull(id)){
//		layer.alert("请求参数为空，请返回重新操作",{"title":"提示"});
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
	param.id = id;
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
         url: "/",
         data: d,
         success: function(data){
        	 //填充table
        	 var list = data.dataList;
        	 var str = '';
        	 if(ifNull(list)||!list.length){
        		 str = '<div style=" padding:20px 0; background-color:#ffffff; text-align:center;">暂无数据</div>';
        		 $("#order2-content").html(str);
        	 }else{
        		 
        	 }
         }
     });
}