/**
 * 初始化添加视频图片匹配页面
 */
function initAddTbStSpTxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	var data = paramOpts.data;
	$('#spbh').textbox('setValue',data.spbh);
	$('#zt').val('0');
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	initPicView();
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
	var getImgBase64=function(){
		return $.compress($('#picPreView')[0]);
	};
	var options = { 
	   data:{
    	   "data":function(){
    		   return JSON.stringify(getImgBase64());
    	   },
    	   "txmc":$('#pic').val()
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
/**
 * 初始化图片信息
 * @returns
 */
function initPicView(){	
	_currentDeg=0;
	$("#pic").uploadPreview({ Img: 'picPreView', Width: 210, Height: 210 });
	$('#picPreView').on('click',function(){           
		_currentDeg = (_currentDeg+90)%360;
        this.style.transform = 'rotate('+_currentDeg+'deg)';
	});
}