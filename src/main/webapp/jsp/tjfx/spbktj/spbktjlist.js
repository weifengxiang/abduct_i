//初始化
function init(){
	$('#listafl').datagrid('options').url=SKY.urlCSRF(basepath+'tjfx/TjfxController/selectSzdd');
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
	$('#listafl').datagrid('options').url=SKY.urlCSRF(basepath+'tjfx/TjfxController/selectSzdd');
	$('#listafl').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var szsjBegin =$('#q_szsjBegin').textbox("getValue");
			if(szsjBegin){
				ft.put("szsjBegin", szsjBegin);
			}
			var szsjEnd =$('#q_szsjEnd').textbox("getValue");
			if(szsjEnd){
				ft.put("szsjEnd", szsjEnd);
			}
			return ft.getJSON();
		}
	});
}
function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'年'+(m<10?('0'+m):m)+'月'+(d<10?('0'+d):d)+'日';
}
function myparser(s){
	if (!s) return new Date();
	var y = parseInt(s.substr(0,4),10);
	var m = parseInt(s.substr(6,2),10);
	var d = parseInt(s.substr(8,2),10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}