/**
 * 初始化添加视频信息页面
 */
function initAddTbStSpxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#spbh').textbox('setValue',spbh);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑视频信息页面
 */
function initEditTbStSpxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"spsb/TbStSpxx/getTbStSpxxById?id="+paramOpts.data.id;
	$('#addedittbstspxxform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑视频信息
 */
function submitAddEditTbStSpxxForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstspxxform').form('enableValidation').form('validate');
       },   
       success:function(data){
    	   SKY_EASYUI.unmask();
    	    $.messager.alert('提示',data.name,'info',function(){
    		   if(data.code=='1'){
    			   _callbacks.fire();  
    		   }  	
    	   	});     	   
       },
       error:function(e){
    	   SKY_EASYUI.unmask();
    	   $.messager.alert('提示',JSON.stringify(e),'info');
       },
       url:SKY.urlCSRF(basepath+'spsb/TbStSpxx/saveAddEditTbStSpxx'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	SKY_EASYUI.mask('正在上传，请稍等...');
	$('#addedittbstspxxform').ajaxSubmit(options);
	
}