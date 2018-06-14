/**
 * 初始化添加指令反馈页面
 */
function initAddTbStZlfkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑指令反馈页面
 */
function initEditTbStZlfkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"zlgl/TbStZlfk/getTbStZlfkById?id="+paramOpts.data.id;
	$('#addedittbstzlfkform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑指令反馈
 */
function submitAddEditTbStZlfkForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstzlfkform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'zlgl/TbStZlfk/saveAddEditTbStZlfk'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstzlfkform').ajaxSubmit(options);
	
}