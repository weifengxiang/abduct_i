//初始化
function init(){
	$('#listtbstajdjxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/getTbStAjdjxxByPage');
	$('#listtbstajdjxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加案件登记信息
 **/
function addTbStAjdjxx(){
	var opts={
				id:'addTbStAjdjxx',
				title:'添加案件登记信息',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initAddTbStAjdjxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStAjdjxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStAjdjxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除案件登记信息
 **/
function delTbStAjdjxx(){
	var checkeds=$('#listtbstajdjxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/delTbStAjdjxx');
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
		    				$('#listtbstajdjxxdg').datagrid('reload');
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
*修改案件登记信息
**/
function editTbStAjdjxx(){
	var checkeds=$('#listtbstajdjxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStAjdjxx',
				title:'修改案件登记信息',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initEditTbStAjdjxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStAjdjxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStAjdjxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStAjdjxx(){
	var checkeds=$('#listtbstajdjxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var gbButton = {
			text: '关闭',  
            iconCls: 'icon-cancel',  
            handler:function(dialog){
            	dialog.close();
            }};
	var buttons = new Array();
	buttons.push(gbButton);
	var opts={
				id:'detailTbStAjdjxx',
				title:'案件登记信息明细',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initAjxxmainPage?ajbh='+checkeds[0].ajbh),
				buttons:buttons
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 案件审核
 * @returns
 */
function shTbStAjdjxx(){
	var checkeds=$('#listtbstajdjxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'shTbStAjdjxx',
				title:'案件登记信息审核',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initEditTbStAjdjxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStAjdjxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStAjdjxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstajdjxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/getTbStAjdjxxByPage');
	$('#listtbstajdjxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var ajbh =$('#q_ajbh').textbox("getValue");
			if(ajbh){
				ft.put("ajbh@=", ajbh);
			}
			var bjsj =$('#q_bjsj').textbox("getValue");
			if(bjsj){
				ft.put("bjsj@=", bjsj);
			}
			var lxdh =$('#q_lxdh').textbox("getValue");
			if(lxdh){
				ft.put("lxdh@=", lxdh);
			}
			var djsj =$('#q_djsj').textbox("getValue");
			if(djsj){
				ft.put("djsj@=", djsj);
			}
			return ft.getJSON();
		}
	});
}
function dblclickFun(rowData){
	var gbButton = {
			text: '关闭',  
            iconCls: 'icon-cancel',  
            handler:function(dialog){
            	dialog.close();
            }};
	var buttons = new Array();
	buttons.push(gbButton);
	var opts={
				id:'detailTbStAjdjxx',
				title:'案件登记信息明细',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initAjxxmainPage?ajbh='+rowData.ajbh),
				buttons:buttons
			  };
	SKY_EASYUI.open(opts);
}