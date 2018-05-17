/**
 * 初始化添加信息布控页面
 */
function initAddTbStXxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑信息布控页面
 */
function initEditTbStXxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"bksz/TbStXxbk/getTbStXxbkById?id="+paramOpts.data.id;
	$('#addedittbstxxbkform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑信息布控
 */
function submitAddEditTbStXxbkForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstxxbkform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'bksz/TbStXxbk/saveAddEditTbStXxbk'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstxxbkform').ajaxSubmit(options);
	
}