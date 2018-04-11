/**
 * 初始化案件结案信息详细页面
 */
function initDetailTbStAjjaxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjjaxx/getTbStAjjaxxById?id="+paramOpts.data.id;
	$('#detailtbstajjaxxform').form('load',SKY.urlCSRF(url));
}
