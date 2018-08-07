//初始化
function init(){
	$('#listtbstzlxfdg').datagrid('options').url=SKY.urlCSRF(basepath+'zlgl/TbStZlxf/getTbStZlxfByPage');
	$('#listtbstzlxfdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加指令下发
 **/
function addTbStZlxf(){
	var opts={
				id:'addTbStZlxf',
				title:'添加指令下发',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'zlgl/TbStZlxf/initAddTbStZlxfPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStZlxfPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStZlxfPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除指令下发
 **/
function delTbStZlxf(){
	var checkeds=$('#listtbstzlxfdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'zlgl/TbStZlxf/delTbStZlxf');
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
		    				$('#listtbstzlxfdg').datagrid('reload');
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
*修改指令下发
**/
function editTbStZlxf(){
	var checkeds=$('#listtbstzlxfdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStZlxf',
				title:'修改指令下发',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'zlgl/TbStZlxf/initEditTbStZlxfPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStZlxfPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStZlxfPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStZlxf(){
	var checkeds=$('#listtbstzlxfdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStZlxf',
				title:'指令下发明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'zlgl/TbStZlxf/initDetailTbStZlxfPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStZlxfPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStZlxfPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstzlxfdg').datagrid('options').url=SKY.urlCSRF(basepath+'zlgl/TbStZlxf/getTbStZlxfByPage');
	$('#listtbstzlxfdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var zlbh =$('#q_zlbh').textbox("getValue");
			if(zlbh){
				ft.put("zlbh@=", zlbh);
			}
			var zlmc =$('#q_zlmc').textbox("getValue");
			if(zlmc){
				ft.put("zlmc@=", zlmc);
			}
			var zlnr =$('#q_zlnr').textbox("getValue");
			if(zlnr){
				ft.put("zlnr@=", zlnr);
			}
			var xfsj =$('#q_xfsj').textbox("getValue");
			if(xfsj){
				ft.put("xfsj@=", xfsj);
			}
			
			return ft.getJSON();
		}
	});
}
/**
 * 指令反馈情况
 * @returns
 */
function detailTbStZlfk(){
	var checkeds=$('#listtbstzlxfdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
			id:'listTbStZlfk',
			title:'指令反馈情况',
			width:600,
			height:450,
			modal:true,
			content:'url:'+SKY.urlCSRF(basepath+'zlgl/TbStZlxf/initTbStZlFKPage'),
			onLoad: function(dialog){ 
	            if(this.content && this.content.initAddTbStZlfkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
	                var paramOpts=new Object();
	                paramOpts.dialog=dialog;
	                paramOpts.data=checkeds[0];
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
function dblClickRow(rowData){
	var opts={
			id:'detailTbStZlxf',
			title:'指令下发明细',
			width:600,
			height:450,
			modal:true,
			content:'url:'+SKY.urlCSRF(basepath+'zlgl/TbStZlxf/initDetailTbStZlxfPage'),
			onLoad: function(dialog){ 
	            if(this.content && this.content.initDetailTbStZlxfPage){//判断弹出窗体iframe中的driveInit方法是否存在 
	                var paramOpts=new Object();
	                paramOpts.dialog=dialog;
	                paramOpts.data=rowData;
	                paramOpts.callBack=function(){
	                	dialog.close();
	                };
	            	this.content.initDetailTbStZlxfPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
	            } 
	        }
		  };
	SKY_EASYUI.open(opts);
}