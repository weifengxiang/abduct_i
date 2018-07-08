//初始化
function init(){
	$('#listtbstspxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'spsb/TbStSpxx/getTbStSpxxByPage');
	$('#listtbstspxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加视频信息
 **/
function addTbStSpxx(){
	var opts={
				id:'addTbStSpxx',
				title:'添加视频信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'spsb/TbStSpxx/initAddTbStSpxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStSpxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStSpxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除视频信息
 **/
function delTbStSpxx(){
	var checkeds=$('#listtbstspxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'spsb/TbStSpxx/delTbStSpxx');
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
		    				$('#listtbstspxxdg').datagrid('reload');
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
*修改视频信息
**/
function editTbStSpxx(){
	var checkeds=$('#listtbstspxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStSpxx',
				title:'修改视频信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'spsb/TbStSpxx/initEditTbStSpxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStSpxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStSpxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStSpxx(){
	var checkeds=$('#listtbstspxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStSpxx',
				title:'视频信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'spsb/TbStSpxx/initDetailTbStSpxxPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStSpxxPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStSpxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstspxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'spsb/TbStSpxx/getTbStSpxxByPage');
	$('#listtbstspxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var spbh =$('#q_spbh').textbox("getValue");
			if(spbh){
				ft.put("spbh@=", spbh);
			}
			var spmc =$('#q_spmc').textbox("getValue");
			if(spmc){
				ft.put("spmc@=", spmc);
			}
			var splj =$('#q_splj').textbox("getValue");
			if(splj){
				ft.put("splj@=", splj);
			}
			return ft.getJSON();
		}
	});
}