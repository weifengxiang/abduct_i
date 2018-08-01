/**
 * 初始化添加指令下发页面
 */
function initAddTbStZlxfPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#xfsj').datetimebox('setValue',datetime);
	$('#zlbh').textbox('setValue',zlbh);
	$('#xfdw').val(orgCode);
	$('#xfdwName').textbox('setValue',orgName);
}
/**
 * 初始化编辑指令下发页面
 */
function initEditTbStZlxfPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"zlgl/TbStZlxf/getTbStZlxfById?id="+paramOpts.data.id;
	$('#addedittbstzlxfform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑指令下发
 */
function submitAddEditTbStZlxfForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstzlxfform').form('enableValidation').form('validate');
       },   
       success:function(data){
    	    $.messager.alert('提示',data.name,'info',function(){
    		   if(data.code=='1'){
    			   _callbacks.fire();  
    		   }  	
    	   	});     	   
       },
       error:function(e){
    	   $.messager.alert('提示',JSON.stringify(e),'info');
       },
       url:SKY.urlCSRF(basepath+'zlgl/TbStZlxf/saveAddEditTbStZlxf'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstzlxfform').ajaxSubmit(options);
}
//组织机构选择
function openOrganHelp(){
	var opts={
			id:'chooseOrganWin',
			title:'选择下发单位',
			width:600,
			height:450,
			modal:true,
			content:'url:'+SKY.urlCSRF(basepath+'sys/common/help/organchoose'),
			onLoad: function(dialog){ 
	            if(this.content && this.content.initOrganHelp){//判断弹出窗体iframe中的driveInit方法是否存在 
	                var paramOpts=new Object();
	                paramOpts.dialog=dialog;
	                paramOpts.close=function(){
	                	dialog.close();
	                };
	                paramOpts.ok=function(list){
	                	if(list.length>0){
	                		var jsdws='';
	                		var jsdwNames='';
	                		$.each(list,function(i,node){
	                			jsdws=jsdws+node.data.code;
	                			jsdwNames=jsdwNames+node.data.name;
	                			if(i!=list.length-1){
	                				jsdws=jsdws+",";
	                				jsdwNames=jsdwNames+',';
	                			}
	                		});
	                		$('#jsdw').val(jsdws);
	                		$('#jsdwName').textbox('setValue',jsdwNames);
	                		dialog.close();
	                	}else{
	                		$.messager.alert('提示','请选择接收单位','error');
	                	}
	                	
	                };
	            	this.content.initOrganHelp(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
	            } 
	        }
		  };
	SKY_EASYUI.open(opts);
}
function openUserHelp(){
	var opts={
			id:'chooseUserWin',
			title:'选择提醒人',
			width:600,
			height:450,
			modal:true,
			content:'url:'+SKY.urlCSRF(basepath+'sys/common/help/userchoose'),
			onLoad: function(dialog){ 
	            if(this.content && this.content.initUserHelp){//判断弹出窗体iframe中的driveInit方法是否存在 
	                var paramOpts=new Object();
	                paramOpts.dialog=dialog;
	                paramOpts.close=function(){
	                	dialog.close();
	                };
	                paramOpts.ok=function(list){
	                	if(list.length>0){
	                		var txrs='';
	                		var txrNames='';
	                		$.each(list,function(i,node){
	                			txrs=txrs+node.code;
	                			txrNames=txrNames+node.name;
	                			if(i!=list.length-1){
	                				txrs=txrs+",";
	                				txrNames=txrNames+',';
	                			}
	                		});
	                		$('#txr').val(txrs);
	                		$('#txrName').textbox('setValue',txrNames);
	                		dialog.close();
	                	}else{
	                		$.messager.alert('提示','请选择提醒人','error');
	                	}
	                	
	                };
	            	this.content.initUserHelp(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
	            } 
	        }
		  };
	SKY_EASYUI.open(opts);
}