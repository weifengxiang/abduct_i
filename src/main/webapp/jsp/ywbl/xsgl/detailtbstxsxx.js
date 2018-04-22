/**
 * 初始化线索信息详细页面
 */
function initDetailTbStXsxxPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#detailtbstxsxxform').form('options').onLoadSuccess=function(data){
		viewTxxx(data);
	};
	var url=basepath+"ywbl/TbStXsxx/getTbStXsxxById?id="+paramOpts.data.id;
	$('#detailtbstxsxxform').form('load',SKY.urlCSRF(url));
}
/**
 * 显示图像信息
 * @returns
 */
function viewTxxx(data){
	var url = basepath+'ywbl/com/viewTxxx/XSXX/'+data.xsbh;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			$.each(data,function(i,node){
				debugger;
				//$('#pic'+(i+1)).val(node.txmc);
				$('#picPreView'+(i+1)).attr('src',node.txnr);
			});
		}
	});
}