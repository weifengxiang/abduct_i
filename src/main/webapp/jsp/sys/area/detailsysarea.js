/**
 * 初始化省市区编码表详细页面
 */
function initDetailSysAreaPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"bkcx/SysArea/getSysAreaById?id="+paramOpts.data.id;
	$('#detailsysareaform').form('load',SKY.urlCSRF(url));
}
