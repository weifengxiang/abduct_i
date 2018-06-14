/**
 * 初始化添加指令下发页面
 */
function initAddTbStZlxfPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
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