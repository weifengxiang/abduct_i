//初始化
function init(){
	$('#listafl').datagrid('options').url=SKY.urlCSRF(basepath+'tjfx/TjfxController/selectAfl');
	$('#listafl').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listafl').datagrid('options').url=SKY.urlCSRF(basepath+'tjfx/TjfxController/selectAfl');
	$('#listafl').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var djsjBegin =$('#q_djsjBegin').textbox("getValue");
			if(djsjBegin){
				ft.put("djsjBegin", djsjBegin);
			}
			var djsjEnd =$('#q_djsjEnd').textbox("getValue");
			if(djsjEnd){
				ft.put("djsjEnd", djsjEnd);
			}
			return ft.getJSON();
		}
	});
}