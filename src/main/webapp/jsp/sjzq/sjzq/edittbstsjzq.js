/**
 * 初始化添加数据抓取页面
 */
function initAddTbStSjzqPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑数据抓取页面
 */
function initEditTbStSjzqPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"sjzq/TbStSjzq/getTbStSjzqById?id="+paramOpts.data.id;
	$('#addedittbstsjzqform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑数据抓取
 */
function submitAddEditTbStSjzqForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstsjzqform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'sjzq/TbStSjzq/saveAddEditTbStSjzq'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstsjzqform').ajaxSubmit(options);
	
}