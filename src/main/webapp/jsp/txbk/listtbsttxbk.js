//初始化
function init(){
	$('#listtbsttxbkdg').datagrid('options').url=SKY.urlCSRF(basepath+'txbk/TbStTxbk/getTbStTxbkByPage');
	$('#listtbsttxbkdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加图像布控
 **/
function addTbStTxbk(){
	var opts={
				id:'addTbStTxbk',
				title:'添加图像布控',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txbk/TbStTxbk/initAddTbStTxbkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStTxbkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStTxbkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除图像布控
 **/
function delTbStTxbk(){
	var checkeds=$('#listtbsttxbkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'txbk/TbStTxbk/delTbStTxbk');
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
		    				$('#listtbsttxbkdg').datagrid('reload');
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
*修改图像布控
**/
function editTbStTxbk(){
	var checkeds=$('#listtbsttxbkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStTxbk',
				title:'修改图像布控',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txbk/TbStTxbk/initEditTbStTxbkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStTxbkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStTxbkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStTxbk(){
	var checkeds=$('#listtbsttxbkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStTxbk',
				title:'图像布控明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'txbk/TbStTxbk/initDetailTbStTxbkPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStTxbkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStTxbkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbsttxbkdg').datagrid('options').url=SKY.urlCSRF(basepath+'txbk/TbStTxbk/getTbStTxbkByPage');
	$('#listtbsttxbkdg').datagrid('load', {
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
			var bkk =$('#q_bkk').textbox("getValue");
			if(bkk){
				ft.put("bkk@=", bkk);
			}
			var bz =$('#q_bz').textbox("getValue");
			if(bz){
				ft.put("bz@=", bz);
			}
			return ft.getJSON();
		}
	});
}
function getImg(data){
	var rend = "<img style='width:150px;height:150px;' src='"+data+"'/>"
	return rend;
}
/**
 * 查询按钮
 */
function loadJG(row){
	$('#listtbsttxbkjgdg').datagrid('options').url=SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/getTbStTxbkjgByPage');
	$('#listtbsttxbkjgdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			ft.put("txbh@=", row.txbh);
			return ft.getJSON();
		}
	});
}
//添加比中
function renderBtn(value,row){
	return "<button onclick='addBz(\""+row.id+"\")'>比中</button>";
}
function addBz(id){
	var url = SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/addBz');
	var params = {
				"id":id
			};
	$.ajax({
		url:url,
		type: "POST",
		data:params,
		dataType:'json',
		success:function(data){
			$.messager.alert("提示",data.name,"info");
			if(data.code != '0'){
				$('#listtbstsptxdg').datagrid('reload');
			}
		}
	});
}