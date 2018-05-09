/**
 * 初始化图像识别详细页面
 */
function initDetailTbStTxsbPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	//var url=basepath+"txsb/TbStTxsb/getTbStTxsbById?id="+paramOpts.data.id;
	viewTxxx(paramOpts.data);
}
function viewTxxx(data){
	
	var url = basepath+'ywbl/com/viewTxxxSH/'+data.ywlx+'/'+data.ywbh+'/'+data.txxh;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			$('#ywPicPreView').attr('src',data.txnr);
		}
	});
	var url = basepath+'ywbl/com/viewTxxxSH/AJXX/'+data.ajbh+"/"+data.ajtxxh;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			$('#ajPicPreView').attr('src',data.txnr);
		}
	});
	if(data.xsd>=xsdDegree){
		$('#xsd').css({"color":"red","font-size":"200%"});
		$('#xsd').html(data.xsd);
	}else{
		$('#xsd').html(data.xsd);
	}
	$('#ajbh').html(data.ajbh);
	//案件编号绑定事件
	$('#ajbh').on('click',function(){
		var gbButton = {
				text: '关闭',  
	            iconCls: 'icon-cancel',  
	            handler:function(dialog){
	            	dialog.close();
	            }};
		var buttons = new Array();
		buttons.push(gbButton);
		var opts={
					id:'detailTbStAjdjxx',
					title:'案件登记信息明细',
					width:800,
					height:600,
					modal:true,
					content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initAjxxmainPage?ajbh='+data.ajbh),
					buttons:buttons
				  };
		SKY_EASYUI.open(opts);
	});
	$('#ywbh').html(data.ywbh);
	//业务编号绑定事件
	$('#ywbh').on('click',function(){
		if('XSXX'==data.ywlx){
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
			                paramOpts.data={'xsbh':data.ywbh};
			                paramOpts.callBack=function(){
			                	dialog.close();
			                };
			            	this.content.initDetailTbStXsxxPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
			            } 
			        }
				  };
			SKY_EASYUI.open(opts);
		}else if('SJZQ'==data.ywlx){
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
			                paramOpts.data={'xqbh':data.ywbh};
			                paramOpts.callBack=function(){
			                	dialog.close();
			                };
			            	this.content.initDetailTbStSjzqPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
			            } 
			        }
				  };
		SKY_EASYUI.open(opts);
		}
	});
}