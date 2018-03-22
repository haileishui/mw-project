
/**
 *用户状态 0正常，1禁用',
 * **/
var userStatusJsonMap = {
		"0":"正常",
		"1":"禁用"
};

var companyJsonMap = {
		"01":"一组",
		"02":"二组",
		"03":"三组",
		"04":"四组",
		"05":"五组",
		"06":"六组",
		"07":"七组",
		"08":"八组",
		"09":"九组",
		"10":"十组",
};
/**
  * 是否为空
  * @param {} 需要验证的参数
  * @return {Boolean} 返回Boolean值
  */
 function ifNull(v){
 	if(v==undefined||v=='undefined'||v==null||v ==='')
 		return true;
 	return false;
 }
 /**
  * 是否为空
  * 如果v不为空 则返回v
  * 如果v为空  则判断n是否为空  如果n不为空返回n   否则返回"";
  */
function isNull(v,n){
 	if(ifNull(v)){
 		if(ifNull(n))
 	 		return '';
 	 	return n;
 	}else{
 		return v;
 	}
 }
 /**
  * 把字符串转换为json对象
  * @param {} text 字符串
  * @return {} json对象
  */
 function text2json(text){
 	try{
 		
 		return  eval("("+text+")");
 	}catch(e){
 		return {};
 	}
 }
 
 
 /**
  * 调用后台的ajax事件
  * @param {} config
  */
 function ajax(config){
	 var $submit = $("#submit");
	 if($submit.length){
		 $submit.attr({"disabled":true});
	 }
	 var loading = config.loading?true:false;//loading
	 var index;//loading层级
	 if(loading){//是否有loading层
		//loading层
		 index = layer.load(1, {
		   shade: [0.5,'#fff'] //0.1透明度的白色背景
		 });
	 }
	var url=config.url;
 	$.ajax({
		url:url,  
		data:config.data,    
		type:'post',//isNull(config.type,'post'),    
		cache:false, 
		dataType:'text' , //'json',  
		success:function(d) {
			 if($submit.length){
				 $submit.attr({"disabled":false});
			 }
			if(loading){//是否有loading层
				layer.close(index);//关闭loading层
			 }
			var data = text2json(d);
			//如果返回的data为空
			if(ifNull(data)){
				
			}
			//返回正确则调用回调方法
			if(data.isSuccess){
				config.success(data);
			}else{//否则提示失败原因
				layer.alert(data.resultMsg,{'title':"提示"});
			}
		 },     
		error : function(data, status, e) {
			 if($submit.length){
				 $submit.attr({"disabled":false});
			 }
			layer.alert("请求接口："+config.url+"<br/>返回状态："+status,{'title':"提示"});
			if(loading){//是否有loading层
				layer.close(index);//关闭loading层
			 }
		}  
 	}); 
 }
//获取表单内容，要求id把#传过来 如果传餐 "#fromId"
function getFormValues(formId){
	var params={};
	$(formId).find("input[type='text']").each(function (i) {
		   var id=this.id;
		   var value=this.value;
	       params[id]=value;
	});
	$(formId).find("input[type='hidden']").each(function (i) {
		   var id=this.id;
		   var value=this.value;
	       params[id]=value;
	});
	$(formId).find("input[type='password']").each(function (i) {
		   var id=this.id;
		   var value=this.value;
	       params[id]=value;
	});
	$(formId).find("textarea").each(function (i) {
		   var id=this.id;
		   var value=this.value;
	       params[id]=value;
	});
	$(formId).find("select").each(function (i) {
		   var id=this.id;
		   var value= $("#"+this.id).find("option:selected").text();
	       params[id]=value;
	});
	$(formId).find("input[type='number']").each(function (i) {
		   var id=this.id;
		   var value= this.value;
	       params[id]=value;
	});
	return params;
}
//获得参数的方法
var request = {
	QueryString : function(val) {
		var uri = window.location.search;
		var re = new RegExp("" + val + "=([^&?]*)", "ig");
		var str = ((uri.match(re)) ? (uri.match(re)[0].substr(val.length + 1)) : null);
		if(str!=null&&str!='null'&&str!=''){
			str = decodeURI(str);
		}
		return str;
	}
};
/**
 * 判断表单是否有信息如果有则加载一下数据
 * **/
function setHistoryList(object){
	var formVal = getFormValues("#wrapper");
	if(ifNull(object)){
		if(!ifNull(formVal.pageNumber)){
			getData(formVal.pageNumber);
		}
	}else{
		var s = 0;
		for(var i = 0; i<object.length; i++){
			if(!ifNull(formVal[object[i]])){
				s++;
				if(s>1){
					return;
				}
				getData(formVal.pageNumber);
			}
		}
	}
}
/**
 * 两个json合并
 * **/
function extend(des, src, override){
	   if(src instanceof Array){
	       for(var i = 0, len = src.length; i < len; i++)
	            extend(des, src[i], override);
	   }
	   for( var i in src){
	       if(override || !(i in des)){
	           des[i] = src[i];
	       }
	   } 
	   return des;
	}
/**
 * 整合js/plugins/bootstrap-paginator.min.js 分页插件
 * 简化方法
 * name:包含分页的div的id值
 * data:异步分页返回的数值
 * fun:回调方法
 * **/
function pageinit(name,data,fun){
	if(data.total==0){
		return;
	}
	var pageSize = data.pageSize;
	var totalPages = data.pages;
	var currentPage = data.pageNo;
	if($("#pageNumber").length){
		$("#pageNumber").val(currentPage);
	}
	var options = {
		    currentPage: currentPage,//当前页
		    totalPages: totalPages,//总页数
		    numberofPages: 5,//显示的页数
		    itemTexts: function(type, page, current) { //修改显示文字
		        switch (type) {
		        case "first":
		            return "第一页";
		        case "prev":
		            return "上一页";
		        case "next":
		            return "下一页";
		        case "last":
		            return "最后一页";
		        case "page":
		            return page;
		        }
		    }, onPageClicked: function (event, originalEvent, type, page) { //异步换页
		    	fun(page,pageSize);
	        },
		                
		};
	$("#"+name).bootstrapPaginator(options);
}
//获取某月的月末
function getDay(year,month){
	var new_year = year;  //取当前的年份   
	var new_month = month++;//取下一个月的第一天，方便计算（最后一天不固定）   
	if(month>12)      //如果当前大于12月，则年份转到下一年   
	{   
		new_month -=12;    //月份减   
		new_year++;      //年份增   
	}
	var new_date = new Date(new_year,new_month,1);        //取当年当月中的第一天  
	var last_date = (new Date(new_date.getTime()-1000*60*60*24)).getDate();//获取当月最后一天日期
	return last_date;//返回最后一天日期
}
//获取当前日期
function getNowFormatDate(type){
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate1 = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    var currentdate2 = date.getFullYear() + seperator1 + month + seperator1 + strDate
    + " " + date.getHours() + seperator2 + date.getMinutes()
    + seperator2 + date.getSeconds();
    if(type==1){
        return currentdate1;
    }else{
        return currentdate2;
    }
}
//两个时间相差天数
function datedifference(sDate1, sDate2) {    //sDate1和sDate2是2006-12-18格式  
    var dateSpan,iDays;
    sDate1 = Date.parse(sDate1);
    sDate2 = Date.parse(sDate2);
    dateSpan = sDate2 - sDate1;
    dateSpan = Math.abs(dateSpan);
    iDays = Math.floor(dateSpan / (24 * 3600 * 1000));
    return iDays;
};
//添加时间
//periodUnit  1年、2月、3天
//number 数量
function dateAdd(periodUnit,number,date) {
  switch (periodUnit) {
	    case '1': {
	        date.setFullYear(date.getFullYear() + number);
	        return date;
	        break;
	    }
	    case '2': {
	        date.setMonth(date.getMonth() + number);
	        return date;
	        break;
	    }
	    case '3': {
	        date.setDate(date.getDate() + number);
	        return date;
	        break;
	    }
	    default: {
	        date.setDate(date.getDate() + number);
	        return date;
	        break;
	    }
  }
}
//获取时间
function timeGeshi(myDate){
	var tyear = myDate.getFullYear();
	var tmonth = ((myDate.getMonth()+1).toString().length==1)?("0"+(myDate.getMonth()+1)):(myDate.getMonth()+1);
	var tdate = ((myDate.getDate()+1).toString().length==1)?("0"+(myDate.getDate())):(myDate.getDate());
	var yourTody = tyear+"-"+tmonth+"-"+tdate;
	return yourTody;
}
//加法
function add(a, b) {
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), (mul(a, e) + mul(b, e)) / e;
}
//减法  前边减后边
function sub(a, b) {
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), (mul(a, e) - mul(b, e)) / e;
}
//除法
function div(a, b) {
    var c, d, e = 0,
        f = 0;
    try {
        e = a.toString().split(".")[1].length;
    } catch (g) {}
    try {
        f = b.toString().split(".")[1].length;
    } catch (g) {}
    return c = Number(a.toString().replace(".", "")), d = Number(b.toString().replace(".", "")), mul(c / d, Math.pow(10, f - e));
}
//乘法
function mul(a, b) {
    var c = 0,
        d = a.toString(),
        e = b.toString();
    try {
        c += d.split(".")[1].length;
    } catch (f) {}
    try {
        c += e.split(".")[1].length;
    } catch (f) {}
    return Number(d.replace(".", "")) * Number(e.replace(".", "")) / Math.pow(10, c);
}

/**
 * 设置cookie
 */
function setCookie(cookieName, cookieValue) {
	var date = new Date();
	var expiresDays =1;
	date.setTime(date.getTime() + expiresDays * 24 * 3600 * 1000); // cookie失效时间
	document.cookie = cookieName + '=' + escape(cookieValue) + ";expires=" + date.toGMTString()+";path=/";//+";path=/"
}

/**
 * 删除cookie
 */
function DelCookie(name) {
	  var exp = new Date();
	  exp.setTime(exp.getTime() + (-1 * 24 * 60 * 60 * 1000));
	  var cval = getCookieValueByName(name);
	  document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString()+";path=/";
}

/**
 * 读取cookie值
 */
function getCookieValueByName(cookieName) {
	var cookieValue = null;
	var begin = document.cookie.indexOf(cookieName);
	if(begin != -1) {
		begin += cookieName.length + 1;
		var end = document.cookie.indexOf(";", begin);
		if(end == -1) {
			end = document.cookie.length;
		}
		cookieValue = unescape(document.cookie.substring(begin, end)); // 获取cookieName的值
	}
	return cookieValue;
}
/**
 * 填充表头的时候加载点点点
 * **/
var pointTime = 0;
function timePoint(){
	pointTime++;
	if(pointTime>2){
		pointTime = 0;
	}
	var str = "<img src='/static/img/loadingbt.gif' />";
	var bt = $("[data-type='bt']");
	$.each(bt,function(o,otem){
		$(this).html(str);
	});
}
/**
 * 填充表头
 * 参数box，哪一块的表头需要换的id值
 * 类型：*
 * 设置字段 data-type='bt'
 * id与获取的字段值一致
 * **/
function setBt(d,box){
	 var bt;
	 if(!ifNull(box)){
		 bt = $("#"+box+" [data-type='bt']");
	 }else{
		 bt = $("[data-type='bt']");
	 }
	 if(ifNull(d)){
		 $.each(bt,function(o,otem){
			$(this).html("空");
		 });
		 return;
	 }
	 $.each(bt,function(o,otem){
		var id =  $(otem).attr("id");
		$(this).html(isNull(d[id],"空"));
	 });
}
/**
 * 判断一个字符串是否在一个数组中
 * stringToSearch:字符串
 * arrayToSearch:数组
 * name:arrayToSearch的字段
 * **/
function in_array(stringToSearch, arrayToSearch,name) {
    for (var s = 0; s < arrayToSearch.length; s++) {
    	if(ifNull(name)){
    	     thisEntry = arrayToSearch[s].toString();
    	}else{
    	     thisEntry = arrayToSearch[s][name].toString();
    	}
     if (thisEntry == stringToSearch) {
      return true;
     }
    }
    return false;
}

function print_page(flag) {
    if (!!window.ActiveXObject || "ActiveXObject" in window || getExplorer() == "IE") {
        remove_ie_header_and_footer();
    }
//    if(flag != ''){
//    	window.print().portrait = true;
//    }
    window.print();
};

function remove_ie_header_and_footer() {
    var hkey_root, hkey_path, hkey_key;
    hkey_path = "HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
    try {
        var RegWsh = new ActiveXObject("WScript.Shell");
        RegWsh.RegWrite(hkey_path + "header", "");
        RegWsh.RegWrite(hkey_path + "footer", "");
    } catch (e) {}
}

function getExplorer() {
    var explorer = window.navigator.userAgent ;
    //ie 
    if (explorer.indexOf("MSIE") >= 0) {
        return "IE";
    }
    //firefox 
    else if (explorer.indexOf("Firefox") >= 0) {
        return "Firefox";
    }
    //Chrome
    else if(explorer.indexOf("Chrome") >= 0){
        return "Chrome";
    }
    //Opera
    else if(explorer.indexOf("Opera") >= 0){
        return "Opera";
    }
    //Safari
    else if(explorer.indexOf("Safari") >= 0){
        return "Safari";
    }
}
