$(function () {
	getarthtml();
});

function getarthtml(){
	 $("div.includetem").each(function () {
         var includeattr=$(this).attr('include');
         var id=$(this).attr('id');
         //menuselect="nav_ul_li_1"  selectclass="nav_li_select"
         var menuselectstrs= $(this).attr('menuselect');
		 var parent_parentId = $(this).attr('parent_parentId');
		 var parentId= $(this).attr('parentId');
         var selectclass= $(this).attr('selectclass');
         
         var titleobj=$(this).attr('titleobj');
         var title=$(this).attr('title');
         if(!title||title==''){
        	 title=$(this).attr('in_title'); 
         }
         if(includeattr&&includeattr!=''){
        	 includeattr=includeattr+"?v="+(new Date()).getTime();
       	  $.ajax({
                 type: "GET",
                 dataType: "html",
                 url: includeattr,
                 cache:false,
                 data: { menuselectstrs: menuselectstrs, selectclass: selectclass },
                 success: function(htmlContent) {              
                     $("#"+id).empty();
                     $("#"+id).html(htmlContent);
                     //$('#side-menu').metisMenu();  //20171016 写在了sideNave.html中   hplus.js中的也注释掉了    过多会影响样式         
                     setselect(menuselectstrs,selectclass);//menu选中项
					 $("#"+parent_parentId).click();
					 $("#"+parentId).click();
                 }
             });
         }
   });

}

/**
* 如果公共页里包含导航  那么设置选中项
* @param menuselectstrs  需要选中的标签id用｜隔开
* @param selectclass     设置选中标签的class
*/
function  setselect(menuselectstrs,selectclass){
	
	if(!selectclass||selectclass==""){
		return;
	}
	if(menuselectstrs&&menuselectstrs!=''){
		var strs= new Array(); //定义一数组 
		
		strs=menuselectstrs.split(","); //字符分割 
		for (i=0;i<strs.length ;i++ ) { 
		  var menuselect=strs[i];
		 
		  if(menuselect&&menuselect!=null){		  
			  $("#"+menuselect).addClass(selectclass);
		  }
		} 
	}
}