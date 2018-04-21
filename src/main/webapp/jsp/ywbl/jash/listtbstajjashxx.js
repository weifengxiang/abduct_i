//初始化
function init(){
	$('#listtbstajjashxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjjashxx/getTbStAjjashxxByPage');
	$('#listtbstajjashxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加案件结案审核信息
 **/
function addTbStAjjashxx(){
	var opts={
				id:'addTbStAjjashxx',
				title:'添加案件结案审核信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjjashxx/initAddTbStAjjashxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStAjjashxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStAjjashxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除案件结案审核信息
 **/
function delTbStAjjashxx(){
	var checkeds=$('#listtbstajjashxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'ywbl/TbStAjjashxx/delTbStAjjashxx');
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
		    				$('#listtbstajjashxxdg').datagrid('reload');
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
*修改案件结案审核信息
**/
function editTbStAjjashxx(){
	var checkeds=$('#listtbstajjashxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStAjjashxx',
				title:'修改案件结案审核信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjjashxx/initEditTbStAjjashxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStAjjashxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStAjjashxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStAjjashxx(){
	var checkeds=$('#listtbstajjashxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStAjjashxx',
				title:'案件结案审核信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjjashxx/initDetailTbStAjjashxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStAjjashxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStAjjashxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstajjashxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjjashxx/getTbStAjjashxxByPage');
	$('#listtbstajjashxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var ajbh =$('#q_ajbh').textbox("getValue");
			if(ajbh){
				ft.put("ajbh@=", ajbh);
			}
			var shjg =$('#q_shjg').textbox("getValue");
			if(shjg){
				ft.put("shjg@=", shjg);
			}
			var shyj =$('#q_shyj').textbox("getValue");
			if(shyj){
				ft.put("shyj@=", shyj);
			}
			var shdw =$('#q_shdw').textbox("getValue");
			if(shdw){
				ft.put("shdw@=", shdw);
			}
			var shsj =$('#q_shsj').textbox("getValue");
			if(shsj){
				ft.put("shsj@=", shsj);
			}
			var shr =$('#q_shr').textbox("getValue");
			if(shr){
				ft.put("shr@=", shr);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			return ft.getJSON();
		}
	});
}