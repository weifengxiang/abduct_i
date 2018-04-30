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
	initPicView();
}
/**
 * 初始化编辑案件登记信息页面
 */
function initEditTbStAjdjxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#addedittbstajdjxxform').form('options').onLoadSuccess=function(data){
		viewTxxx(data);
	};
	var url=basepath+"ywbl/TbStAjdjxx/getTbStAjdjxxById?id="+paramOpts.data.id;
	$('#addedittbstajdjxxform').form('load',SKY.urlCSRF(url));
	initPicView();
}
/**
 * 保存添加/编辑案件登记信息
 */
function submitAddEditTbStAjdjxxForm(sjzt) {
	$("#sjzt").combobox('setValue',sjzt);
	var getImgBase64=function(){
		var imgBase64=new Array();
		var fileId='pic';
		var imgId='picPreView';
		for(var i=1;i<=3;i++){
			if($('#pic'+i).val()){
				imgBase64.push({
					ywlx:"AJXX",
					txmc:$('#pic'+i).val(),
					txnr:$.compress($('#picPreView'+i)[0]),
					seq:i
				});
			}
		}
		return imgBase64;
	};
	var options = { 
	   data:{
    	   "data":function(){
    		   return JSON.stringify(getImgBase64());
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
/**
 * 初始化图片信息
 * @returns
 */
function initPicView(){	
	_currentDeg1=0;
	_currentDeg2=0;
	_currentDeg3=0;
	$("#pic1").uploadPreview({ Img: 'picPreView1', Width: 210, Height: 210 });
	$('#picPreView1').on('click',function(){           
		_currentDeg1 = (_currentDeg1+90)%360;
        this.style.transform = 'rotate('+_currentDeg1+'deg)';
	});
	$("#pic2").uploadPreview({ Img: 'picPreView2', Width: 210, Height: 210 });
	$('#picPreView2').on('click',function(){           
		_currentDeg2 = (_currentDeg2+90)%360;
        this.style.transform = 'rotate('+_currentDeg2+'deg)';
	});
	$("#pic3").uploadPreview({ Img: 'picPreView3', Width: 210, Height: 210 });
	$('#picPreView3').on('click',function(){           
		_currentDeg3 = (_currentDeg3+90)%360;
        this.style.transform = 'rotate('+_currentDeg3+'deg)';
	});
}
/**
 * 显示图像信息
 * @returns
 */
function viewTxxx(data){
	var url = basepath+'ywbl/com/viewTxxx/AJXX/'+data.ajbh;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			$.each(data,function(i,node){
				//$('#pic'+(i+1)).val(node.txmc);
				$('#picPreView'+(i+1)).attr('src',node.txnr);
			});
		}
	});
}