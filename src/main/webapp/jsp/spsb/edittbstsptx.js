/**
 * 初始化添加视频图片匹配页面
 */
function initAddTbStSpTxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑视频图片匹配页面
 */
function initEditTbStSpTxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"spsb/TbStSpTx/getTbStSpTxById?id="+paramOpts.data.id;
	$('#addedittbstsptxform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑视频图片匹配
 */
function submitAddEditTbStSpTxForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstsptxform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'spsb/TbStSpTx/saveAddEditTbStSpTx'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstsptxform').ajaxSubmit(options);
	
}