/**
 * 初始化指令反馈详细页面
 */
function initDetailTbStZlfkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"zlgl/TbStZlfk/getTbStZlfkById?id="+paramOpts.data.id;
	$('#detailtbstzlfkform').form('load',SKY.urlCSRF(url));
}
