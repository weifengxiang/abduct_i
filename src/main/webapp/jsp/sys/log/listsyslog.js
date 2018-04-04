//初始化
function init(){
	$('#listsyslogdg').datagrid('options').url=SKY.urlCSRF(basepath+'base/SysLog/getSysLogByPage');
	$('#listsyslogdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加日志表
 **/
function addSysLog(){
	var opts={
				id:'addSysLog',
				title:'添加日志表',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/SysLog/initAddSysLogPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddSysLogPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddSysLogPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除日志表
 **/
function delSysLog(){
	var checkeds=$('#listsyslogdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/SysLog/delSysLog');
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
		    				$('#listsyslogdg').datagrid('reload');
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
*修改日志表
**/
function editSysLog(){
	var checkeds=$('#listsyslogdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editSysLog',
				title:'修改日志表',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/SysLog/initEditSysLogPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditSysLogPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditSysLogPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailSysLog(){
	var checkeds=$('#listsyslogdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailSysLog',
				title:'日志表明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/SysLog/initDetailSysLogPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailSysLogPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailSysLogPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listsyslogdg').datagrid('options').url=SKY.urlCSRF(basepath+'base/SysLog/getSysLogByPage');
	$('#listsyslogdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var userCode =$('#q_userCode').textbox("getValue");
			if(userCode){
				ft.put("userCode@=", userCode);
			}
			var optTimeBegin =$('#q_optTimeBegin').textbox("getValue");
			if(optTimeBegin){
				ft.put("date_format(optTime,concat(upper('%y'),'-%m-%d'))@>=", optTimeBegin);
			}
			var optTimeEnd =$('#q_optTimeEnd').textbox("getValue");
			if(optTimeEnd){
				ft.put("date_format(optTime,concat(upper('%y'),'-%m-%d'))@<=", optTimeEnd);
			}
			return ft.getJSON();
		}
	});
}