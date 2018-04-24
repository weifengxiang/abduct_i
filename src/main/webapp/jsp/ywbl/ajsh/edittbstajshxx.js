/**
 * 初始化添加案件审核页面
 */
function initAddTbStAjshxxPage(paramOpts){
	var data = paramOpts.data;
	$('#ajbh').textbox('setValue',data.ajbh);
	$('#shjg').combobox('setValue',data.opt);
	$('#shenhr').val(shr);
	$('#shenhrName').textbox('setValue',shrName);
	$('#shdw').val(shdw);
	$('#shdwName').textbox('setValue',shdwName);
	$('#shsj').datetimebox('setValue',shsj);
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑案件审核页面
 */
function initEditTbStAjshxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjshxx/getTbStAjshxxById?id="+paramOpts.data.id;
	$('#addedittbstajshxxform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑案件审核
 */
function submitAddEditTbStAjshxxForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstajshxxform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'ywbl/TbStAjshxx/saveAddEditTbStAjshxx'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstajshxxform').ajaxSubmit(options);
	
}