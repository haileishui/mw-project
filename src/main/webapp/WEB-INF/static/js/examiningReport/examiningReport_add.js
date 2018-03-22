/**
 * 保存数据
 * 增加和修改保存  添加行删除行代码一样所以引入一个js examiningReport_add.js
 **/
function add(type){
	/***do***/
//	insertExaminingReport.json
	var insertExaminingReport = {};
	insertExaminingReport.weituodanwei = $("#weituodanwei").val();
	insertExaminingReport.fangleileibie = $("#fangleileibie").val();
	insertExaminingReport.jiancexingzhi = $("#jiancexingzhi").val();
	insertExaminingReport.jiancedanwei = $("#jiancedanwei").val();
	insertExaminingReport.dizhi = $("#dizhi").val();
	insertExaminingReport.youbian = $("#youbian").val();
	insertExaminingReport.lianxidianhua = $("#lianxidianhua").val();
	insertExaminingReport.lianxiren = $("#lianxiren").val();
	insertExaminingReport.tianqiqingkuang = $("#tianqiqingkuang").val();
	insertExaminingReport.dimianzhuangkuang = $("#dimianzhuangkuang").val();
	insertExaminingReport.jianceyiqi = $("#jianceyiqi").val();
	insertExaminingReport.jianceriqi = $("#jianceriqi").val();
	insertExaminingReport.jianceyiju = $("#jianceyiju").val();
	insertExaminingReport.cunzaiwenti = $("#cunzaiwenti").val();
	insertExaminingReport.jiancejielun = $("#jiancejielun").val();
	insertExaminingReport.youxiaoqiStart = $("#youxiaoqiStart").val();
	insertExaminingReport.youxiaoqiEnd = $("#youxiaoqiEnd").val();
	insertExaminingReport.jianceren = $("#jianceren").val();
	insertExaminingReport.jiaohe = $("#jiaohe").val();
	insertExaminingReport.pizhunren = $("#pizhunren").val();
	insertExaminingReport.jianzhuwuleibie = $("#jianzhuwuleibie").val();
	insertExaminingReport.jiancejine = $("#jiancejine").val();
	//防 直 击 雷
	var monitoringPointList = '[';
	if($("#fzjl-table tr").length){
		var l = 0;
		$.each($("#fzjl-table tr"),function(i,item){
			var s = 0;
			$.each($(item).find("input"),function(j,jtem){
				if(!ifNull($(jtem).val())){
					s++;
				}
			});
			if(s>0){
				if(l>0){
					monitoringPointList += ',';
				}
				monitoringPointList += '{"jiancedianmingchen":"'+$(item).find("input").eq(0).val();
				monitoringPointList += '","jiashegaodu":"'+$(item).find("input").eq(1).val();
				monitoringPointList += '","xingzhuang":"'+$(item).find("input").eq(2).val();
				monitoringPointList += '","cailiao":"'+$(item).find("input").eq(3).val();
				monitoringPointList += '","yunxuzhi":"'+$(item).find("input").eq(4).val();
				monitoringPointList += '","shicezhi":"'+$(item).find("input").eq(5).val();
				monitoringPointList += '","cailiao2":"'+$(item).find("input").eq(6).val();
				monitoringPointList += '","fushefangshi":"'+$(item).find("input").eq(7).val();
				monitoringPointList += '","jianju":"'+$(item).find("input").eq(8).val();
				monitoringPointList += '","yunxuzhi2":"'+$(item).find("input").eq(9).val();
				monitoringPointList += '","shicezhi2":"'+$(item).find("input").eq(10).val();
				monitoringPointList += '","yunxuzhi3":"'+$(item).find("input").eq(11).val();
				monitoringPointList += '","shicezhi3":"'+$(item).find("input").eq(12).val();
				monitoringPointList += '","jielun":"'+$(item).find("input").eq(13).val();
				monitoringPointList += '","beizhu":"'+$(item).find("input").eq(14).val()+'"}';
				l++;
			}
		});
	}
	monitoringPointList += ']';
//	monitoringPointList = JSON.parse(monitoringPointList);
	insertExaminingReport.monitoringPointJson = monitoringPointList;
	//防雷电感应、防雷电波侵入
	var antiThunderList = '[';
	if($("#fldgy-table tr").length){
		var l = 0;
		$.each($("#fldgy-table tr"),function(i,item){
			var s = 0;
			$.each($(item).find("input"),function(j,jtem){
				if(!ifNull($(jtem).val())){
					s++;
				}
			});
			if(s>0){
				if(l>0){
					antiThunderList += ',';
				}
				antiThunderList += '{"jiancedianmingcheng":"'+$(item).find("input").eq(0).val();
				antiThunderList += '","jinshuwumingcheng":"'+$(item).find("input").eq(1).val();
//				antiThunderList += '","waiguanjiancha":"'+$(item).find("input").eq(2).val();
//				antiThunderList += '","lianjiedaoticailiaoheguige":"'+$(item).find("input").eq(3).val();
//				antiThunderList += '","yunxuzhi":"'+$(item).find("input").eq(4).val();
//				antiThunderList += '","shicezhi":"'+$(item).find("input").eq(5).val();
				antiThunderList += '","yunxuzhi2":"'+$(item).find("input").eq(2).val();
				antiThunderList += '","shicezhi2":"'+$(item).find("input").eq(3).val();
				antiThunderList += '","changjinshuwumingcheng":"'+$(item).find("input").eq(4).val();
//				antiThunderList += '","kuajiezhuangkuang":"'+$(item).find("input").eq(9).val();
//				antiThunderList += '","kuajiedaoticailiaoheguige":"'+$(item).find("input").eq(10).val();
//				antiThunderList += '","yunxuzhi3":"'+$(item).find("input").eq(11).val();
//				antiThunderList += '","shicezhi3":"'+$(item).find("input").eq(12).val();
				antiThunderList += '","yunxuzhi4":"'+$(item).find("input").eq(5).val();
				antiThunderList += '","shicezhi4":"'+$(item).find("input").eq(6).val();
				antiThunderList += '","jielun":"'+$(item).find("input").eq(7).val();
				antiThunderList += '","beizhu":"'+$(item).find("input").eq(8).val()+'"}';
				l++;
			}
		});
	}
	antiThunderList += ']';
//	antiThunderList = JSON.parse(antiThunderList);
	insertExaminingReport.antiThunderJson = antiThunderList;
	//电源SPD检测
	var powerSupplyList = '[';
	if($("#dyspdjc-table tr").length){
		var l = 0;
		$.each($("#dyspdjc-table tr"),function(i,item){
			var s = 0;
			$.each($(item).find("input"),function(j,jtem){
				if(!ifNull($(jtem).val())){
					s++;
				}
			});
			if(s>0){
				if(l>0){
					powerSupplyList += ',';
				}
				powerSupplyList += '{"jiancedianbianhao":"'+$(item).find("input").eq(0).val();
				powerSupplyList += '","anzhuangweizhi":"'+$(item).find("input").eq(1).val();
				powerSupplyList += '","chanpinxinghao":"'+$(item).find("input").eq(2).val();
//				powerSupplyList += '","changdu":"'+$(item).find("input").eq(3).val();
//				powerSupplyList += '","yunxuzhi":"'+$(item).find("input").eq(4).val();
//				powerSupplyList += '","shicezhi":"'+$(item).find("input").eq(5).val();
//				powerSupplyList += '","sebiao":"'+$(item).find("input").eq(6).val();
//				powerSupplyList += '","cailiao":"'+$(item).find("input").eq(7).val();
//				powerSupplyList += '","yunxuzhi2":"'+$(item).find("input").eq(8).val();
//				powerSupplyList += '","shicezhi2":"'+$(item).find("input").eq(9).val();
//				powerSupplyList += '","yunxuzhi3":"'+$(item).find("input").eq(11).val();
//				powerSupplyList += '","shicezhi3":"'+$(item).find("input").eq(12).val();
				powerSupplyList += '","yunxuzhi4":"'+$(item).find("input").eq(3).val();
				powerSupplyList += '","shicezhi4":"'+$(item).find("input").eq(4).val();
				powerSupplyList += '","jielun":"'+$(item).find("input").eq(5).val();
				powerSupplyList += '","beizhu":"'+$(item).find("input").eq(6).val()+'"}';
				l++;
			}
		});
	}
	powerSupplyList += ']';
//	powerSupplyList = JSON.parse(powerSupplyList);
	insertExaminingReport.powerSupplyJson = powerSupplyList;
	//保存  insertExaminingReport
	var url = "/insertExaminingReport.json";
	if(type == 'update'){
		insertExaminingReport.id = $("#id").val();
		url = "/updateExaminingReport.json";
	}
	 ajax({
         url: url,
         data: insertExaminingReport,
         success: function(data){
        	 layer.alert(data.resultMsg,{'title':"提示"},function(){
        		 history.back();
        	 });
         }
     });
}
/**
 * 防     直     击     雷
 * 增加一行
 **/
function fzjlAdd(){
	var fzjl = '<tr><td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
				                        	'<td><button type="button" class="btn btn-primary btn-sm" onclick="listDel(this)">'+
			                                '<i class="glyphicon glyphicon-minus"></i> 移除'+
			                                '</button></td></tr>';
	$("#fzjl-table").append(fzjl);
	
}
/**
 * 防雷电感应、防雷电波侵入
 * 增加一行
 **/
function fldgyAdd(){
	var fldgy = '<tr><td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
				                        	'<td><button type="button" class="btn btn-primary btn-sm" onclick="listDel(this)">'+
			                                '<i class="glyphicon glyphicon-minus"></i> 移除'+
			                                '</button></td></tr>';
	$("#fldgy-table").append(fldgy);
	
}
/**
 * 电源SPD检测
 * 增加一行
 **/
function dyspdjcAdd(){
	var dyspdjc = '<tr><td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
		                          			'<td><input type="text" class="form-control input-sm" /></td>'+
				                        	'<td><button type="button" class="btn btn-primary btn-sm" onclick="listDel(this)">'+
			                                '<i class="glyphicon glyphicon-minus"></i> 移除'+
			                                '</button></td></tr>';
	$("#dyspdjc-table").append(dyspdjc);
	
}

/**
 * 移除一行
 **/
function listDel(e){
	$(e).closest("tr").remove();
}