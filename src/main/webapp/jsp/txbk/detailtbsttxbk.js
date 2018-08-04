/**
 * 初始化图像布控详细页面
 */
function initDetailTbStTxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"txbk/TbStTxbk/getTbStTxbkById?id="+paramOpts.data.id;
	$('#detailtbsttxbkform').form('load',SKY.urlCSRF(url));
}
