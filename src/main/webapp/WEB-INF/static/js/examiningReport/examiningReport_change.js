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
 * **/
function getParam(){
	var param = {};
	param.id = id;
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
         url: "/getExaminingReportDetail.json",
         data: d,
         success: function(data){
    		 //填充input value 值
        	 $("#id").val(isNull(data.id));
    		 $("#weituodanwei").val(isNull(data.weituodanwei));
    		 $("#fangleileibie").val(isNull(data.fangleileibie));
    		 $("#jiancexingzhi").val(isNull(data.jiancexingzhi));
    		 $("#jiancedanwei").val(isNull(data.jiancedanwei));
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
     		 $("#youxiaoqiStart").val(data.youxiaoqiStart);
     		 $("#youxiaoqiEnd").val(data.youxiaoqiEnd);
     		 $("#jianceren").val(isNull(data.jianceren));
     		 $("#jiaohe").val(isNull(data.jiaohe));
     		 $("#pizhunren").val(isNull(data.pizhunren));
     		 $("#jianzhuwuleibie").val(isNull(data.jianzhuwuleibie));
     		 $("#jiancejine").val(isNull(data.jiancejine));
         	 // 第一个table
     		 if(!data.monitoringPointList&&!data.monitoringPointList.length){
     			$("#fzjl-table").html("");
     		 }else{
     			 $.each(data.monitoringPointList,function(i,item){
     				 var str = '';
     				 str += '<tr><td><input type="text" class="form-control input-sm" value="'+item.jiancedianmingchen+'" /></td>'+
               			'<td><input type="text" class="form-control input-sm" value="'+item.jiashegaodu+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.xingzhuang+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.cailiao+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.cailiao2+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.fushefangshi+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.jianju+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi2+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi2+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi3+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi3+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.jielun+'" /></td>'+
              			'<td><input type="text" class="form-control input-sm" value="'+item.beizhu+'" /></td>'+
              			'<td>'+
                        ' 	<button type="button" class="btn btn-primary btn-sm" onclick="listDel(this)">'+
                        '         <i class="glyphicon glyphicon-minus"></i> 移除'+
                        '     </button>'+
                        '</td></tr>';
         			 $("#fzjl-table").append(str);
     			 });
     		 }
     		 // 第二个table
     		 if(!data.antiThunderList&&!data.antiThunderList.length){
     			$("#fldgy-table").html("");
     		 }else{
     			 $.each(data.antiThunderList,function(i,item){
     				 var str = '';
     				 str += '<tr><td><input type="text" class="form-control input-sm" value="'+item.jiancedianmingcheng+'" /></td>'+
			           			'<td><input type="text" class="form-control input-sm" value="'+item.jinshuwumingcheng+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.waiguanjiancha+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.lianjiedaoticailiaoheguige+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi2+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi2+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.changjinshuwumingcheng+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.kuajiezhuangkuang+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.kuajiedaoticailiaoheguige+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi3+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi3+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi4+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi4+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.jielun+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.beizhu+'" /></td>'+
			                	'<td><button type="button" class="btn btn-primary btn-sm" onclick="listDel(this)">'+
			                    '<i class="glyphicon glyphicon-minus"></i> 移除'+
			                    '</button></td></tr>';
         			 $("#fldgy-table").append(str);
     			 });
     		 }
     		 // 第三个table
     		 if(!data.powerSupplyList&&!data.powerSupplyList.length){
     			$("#dyspdjc-table").html("");
     		 }else{
     			 $.each(data.powerSupplyList,function(i,item){
     				 var str = '';
     				 str += '<tr><td><input type="text" class="form-control input-sm" value="'+item.jiancedianbianhao+'" /></td>'+
			           			'<td><input type="text" class="form-control input-sm" value="'+item.anzhuangweizhi+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.chanpinxinghao+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.changdu+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.sebiao+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.cailiao+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi2+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi2+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi3+'" /></td>'+
//			          			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi3+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.yunxuzhi4+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.shicezhi4+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.jielun+'" /></td>'+
			          			'<td><input type="text" class="form-control input-sm" value="'+item.beizhu+'" /></td>'+
			                	'<td><button type="button" class="btn btn-primary btn-sm" onclick="listDel(this)">'+
			                    '<i class="glyphicon glyphicon-minus"></i> 移除'+
			                    '</button></td></tr>';
         			 $("#dyspdjc-table").append(str);
     			 });
     		 }
     		 
         }
     });
}