/**
 * 初始化添加图像布控页面
 */
function initAddTbStTxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#txbh').textbox('setValue',txbh);
	initPicView();
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
	var getImgBase64=function(){
		return $.compress($('#picPreView')[0]);
	};
	var options = { 
	   data:{
		   "data":function(){
    		   return JSON.stringify(getImgBase64());
    	   },
    	   "ysmc":$('#pic').val()
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