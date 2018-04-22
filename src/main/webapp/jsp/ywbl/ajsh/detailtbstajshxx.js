/**
 * 初始化案件审核详细页面
 */
function initDetailTbStAjshxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStAjshxx/getTbStAjshxxById?id="+paramOpts.data.id;
	$('#detailtbstajshxxform').form('load',SKY.urlCSRF(url));
}
