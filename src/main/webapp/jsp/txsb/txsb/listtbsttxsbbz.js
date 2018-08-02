//初始化
function init(){
	$('#listtbsttxsbdg').datagrid('options').url=SKY.urlCSRF(basepath+'txsb/TbStTxsb/getTbStTxsbByPage');
	$('#listtbsttxsbdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			ft.put("state@=",'01');
			return ft.getJSON();
		},
		sortfield:"sbsj desc"
	});
}
 /**
 *添加图像识别
 **/
function addTbStTxsb(){
	var opts={
				id:'addTbStTxsb',
				title:'添加图像识别',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txsb/TbStTxsb/initAddTbStTxsbPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStTxsbPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStTxsbPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除图像识别
 **/
function delTbStTxsb(){
	var checkeds=$('#listtbsttxsbdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'txsb/TbStTxsb/delTbStTxsb');
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
		    				$('#listtbsttxsbdg').datagrid('reload');
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
*修改图像识别
**/
function editTbStTxsb(){
	var checkeds=$('#listtbsttxsbdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStTxsb',
				title:'修改图像识别',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txsb/TbStTxsb/initEditTbStTxsbPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStTxsbPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStTxsbPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStTxsb(){
	var checkeds=$('#listtbsttxsbdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStTxsb',
				title:'图像识别明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txsb/TbStTxsb/initDetailTbStTxsbPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStTxsbPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStTxsbPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbsttxsbdg').datagrid('options').url=SKY.urlCSRF(basepath+'txsb/TbStTxsb/getTbStTxsbByPage');
	$('#listtbsttxsbdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			ft.put("state@=",'01');
			var ywlx =$('#q_ywlx').textbox("getValue");
			if(ywlx){
				ft.put("ywlx@=", ywlx);
			}
			var ywbh =$('#q_ywbh').textbox("getValue");
			if(ywbh){
				ft.put("ywbh@=", ywbh);
			}
			var txxh =$('#q_txxh').textbox("getValue");
			if(txxh){
				ft.put("txxh@=", txxh);
			}
			return ft.getJSON();
		},
		sortfield:"sbsj desc"
	});
}