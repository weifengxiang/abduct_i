//初始化
function init(){
	$('#listtbstmsgdg').datagrid('options').url=SKY.urlCSRF(basepath+'msg/TbStMsg/getTbStMsgByPage');
	$('#listtbstmsgdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加短信发送
 **/
function addTbStMsg(){
	var opts={
				id:'addTbStMsg',
				title:'添加短信发送',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'msg/TbStMsg/initAddTbStMsgPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStMsgPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStMsgPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除短信发送
 **/
function delTbStMsg(){
	var checkeds=$('#listtbstmsgdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'msg/TbStMsg/delTbStMsg');
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
		    				$('#listtbstmsgdg').datagrid('reload');
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
*修改短信发送
**/
function editTbStMsg(){
	var checkeds=$('#listtbstmsgdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStMsg',
				title:'修改短信发送',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'msg/TbStMsg/initEditTbStMsgPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStMsgPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStMsgPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStMsg(){
	var checkeds=$('#listtbstmsgdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStMsg',
				title:'短信发送明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'msg/TbStMsg/initDetailTbStMsgPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStMsgPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStMsgPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstmsgdg').datagrid('options').url=SKY.urlCSRF(basepath+'msg/TbStMsg/getTbStMsgByPage');
	$('#listtbstmsgdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var receiverTel =$('#q_receiverTel').textbox("getValue");
			if(receiverTel){
				ft.put("receiverTel@=", receiverTel);
			}
			return ft.getJSON();
		}
	});
}