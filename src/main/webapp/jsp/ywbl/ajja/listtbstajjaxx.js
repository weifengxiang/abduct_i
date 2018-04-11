//初始化
function init(){
	$('#listtbstajjaxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjjaxx/getTbStAjjaxxByPage');
	$('#listtbstajjaxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加案件结案信息
 **/
function addTbStAjjaxx(){
	var opts={
				id:'addTbStAjjaxx',
				title:'添加案件结案信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjjaxx/initAddTbStAjjaxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStAjjaxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStAjjaxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除案件结案信息
 **/
function delTbStAjjaxx(){
	var checkeds=$('#listtbstajjaxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'ywbl/TbStAjjaxx/delTbStAjjaxx');
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
		    				$('#listtbstajjaxxdg').datagrid('reload');
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
*修改案件结案信息
**/
function editTbStAjjaxx(){
	var checkeds=$('#listtbstajjaxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStAjjaxx',
				title:'修改案件结案信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjjaxx/initEditTbStAjjaxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStAjjaxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStAjjaxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStAjjaxx(){
	var checkeds=$('#listtbstajjaxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStAjjaxx',
				title:'案件结案信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjjaxx/initDetailTbStAjjaxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStAjjaxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStAjjaxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstajjaxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjjaxx/getTbStAjjaxxByPage');
	$('#listtbstajjaxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var ajbh =$('#q_ajbh').textbox("getValue");
			if(ajbh){
				ft.put("ajbh@=", ajbh);
			}
			var jadw =$('#q_jadw').textbox("getValue");
			if(jadw){
				ft.put("jadw@=", jadw);
			}
			var jasj =$('#q_jasj').textbox("getValue");
			if(jasj){
				ft.put("jasj@=", jasj);
			}
			var jar =$('#q_jar').textbox("getValue");
			if(jar){
				ft.put("jar@=", jar);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			return ft.getJSON();
		}
	});
}