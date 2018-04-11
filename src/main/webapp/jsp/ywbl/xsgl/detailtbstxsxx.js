/**
 * 初始化线索信息详细页面
 */
function initDetailTbStXsxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"ywbl/TbStXsxx/getTbStXsxxById?id="+paramOpts.data.id;
	$('#detailtbstxsxxform').form('load',SKY.urlCSRF(url));
}
