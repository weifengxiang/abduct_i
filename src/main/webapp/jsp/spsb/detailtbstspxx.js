/**
 * 初始化视频信息详细页面
 */
function initDetailTbStSpxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"spsb/TbStSpxx/getTbStSpxxById?id="+paramOpts.data.id;
	$('#detailtbstspxxform').form('load',SKY.urlCSRF(url));
}
