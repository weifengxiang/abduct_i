//初始化
function init(){
	$('#listtbstzlfkdg').datagrid('options').url=SKY.urlCSRF(basepath+'zlgl/TbStZlfk/getTbStZlfkByPage');
	$('#listtbstzlfkdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加指令反馈
 **/
function addTbStZlfk(){
	var opts={
				id:'addTbStZlfk',
				title:'添加指令反馈',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'zlgl/TbStZlfk/initAddTbStZlfkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStZlfkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStZlfkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除指令反馈
 **/
function delTbStZlfk(){
	var checkeds=$('#listtbstzlfkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'zlgl/TbStZlfk/delTbStZlfk');
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
		    				$('#listtbstzlfkdg').datagrid('reload');
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
*修改指令反馈
**/
function editTbStZlfk(){
	var checkeds=$('#listtbstzlfkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStZlfk',
				title:'修改指令反馈',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'zlgl/TbStZlfk/initEditTbStZlfkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStZlfkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStZlfkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStZlfk(){
	var checkeds=$('#listtbstzlfkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStZlfk',
				title:'指令反馈明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'zlgl/TbStZlfk/initDetailTbStZlfkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStZlfkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStZlfkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstzlfkdg').datagrid('options').url=SKY.urlCSRF(basepath+'zlgl/TbStZlfk/getTbStZlfkByPage');
	$('#listtbstzlfkdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var zlbh =$('#q_zlbh').textbox("getValue");
			if(zlbh){
				ft.put("zlbh@=", zlbh);
			}
			var jsdw =$('#q_jsdw').textbox("getValue");
			if(jsdw){
				ft.put("jsdw@=", jsdw);
			}
			var jssj =$('#q_jssj').textbox("getValue");
			if(jssj){
				ft.put("jssj@=", jssj);
			}
			var fksj =$('#q_fksj').textbox("getValue");
			if(fksj){
				ft.put("fksj@=", fksj);
			}
			var fknr =$('#q_fknr').textbox("getValue");
			if(fknr){
				ft.put("fknr@=", fknr);
			}
			var zt =$('#q_zt').textbox("getValue");
			if(zt){
				ft.put("zt@=", zt);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			return ft.getJSON();
		}
	});
}