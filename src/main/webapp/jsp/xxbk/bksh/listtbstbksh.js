//初始化
function init(){
	$('#listtbstxxbkdg').datagrid('options').url=SKY.urlCSRF(basepath+'bksz/TbStXxbk/getTbStXxbkByPage');
	$('#listtbstxxbkdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}

 /**
 *信息布控审核
 **/
function doSh(zt){
	var checkeds=$('#listtbstxxbkdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要审核的记录','info');
		return;
	}else{
		var msg="确定要审核"+checkeds.length+"条数据?";
		$.messager.confirm("确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行审核，请稍等...');
				var url = SKY.urlCSRF(basepath+'bksh/TbStBksh/shTbStXxbk');
				var params = {
							"shRows":JSON.stringify(checkeds),
							"zt":zt
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
		    				$('#listtbstxxbkdg').datagrid('reload');
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
 * 查询按钮
 */
function searchButton(){
	$('#listtbstxxbkdg').datagrid('options').url=SKY.urlCSRF(basepath+'bksz/TbStXxbk/getTbStXxbkByPage');
	$('#listtbstxxbkdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var bh =$('#q_bh').textbox("getValue");
			if(bh){
				ft.put("bh@=", bh);
			}
			var bknr =$('#q_bknr').textbox("getValue");
			if(bknr){
				ft.put("bknr@=", bknr);
			}
			var yxsjq =$('#q_yxsjq').textbox("getValue");
			if(yxsjq){
				ft.put("yxsjq@=", yxsjq);
			}
			var yxsjz =$('#q_yxsjz').textbox("getValue");
			if(yxsjz){
				ft.put("yxsjz@=", yxsjz);
			}
			
			return ft.getJSON();
		}
	});
}
function dblClick(rowData){
	var opts={
			id:'detailTbStXxbk',
			title:'信息布控明细',
			width:600,
			height:450,
			modal:true,
			content:'url:'+SKY.urlCSRF(basepath+'bksz/TbStXxbk/initDetailTbStXxbkPage'),
			onLoad: function(dialog){ 
	            if(this.content && this.content.initDetailTbStXxbkPage){//判断弹出窗体iframe中的driveInit方法是否存在 
	                var paramOpts=new Object();
	                paramOpts.dialog=dialog;
	                paramOpts.data=rowData;
	                paramOpts.callBack=function(){
	                	dialog.close();
	                };
	            	this.content.initDetailTbStXxbkPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
	            } 
	        }
		  };
	SKY_EASYUI.open(opts);
}