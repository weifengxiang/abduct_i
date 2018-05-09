/**
 * 初始化数据抓取详细页面
 */
function initDetailTbStSjzqPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	$('#detailtbstsjzqform').form('options').onLoadSuccess=function(data){
		viewTxxx(data);
	};
	var url=basepath+"sjzq/TbStSjzq/getTbStSjzqByXqbh?xqbh="+paramOpts.data.xqbh;
	$('#detailtbstsjzqform').form('load',SKY.urlCSRF(url));
}
function viewTxxx(data){
	var url = basepath+'ywbl/com/viewTxxx/SJZQ/'+data.xqbh;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			$.each(data,function(i,node){
				//$('#pic'+(i+1)).val(node.txmc);
				console.log(node.txnr);
				$('#picPreView'+(i+1)).attr('src',node.txnr);
			});
		}
	});
}