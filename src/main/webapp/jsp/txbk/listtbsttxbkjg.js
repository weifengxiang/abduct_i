//初始化
function init(){
	$('#listtbsttxbkjgdg').datagrid('options').url=SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/getTbStTxbkjgByPage');
	$('#listtbsttxbkjgdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加图像布控结果
 **/
function addTbStTxbkjg(){
	var opts={
				id:'addTbStTxbkjg',
				title:'添加图像布控结果',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/initAddTbStTxbkjgPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStTxbkjgPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStTxbkjgPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除图像布控结果
 **/
function delTbStTxbkjg(){
	var checkeds=$('#listtbsttxbkjgdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/delTbStTxbkjg');
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
		    				$('#listtbsttxbkjgdg').datagrid('reload');
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
*修改图像布控结果
**/
function editTbStTxbkjg(){
	var checkeds=$('#listtbsttxbkjgdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStTxbkjg',
				title:'修改图像布控结果',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/initEditTbStTxbkjgPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStTxbkjgPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStTxbkjgPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStTxbkjg(){
	var checkeds=$('#listtbsttxbkjgdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStTxbkjg',
				title:'图像布控结果明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/initDetailTbStTxbkjgPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStTxbkjgPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStTxbkjgPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbsttxbkjgdg').datagrid('options').url=SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/getTbStTxbkjgByPage');
	$('#listtbsttxbkjgdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var ywbh =$('#q_ywbh').textbox("getValue");
			if(ywbh){
				ft.put("ywbh@=", ywbh);
			}
			var xh =$('#q_xh').textbox("getValue");
			if(xh){
				ft.put("xh@=", xh);
			}
			var xsd =$('#q_xsd').textbox("getValue");
			if(xsd){
				ft.put("xsd@=", xsd);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			var state =$('#q_state').textbox("getValue");
			if(state){
				ft.put("state@=", state);
			}
			return ft.getJSON();
		}
	});
}