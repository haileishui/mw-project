/**
 * 保存数据
 **/
function add(){
	/***do***/
//	addUsersInfo.json
	var d = {};
	d.name = $("#name").val();
	d.userName = $("#userName").val();
	d.password = $("#password").val();
	d.status = $("#status").val();
	d.phone = $("#phone").val();
	d.company = $("#company").val();
	 ajax({
         url: "/addUsersInfo.json",
         data: d,
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
	$("#dyspdjc-table").append(dyspdjc);
	
}

/**
 * 移除一行
 **/
function listDel(e){
	$(e).closest("tr").remove();
}