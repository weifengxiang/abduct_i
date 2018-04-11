/**
 * 初始化添加案件结案信息页面
 */
function initAddTbStAjjaxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑案件结案信息页面
 */
function initEditTbStAjjaxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjjaxx/getTbStAjjaxxById?id="+paramOpts.data.id;
	$('#addedittbstajjaxxform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑案件结案信息
 */
function submitAddEditTbStAjjaxxForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstajjaxxform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'ywbl/TbStAjjaxx/saveAddEditTbStAjjaxx'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstajjaxxform').ajaxSubmit(options);
	
}