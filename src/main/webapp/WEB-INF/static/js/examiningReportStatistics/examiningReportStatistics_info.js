var id = "";
$(function(){
	id = request.QueryString("id");
	if(ifNull(id)){
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
	param.id = id;
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
         url: "/getExaminingReportDetail.json",
         data: d,
         success: function(data){
        	 //填充table
        	 var list = data;
        	 var str = '';
        	 if(ifNull(list)){
        		 str = '<div style=" padding:20px 0; background-color:#ffffff; text-align:center;">暂无数据</div>';
        		 $("#order2-content").html(str);
        	 }else{
        		//填充表头
//        		setBt(data);
//        		 alert(data.antiThunderList);
        		 
        		$("#weituodanwei").val(isNull(data.weituodanwei));
        		$("#dizhi").val(isNull(data.dizhi));
        		$("#youbian").val(isNull(data.youbian));
        		$("#lianxidianhua").val(isNull(data.lianxidianhua));
        		$("#lianxiren").val(isNull(data.lianxiren));
        		$("#tianqiqingkuang").val(isNull(data.tianqiqingkuang));
        		$("#dimianzhuangkuang").val(isNull(data.dimianzhuangkuang));
        		$("#jianceyiqi").val(isNull(data.jianceyiqi));
        		$("#jianceriqi").val(isNull(data.jianceriqi));
        		$("#jianceyiju").val(isNull(data.jianceyiju));
        		$("#cunzaiwenti").val(isNull(data.cunzaiwenti));
        		$("#jiancejielun").val(isNull(data.jiancejielun));
        		$("#youxiaoqiStart").html(isNull(data.youxiaoqiStart));
        		$("#youxiaoqiEnd").html(isNull(data.youxiaoqiEnd));
        		$("#jianceren").val(isNull(data.jianceren));
        		$("#jiaohe").val(isNull(data.jiaohe));
        		$("#pizhunren").val(isNull(data.pizhunren));
        		
        	 }
        	 //分页
//        	 pageinit("pageLimit",data,getData);//pageLimit:放置分页div的id值     data:异步返回的数据    getData:回调函数
         }
     });
}