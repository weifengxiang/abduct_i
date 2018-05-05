/**
 * 初始化添加图像识别页面
 */
function initAddTbStTxsbPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑图像识别页面
 */
function initEditTbStTxsbPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"txsb/TbStTxsb/getTbStTxsbById?id="+paramOpts.data.id;
	$('#addedittbsttxsbform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑图像识别
 */
function submitAddEditTbStTxsbForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbsttxsbform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'txsb/TbStTxsb/saveAddEditTbStTxsb'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbsttxsbform').ajaxSubmit(options);
	
}