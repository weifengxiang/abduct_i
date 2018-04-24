/**
 * 初始化数据抓取详细页面
 */
function initDetailTbStSjzqPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"sjzq/TbStSjzq/getTbStSjzqById?id="+paramOpts.data.id;
	$('#detailtbstsjzqform').form('load',SKY.urlCSRF(url));
}
