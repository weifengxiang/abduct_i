/**
 * 初始化添加案件结案审核信息页面
 */
function initAddTbStAjjashxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑案件结案审核信息页面
 */
function initEditTbStAjjashxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjjashxx/getTbStAjjashxxById?id="+paramOpts.data.id;
	$('#addedittbstajjashxxform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑案件结案审核信息
 */
function submitAddEditTbStAjjashxxForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstajjashxxform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'ywbl/TbStAjjashxx/saveAddEditTbStAjjashxx'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstajjashxxform').ajaxSubmit(options);
	
}