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
 * 案件办理
 * @returns
 */
function doAjbh(){
	var checkeds=$('#listtbstajdjxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	//办理
	var doBL=function(opt){
		var opts={
				id:'addTbStAjblxx',
				title:'案件办理',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjblxx/initAddTbStAjblxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStAjblxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                var data = new Object();
		                data.ajbh = checkeds[0].ajbh;
		                data.opt=opt;
		                paramOpts.data=data;
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
	};
	var buttons = new Array();
	var thButton = {
			text: '退回',  
            iconCls: 'icon-undo',  
            handler:function(dialog){
            	doBL('-1');
            }};
	var flButton = {
			text: '分流',  
            iconCls: 'icon-20130406125519344_easyicon_net_16',  
            handler:function(dialog){
            	doBL('0');
            }}; 
	var slButton = {
			text: '受理',  
            iconCls: 'icon-accept',  
            handler:function(dialog){
            	doBL('1');
            }}; 
	var bjButton = {
			text: '办结',  
            iconCls: 'icon-ok',  
            handler:function(dialog){
            	doBL('2');
            }}; 
	var gbButton = {
			text: '关闭',  
            iconCls: 'icon-cancel',  
            handler:function(dialog){
            	dialog.close();
            }};
	buttons.push(thButton);
	buttons.push(flButton);
	buttons.push(slButton);
	buttons.push(bjButton);
	buttons.push(gbButton);
	var opts={
			id:'doAjbl',
			title:'案件办理',
			width:800,
			height:600,
			modal:true,
			content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initAjxxmainPage?ajbh='+checkeds[0].ajbh),
			buttons:buttons
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
	var opts={
				id:'detailTbStAjdjxx',
				title:'案件登记信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initDetailTbStAjdjxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStAjdjxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStAjdjxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
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