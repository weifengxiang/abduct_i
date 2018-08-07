//初始化
function init(){
	$('#listtbstxxbkdg').datagrid('options').url=SKY.urlCSRF(basepath+'bksz/TbStXxbk/getTbStXxbkByPage');
	$('#listtbstxxbkdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加信息布控
 **/
function addTbStXxbk(){
	var opts={
				id:'addTbStXxbk',
				title:'添加信息布控',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'bksz/TbStXxbk/initAddTbStXxbkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStXxbkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStXxbkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除信息布控
 **/
function delTbStXxbk(){
	var checkeds=$('#listtbstxxbkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'bksz/TbStXxbk/delTbStXxbk');
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
		    				$('#listtbstxxbkdg').datagrid('reload');
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
*修改信息布控
**/
function editTbStXxbk(){
	var checkeds=$('#listtbstxxbkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStXxbk',
				title:'修改信息布控',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'bksz/TbStXxbk/initEditTbStXxbkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStXxbkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStXxbkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStXxbk(){
	var checkeds=$('#listtbstxxbkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStXxbk',
				title:'信息布控明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'bksz/TbStXxbk/initDetailTbStXxbkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStXxbkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStXxbkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstxxbkdg').datagrid('options').url=SKY.urlCSRF(basepath+'bksz/TbStXxbk/getTbStXxbkByPage');
	$('#listtbstxxbkdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var bh =$('#q_bh').textbox("getValue");
			if(bh){
				ft.put("bh@=", bh);
			}
			var bknr =$('#q_bknr').textbox("getValue");
			if(bknr){
				ft.put("bknr@=", bknr);
			}
			var yxsjq =$('#q_yxsjq').textbox("getValue");
			if(yxsjq){
				ft.put("yxsjq@=", yxsjq);
			}
			var yxsjz =$('#q_yxsjz').textbox("getValue");
			if(yxsjz){
				ft.put("yxsjz@=", yxsjz);
			}
			
			return ft.getJSON();
		}
	});
}
function dblClick(rowData){
	var opts={
				id:'detailTbStXxbk',
				title:'信息布控明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'bksz/TbStXxbk/initDetailTbStXxbkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStXxbkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=rowData;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStXxbkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}