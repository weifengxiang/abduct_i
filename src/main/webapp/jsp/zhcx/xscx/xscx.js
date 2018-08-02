//初始化
function init(){
	$('#listtbstxsxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStXsxx/getTbStXsxxByPage');
	$('#listtbstxsxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加线索信息
 **/
function addTbStXsxx(){
	var opts={
				id:'addTbStXsxx',
				title:'添加线索信息',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStXsxx/initAddTbStXsxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStXsxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStXsxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除线索信息
 **/
function delTbStXsxx(){
	var checkeds=$('#listtbstxsxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'ywbl/TbStXsxx/delTbStXsxx');
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
		    				$('#listtbstxsxxdg').datagrid('reload');
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
*修改线索信息
**/
function editTbStXsxx(){
	var checkeds=$('#listtbstxsxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStXsxx',
				title:'修改线索信息',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStXsxx/initEditTbStXsxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStXsxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStXsxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStXsxx(){
	var checkeds=$('#listtbstxsxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
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
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStXsxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstxsxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStXsxx/getTbStXsxxByPage');
	$('#listtbstxsxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var xsbh =$('#q_xsbh').textbox("getValue");
			if(xsbh){
				ft.put("xsbh@=", xsbh);
			}
			var jbr =$('#q_jbr').textbox("getValue");
			if(jbr){
				ft.put("jbr@=", jbr);
			}
			var djsj =$('#q_djsj').textbox("getValue");
			if(djsj){
				ft.put("date_format(djsj,concat(upper('%y'),'-%m-%d'))@<=@=", djsj);
			}
			return ft.getJSON();
		}
	});
}