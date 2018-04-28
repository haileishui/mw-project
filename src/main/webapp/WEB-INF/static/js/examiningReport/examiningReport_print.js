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
 * **/
function getData(){
	//回显以后写上不可编辑代码
	$("input,textarea").attr("disabled","disabled");
	//end
	 var d = getParam();
	 ajax({
         url: "/getExaminingReportDetail",
         data: d,
         success: function(data){
    		//填充input value 值
        	 $("#baogaobianhao").html(isNull(data.baogaobianhao));
//        	 $("#title").html(isNull(data.title));
        	 $("#id").html(isNull(data.id));
    		 $("#weituodanwei").html(isNull(data.weituodanwei));
    		 $("#weituodanwei1").html(isNull(data.weituodanwei));
    		 $("#fangleileibie").html(isNull(data.fangleileibie));
    		 $("#jiancexingzhi").html(isNull(data.jiancexingzhi));
    		 $("#jiancedanwei").html(isNull(data.jiancedanwei));
     		 $("#dizhi").html(isNull(data.dizhi));
     		 $("#youbian").html(isNull(data.youbian));
     		 $("#lianxidianhua").html(isNull(data.lianxidianhua));
     		 $("#lianxiren").html(isNull(data.lianxiren));
     		 $("#tianqiqingkuang").html(isNull(data.tianqiqingkuang));
     		 $("#dimianzhuangkuang").html(isNull(data.dimianzhuangkuang));
     		 $("#jianceyiqi").html(isNull(data.jianceyiqi));
     		 $("#jianceriqi").html(isNull(data.jianceriqi));
     		 $("#jianceyiju").html(isNull(data.jianceyiju));
     		 $("#cunzaiwenti").html(isNull(data.cunzaiwenti));
     		 $("#jiancejielun").html(isNull(data.jiancejielun));
     		 $("#youxiaoqiStart").html(data.youxiaoqiStart.replace('-', '年').replace('-', '月')+'日');
     		 $("#youxiaoqiEnd").html(data.youxiaoqiEnd.replace('-', '年').replace('-', '月')+'日');
//     		 $("#jianceren").html(isNull(data.jianceren));
     		 $("#jiaohe").html(isNull(data.jiaohe));
//     		 $("#pizhunren").html(isNull(data.pizhunren));
     		 $("#yearMonth").html(data.jianceriqi.replace('-', '年').replace('-', '月')+'日');
     		$("#jianzhuwuleibie").val(isNull(data.jianzhuwuleibie));
     		 // 第一个table
     		 if(!data.monitoringPointList&&!data.monitoringPointList.length){
//     			$("#fzjl-table").html("");
     			for (var i = 0; i < 22; i++) {
					 var str = '';
    				 if(i == 0){
    					 str += '<tr style="height:30px;" ><td colspan="16" style=";">本页以下空白</td>'
    				 }else{
    					 str += '<tr style="height:30px;" ><td></td>'+
    						'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'<td></td>'+
                 			'</tr>';
    				 }
        			 $("#fzjl-table").append(str);
				}
     		 }else{
     			 $.each(data.monitoringPointList,function(i,item){
     				 var str = '';
     				 str += '<tr><td>'+ifNullValue(item.jiancedianmingchen)+'</td>'+
               			'<td>'+ifNullValue(item.jiashegaodu)+'</td>'+
              			'<td>'+ifNullValue(item.xingzhuang)+'</td>'+
              			'<td>'+ifNullValue(item.cailiao)+'</td>'+
              			'<td>'+ifNullValue(item.yunxuzhi)+'</td>'+
              			'<td>'+ifNullValue(item.shicezhi)+'</td>'+
              			'<td>'+ifNullValue(item.cailiao2)+'</td>'+
              			'<td>'+ifNullValue(item.fushefangshi)+'</td>'+
              			'<td>'+ifNullValue(item.jianju)+'</td>'+
              			'<td>'+ifNullValue(item.yunxuzhi2)+'</td>'+
              			'<td>'+ifNullValue(item.shicezhi2)+'</td>'+
              			'<td>'+ifNullValue(item.yunxuzhi3)+'</td>'+
              			'<td>'+ifNullValue(item.shicezhi3)+'</td>'+
              			'<td>'+ifNullValue(item.jielun)+'</td>'+
              			'<td>'+ifNullValue(item.beizhu)+'</td>'+
              			'</tr>';
         			 $("#fzjl-table").append(str);
     			 });
				 for (var i = 0; i < (22-data.monitoringPointList.length); i++) {
					 var str = '';
     				 if(i == 0){
     					 str += '<tr style="height:30px;" ><td colspan="16" style=";">本页以下空白</td>'
     				 }else{
     					 str += '<tr style="height:30px;" ><td></td>'+
     						'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'<td></td>'+
                  			'</tr>';
     				 }
     				
         			 $("#fzjl-table").append(str);
				}
     		 }
     		 // 第二个table
     		 if(!data.antiThunderList&&!data.antiThunderList.length){
//     			$("#fldgy-table").html("");
     			for (var i = 0; i < 22; i++) {
					 var str = '';
					 if(i == 0){
     					 str += '<tr style="height:30px;" ><td colspan="8" style=";">本页以下空白</td>'
     				 }else{
	     				 str += '<tr style="height:30px;" ><td></td>'+
	               			'<td></td>'+
	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
	              			'<td></td>'+
	              			'<td></td>'+
	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
	              			'<td></td>'+
	              			'<td></td>'+
	              			'<td></td>'+
	              			'</tr>';
     				 }
					 $("#fldgy-table").append(str);
				}
     		 }else{
     			 $.each(data.antiThunderList,function(i,item){
     				 var str = '';
     				 str += '<tr><td>'+ifNullValue(item.jiancedianmingcheng)+'</td>'+
			           			'<td>'+ifNullValue(item.jinshuwumingcheng)+'</td>'+
//			          			'<td>'+ifNullValue(item.waiguanjiancha)+'</td>'+
//			          			'<td>'+ifNullValue(item.lianjiedaoticailiaoheguige)+'</td>'+
//			          			'<td>'+ifNullValue(item.yunxuzhi)+'</td>'+
//			          			'<td>'+ifNullValue(item.shicezhi)+'</td>'+
			          			'<td>'+ifNullValue(item.yunxuzhi2)+'</td>'+
			          			'<td>'+ifNullValue(item.shicezhi2)+'</td>'+
			          			'<td>'+ifNullValue(item.changjinshuwumingcheng)+'</td>'+
//			          			'<td>'+ifNullValue(item.kuajiezhuangkuang)+'</td>'+
//			          			'<td>'+ifNullValue(item.kuajiedaoticailiaoheguige)+'</td>'+
//			          			'<td>'+ifNullValue(item.yunxuzhi3)+'</td>'+
//			          			'<td>'+ifNullValue(item.shicezhi3)+'</td>'+
			          			'<td>'+ifNullValue(item.yunxuzhi4)+'</td>'+
			          			'<td>'+ifNullValue(item.shicezhi4)+'</td>'+
			          			'<td>'+ifNullValue(item.jielun)+'</td>'+
			          			'<td>'+ifNullValue(item.beizhu)+'</td>'+
			                	'</tr>';
         			 $("#fldgy-table").append(str);
     			 });
     			 for (var i = 0; i < (22-data.antiThunderList.length ); i++) {
					 var str = '';
					 if(i == 0){
     					 str += '<tr style="height:30px;" ><td colspan="8" style=";">本页以下空白</td>'
     				 }else{
	     				 str += '<tr style="height:30px;" ><td></td>'+
	               			'<td></td>'+
	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
	              			'<td></td>'+
	              			'<td></td>'+
	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
//	              			'<td></td>'+
	              			'<td></td>'+
	              			'<td></td>'+
	              			'<td></td>'+
	              			'</tr>';
     				 }
					 $("#fldgy-table").append(str);
				}
     		 }
     		 // 第三个table
     		 if(!data.powerSupplyList&&!data.powerSupplyList.length){
//     			$("#dyspdjc-table").html("");
     			for (var i = 0; i < 22; i++) {
					 var str = '';
					 if(i == 0){
    					 str += '<tr style="height:30px;" ><td colspan="6" style=";">本页以下空白</td>'
    				 }else{
    					 str += '<tr style="height:30px;" ><td></td>'+
    					 '<td></td>'+
    					 '<td></td>'+
    					 '<td></td>'+
//    					 '<td></td>'+
//    					 '<td></td>'+
//    					 '<td></td>'+
//    					 '<td></td>'+
//    					 '<td></td>'+
//    					 '<td></td>'+
//    					 '<td></td>'+
//    					 '<td></td>'+
//    					 '<td></td>'+
    					 '<td></td>'+
    					 '<td></td>'+
    					 '<td></td>'+
    					 '</tr>';
    				 }
        			 $("#dyspdjc-table").append(str);
				}
     		 }else{
     			 $.each(data.powerSupplyList,function(i,item){
     				 var str = '';
     				 str += '<tr><td>'+ifNullValue(item.jiancedianbianhao)+'</td>'+
			           			'<td>'+ifNullValue(item.anzhuangweizhi)+'</td>'+
			          			'<td>'+ifNullValue(item.chanpinxinghao)+'</td>'+
//			          			'<td>'+ifNullValue(item.changdu)+'</td>'+
//			          			'<td>'+ifNullValue(item.yunxuzhi)+'</td>'+
//			          			'<td>'+ifNullValue(item.shicezhi)+'</td>'+
//			          			'<td>'+ifNullValue(item.sebiao)+'</td>'+
//			          			'<td>'+ifNullValue(item.cailiao)+'</td>'+
//			          			'<td>'+ifNullValue(item.yunxuzhi2)+'</td>'+
//			          			'<td>'+ifNullValue(item.shicezhi2)+'</td>'+
//			          			'<td>'+ifNullValue(item.yunxuzhi3)+'</td>'+
//			          			'<td>'+ifNullValue(item.shicezhi3)+'</td>'+
			          			'<td>'+ifNullValue(item.yunxuzhi4)+'</td>'+
			          			'<td>'+ifNullValue(item.shicezhi4)+'</td>'+
			          			'<td>'+ifNullValue(item.jielun)+'</td>'+
			          			'<td>'+ifNullValue(item.beizhu)+'</td>'+
			                	'</tr>';
         			 $("#dyspdjc-table").append(str);
     			 });
     			 for (var i = 0; i < (22-data.powerSupplyList.length); i++) {
					 var str = '';
					 if(i == 0){
     					 str += '<tr style="height:30px;" ><td colspan="6" style=";">本页以下空白</td>'
     				 }else{
     					 str += '<tr style="height:30px;" ><td></td>'+
     					 '<td></td>'+
     					 '<td></td>'+
     					 '<td></td>'+
//     					 '<td></td>'+
//     					 '<td></td>'+
//     					 '<td></td>'+
//     					 '<td></td>'+
//     					 '<td></td>'+
//     					 '<td></td>'+
//     					 '<td></td>'+
//     					 '<td></td>'+
//     					 '<td></td>'+
     					 '<td></td>'+
     					 '<td></td>'+
     					 '<td></td>'+
     					 '</tr>';
     				 }
         			 $("#dyspdjc-table").append(str);
				}
     		 }
    	 }
     });
}
function ifNullValue(value){
	if(value == null || value == '' || value =='undefined'){
		return "/"
	}
	return value;
	
}
