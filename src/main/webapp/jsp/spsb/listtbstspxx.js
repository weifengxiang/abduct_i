//初始化
function init(){
	$('#listtbstspxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'spsb/TbStSpxx/getTbStSpxxByPage');
	$('#listtbstspxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加视频信息
 **/
function addTbStSpxx(){
	var opts={
				id:'addTbStSpxx',
				title:'添加视频信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'spsb/TbStSpxx/initAddTbStSpxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStSpxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStSpxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除视频信息
 **/
function delTbStSpxx(){
	var checkeds=$('#listtbstspxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'spsb/TbStSpxx/delTbStSpxx');
				var params = {
							"delRows":JSON.stringify(checkeds)
						};
				$.ajax({
		    		url:url,
		    		type: "POST",
		    		data:params,
		    		dataType:'json',
		    		success:function(data){
		    			SKY_EASYUI.unmask();
		    			$.messager.alert("提示",data.name,"info");
		    			if(data.code != '0'){
		    				$('#listtbstspxxdg').datagrid('reload');
		    			}
		    		}
				});
			}else{
				return;
			}
		}
		);
	}
}

/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstspxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'spsb/TbStSpxx/getTbStSpxxByPage');
	$('#listtbstspxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var spbh =$('#q_spbh').textbox("getValue");
			if(spbh){
				ft.put("spbh@=", spbh);
			}
			var spmc =$('#q_spmc').textbox("getValue");
			if(spmc){
				ft.put("spmc@=", spmc);
			}
			return ft.getJSON();
		}
	});
}
/**
 * 附件下载
 */
function downloadSysFile(){
	var checkeds=$('#listtbstspxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	SKY_EASYUI.downLoad(checkeds[0].splj);
}
/**
 *添加视频图片匹配
 **/
function addTbStSpTx(){
	var checkeds=$('#listtbstspxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条要比对的视频记录','info');
		return;
	}
	var opts={
				id:'addTbStSpTx',
				title:'添加视频图片匹配',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'spsb/TbStSpTx/initAddTbStSpTxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStSpTxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.data = checkeds[0];
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	$('#listtbstsptxdg').datagrid('reload');
		                };
		            	this.content.initAddTbStSpTxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 *删除视频图片匹配
 **/
function delTbStSpTx(){
	var checkeds=$('#listtbstsptxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'spsb/TbStSpTx/delTbStSpTx');
				var params = {
							"delRows":JSON.stringify(checkeds)
						};
				$.ajax({
		    		url:url,
		    		type: "POST",
		    		data:params,
		    		dataType:'json',
		    		success:function(data){
		    			SKY_EASYUI.unmask();
		    			$.messager.alert("提示",data.name,"info");
		    			if(data.code != '0'){
		    				$('#listtbstsptxdg').datagrid('reload');
		    			}
		    		}
				});
			}else{
				return;
			}
		}
		);
	}
}
function getImg(id){	
	var url = basepath+'spsb/TbStSpTx/viewImg/'+id;
	var rend = "";
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "get",
		dataType:'json',
		async:false,
		success:function(data){
			if(!data){
				return;
			}
			rend =  "<img style='width:150px;height:150px;' src='"+data+"'/>";
		}
	});
	return rend;
}
function loadSpTxList(spbh){
	$('#listtbstsptxdg').datagrid('options').url=SKY.urlCSRF(basepath+'spsb/TbStSpTx/getTbStSpTxByPage');
	$('#listtbstsptxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			if(spbh){
				ft.put("spbh@=", spbh);
			}
			return ft.getJSON();
		}
	});
}