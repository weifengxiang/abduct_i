/**
 * 初始化图像布控结果详细页面
 */
function initDetailTbStTxbkjgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"txbk/TbStTxbkjg/getTbStTxbkjgById?id="+paramOpts.data.id;
	$('#detailtbsttxbkjgform').form('load',SKY.urlCSRF(url));
}
