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
// * pageNumber：第几页
// * pageSize：一页几条数据
 * **/
function getParam(pageNumber,pageSize){
	var param = {};
	param.uid = uid;
//	param.pageNumber = pageNumber?pageNumber:1;
//	param.pageSize = pageSize?pageSize:10;
	return param;
}
/**
 * 获取数据
 * pageNumber：第几页
 * pageSize：一页几条数据
 * **/
function getData(pageNumber,pageSize){
	 var d = getParam(pageNumber,pageSize);
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
        		//填充表头
//        		setBt(data);
        			$("#name").val(isNull(data.name));
            		$("#userName").val(isNull(data.userName));
            		$("#password").val(isNull(data.password));
            		$("#status").val(isNull(data.status));
            		$("#phone").val(isNull(data.phone));
            		$("#company").val(isNull(data.company));
            		$("input").attr("disabled","disabled");
            		$("select").attr("disabled","disabled");
//        	 }
        	 //分页
//        	 pageinit("pageLimit",data,getData);//pageLimit:放置分页div的id值     data:异步返回的数据    getData:回调函数
         }
     });
}