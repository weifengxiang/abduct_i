/**
 * 初始化短信发送详细页面
 */
function initDetailTbStMsgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"msg/TbStMsg/getTbStMsgById?id="+paramOpts.data.id;
	$('#detailtbstmsgform').form('load',SKY.urlCSRF(url));
}
