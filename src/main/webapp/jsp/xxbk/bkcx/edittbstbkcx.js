/**
 * 初始化添加布控查询页面
 */
function initAddTbStBkcxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑布控查询页面
 */
function initEditTbStBkcxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"bkcx/TbStBkcx/getTbStBkcxById?id="+paramOpts.data.id;
	$('#addedittbstbkcxform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑布控查询
 */
function submitAddEditTbStBkcxForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstbkcxform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'bkcx/TbStBkcx/saveAddEditTbStBkcx'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstbkcxform').ajaxSubmit(options);
	
}