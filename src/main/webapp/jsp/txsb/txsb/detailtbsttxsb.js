/**
 * 初始化图像识别详细页面
 */
function initDetailTbStTxsbPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"txsb/TbStTxsb/getTbStTxsbById?id="+paramOpts.data.id;
	$('#detailtbsttxsbform').form('load',SKY.urlCSRF(url));
}
