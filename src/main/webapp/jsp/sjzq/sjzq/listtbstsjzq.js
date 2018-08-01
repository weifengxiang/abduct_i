//初始化
function init(){
	$('#listtbstsjzqdg').datagrid('options').url=SKY.urlCSRF(basepath+'sjzq/TbStSjzq/getTbStSjzqByPage');
	$('#listtbstsjzqdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加数据抓取
 **/
function addTbStSjzq(){
	var opts={
				id:'addTbStSjzq',
				title:'添加数据抓取',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'sjzq/TbStSjzq/initAddTbStSjzqPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddTbStSjzqPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddTbStSjzqPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除数据抓取
 **/
function delTbStSjzq(){
	var checkeds=$('#listtbstsjzqdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'sjzq/TbStSjzq/delTbStSjzq');
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
		    				$('#listtbstsjzqdg').datagrid('reload');
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
*修改数据抓取
**/
function editTbStSjzq(){
	var checkeds=$('#listtbstsjzqdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editTbStSjzq',
				title:'修改数据抓取',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'sjzq/TbStSjzq/initEditTbStSjzqPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditTbStSjzqPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditTbStSjzqPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailTbStSjzq(){
	var checkeds=$('#listtbstsjzqdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailTbStSjzq',
				title:'数据抓取明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'sjzq/TbStSjzq/initDetailTbStSjzqPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStSjzqPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStSjzqPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 双击事件
 * @returns
 */
function dblclickFun(row){
	var opts={
				id:'detailTbStSjzq',
				title:'数据抓取明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'sjzq/TbStSjzq/initDetailTbStSjzqPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailTbStSjzqPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=row;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailTbStSjzqPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstsjzqdg').datagrid('options').url=SKY.urlCSRF(basepath+'sjzq/TbStSjzq/getTbStSjzqByPage');
	$('#listtbstsjzqdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var xqbh =$('#q_xqbh').textbox("getValue");
			if(xqbh){
				ft.put("xqbh@=", xqbh);
			}
			var xm =$('#q_xm').textbox("getValue");
			if(xm){
				ft.put("xm@=", xm);
			}
			var szrszd=$('#q_szrszd').textbox('getValue');
			if(szrszd){
				ft.put("szrszd@like", "%"+szrszd+"%");
			}
			var szdd=$('#q_szdd').textbox('getValue');
			if(szdd){
				ft.put("szdd@like", "%"+szdd+"%");
			}
			return ft.getJSON();
		}
	});
}
function cellStyler(value,row,index){
	if (value == 0){
		return 'color:red;';
	}else{
		return 'color:blue;';
	}
}
//数据导出
function expExcel(){
	SKY_EASYUI.mask('正在进行导出，请稍等...');
	var ft = new HashMap();
	var xqbh =$('#q_xqbh').textbox("getValue");
	if(xqbh){
		ft.put("xqbh@=", xqbh);
	}
	var xm =$('#q_xm').textbox("getValue");
	if(xm){
		ft.put("xm@=", xm);
	}
	var url = SKY.urlCSRF(basepath+'sjzq/TbStSjzq/expExcel');
	$.ajax({
		url:url,
		type: "POST",
		dataType:'json',
		data:{"filter":ft.getJSON()},
		success:function(data){
			SKY_EASYUI.unmask();
			$.messager.alert("提示",data.name,"info");
			var filepath=data.data;
			SKY_EASYUI.downLoad(filepath);
		}
	});
}
function getImg(xqbh){
	
	var url = basepath+'ywbl/com/viewTxxxSH/SJZQ/'+xqbh+'/'+1;
	var rend = "";
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		async:false,
		success:function(data){
			if(!data){
				return;
			}
			rend =  "<img id='ajPicPreView' style='width:150px;height:150px;' src='"+data.txnr+"'/>";
		}
	});
	return rend;
}