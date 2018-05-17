/**
 * 初始化信息布控详细页面
 */
function initDetailTbStXxbkPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"bksz/TbStXxbk/getTbStXxbkById?id="+paramOpts.data.id;
	$('#detailtbstxxbkform').form('load',SKY.urlCSRF(url));
}
