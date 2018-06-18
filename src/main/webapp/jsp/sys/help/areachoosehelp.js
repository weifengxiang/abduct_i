//初始化
function initAreaHelp(paramsObj){
	initAreaTree();
	//关闭功能
	$('#cloBtn').on('click',function(){
		paramsObj.close()
	});
	//确定功能
	$('#okBtn').on('click',function(){
		chooseOK(paramsObj.ok);
	});
}
/**
 * 初始化组织机构树
 */
function initAreaTree() {
	var rootData=[
					{    
					    "id":"100000",    
					    "text":"中国[100000]",    
					    "iconCls":"icon-2012080111634",
					    "state":"closed",
					    "data":{
					    	"code":"100000",
					    	"name":"中国",
					    }
					}
	              ];
	var url = basepath + 'sys/SysArea/getSysAreaTree';
	url=SKY.urlCSRF(url);
	$('#areatree').tree(
			{
				data : rootData,
				lines:true,
				checkbox:true,
				cascadeCheck:false,
				method : 'POST',
				onBeforeExpand : function(node, param) {
					$('#areatree').tree('options').url = url + "&data="
							+ JSON.stringify(node.data);
				}
			});
}

function chooseOK(callback){
	var checkeds=$('#areatree').tree('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择记录','info');
		return;
	}else{
		debugger;
		callback(checkeds);
	}
}