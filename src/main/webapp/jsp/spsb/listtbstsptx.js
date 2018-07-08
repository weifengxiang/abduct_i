//初始化
function init(){
	$('#listtbstsptxdg').datagrid('options').url=SKY.urlCSRF(basepath+'spsb/TbStSpTx/getTbStSpTxByPage');
	$('#listtbstsptxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加视频图片匹配
 **/
function addTbStSpTx(){
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
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
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
/**
*修改视频图片匹配
**/
function editTbStSpTx(){
	var checkeds=$('#listtbstsptxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStSpTx',
				title:'修改视频图片匹配',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'spsb/TbStSpTx/initEditTbStSpTxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStSpTxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStSpTxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStSpTx(){
	var checkeds=$('#listtbstsptxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStSpTx',
				title:'视频图片匹配明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'spsb/TbStSpTx/initDetailTbStSpTxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStSpTxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStSpTxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstsptxdg').datagrid('options').url=SKY.urlCSRF(basepath+'spsb/TbStSpTx/getTbStSpTxByPage');
	$('#listtbstsptxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var txnr =$('#q_txnr').textbox("getValue");
			if(txnr){
				ft.put("txnr@=", txnr);
			}
			var spbh =$('#q_spbh').textbox("getValue");
			if(spbh){
				ft.put("spbh@=", spbh);
			}
			var jt =$('#q_jt').textbox("getValue");
			if(jt){
				ft.put("jt@=", jt);
			}
			var xsd =$('#q_xsd').textbox("getValue");
			if(xsd){
				ft.put("xsd@=", xsd);
			}
			return ft.getJSON();
		}
	});
}