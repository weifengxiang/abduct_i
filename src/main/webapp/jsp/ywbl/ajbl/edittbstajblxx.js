/**
 * 初始化添加案件办理信息页面
 */
function initAddTbStAjblxxPage(paramOpts){
	var ajbh = paramOpts.data.ajbh;
	var opt = paramOpts.data.opt;
	$('#ajbh').textbox('setValue',ajbh);
	$('#bljg').combobox('setValue',opt);
	$('#blrName').textbox('setValue',blrName);
	$('#blr').val(blr);
	$('#bldwName').textbox('setValue',bldwName);
	$('#bldw').val(bldw);
	$('#blsj').datetimebox('setValue',blsj);
	if('3'==opt){
		$('#flqxTR').show();
	}else{
		$('#flqxTR').hide();
	}
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑案件办理信息页面
 */
function initEditTbStAjblxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjblxx/getTbStAjblxxById?id="+paramOpts.data.id;
	$('#addedittbstajblxxform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑案件办理信息
 */
function submitAddEditTbStAjblxxForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstajblxxform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'ywbl/TbStAjblxx/saveAddEditTbStAjblxx'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstajblxxform').ajaxSubmit(options);
	
}
//组织机构选择
function openOrganHelp(){
	var opts={
			id:'chooseOrganWin',
			title:'选择分流去向',
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
	                	debugger;
	                	if(list.length==1){
	                		$('#flqx').val(list[0].data.code);
	                		$('#flqxName').textbox('setValue',list[0].data.name);
	                		dialog.close();
	                	}else{
	                		$.messager.alert('提示','请选择一个分流去向','error');
	                	}
	                	
	                };
	            	this.content.initOrganHelp(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
	            } 
	        }
		  };
	SKY_EASYUI.open(opts);
}