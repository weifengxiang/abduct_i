/**
 * 初始化添加省市区编码表页面
 */
function initAddSysAreaPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑省市区编码表页面
 */
function initEditSysAreaPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"bkcx/SysArea/getSysAreaById?id="+paramOpts.data.id;
	$('#addeditsysareaform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑省市区编码表
 */
function submitAddEditSysAreaForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditsysareaform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'bkcx/SysArea/saveAddEditSysArea'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditsysareaform').ajaxSubmit(options);
	
}