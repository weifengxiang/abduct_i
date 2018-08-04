/**
 * 初始化添加图像布控结果页面
 */
function initAddTbStTxbkjgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑图像布控结果页面
 */
function initEditTbStTxbkjgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"txbk/TbStTxbkjg/getTbStTxbkjgById?id="+paramOpts.data.id;
	$('#addedittbsttxbkjgform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑图像布控结果
 */
function submitAddEditTbStTxbkjgForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbsttxbkjgform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'txbk/TbStTxbkjg/saveAddEditTbStTxbkjg'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbsttxbkjgform').ajaxSubmit(options);
	
}