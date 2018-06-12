//初始化
function init(){
	$('#listtbstbkcxdg').datagrid('options').url=SKY.urlCSRF(basepath+'bkcx/TbStBkcx/getTbStBkcxByPage');
	$('#listtbstbkcxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加布控查询
 **/
function addTbStBkcx(){
	var opts={
				id:'addTbStBkcx',
				title:'添加布控查询',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'bkcx/TbStBkcx/initAddTbStBkcxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStBkcxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStBkcxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除布控查询
 **/
function delTbStBkcx(){
	var checkeds=$('#listtbstbkcxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'bkcx/TbStBkcx/delTbStBkcx');
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
		    				$('#listtbstbkcxdg').datagrid('reload');
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
*修改布控查询
**/
function editTbStBkcx(){
	var checkeds=$('#listtbstbkcxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStBkcx',
				title:'修改布控查询',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'bkcx/TbStBkcx/initEditTbStBkcxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStBkcxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStBkcxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStBkcx(){
	var checkeds=$('#listtbstbkcxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStBkcx',
				title:'布控查询明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'bkcx/TbStBkcx/initDetailTbStBkcxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStBkcxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStBkcxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstbkcxdg').datagrid('options').url=SKY.urlCSRF(basepath+'bkcx/TbStBkcx/getTbStBkcxByPage');
	$('#listtbstbkcxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var bkbh =$('#q_bkbh').textbox("getValue");
			if(bkbh){
				ft.put("bkbh@=", bkbh);
			}
			var ywlx =$('#q_ywlx').textbox("getValue");
			if(ywlx){
				ft.put("ywlx@=", ywlx);
			}
			var ywbh =$('#q_ywbh').textbox("getValue");
			if(ywbh){
				ft.put("ywbh@=", ywbh);
			}
			var jksj =$('#q_jksj').textbox("getValue");
			if(jksj){
				ft.put("jksj@=", jksj);
			}
			return ft.getJSON();
		}
	});
}
function fmYwbh(data){
	console.log(data.ywlx);
	if('AJXX'==data.ywlx){
		return "<a href='#' onclick='ajdetail(\""+data.ywbh+"\")'>"+data.ywbh+"</a>";
	}else if('XSXX'==data.ywlx){
		return "<a href='#' onclick='xsdetail(\""+data.ywbh+"\")'>"+data.ywbh+"</a>";
	}else{
		return data.ywbh
	}
	
}
var ajdetail=function(ajbh){
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
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initAjxxmainPage?ajbh='+ajbh),
				buttons:buttons
			  };
	SKY_EASYUI.open(opts);
};
var xsdetail=function(ywbh){
		var opts={
				id:'detailTbStXsxx',
				title:'线索信息明细',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStXsxx/initDetailTbStXsxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStXsxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data={'xsbh':ywbh};
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStXsxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
		SKY_EASYUI.open(opts);
};