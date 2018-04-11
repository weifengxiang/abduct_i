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
				width:600,
				height:450,
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
				width:600,
				height:450,
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
			var ssfj =$('#q_ssfj').textbox("getValue");
			if(ssfj){
				ft.put("ssfj@=", ssfj);
			}
			var lxdh =$('#q_lxdh').textbox("getValue");
			if(lxdh){
				ft.put("lxdh@=", lxdh);
			}
			var bjfs =$('#q_bjfs').textbox("getValue");
			if(bjfs){
				ft.put("bjfs@=", bjfs);
			}
			var bjlb =$('#q_bjlb').textbox("getValue");
			if(bjlb){
				ft.put("bjlb@=", bjlb);
			}
			var bjlx =$('#q_bjlx').textbox("getValue");
			if(bjlx){
				ft.put("bjlx@=", bjlx);
			}
			var bjxl =$('#q_bjxl').textbox("getValue");
			if(bjxl){
				ft.put("bjxl@=", bjxl);
			}
			var sfdz =$('#q_sfdz').textbox("getValue");
			if(sfdz){
				ft.put("sfdz@=", sfdz);
			}
			var lhlb =$('#q_lhlb').textbox("getValue");
			if(lhlb){
				ft.put("lhlb@=", lhlb);
			}
			var bjr =$('#q_bjr').textbox("getValue");
			if(bjr){
				ft.put("bjr@=", bjr);
			}
			var sjxq =$('#q_sjxq').textbox("getValue");
			if(sjxq){
				ft.put("sjxq@=", sjxq);
			}
			var xqdw =$('#q_xqdw').textbox("getValue");
			if(xqdw){
				ft.put("xqdw@=", xqdw);
			}
			var xzqh =$('#q_xzqh').textbox("getValue");
			if(xzqh){
				ft.put("xzqh@=", xzqh);
			}
			var cjr =$('#q_cjr').textbox("getValue");
			if(cjr){
				ft.put("cjr@=", cjr);
			}
			var dcsj =$('#q_dcsj').textbox("getValue");
			if(dcsj){
				ft.put("dcsj@=", dcsj);
			}
			var dcqk =$('#q_dcqk').textbox("getValue");
			if(dcqk){
				ft.put("dcqk@=", dcqk);
			}
			var fknr =$('#q_fknr').textbox("getValue");
			if(fknr){
				ft.put("fknr@=", fknr);
			}
			var cljg =$('#q_cljg').textbox("getValue");
			if(cljg){
				ft.put("cljg@=", cljg);
			}
			var sjzt =$('#q_sjzt').textbox("getValue");
			if(sjzt){
				ft.put("sjzt@=", sjzt);
			}
			var jwq =$('#q_jwq').textbox("getValue");
			if(jwq){
				ft.put("jwq@=", jwq);
			}
			var afdzlb =$('#q_afdzlb').textbox("getValue");
			if(afdzlb){
				ft.put("afdzlb@=", afdzlb);
			}
			var sjfsdz =$('#q_sjfsdz').textbox("getValue");
			if(sjfsdz){
				ft.put("sjfsdz@=", sjfsdz);
			}
			var dqdw =$('#q_dqdw').textbox("getValue");
			if(dqdw){
				ft.put("dqdw@=", dqdw);
			}
			var ajly =$('#q_ajly').textbox("getValue");
			if(ajly){
				ft.put("ajly@=", ajly);
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
			var xsbh =$('#q_xsbh').textbox("getValue");
			if(xsbh){
				ft.put("xsbh@=", xsbh);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			return ft.getJSON();
		}
	});
}