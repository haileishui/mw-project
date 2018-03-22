     // 按钮组

	 /* 返回上一级 */
	 $(".buttons").on('click','.back',function(){
		  window.history.go(-1);   
	  });
	  
	  /* 删除 */ 
	 $(".buttons").on('click','.delete',function(){
		 $.layer({
			    title:"提示",
				dialog: {
					msg: '删除本条记录？',                   
					type: -1,
					btns: 2,
					btn: ['删除','取消'],
					yes: function(){
					   window.history.back();
					}, 
				}
			});
	  });
	  
	  /* 删除已选 */ 
	 $(".buttons").on('click','.deletes',function(){
		 $.layer({
			    title:"提示",
				dialog: {
					msg: '删除已选记录？',                   
					type: -1,
					btns: 2,
					btn: ['删除','取消'],
					yes: function(){
					   window.history.back();
					}, 
				}
			});
	  });
	  
 
	 /* 存为草稿 */ 
	 $(".buttons").on('click','.save',function(){
		 $.layer({
			    title:"提示信息",
				dialog: {
					msg: '是否将计划保存至草稿箱？',                   
					type: -1,
					btns: 2,
					btn: ['是','否'],
					yes: function(){
					   window.history.back();
					}, 
				}
			});
	  });
	  
	   /* 导出所选 */ 
	 $(".buttons").on('click','.export',function(){
		 $.layer({
			    title:"提示信息",
				dialog: {
					msg: '是否确定导出所选内容？',                   
					type: -1,
					btns: 2,
					btn: ['是','否'],
				}
			});
	  });

	  
	  
	  /* 查询 仅限于有一个input */ 
//	 $(".buttons").on('click','.query',function(){
//		 var val = $.trim($("#query").find("input").val());
//		 if(!ifNull(val)){
//			$("#query").hide();
//			$("#info").show();
//		 }
//	  });
	 function hideQuery(){
		 var val = $.trim($("#query").find("input#khmc").val());
		 if(!ifNull(val)){
			$("#query").hide();
			$("#info").show();
		 }
	 }
	  
	  /* 切换 */
	 $(".buttons").on('click','.change',function(){
		 $("#info").hide();
		 //$("#query").find("input").val("");
		 $("#query").show();  
	  });
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  