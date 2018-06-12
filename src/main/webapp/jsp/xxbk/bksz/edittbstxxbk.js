/**
 * 初始化添加信息布控页面
 */
function initAddTbStXxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#bh').textbox('setValue',bh);
	$('#zt').combobox('setValue','0');
}
/**
 * 初始化编辑信息布控页面
 */
function initEditTbStXxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"bksz/TbStXxbk/getTbStXxbkById?id="+paramOpts.data.id;
	$('#addedittbstxxbkform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑信息布控
 */
function submitAddEditTbStXxbkForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addedittbstxxbkform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'bksz/TbStXxbk/saveAddEditTbStXxbk'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addedittbstxxbkform').ajaxSubmit(options);
}
/**
 * 用户选择帮助
 * @returns
 */
function openUserHelp(){
	var opts={
			id:'editBaseComcheckCfg',
			title:'修改商品检查设置',
			width:600,
			height:450,
			modal:true,
			content:'url:'+SKY.urlCSRF(basepath+'sys/common/help/userchoose'),
			onLoad: function(dialog){ 
	            if(this.content && this.content.initUserHelp){//判断弹出窗体iframe中的driveInit方法是否存在 
	                var paramOpts=new Object();
	                paramOpts.dialog=dialog;
	                paramOpts.close=function(){
	                	dialog.close();
	                };
	                paramOpts.ok=function(list){
	                	if(list.length==1){
	                		$('#zrr').val(list[0].code);
	                		$('#zrrName').textbox('setValue',list[0].name);
	                		dialog.close();
	                	}else{
	                		//$.messager.alert('提示','请选择一个员工','info');
	                	}
	                	
	                };
	            	this.content.initUserHelp(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
	            } 
	        }
		  };
	SKY_EASYUI.open(opts);
}