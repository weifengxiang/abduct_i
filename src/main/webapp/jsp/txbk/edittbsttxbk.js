/**
 * 初始化添加图像布控页面
 */
function initAddTbStTxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#spbh').textbox('setValue',txbh);
}
/**
 * 初始化编辑图像布控页面
 */
function initEditTbStTxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"txbk/TbStTxbk/getTbStTxbkById?id="+paramOpts.data.id;
	$('#addedittbsttxbkform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑图像布控
 */
function submitAddEditTbStTxbkForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbsttxbkform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'txbk/TbStTxbk/saveAddEditTbStTxbk'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbsttxbkform').ajaxSubmit(options);
	
}