/**
 * 初始化添加短信发送页面
 */
function initAddTbStMsgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#state').val(0);
}
/**
 * 初始化编辑短信发送页面
 */
function initEditTbStMsgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"msg/TbStMsg/getTbStMsgById?id="+paramOpts.data.id;
	$('#addedittbstmsgform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑短信发送
 */
function submitAddEditTbStMsgForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstmsgform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'msg/TbStMsg/saveAddEditTbStMsg'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstmsgform').ajaxSubmit(options);
	
}