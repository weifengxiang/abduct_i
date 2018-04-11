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
				width:600,
				height:450,
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
				width:600,
				height:450,
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
				width:600,
				height:450,
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
			var ajbh =$('#q_ajbh').textbox("getValue");
			if(ajbh){
				ft.put("ajbh@=", ajbh);
			}
			var jbr =$('#q_jbr').textbox("getValue");
			if(jbr){
				ft.put("jbr@=", jbr);
			}
			var zjlx =$('#q_zjlx').textbox("getValue");
			if(zjlx){
				ft.put("zjlx@=", zjlx);
			}
			var zjhm =$('#q_zjhm').textbox("getValue");
			if(zjhm){
				ft.put("zjhm@=", zjhm);
			}
			var dh =$('#q_dh').textbox("getValue");
			if(dh){
				ft.put("dh@=", dh);
			}
			var sfd =$('#q_sfd').textbox("getValue");
			if(sfd){
				ft.put("sfd@=", sfd);
			}
			var sjxq =$('#q_sjxq').textbox("getValue");
			if(sjxq){
				ft.put("sjxq@=", sjxq);
			}
			var xsly =$('#q_xsly').textbox("getValue");
			if(xsly){
				ft.put("xsly@=", xsly);
			}
			var djr =$('#q_djr').textbox("getValue");
			if(djr){
				ft.put("djr@=", djr);
			}
			var djdw =$('#q_djdw').textbox("getValue");
			if(djdw){
				ft.put("djdw@=", djdw);
			}
			var djsj =$('#q_djsj').textbox("getValue");
			if(djsj){
				ft.put("djsj@=", djsj);
			}
			var zt =$('#q_zt').textbox("getValue");
			if(zt){
				ft.put("zt@=", zt);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			return ft.getJSON();
		}
	});
}