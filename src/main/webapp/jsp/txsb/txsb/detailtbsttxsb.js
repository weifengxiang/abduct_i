/**
 * 初始化图像识别详细页面
 */
function initDetailTbStTxsbPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	//var url=basepath+"txsb/TbStTxsb/getTbStTxsbById?id="+paramOpts.data.id;
	viewTxxx(paramOpts.data);
}
function viewTxxx(data){
	
	var url = basepath+'ywbl/com/viewTxxxSH/'+data.ywlx+'/'+data.ywbh+'/'+data.txxh;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			$('#ywPicPreView').attr('src',data.txnr);
		}
	});
	var url = basepath+'ywbl/com/viewTxxxSH/AJXX/'+data.ajbh+"/"+data.ajtxxh;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			$('#ajPicPreView').attr('src',data.txnr);
		}
	});
}