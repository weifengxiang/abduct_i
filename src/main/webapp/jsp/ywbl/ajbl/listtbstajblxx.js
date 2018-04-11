//初始化
function init(){
	$('#listtbstajblxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjblxx/getTbStAjblxxByPage');
	$('#listtbstajblxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加案件办理信息
 **/
function addTbStAjblxx(){
	var opts={
				id:'addTbStAjblxx',
				title:'添加案件办理信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjblxx/initAddTbStAjblxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStAjblxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStAjblxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除案件办理信息
 **/
function delTbStAjblxx(){
	var checkeds=$('#listtbstajblxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'ywbl/TbStAjblxx/delTbStAjblxx');
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
		    				$('#listtbstajblxxdg').datagrid('reload');
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
*修改案件办理信息
**/
function editTbStAjblxx(){
	var checkeds=$('#listtbstajblxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStAjblxx',
				title:'修改案件办理信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjblxx/initEditTbStAjblxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStAjblxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStAjblxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStAjblxx(){
	var checkeds=$('#listtbstajblxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStAjblxx',
				title:'案件办理信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjblxx/initDetailTbStAjblxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStAjblxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStAjblxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstajblxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjblxx/getTbStAjblxxByPage');
	$('#listtbstajblxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var ajbh =$('#q_ajbh').textbox("getValue");
			if(ajbh){
				ft.put("ajbh@=", ajbh);
			}
			var bljg =$('#q_bljg').textbox("getValue");
			if(bljg){
				ft.put("bljg@=", bljg);
			}
			var blyj =$('#q_blyj').textbox("getValue");
			if(blyj){
				ft.put("blyj@=", blyj);
			}
			var blsj =$('#q_blsj').textbox("getValue");
			if(blsj){
				ft.put("blsj@=", blsj);
			}
			var blr =$('#q_blr').textbox("getValue");
			if(blr){
				ft.put("blr@=", blr);
			}
			var bldw =$('#q_bldw').textbox("getValue");
			if(bldw){
				ft.put("bldw@=", bldw);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			var createrTime =$('#q_createrTime').textbox("getValue");
			if(createrTime){
				ft.put("createrTime@=", createrTime);
			}
			var updaterTime =$('#q_updaterTime').textbox("getValue");
			if(updaterTime){
				ft.put("updaterTime@=", updaterTime);
			}
			return ft.getJSON();
		}
	});
}