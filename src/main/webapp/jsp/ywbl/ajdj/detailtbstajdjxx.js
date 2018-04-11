/**
 * 初始化案件登记信息详细页面
 */
function initDetailTbStAjdjxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjdjxx/getTbStAjdjxxById?id="+paramOpts.data.id;
	$('#detailtbstajdjxxform').form('load',SKY.urlCSRF(url));
}
