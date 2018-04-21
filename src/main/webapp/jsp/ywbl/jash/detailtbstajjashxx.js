/**
 * 初始化案件结案审核信息详细页面
 */
function initDetailTbStAjjashxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjjashxx/getTbStAjjashxxById?id="+paramOpts.data.id;
	$('#detailtbstajjashxxform').form('load',SKY.urlCSRF(url));
}
