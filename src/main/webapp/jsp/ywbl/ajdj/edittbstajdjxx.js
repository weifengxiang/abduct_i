/**
 * 初始化添加案件登记信息页面
 */
function initAddTbStAjdjxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#ajbh').textbox('setValue',ajbh);
	$('#bjsj').datetimebox('setValue',djsj);
	$('#djsj').datetimebox('setValue',djsj);
	$('#dcsj').datetimebox('setValue',djsj);
	$('#djr').val(djr);
	$('#djrName').textbox('setValue',djrName);
	$('#djdw').val(djdw);
	$('#djdwName').textbox('setValue',djdwName);
	$('#dqdw').val(djdw);
	$('#dqdwName').textbox('setValue',djdwName);
}
/**
 * 初始化编辑案件登记信息页面
 */
function initEditTbStAjdjxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjdjxx/getTbStAjdjxxById?id="+paramOpts.data.id;
	$('#addedittbstajdjxxform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑案件登记信息
 */
function submitAddEditTbStAjdjxxForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstajdjxxform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/saveAddEditTbStAjdjxx'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstajdjxxform').ajaxSubmit(options);
	
}