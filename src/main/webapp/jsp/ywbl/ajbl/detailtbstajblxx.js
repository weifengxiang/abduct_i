/**
 * 初始化案件办理信息详细页面
 */
function initDetailTbStAjblxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjblxx/getTbStAjblxxById?id="+paramOpts.data.id;
	$('#detailtbstajblxxform').form('load',SKY.urlCSRF(url));
}
