/**
 * 初始化视频图片匹配详细页面
 */
function initDetailTbStSpTxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"spsb/TbStSpTx/getTbStSpTxById?id="+paramOpts.data.id;
	$('#detailtbstsptxform').form('load',SKY.urlCSRF(url));
}
