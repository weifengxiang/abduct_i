//初始化
function init(){
	$('#listtbstajshxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjshxx/getTbStAjshxxByPage');
	$('#listtbstajshxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加案件审核
 **/
function addTbStAjshxx(){
	var opts={
				id:'addTbStAjshxx',
				title:'添加案件审核',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjshxx/initAddTbStAjshxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStAjshxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStAjshxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除案件审核
 **/
function delTbStAjshxx(){
	var checkeds=$('#listtbstajshxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'ywbl/TbStAjshxx/delTbStAjshxx');
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
		    				$('#listtbstajshxxdg').datagrid('reload');
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
*修改案件审核
**/
function editTbStAjshxx(){
	var checkeds=$('#listtbstajshxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStAjshxx',
				title:'修改案件审核',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjshxx/initEditTbStAjshxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStAjshxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStAjshxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStAjshxx(){
	var checkeds=$('#listtbstajshxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStAjshxx',
				title:'案件审核明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjshxx/initDetailTbStAjshxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStAjshxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStAjshxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstajshxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'ywbl/TbStAjshxx/getTbStAjshxxByPage');
	$('#listtbstajshxxdg').datagrid('load', {
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
			var shenhr =$('#q_shenhr').textbox("getValue");
			if(shenhr){
				ft.put("shenhr@=", shenhr);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			return ft.getJSON();
		}
	});
}