//初始化
function init(){
	$('#listsysareadg').datagrid('options').url=SKY.urlCSRF(basepath+'sys/SysArea/getSysAreaByPage');
	$('#listsysareadg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加省市区编码表
 **/
function addSysArea(){
	var opts={
				id:'addSysArea',
				title:'添加省市区编码表',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'sys/SysArea/initAddSysAreaPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddSysAreaPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddSysAreaPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除省市区编码表
 **/
function delSysArea(){
	var checkeds=$('#listsysareadg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'sys/SysArea/delSysArea');
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
		    				$('#listsysareadg').datagrid('reload');
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
*修改省市区编码表
**/
function editSysArea(){
	var checkeds=$('#listsysareadg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editSysArea',
				title:'修改省市区编码表',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'sys/SysArea/initEditSysAreaPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditSysAreaPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditSysAreaPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailSysArea(){
	var checkeds=$('#listsysareadg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailSysArea',
				title:'省市区编码表明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'sys/SysArea/initDetailSysAreaPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailSysAreaPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailSysAreaPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listsysareadg').datagrid('options').url=SKY.urlCSRF(basepath+'sys/SysArea/getSysAreaByPage');
	$('#listsysareadg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var code =$('#q_code').textbox("getValue");
			if(code){
				ft.put("code@=", code);
			}
			var name =$('#q_name').textbox("getValue");
			if(name){
				ft.put("name@=", name);
			}
			var parCode =$('#q_parCode').textbox("getValue");
			if(parCode){
				ft.put("parCode@=", parCode);
			}
			var seq =$('#q_seq').textbox("getValue");
			if(seq){
				ft.put("seq@=", seq);
			}
			return ft.getJSON();
		}
	});
}