//初始化
function initAddTbStZlfkPage(paramOpts){
	var data=paramOpts.data;
	$('#listtbstzlfkdg').datagrid('options').url=SKY.urlCSRF(basepath+'zlgl/TbStZlxf/getTbStZlfkByPage');
	$('#listtbstzlfkdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			ft.put('zlbh@=',data.zlbh);
			return ft.getJSON();
		}
	});
}