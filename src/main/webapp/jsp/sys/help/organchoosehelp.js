//初始化
function initOrganHelp(paramsObj){
	initSysOrganTree();
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
function initSysOrganTree() {
	var rootData=[
					{    
					    "id":"root",    
					    "text":"组织机构树[root]",    
					    "iconCls":"icon-2012080111634",
					    "state":"closed",
					    "data":{
					    	"code":"root",
					    	"name":"组织机构树",
					    }
					}
	              ];
	var url = basepath + 'sys/SysOrgan/getSysOrganTree';
	url=SKY.urlCSRF(url);
	$('#organtree').tree(
			{
				data : rootData,
				lines:true,
				checkbox:true,
				cascadeCheck:false,
				method : 'POST',
				onBeforeExpand : function(node, param) {
					$('#organtree').tree('options').url = url + "&data="
							+ JSON.stringify(node.data);
				}
			});
}

function chooseOK(callback){
	var checkeds=$('#organtree').tree('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择记录','info');
		return;
	}else{
		callback(checkeds);
	}
}