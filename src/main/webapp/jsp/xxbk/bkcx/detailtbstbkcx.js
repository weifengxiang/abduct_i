/**
 * 初始化布控查询详细页面
 */
function initDetailTbStBkcxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"bkcx/TbStBkcx/getTbStBkcxById?id="+paramOpts.data.id;
	$('#detailtbstbkcxform').form('load',SKY.urlCSRF(url));
}
